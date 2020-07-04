package com.xiangmitech.wx.pay.apiv3.spec.been;


import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.SalesScenesType;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-05-25 11:42
 **/
public class SalesInfo {

  private List<SalesScenesType> salesScenesType;

  private MiniProgramInfo miniProgramInfo;

  private BizStoreInfo bizStoreInfo;

  private MpInfo mpInfo;

  private AppInfo appInfo;

  private WebInfo webInfo;

  private WeworkInfo weworkInfo;

  public MpInfo getMpInfo() {
    return mpInfo;
  }

  public void setMpInfo(MpInfo mpInfo) {
    this.mpInfo = mpInfo;
  }

  public AppInfo getAppInfo() {
    return appInfo;
  }

  public void setAppInfo(AppInfo appInfo) {
    this.appInfo = appInfo;
  }

  public WebInfo getWebInfo() {
    return webInfo;
  }

  public void setWebInfo(WebInfo webInfo) {
    this.webInfo = webInfo;
  }

  public WeworkInfo getWeworkInfo() {
    return weworkInfo;
  }

  public void setWeworkInfo(WeworkInfo weworkInfo) {
    this.weworkInfo = weworkInfo;
  }

  public BizStoreInfo getBizStoreInfo() {
    return bizStoreInfo;
  }

  public void setBizStoreInfo(BizStoreInfo bizStoreInfo) {
    this.bizStoreInfo = bizStoreInfo;
  }

  public List<SalesScenesType> getSalesScenesType() {
    return salesScenesType;
  }

  public void setSalesScenesType(List<SalesScenesType> salesScenesType) {
    this.salesScenesType = salesScenesType;
  }

  public MiniProgramInfo getMiniProgramInfo() {
    return miniProgramInfo;
  }

  public void setMiniProgramInfo(MiniProgramInfo miniProgramInfo) {
    this.miniProgramInfo = miniProgramInfo;
  }
}
