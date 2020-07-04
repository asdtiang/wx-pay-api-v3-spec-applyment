package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;

/**
 * 超级管理员需在开户后进行签约，并接收日常重要管理信息和进行资金操作，请确定其为商户法定代表人或负责人。
 *
 * @author abel lee
 * @create 2020-05-25 10:34
 **/
public class ContactInfo {

  /**
   * 超级管理员姓名
   */
  @SpecEncrypt
  private String contactName;
  /**
   * 超级管理员身份证件号码
   * 1、“超级管理员身份证号码”与“超级管理员微信openid”，二选一必填。
   * 2、超级管理员签约时，校验微信号绑定的银行卡实名信息，是否与该证件号码一致。
   * 3、可传身份证、来往内地通行证、来往大陆通行证、护照等证件号码。
   */
  @SpecEncrypt
  private String contactIdNumber;
  /**
   * 超级管理员微信openid
   * 1、“超级管理员身份证件号码”与“超级管理员微信openid”，二选一必填。
   * 2、超级管理员签约时，校验微信号是否与该微信openid一致。
   */
  private String openid;
  /**
   * 1、11位数字。
   * 2、用于接收微信支付的重要管理信息及日常操作验证码。
   */
  @SpecEncrypt
  private String mobilePhone;
  /**
   * 1、用于接收微信支付的开户邮件及日常业务通知。
   * 2、需要带@，遵循邮箱格式校验，该字段需进行加密处理，
   */
  @SpecEncrypt
  private String contactEmail;

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getContactIdNumber() {
    return contactIdNumber;
  }

  public void setContactIdNumber(String contactIdNumber) {
    this.contactIdNumber = contactIdNumber;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }
}
