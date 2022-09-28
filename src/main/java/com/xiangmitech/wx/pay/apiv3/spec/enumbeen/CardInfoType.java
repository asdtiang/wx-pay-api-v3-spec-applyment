package com.xiangmitech.wx.pay.apiv3.spec.enumbeen;

/**
 * @author abel lee
 * @create 2020-05-25 11:16
 **/
public enum CardInfoType {
  LEGAL("经营者/法人"),
  SUPER("经办人"),
  ;


  private String desc;

  private CardInfoType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

}
