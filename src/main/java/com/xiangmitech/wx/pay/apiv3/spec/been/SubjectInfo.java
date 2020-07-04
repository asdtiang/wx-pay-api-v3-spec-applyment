package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.SubjectType;

/**
 * @author abel lee
 * @create 2020-05-25 11:15
 **/
public class SubjectInfo {

  private SubjectType subjectType;

  /**
   * 营业执照
   * 1、主体为个体户/企业，必填。
   * 2、请上传“营业执照”，需年检章齐全，当年注册除外。
   */
  private BusinessLicenseInfo businessLicenseInfo;

  @SpecEncrypt
  private IdentityInfo identityInfo;

  private CertificateInfo certificateInfo;

  private OrganizationInfo organizationInfo;

  private String certificateLetterCopy;

  @SpecEncrypt
  private UboInfo uboInfo;


  public CertificateInfo getCertificateInfo() {
    return certificateInfo;
  }

  public void setCertificateInfo(CertificateInfo certificateInfo) {
    this.certificateInfo = certificateInfo;
  }

  public OrganizationInfo getOrganizationInfo() {
    return organizationInfo;
  }

  public void setOrganizationInfo(OrganizationInfo organizationInfo) {
    this.organizationInfo = organizationInfo;
  }

  public String getCertificateLetterCopy() {
    return certificateLetterCopy;
  }

  public void setCertificateLetterCopy(String certificateLetterCopy) {
    this.certificateLetterCopy = certificateLetterCopy;
  }

  public UboInfo getUboInfo() {
    return uboInfo;
  }

  public void setUboInfo(UboInfo uboInfo) {
    this.uboInfo = uboInfo;
  }

  public SubjectType getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(SubjectType subjectType) {
    this.subjectType = subjectType;
  }

  public BusinessLicenseInfo getBusinessLicenseInfo() {
    return businessLicenseInfo;
  }

  public void setBusinessLicenseInfo(BusinessLicenseInfo businessLicenseInfo) {
    this.businessLicenseInfo = businessLicenseInfo;
  }

  public IdentityInfo getIdentityInfo() {
    return identityInfo;
  }

  public void setIdentityInfo(IdentityInfo identityInfo) {
    this.identityInfo = identityInfo;
  }


}
