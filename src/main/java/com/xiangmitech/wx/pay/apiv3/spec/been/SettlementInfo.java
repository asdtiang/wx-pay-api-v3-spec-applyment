package com.xiangmitech.wx.pay.apiv3.spec.been;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-05-25 11:48
 **/
public class SettlementInfo {

  private String settlementId;

  private String qualificationType;

  private List<String> qualifications;

  private String activitiesId;

  private String activitiesRate;

  private List<String> activitiesAdditions;

  public String getSettlementId() {
    return settlementId;
  }

  public void setSettlementId(String settlementId) {
    this.settlementId = settlementId;
  }

  public String getQualificationType() {
    return qualificationType;
  }

  public void setQualificationType(String qualificationType) {
    this.qualificationType = qualificationType;
  }

  public List<String> getQualifications() {
    return qualifications;
  }

  public void setQualifications(List<String> qualifications) {
    this.qualifications = qualifications;
  }

  public String getActivitiesId() {
    return activitiesId;
  }

  public void setActivitiesId(String activitiesId) {
    this.activitiesId = activitiesId;
  }

  public String getActivitiesRate() {
    return activitiesRate;
  }

  public void setActivitiesRate(String activitiesRate) {
    this.activitiesRate = activitiesRate;
  }

  public List<String> getActivitiesAdditions() {
    return activitiesAdditions;
  }

  public void setActivitiesAdditions(List<String> activitiesAdditions) {
    this.activitiesAdditions = activitiesAdditions;
  }
}
