import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.xiangmitech.wx.pay.apiv3.spec.SpecFieldEncryptFormat;
import com.xiangmitech.wx.pay.apiv3.spec.been.ApplymentInfo;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivateKey;
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
    File file = new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\apiclient_cert.pem");
    X509Certificate x509Certificate = PemUtil.loadCertificate(new FileInputStream(file));
    System.out.println(x509Certificate.getSerialNumber().toString(16));
  }

  @Test
  public void decodeStr() throws IOException, BadPaddingException {
    String str = "y92u0gp48pEIFjqgnpeZbroZvThlReoFCzwKbh0XcpNmj165Ji9FQ1PFkxJedCcpggWlPRY4PxKzSwVy8VxdmgRc3lrqHQUnlc2jZ/dg44i0o97aLQFfrQ/fvFFKqFSCUzckrXexwXSPQlniKc0Qkr1rrCYlBn12oYzbqoCS/ejqHvCX6FAEk8/G6gY37mZuXHe6Hft1CxOlRhaSgZm7CG0qkDbrv/RbV8Wuz3YNc72vhuYcl8Sa/6jAj/YDcg5v/dhtbNgDpusZzJJPgyk0q+96iuUtn5W0Ay43rcJyk6M3m3olvGghSKTNvFtrF23TuxjhMap458usyvvw2tiBrQ==";
    File file = new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\apiclient_key.pem");
    PrivateKey privateKey = PemUtil.loadPrivateKey(new FileInputStream(file));
    String strDec = SpecFieldEncryptFormat.rsaDecryptOAEP(str, privateKey);
    System.out.println(strDec);
  }


}
