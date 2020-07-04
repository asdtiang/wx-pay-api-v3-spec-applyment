package com.xiangmitech.wx.pay.apiv3.spec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.xiangmitech.wx.pay.apiv3.spec.been.ApplymentInfo;
import com.xiangmitech.wx.pay.apiv3.spec.been.BankAccountInfo;
import com.xiangmitech.wx.pay.apiv3.spec.been.result.ApplymentStatusResult;
import com.xiangmitech.wx.pay.apiv3.spec.been.result.BankAccountResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.IllegalBlockSizeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/**
 * @author abel lee
 * @create 2020-05-25 15:22
 **/
public class WxPayApiV3SpecServiceDefaultImpl implements WxPayApiV3SpecService {
  private static final Logger log = LoggerFactory.getLogger(WxPayApiV3SpecServiceDefaultImpl.class);

  private WxPayApiV3SpecConfig specConfig;
  private X509Certificate certificate;
  private PrivateKey privateKey;
  private CloseableHttpClient httpClient;
  private ObjectMapper objectMapper = new ObjectMapper();
  private AutoUpdateCertificatesVerifier autoUpdateCertificatesVerifier = null;

  public WxPayApiV3SpecServiceDefaultImpl(WxPayApiV3SpecConfig specConfig) {
    this.specConfig = specConfig;
    this.certificate = PemUtil.loadCertificate(specConfig.getX509certificateInputStream());
    this.privateKey = PemUtil.loadPrivateKey(specConfig.getPrivateKeyInputStream());
    objectMapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
    try {
      autoUpdateCertificatesVerifier = new AutoUpdateCertificatesVerifier(
        new WechatPay2Credentials(specConfig.getMerchantId(), new PrivateKeySigner(specConfig.getMerchantSerialNumber(), this.privateKey), "boundary"),
        specConfig.getApiV3Key().getBytes("utf-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
      .withMerchant(specConfig.getMerchantId(), specConfig.getMerchantSerialNumber(), this.privateKey)
      .withValidator(new WechatPay2Validator(autoUpdateCertificatesVerifier));

// 通过WechatPayHttpClientBuilder构造的HttpClient，会自动的处理签名和验签，并进行证书自动更新
    this.httpClient = builder.build();
  }

  @Override
  public String applyment4sub(ApplymentInfo applymentInfo) throws IOException, IllegalBlockSizeException, IllegalAccessException {
    X509Certificate wxPlatformX509 = autoUpdateCertificatesVerifier.getWxPlatformX509();
    //敏感字段加密
    SpecFieldEncryptFormat.encryptField(applymentInfo, wxPlatformX509);
    log.info("Wechatpay-Serial--->" + wxPlatformX509.getSerialNumber().toString(16).toUpperCase());
    HttpPost httpPost = new HttpPost(APPLYMENT_URL);
    // 设置请求头
    httpPost.addHeader("Content-Type", "application/json");
    httpPost.addHeader("Accept", "application/json");
    httpPost.addHeader("Wechatpay-Serial", wxPlatformX509.getSerialNumber().toString(16).toUpperCase());

    String submitJson = objectMapper.writeValueAsString(applymentInfo);
    log.info("submit applymentInfo json---->\n" + submitJson);
    httpPost.setEntity(new StringEntity(submitJson, "UTF-8")); //防止中文乱码
    HttpResponse response = httpClient.execute(httpPost);
    HttpEntity entity = response.getEntity();
    String result = EntityUtils.toString(entity);
    log.info(" result source->{}", result);
    if (response.getStatusLine().getStatusCode() == 200) {
      log.info("result---->" + result);
      JsonNode dataNode = objectMapper.readTree(result).get("applyment_id");
      return dataNode.asText();
    } else {
      log.warn("result error---->" + result);
      return null;
    }
  }

  @Override
  public ApplymentStatusResult applymentStatus(String businessCode) throws IOException {
    HttpGet httpGet = new HttpGet(SEARCH_APPLY_STATUS_URL.replace("{business_code}", businessCode));
    // 设置请求头
    httpGet.addHeader("Content-Type", "application/json");
    httpGet.addHeader("Accept", "application/json");
    HttpResponse response = httpClient.execute(httpGet);
    HttpEntity entity = response.getEntity();
    String result = EntityUtils.toString(entity);
    log.info(" result source->{}", result);
    if (response.getStatusLine().getStatusCode() == 200) {
      log.info("result---->" + result);
      ApplymentStatusResult statusResult = objectMapper.readValue(result, ApplymentStatusResult.class);
      statusResult.setSourceJson(result);
      return statusResult;
    } else {
      log.warn("result error---->" + result);
      return null;
    }
  }

  @Override
  public boolean changeSubBank(String subMchid, BankAccountInfo bankAccountInfo) throws IOException {
    HttpPost httpPost = new HttpPost(CHANGE_SUB_MCH_BANK_URL.replace("{sub_mchid}", subMchid));
    // 设置请求头
    httpPost.addHeader("Content-Type", "application/json");
    httpPost.addHeader("Accept", "application/json");
    httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(bankAccountInfo), "UTF-8")); //防止中文乱码
    HttpResponse response = httpClient.execute(httpPost);
    HttpEntity entity = response.getEntity();
    String result = EntityUtils.toString(entity);
    log.info(" result source->{}", result);
    if (response.getStatusLine().getStatusCode() == 204) {
      return true;
    } else {
      log.warn("result error---->" + result);
      return false;
    }
  }

  @Override
  public BankAccountResult querySubMch(String submchId) throws IOException {
    HttpGet httpGet = new HttpGet(QUERY_SUB_MCH_BANK_URL.replace("{sub_mchid}", submchId));
    // 设置请求头
    httpGet.addHeader("Content-Type", "application/json");
    httpGet.addHeader("Accept", "application/json");
    HttpResponse response = httpClient.execute(httpGet);
    HttpEntity entity = response.getEntity();
    String result = EntityUtils.toString(entity);
    log.info(" result source->{}", result);
    if (response.getStatusLine().getStatusCode() == 200) {
      log.info("result---->" + result);
      BankAccountResult bankAccountResult = objectMapper.readValue(result, BankAccountResult.class);
      bankAccountResult.setSourceJson(result);
      return bankAccountResult;
    } else {
      log.warn("result error---->" + result);
      return null;
    }
  }

  public String upload(File file) throws IOException {
    HttpPost httpPost = new HttpPost(UPLOAD_FILE_URL);
    httpPost.addHeader("Accept", "application/json");
    httpPost.addHeader("Content-Type", "multipart/form-data");
    String sha256Hex = DigestUtils.sha256Hex(new FileInputStream(file));

    //创建MultipartEntityBuilder
    MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
    //设置boundary
    multipartEntityBuilder.setBoundary("boundary");
    multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
    //设置meta内容
    multipartEntityBuilder.addTextBody("meta", "{\"filename\":\"" + file.getName() + "\",\"sha256\":\"" + sha256Hex + "\"}", ContentType.APPLICATION_JSON);
    //设置图片内容
    multipartEntityBuilder.addBinaryBody("file", file, ContentType.create("image/jpg"), file.getName());
    //放入内容
    httpPost.setEntity(multipartEntityBuilder.build());
//    InputStream inputStream = httpPost.getEntity().getContent();
//
//    StringBuilder contentSb = new StringBuilder();
//    String line;
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//    while ((line = br.readLine()) != null) {
//      contentSb.append(line);
//    }
//
//    String str = contentSb.toString();
//    System.out.println("输出---->\n" + str);

    log.info("upload file request " + httpPost.getRequestLine());
    HttpResponse response = httpClient.execute(httpPost);
    log.info(response.getStatusLine().toString());
    HttpEntity resEntity = response.getEntity();
    if (resEntity != null) {
      String responseEntityStr = EntityUtils.toString(response.getEntity());
      log.info(responseEntityStr);
      log.info("Response content length: " + resEntity.getContentLength());
      JsonNode dataNode = objectMapper.readTree(responseEntityStr).get("media_id");
      EntityUtils.consume(resEntity);
      return dataNode.asText();
    } else {
      log.error("upload file response error");
      return "";
    }
  }
}
