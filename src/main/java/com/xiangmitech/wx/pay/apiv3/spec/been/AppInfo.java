package com.xiangmitech.wx.pay.apiv3.spec.been;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-06-06 10:45
 **/
public class AppInfo {

  private String appAppid;

  private String appSubAppid;

  private List<String> appPics;

  public String getAppAppid() {
    return appAppid;
  }

  public void setAppAppid(String appAppid) {
    this.appAppid = appAppid;
  }

  public String getAppSubAppid() {
    return appSubAppid;
  }

  public void setAppSubAppid(String appSubAppid) {
    this.appSubAppid = appSubAppid;
  }

  public List<String> getAppPics() {
    return appPics;
  }

  public void setAppPics(List<String> appPics) {
    this.appPics = appPics;
  }
}
