import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.pay.java.core.cipher.PrivacyDecryptor;
import com.wechat.pay.java.core.cipher.PrivacyEncryptor;
import com.wechat.pay.java.core.cipher.RSAPrivacyDecryptor;
import com.wechat.pay.java.core.cipher.RSAPrivacyEncryptor;
import com.wechat.pay.java.core.util.IOUtil;
import com.wechat.pay.java.core.util.PemUtil;
import com.xiangmitech.wx.pay.apiv3.spec.SpecFieldEncryptFormat;
import com.xiangmitech.wx.pay.apiv3.spec.been.ApplymentInfo;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

/**
 * @author abel lee
 * @create 2020-05-25 10:17
 **/
public class JsonTest {

  @Test
  public void testJson() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);
    ApplymentInfo applymentInfo = new ApplymentInfo();
    applymentInfo.setBusinessCode("sssss");
    System.out.println(objectMapper.writeValueAsString(applymentInfo));
  }

  @Test
  public void applyTest() throws Exception {
    File file = new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\pub_key.pem");
    PublicKey wechatPayPublicKey = genPublicKeyFromInputStream( new FileInputStream(file));
    PrivacyEncryptor encryptor = new RSAPrivacyEncryptor(wechatPayPublicKey,"PUB_KEY_ID_0115588915912025020800337100001553");
    String str = encryptor.encrypt("aaaa");
    System.out.println(str);
  }

  @Test
  public void decodeStr() throws IOException, BadPaddingException {
    String str = "yE/I4VaixM2c5ld/u4Jl9ehflEupoB17Mwv8Zm3mOJesHZkOamas0zKvHppTqIC0Pij0Ax2jpPDSLTe6v5Fp3qgHC7f+sDCTFLYFOMLEjLndsrXqisDtgzSKBzrrwG7wiYt67gxecnFHjKhKmg5hBrcCpBp9l8EFWG8kgEJvrGFV2Jw7hSePE6G+JnmBia68H0LsKlhFXJVZ8jW97tGvekMuKAE6J6SKPHrLkN5DdIAjWBt1SUuSdxwG7Crp0VIAzNWMbOGivU4hkW3PEgEn2DlyExpQXPoVfhivPKzsALGGmGxnLCtQ2ULSiKNWZzqBH/kHCXzwqPYRwuR+t4B+0w==";
    File file = new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\apiclient_key.pem");
    PrivateKey privateKey = genPrivateKeyFromInputStream(new FileInputStream(file));
    PrivacyDecryptor decryptor = new RSAPrivacyDecryptor(privateKey);
    String strDec = decryptor.decrypt(str);
    System.out.println(strDec);
  }
  public PrivateKey genPrivateKeyFromInputStream(InputStream inputStream) throws IOException {
    String key = IOUtil.toString(inputStream);
    return PemUtil.loadPrivateKeyFromString(key);
  }

  public PublicKey genPublicKeyFromInputStream(InputStream inputStream) throws IOException {
    String key = IOUtil.toString(inputStream);
    return PemUtil.loadPublicKeyFromString(key);
  }

}
