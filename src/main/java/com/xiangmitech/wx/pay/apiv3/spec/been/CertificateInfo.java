package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.WxCertType;

/**
 * @author abel lee
 * @create 2020-06-06 10:25
 **/
public class CertificateInfo {

  private String certCopy;

  private WxCertType certType;

  private String certNumber;

  private String merchantName;

  private String companyAddress;

  private String legalPerson;

  private String periodBegin;

  private String periodEnd;

  public String getCertCopy() {
    return certCopy;
  }

  public void setCertCopy(String certCopy) {
    this.certCopy = certCopy;
  }

  public WxCertType getCertType() {
    return certType;
  }

  public void setCertType(WxCertType certType) {
    this.certType = certType;
  }

  public String getCertNumber() {
    return certNumber;
  }

  public void setCertNumber(String certNumber) {
    this.certNumber = certNumber;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public String getPeriodBegin() {
    return periodBegin;
  }

  public void setPeriodBegin(String periodBegin) {
    this.periodBegin = periodBegin;
  }

  public String getPeriodEnd() {
    return periodEnd;
  }

  public void setPeriodEnd(String periodEnd) {
    this.periodEnd = periodEnd;
  }
}
