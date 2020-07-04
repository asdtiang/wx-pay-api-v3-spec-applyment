package com.xiangmitech.wx.pay.apiv3.spec.been;

/**
 * 1、主体为个体户/企业，必填。
 * 2、请上传“营业执照”，需年检章齐全，当年注册除外。
 *
 * @author abel lee
 * @create 2020-05-25 11:20
 **/
public class BusinessLicenseInfo {

  /**
   * 营业执照照片
   * 1、可上传1张图片，请填写通过图片上传接口生成好的MediaID。
   * 2、 请上传彩色照片or彩色扫描件or复印件（需加盖公章鲜章），可添加“微信支付”相关水印（如微信支付认证） 。
   */
  private String licenseCopy;
  /**
   * 注册号/统一社会信用代码
   * 请填写营业执照上的营业执照注册号，注册号格式须为15位数字或18位数字|大写字母。
   */
  private String licenseNumber;
  /**
   * 商户名称
   * 1、请填写营业执照上的商户名称，2~110个字符，支持括号。
   * 2、个体户，不能以“公司”结尾。
   * 3、个体户，若营业执照上商户名称为“空“或“无”时，填写"个体户+经营者姓名"，如“个体户张三”。
   */
  private String merchantName;
  /**
   * 个体户经营者/法人姓名
   * 请填写营业执照的经营者/法定代表人姓名。
   */
  private String legalPerson;

  public String getLicenseCopy() {
    return licenseCopy;
  }

  public void setLicenseCopy(String licenseCopy) {
    this.licenseCopy = licenseCopy;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }
}
