import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author abel lee
 * @create 2020-06-04 22:11
 **/
public class UploadFileTest2 {

  @Test
  public void testUpload() {

    try {
      //商户号
      String mchid = "1558891591";
      //证书序列号
      String serial_no = "63E98230278F18DA4E0950AB50725562931B1132";
      //商户私钥（拷贝apiclient_key.pem文件里-----BEGIN PRIVATE KEY-----和-----END PRIVATE KEY-----之间的内容）
      String rsaPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDO9ijHlpaO+9Rj\n" +
        "PqgZ1yX8XaKUcOfW+W9rOJlxom8JN//QsHbPixicwvoCawGBxQTz05quct7nDw70\n" +
        "NWSlI/gOgBbAVFdau2VW+RGEsetbDCf1qs4UKmcKuGX+qp8w9dLfjKAE+oroAtAz\n" +
        "osnPdHIVCL964vHDWkA34591w5ytyZBQemVP/eBu3zwXSnpp25MxGZ7adl8vAk3K\n" +
        "8aAiBFi8z6nJb0qLBdwxtDk3/BtyHkHplOjptcAjqc5VTi3XafwPWrgpG41rysp+\n" +
        "OrM4DZbQ2UnrC9e6h5PzM0iq5zuMGaUlm7r5HdX4QglgEKgbPXiu4aYjVLg98yd0\n" +
        "CnEfEXonAgMBAAECggEBAJ/mG7eopwYtlvhejm34hganKVdarCSxbt3+Sr866mLK\n" +
        "+0B3NjQ/mXJ0ScjYd7+VQrBHirjBU2pdfgY7wli8o4hAelN6VktpgXBi2qAU/mvH\n" +
        "xo/NuY5m/FmSAmtx07B2HMhO08tE71E16zoZyaYYp5OMwLPm5zcxYXBM0wSfb0vs\n" +
        "jSs6Xgm3rIAeFWHB1NLKEzuEzEPXXYE4OkpiSKRSTStN+KFbSxQhMvfeWpn7Xk/c\n" +
        "66sjuP5DmUfJ+czstSQl6DGcZQG3GtbFWau9BTFhpR+G4kzTl+Yg+i8Rdm0WysPJ\n" +
        "vwR0eVlNZQgr/9Bh7RPvBXkJDOlVTYqKGwIeTbt+OrECgYEA8E6BojOydFs02J5d\n" +
        "Ra9Cg+i+lwjcwHEOwdDDN1ga1FQVWJKA0T01vi/kZqnBQs3KQh7AAInOyAbDQuRs\n" +
        "c/baSdmo8ClPUAVyw5BBEV0bNQIujJs/rbfIW/VlsfzqoVisw/Y52ct+XMW++/Rj\n" +
        "7g5sI62Op6fuSlVPx74kBg6iIdMCgYEA3Hou1WRnN+as4OuB1gyUZeb4BvS9ilqL\n" +
        "NK3dYODUsITIQGmFa5r8E+PQRm9WqYuMSznU7/f4Z3of9iLLxefoQ3U0Hnbp/vr5\n" +
        "2pLlEf4uoCFhnKmHrvY791i4S7VFawQwypWQgYrHbvn7WjUiEQ10SVNmHZ/XhnNq\n" +
        "AHycNWbpPd0CgYAwkN04J9SQGYLDqLXXCIWb3STvp1Xd+rttxkA95it98ARkYy9v\n" +
        "mjxLVKiHaxVo5+hRlp9dPHyzBlLeKQYWJbSWKkwvRVoHJSK9jWDpHnUKMIex2Qp0\n" +
        "lGkE1MKZxzCwLRi1fgTRFIRUQY7IouqzSOzoBQKItbK+CSHXj4D+TGTOCwKBgBPp\n" +
        "mRc+xS/ATrbVrllFs5VsgdQnAINhYBc26LqaM7tpkqh2n00zpzaoqaPi5GHVr6sP\n" +
        "oxK1Q6Mc3YweYmcSZeDJ0hY6STH1OuGpyLSST2W4/hbnHNEJfir9wU9dJNLggwOY\n" +
        "9H8uqIp2W2QvTk9Z9rm0pZFhYVbMT7ORjY4pKEGlAoGAXeDQeIvFOD9yoWVFolwN\n" +
        "8f62vFiZ73Z8JP+kys4mRbQhRUfcKqgTqJ90jGjl2wahOoCfdvdGWgodJOp2k6sM\n" +
        "ezIw9KymTphd2/8zz8yiuxfpcWViyTIzAX3g+QuEQkLPHc52i0ZEKLtfoxn0wIyi\n" +
        "dbjew1CJqsfQgLfKT726bYQ=";
      //微信支付平台公钥
      String rsaPublicKeyFile = "D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\apiclient_cert.pem";
      //时间戳
      String timestamp = Long.toString(System.currentTimeMillis() / 1000);
      //随机数
      String nonce_str = "332de77defe04d4a85e5c19c2d058d89";

      //图片文件
      String filePath = "D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\1M.jpg";//文件路径
      File file = new File(filePath);
      String filename = file.getName();//文件名
      String fileSha256 = DigestUtils.sha256Hex(new FileInputStream(file));//文件sha256

      //拼签名串
      StringBuffer sb = new StringBuffer();
      sb.append("POST").append("\n");
      sb.append("/v3/merchant/media/upload").append("\n");
      sb.append(timestamp).append("\n");
      sb.append(nonce_str).append("\n");
      sb.append("{\"filename\":\"" + filename + "\",\"sha256\":\"" + fileSha256 + "\"}").append("\n");
      System.out.println("签名原串:" + sb.toString());

      //计算签名
      String sign = new String(Base64.encodeBase64(signRSA(sb.toString(), rsaPrivateKey)));
      System.out.println("签名sign值:" + sign);

      //拼装http头的Authorization内容
      String authorization = "WECHATPAY2-SHA256-RSA2048 mchid=\"" + mchid + "\",nonce_str=\"" + nonce_str + "\",signature=\"" + sign + "\",timestamp=\"" + timestamp + "\",serial_no=\"" + serial_no + "\"";
      System.out.println("authorization值:" + authorization);

      //接口URL
      String url = "https://api.mch.weixin.qq.com/v3/merchant/media/upload";
      CloseableHttpClient httpclient = HttpClients.createDefault();
      HttpPost httpPost = new HttpPost(url);

      //设置头部
      httpPost.addHeader("Accept", "application/json");
      httpPost.addHeader("Content-Type", "multipart/form-data");
      httpPost.addHeader("Authorization", authorization);

      //创建MultipartEntityBuilder
      MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
      //设置boundary
      multipartEntityBuilder.setBoundary("boundary");
      multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
      //设置meta内容
      multipartEntityBuilder.addTextBody("meta", "{\"filename\":\"" + filename + "\",\"sha256\":\"" + fileSha256 + "\"}", ContentType.APPLICATION_JSON);
      //设置图片内容
      multipartEntityBuilder.addBinaryBody("file", file, ContentType.create("image/jpg"), filename);
      //放入内容
      httpPost.setEntity(multipartEntityBuilder.build());
      InputStream inputStream = httpPost.getEntity().getContent();

      StringBuilder contentSb = new StringBuilder();
      String line;

      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
      while ((line = br.readLine()) != null) {
        contentSb.append(line);
      }

      String str = contentSb.toString();
      System.out.println("输出---->\n" + str);

      //获取返回内容
      CloseableHttpResponse response = httpclient.execute(httpPost);
      HttpEntity httpEntity = response.getEntity();
      String rescontent = new String(InputStreamTOByte(httpEntity.getContent()));
      System.out.println("返回内容:" + rescontent);
      //获取返回的http header
      Header headers[] = response.getAllHeaders();
      int i = 0;
      while (i < headers.length) {
        System.out.println(headers[i].getName() + ":  " + headers[i].getValue());
        i++;
      }

      //验证微信支付返回签名
      String Wtimestamp = response.getHeaders("Wechatpay-Timestamp")[0].getValue();
      String Wnonce = response.getHeaders("Wechatpay-Nonce")[0].getValue();
      String Wsign = response.getHeaders("Wechatpay-Signature")[0].getValue();
      //拼装待签名串
      StringBuffer ss = new StringBuffer();
      ss.append(Wtimestamp).append("\n");
      ss.append(Wnonce).append("\n");
      ss.append(rescontent).append("\n");
      System.out.println("-------->");
      System.out.println(ss.toString());
      System.out.println("-------->");
      System.out.println("-------->" + Wsign);

      //验证签名
      if (verifyRSA(ss.toString(), Base64.decodeBase64(Wsign.getBytes()), rsaPublicKeyFile)) {
        System.out.println("签名验证成功");
      } else {
        System.out.println("签名验证失败");
      }

      EntityUtils.consume(httpEntity);
      response.close();

    } catch (Exception e) {
      System.out.println("发送POST请求异常！" + e);
      e.printStackTrace();
    }

  }

  public static byte[] InputStreamTOByte(InputStream in) throws IOException {

    int BUFFER_SIZE = 4096;
    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    byte[] data = new byte[BUFFER_SIZE];
    int count = -1;

    while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
      outStream.write(data, 0, count);

    data = null;
    byte[] outByte = outStream.toByteArray();
    outStream.close();

    return outByte;
  }


  public static byte[] signRSA(String data, String priKey) throws Exception {


//签名的类型

    Signature sign = Signature.getInstance("SHA256withRSA");

    //读取商户私钥,该方法传入商户私钥证书的内容即可

    byte[] keyBytes = Base64.decodeBase64(priKey);

    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

    sign.initSign(privateKey);

    sign.update(data.getBytes("UTF-8"));

    return sign.sign();

  }


  public static boolean verifyRSA(String data, byte[] sign, String pubKey) throws Exception {

    if (data == null || sign == null || pubKey == null) {

      return false;

    }


    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    FileInputStream in = new FileInputStream(pubKey);

    Certificate c = cf.generateCertificate(in);

    in.close();

    PublicKey publicKey = c.getPublicKey();

    Signature signature = Signature.getInstance("SHA256WithRSA");

    signature.initVerify(publicKey);

    signature.update(data.getBytes("UTF-8"));

    return signature.verify(sign);


  }


}
