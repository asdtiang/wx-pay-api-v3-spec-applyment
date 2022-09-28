package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.SubjectType;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-05-25 11:15
 **/
public class SubjectInfo {

  private SubjectType subjectType;

  private Boolean financeInstitution;

  /**
   * 营业执照
   * 1、主体为个体户/企业，必填。
   * 2、请上传“营业执照”，需年检章齐全，当年注册除外。
   */
  private BusinessLicenseInfo businessLicenseInfo;

  @SpecEncrypt
  private IdentityInfo identityInfo;

  private CertificateInfo certificateInfo;

  private String certificateLetterCopy;

  @SpecEncrypt
  private List<UboInfo> uboInfoList;


  public CertificateInfo getCertificateInfo() {
    return certificateInfo;
  }

  public void setCertificateInfo(CertificateInfo certificateInfo) {
    this.certificateInfo = certificateInfo;
  }


  public String getCertificateLetterCopy() {
    return certificateLetterCopy;
  }

  public void setCertificateLetterCopy(String certificateLetterCopy) {
    this.certificateLetterCopy = certificateLetterCopy;
  }

  public List<UboInfo> getUboInfoList() {
    return uboInfoList;
  }

  public void setUboInfoList(List<UboInfo> uboInfoList) {
    this.uboInfoList = uboInfoList;
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
