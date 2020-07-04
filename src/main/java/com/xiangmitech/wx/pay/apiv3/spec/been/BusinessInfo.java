package com.xiangmitech.wx.pay.apiv3.spec.been;

/**
 * @author abel lee
 * @create 2020-05-25 11:45
 **/
public class BusinessInfo {

  private String merchantShortname;

  private String servicePhone;

  private SalesInfo salesInfo;

  public String getMerchantShortname() {
    return merchantShortname;
  }

  public void setMerchantShortname(String merchantShortname) {
    this.merchantShortname = merchantShortname;
  }

  public String getServicePhone() {
    return servicePhone;
  }

  public void setServicePhone(String servicePhone) {
    this.servicePhone = servicePhone;
  }

  public SalesInfo getSalesInfo() {
    return salesInfo;
  }

  public void setSalesInfo(SalesInfo salesInfo) {
    this.salesInfo = salesInfo;
  }
}
