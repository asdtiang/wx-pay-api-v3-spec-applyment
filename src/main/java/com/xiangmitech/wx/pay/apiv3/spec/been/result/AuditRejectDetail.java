package com.xiangmitech.wx.pay.apiv3.spec.been.result;

/**
 * @author abel lee
 * @create 2020-06-03 12:05
 **/
public class AuditRejectDetail {

  private String field;

  private String fieldName;

  private String rejectReason;

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }
}
