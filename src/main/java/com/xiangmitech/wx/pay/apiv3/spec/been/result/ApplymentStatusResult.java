package com.xiangmitech.wx.pay.apiv3.spec.been.result;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-06-03 12:01
 **/
public class ApplymentStatusResult {

  private String sourceJson;

  private String businessCode;

  private String applymentId;

  private String subMchid;

  private String signUrl;

  private String applymentState;

  private String applymentStateMsg;

  private List<AuditRejectDetail> auditDetail;


  public String getSourceJson() {
    return sourceJson;
  }

  public void setSourceJson(String sourceJson) {
    this.sourceJson = sourceJson;
  }

  public String getBusinessCode() {
    return businessCode;
  }

  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode;
  }

  public String getApplymentId() {
    return applymentId;
  }

  public void setApplymentId(String applymentId) {
    this.applymentId = applymentId;
  }

  public String getSubMchid() {
    return subMchid;
  }

  public void setSubMchid(String subMchid) {
    this.subMchid = subMchid;
  }

  public String getSignUrl() {
    return signUrl;
  }

  public void setSignUrl(String signUrl) {
    this.signUrl = signUrl;
  }

  public String getApplymentState() {
    return applymentState;
  }

  public void setApplymentState(String applymentState) {
    this.applymentState = applymentState;
  }

  public String getApplymentStateMsg() {
    return applymentStateMsg;
  }

  public void setApplymentStateMsg(String applymentStateMsg) {
    this.applymentStateMsg = applymentStateMsg;
  }

  public List<AuditRejectDetail> getAuditDetail() {
    return auditDetail;
  }

  public void setAuditDetail(List<AuditRejectDetail> auditDetail) {
    this.auditDetail = auditDetail;
  }
}
