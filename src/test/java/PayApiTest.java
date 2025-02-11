import com.xiangmitech.wx.pay.apiv3.spec.WxPayApiV3SpecConfig;
import com.xiangmitech.wx.pay.apiv3.spec.WxPayApiV3SpecFactory;
import com.xiangmitech.wx.pay.apiv3.spec.WxPayApiV3SpecService;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author abel lee
 * @create 2020-05-25 16:14
 **/
public class PayApiTest {

  @Test
  public void testApplyment() throws IOException {
    File wxPublicKey = new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\pub_key.pem");

    File privateKeyFile = new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\cert\\apiclient_key.pem");


    WxPayApiV3SpecConfig wxPayApiV3SpecConfig = new WxPayApiV3SpecConfig();
    wxPayApiV3SpecConfig.setApiV3Key("332de77defe04d4a85e5c19c2d058d89");
    wxPayApiV3SpecConfig.setMerchantId("1558891591");
    wxPayApiV3SpecConfig.setMerchantSerialNumber("3DCAB7204282575AB6092234A01A1F2E0AB8783F");
    wxPayApiV3SpecConfig.setPrivateKeyInputStream(new FileInputStream(privateKeyFile));
    wxPayApiV3SpecConfig.setWxPublicKeyInputStream(new FileInputStream(wxPublicKey));
    wxPayApiV3SpecConfig.setWxPublicKeyId("PUB_KEY_ID_0115588915912025020800337100001553");

    WxPayApiV3SpecService wxPayApiV3SpecService = WxPayApiV3SpecFactory.getWxPayApiV3SpecService(wxPayApiV3SpecConfig);
//    ApplymentInfo applymentInfo = new ApplymentInfo();
//    applymentInfo.setBusinessCode("business_code_1");
//
//    ContactInfo contactInfo = new ContactInfo();
//    contactInfo.setContactName("李栋梁");
//    contactInfo.setContactEmail("asdtiang@qq.com");
//    contactInfo.setMobilePhone("18190910296");
//    contactInfo.setContactIdNumber("510321198612021430");
//
//    applymentInfo.setContactInfo(contactInfo);

    String resultStr = wxPayApiV3SpecService.upload(new File("D:\\openSource\\wx-pay-api-v3-spec\\src\\main\\resources\\avatar-default.png"));
    System.out.println(resultStr);

  }


}
