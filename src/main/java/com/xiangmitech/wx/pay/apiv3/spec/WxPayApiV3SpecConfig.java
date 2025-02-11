package com.xiangmitech.wx.pay.apiv3.spec;

import java.io.InputStream;

/**
 * @author abel lee
 * @create 2020-05-25 10:00
 **/
public class WxPayApiV3SpecConfig {
  /**
   *   微信公钥 pub_key.pem
   */
  private InputStream wxPublicKeyInputStream;
  /**
   * 微信支付公钥ID
   */
  private String wxPublicKeyId;
  /**
   * 私钥文件  key.pem
   */
  private InputStream privateKeyInputStream;
  /**
   * 服务商户号
   */
  private String merchantId;
  /**
   * 商户证书编号
   */
  private String merchantSerialNumber;
  /**
   * apiV3密钥
   */
  private String apiV3Key;

  public InputStream getWxPublicKeyInputStream() {
    return wxPublicKeyInputStream;
  }

  public void setWxPublicKeyInputStream(InputStream wxPublicKeyInputStream) {
    this.wxPublicKeyInputStream = wxPublicKeyInputStream;
  }

  public String getWxPublicKeyId() {
    return wxPublicKeyId;
  }

  public void setWxPublicKeyId(String wxPublicKeyId) {
    this.wxPublicKeyId = wxPublicKeyId;
  }

  public InputStream getPrivateKeyInputStream() {
    return privateKeyInputStream;
  }

  public void setPrivateKeyInputStream(InputStream privateKeyInputStream) {
    this.privateKeyInputStream = privateKeyInputStream;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getMerchantSerialNumber() {
    return merchantSerialNumber;
  }

  public void setMerchantSerialNumber(String merchantSerialNumber) {
    this.merchantSerialNumber = merchantSerialNumber;
  }

  public String getApiV3Key() {
    return apiV3Key;
  }

  public void setApiV3Key(String apiV3Key) {
    this.apiV3Key = apiV3Key;
  }
}
