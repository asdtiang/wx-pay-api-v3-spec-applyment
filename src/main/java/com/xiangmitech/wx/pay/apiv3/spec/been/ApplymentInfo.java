package com.xiangmitech.wx.pay.apiv3.spec.been;


import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;

/**
 * wx文档地址 https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/applyment4sub/chapter3_1.shtml
 *
 * @author abel lee
 * @create 2020-05-25 10:14
 **/
public class ApplymentInfo {

  /**
   * 1、服务商自定义的唯一编号。
   * 2、每个编号对应一个申请单，每个申请单审核通过后会生成一个微信支付商户号。
   * 3、若申请单被驳回，可填写相同的“业务申请编号”，即可覆盖修改原申请单信息。
   */
  private String businessCode;

  /**
   * 超级管理员信息
   * 超级管理员需在开户后进行签约，并接收日常重要管理信息和进行资金操作，请确定其为商户法定代表人或负责人。
   */
  @SpecEncrypt
  private ContactInfo contactInfo;

  /**
   * -主体资料
   */
  @SpecEncrypt
  private SubjectInfo subjectInfo;

  /**
   * 经营资料
   */
  private BusinessInfo businessInfo;
  /**
   * 结算规则
   */
  private SettlementInfo settlementInfo;

  /**
   * 结算银行账户
   */
  @SpecEncrypt
  private BankAccountInfo bankAccountInfo;

  /**
   * 补充材料
   */
  private AdditionInfo additionInfo;

  public AdditionInfo getAdditionInfo() {
    return additionInfo;
  }

  public void setAdditionInfo(AdditionInfo additionInfo) {
    this.additionInfo = additionInfo;
  }

  public BankAccountInfo getBankAccountInfo() {
    return bankAccountInfo;
  }

  public void setBankAccountInfo(BankAccountInfo bankAccountInfo) {
    this.bankAccountInfo = bankAccountInfo;
  }

  public SettlementInfo getSettlementInfo() {
    return settlementInfo;
  }

  public void setSettlementInfo(SettlementInfo settlementInfo) {
    this.settlementInfo = settlementInfo;
  }

  public SubjectInfo getSubjectInfo() {
    return subjectInfo;
  }

  public void setSubjectInfo(SubjectInfo subjectInfo) {
    this.subjectInfo = subjectInfo;
  }

  public BusinessInfo getBusinessInfo() {
    return businessInfo;
  }

  public void setBusinessInfo(BusinessInfo businessInfo) {
    this.businessInfo = businessInfo;
  }

  public String getBusinessCode() {
    return businessCode;
  }

  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }
}
