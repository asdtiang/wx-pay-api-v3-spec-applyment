package com.xiangmitech.wx.pay.apiv3.spec.been;

/**
 * @author abel lee
 * @create 2020-06-06 10:45
 **/
public class WebInfo {

  private String domain;

  private String webAuthorisation;

  private String webAppid;

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getWebAuthorisation() {
    return webAuthorisation;
  }

  public void setWebAuthorisation(String webAuthorisation) {
    this.webAuthorisation = webAuthorisation;
  }

  public String getWebAppid() {
    return webAppid;
  }

  public void setWebAppid(String webAppid) {
    this.webAppid = webAppid;
  }
}
