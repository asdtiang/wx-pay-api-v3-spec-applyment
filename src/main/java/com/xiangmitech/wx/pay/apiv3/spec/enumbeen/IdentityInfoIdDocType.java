package com.xiangmitech.wx.pay.apiv3.spec.enumbeen;

/**
 * @author abel lee
 * @create 2020-05-25 11:16
 **/
public enum IdentityInfoIdDocType {
  IDENTIFICATION_TYPE_IDCARD("中国大陆居民-身份证"),
  IDENTIFICATION_TYPE_OVERSEA_PASSPORT("其他国家或地区居民-护照"),
  IDENTIFICATION_TYPE_HONGKONG_PASSPORT("中国香港居民-来往内地通行证"),
  IDENTIFICATION_TYPE_MACAO_PASSPORT("中国澳门居民-来往内地通行证"),
  IDENTIFICATION_TYPE_TAIWAN_PASSPORT("中国台湾居民-来往大陆通行证"),
  ;


  private String desc;

  private IdentityInfoIdDocType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

}
