package com.xiangmitech.wx.pay.apiv3.spec.enumbeen;

/**
 * @author abel lee
 * @create 2020-05-25 11:16
 **/
public enum SalesScenesType {
  SALES_SCENES_STORE("线下门店"),
  SALES_SCENES_MP("公众号"),
  SALES_SCENES_MINI_PROGRAM("小程序"),
  SALES_SCENES_WEB("互联网"),
  SALES_SCENES_APP("APP"),
  SALES_SCENES_WEWORK("企业微信");

  private String desc;

  private SalesScenesType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

}
