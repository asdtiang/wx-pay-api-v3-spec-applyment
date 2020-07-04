package com.xiangmitech.wx.pay.apiv3.spec.enumbeen;

/**
 * @author abel lee
 * @create 2020-05-25 11:16
 **/
public enum BankAccountType {
  BANK_ACCOUNT_TYPE_CORPORATE("对公银行账户"),
  BANK_ACCOUNT_TYPE_PERSONAL("经营者个人银行卡");

  private String desc;

  private BankAccountType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

}
