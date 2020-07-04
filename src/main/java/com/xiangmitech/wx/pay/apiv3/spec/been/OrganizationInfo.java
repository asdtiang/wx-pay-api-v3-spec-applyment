package com.xiangmitech.wx.pay.apiv3.spec.been;

/**
 * @author abel lee
 * @create 2020-06-06 10:33
 **/
public class OrganizationInfo {

  private String organizationCopy;

  private String organizationCode;

  private String orgPeriodBegin;

  private String orgPeriodEnd;

  public String getOrganizationCopy() {
    return organizationCopy;
  }

  public void setOrganizationCopy(String organizationCopy) {
    this.organizationCopy = organizationCopy;
  }

  public String getOrganizationCode() {
    return organizationCode;
  }

  public void setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
  }

  public String getOrgPeriodBegin() {
    return orgPeriodBegin;
  }

  public void setOrgPeriodBegin(String orgPeriodBegin) {
    this.orgPeriodBegin = orgPeriodBegin;
  }

  public String getOrgPeriodEnd() {
    return orgPeriodEnd;
  }

  public void setOrgPeriodEnd(String orgPeriodEnd) {
    this.orgPeriodEnd = orgPeriodEnd;
  }
}
