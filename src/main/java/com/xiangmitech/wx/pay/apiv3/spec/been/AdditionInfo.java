package com.xiangmitech.wx.pay.apiv3.spec.been;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-05-25 11:56
 **/
public class AdditionInfo {

  private String legalPersonCommitment;

  private String legalPersonVideo;

  private List<String> businessAdditionPics;

  private String businessAdditionMsg;

  public String getLegalPersonCommitment() {
    return legalPersonCommitment;
  }

  public void setLegalPersonCommitment(String legalPersonCommitment) {
    this.legalPersonCommitment = legalPersonCommitment;
  }

  public String getLegalPersonVideo() {
    return legalPersonVideo;
  }

  public void setLegalPersonVideo(String legalPersonVideo) {
    this.legalPersonVideo = legalPersonVideo;
  }

  public List<String> getBusinessAdditionPics() {
    return businessAdditionPics;
  }

  public void setBusinessAdditionPics(List<String> businessAdditionPics) {
    this.businessAdditionPics = businessAdditionPics;
  }

  public String getBusinessAdditionMsg() {
    return businessAdditionMsg;
  }

  public void setBusinessAdditionMsg(String businessAdditionMsg) {
    this.businessAdditionMsg = businessAdditionMsg;
  }
}
