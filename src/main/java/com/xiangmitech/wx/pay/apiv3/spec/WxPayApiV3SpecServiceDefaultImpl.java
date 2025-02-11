package com.xiangmitech.wx.pay.apiv3.spec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAPublicKeyConfig;
import com.wechat.pay.java.core.cipher.PrivacyEncryptor;
import com.wechat.pay.java.core.cipher.RSAPrivacyEncryptor;
import com.wechat.pay.java.core.http.*;
import com.wechat.pay.java.core.util.IOUtil;
import com.wechat.pay.java.core.util.PemUtil;
import com.wechat.pay.java.service.file.FileUploadService;
import com.wechat.pay.java.service.file.model.FileUploadResponse;
import com.xiangmitech.wx.pay.apiv3.spec.been.ApplymentInfo;
import com.xiangmitech.wx.pay.apiv3.spec.been.BankAccountInfo;
import com.xiangmitech.wx.pay.apiv3.spec.been.result.ApplymentStatusResult;
import com.xiangmitech.wx.pay.apiv3.spec.been.result.BankAccountResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.IllegalBlockSizeException;
import java.io.*;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

/**
 * @author abel lee
 * @create 2020-05-25 15:22
 **/
public class WxPayApiV3SpecServiceDefaultImpl implements WxPayApiV3SpecService {
  private static final Logger log = LoggerFactory.getLogger(WxPayApiV3SpecServiceDefaultImpl.class);

  private WxPayApiV3SpecConfig specConfig;
  private PublicKey wechatPayPublicKey;
  private PrivacyEncryptor encryptor;
  private HttpClient httpClient;
  private ObjectMapper objectMapper = new ObjectMapper();
  private FileUploadService fileService;


  public WxPayApiV3SpecServiceDefaultImpl(WxPayApiV3SpecConfig specConfig) {
    this.specConfig = specConfig;

    objectMapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
    try {
      PrivateKey privateKey = genPrivateKeyFromInputStream(specConfig.getPrivateKeyInputStream());
      wechatPayPublicKey = genPublicKeyFromInputStream(specConfig.getWxPublicKeyInputStream());
      encryptor = new RSAPrivacyEncryptor(wechatPayPublicKey,specConfig.getWxPublicKeyId());
      // 可以根据实际情况使用publicKeyFromPath或publicKey加载公钥
      Config config =
        new RSAPublicKeyConfig.Builder()
          .merchantId(specConfig.getMerchantId()) //微信支付的商户号
          .privateKey(privateKey)
          .publicKey(wechatPayPublicKey)
         // .privateKeyFromPath(specConfig.getPrivateKeyInputStream()) // 商户API证书私钥的存放路径
         // .publicKeyFromPath("/Users/yourname/yourpath/pub_key.pem") //微信支付公钥的存放路径
          .publicKeyId(specConfig.getWxPublicKeyId()) //微信支付公钥ID
          .merchantSerialNumber(specConfig.getMerchantSerialNumber()) //商户API证书序列号
          .apiV3Key(specConfig.getApiV3Key()) //APIv3密钥
          .build();
       this.httpClient =
        new DefaultHttpClientBuilder()
          .config(config)
          .connectTimeoutMs(5000)
          .build();
       this.fileService = new FileUploadService.Builder().config(config).build();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  }

  public PrivateKey genPrivateKeyFromInputStream(InputStream inputStream) throws IOException {
    String key = IOUtil.toString(inputStream);
    return PemUtil.loadPrivateKeyFromString(key);
  }

  public PublicKey genPublicKeyFromInputStream(InputStream inputStream) throws IOException {
    String key = IOUtil.toString(inputStream);
    return PemUtil.loadPublicKeyFromString(key);
  }

  @Override
  public String applyment4sub(ApplymentInfo applymentInfo) throws IOException, IllegalBlockSizeException, IllegalAccessException {
    //敏感字段加密
    SpecFieldEncryptFormat.encryptField(applymentInfo, encryptor);
    log.info("Wechatpay-Serial--->" + encryptor.getWechatpaySerial().toUpperCase());
    HttpHeaders headers = new HttpHeaders();
    // 设置请求头
    headers.addHeader("Content-Type", "application/json");
    headers.addHeader("Accept", "application/json");
    headers.addHeader("Wechatpay-Serial", encryptor.getWechatpaySerial().toUpperCase());

    String submitJson = objectMapper.writeValueAsString(applymentInfo);
    RequestBody body = new JsonRequestBody.Builder().body(submitJson).build();

    log.info("submit applymentInfo json---->\n" + submitJson);
    HttpResponse response = httpClient.post(headers,APPLYMENT_URL,body,Object.class);
    String result = response.getServiceResponse().toString();
    log.info(" result source->{}", result);
    log.info("result---->" + result);
    JsonNode dataNode = objectMapper.readTree(result).get("applyment_id");
    if (dataNode == null) {
      return result;
    } else {
      return dataNode.asText();
    }
  }

  @Override
  public ApplymentStatusResult applymentStatus(String businessCode) throws IOException {
    HttpHeaders headers = new HttpHeaders();
    String url = SEARCH_APPLY_STATUS_URL.replace("{business_code}", businessCode);
    // 设置请求头
    headers.addHeader("Content-Type", "application/json");
    headers.addHeader("Accept", "application/json");
    HttpResponse response = httpClient.get(headers,url,Object.class);
    String result = response.getServiceResponse().toString();
    log.info(" result source->{}", result);
    log.info("result---->" + result);
    ApplymentStatusResult statusResult = objectMapper.readValue(result, ApplymentStatusResult.class);
    statusResult.setSourceJson(result);
    return statusResult;
  }

  @Override
  public boolean changeSubBank(String subMchid, BankAccountInfo bankAccountInfo) throws IOException {
    // 设置请求头
    HttpHeaders headers = new HttpHeaders();
    String url = CHANGE_SUB_MCH_BANK_URL.replace("{sub_mchid}", subMchid)
    headers.addHeader("Content-Type", "application/json");
    headers.addHeader("Accept", "application/json");
    RequestBody body = new JsonRequestBody.Builder().body(objectMapper.writeValueAsString(bankAccountInfo)).build();

    HttpResponse response = httpClient.post(headers,url,body,Object.class);
    String result = response.getServiceResponse().toString();
    log.info(" result source->{}", result);
    return true;
  }

  @Override
  public BankAccountResult querySubMch(String submchId) throws IOException {
    HttpHeaders headers = new HttpHeaders();
    String url = QUERY_SUB_MCH_BANK_URL.replace("{sub_mchid}", submchId);
    // 设置请求头
    headers.addHeader("Content-Type", "application/json");
    headers.addHeader("Accept", "application/json");
    HttpResponse response = httpClient.get(headers,url,Object.class);
    String result = response.getServiceResponse().toString();

    log.info("result---->" + result);
    BankAccountResult bankAccountResult = objectMapper.readValue(result, BankAccountResult.class);
    bankAccountResult.setSourceJson(result);
    return bankAccountResult;
  }

  public String upload(File file) throws IOException {
    String sha256Hex = DigestUtils.sha256Hex(new FileInputStream(file));
    String meta = "{\"filename\":\"" + file.getName() + "\",\"sha256\":\"" + sha256Hex + "\"}";
    FileUploadResponse fileUploadResponse = fileService.uploadImage(UPLOAD_FILE_URL, meta, file.getAbsolutePath());
    return fileUploadResponse.getMediaId();
  }
}
