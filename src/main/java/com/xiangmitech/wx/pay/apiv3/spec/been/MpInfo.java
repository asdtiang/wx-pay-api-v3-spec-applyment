package com.xiangmitech.wx.pay.apiv3.spec.been;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-06-06 10:45
 **/
public class MpInfo {

  private String mpAppid;

  private String mpSubAppid;

  private List<String> mpPics;


  public String getMpAppid() {
    return mpAppid;
  }

  public void setMpAppid(String mpAppid) {
    this.mpAppid = mpAppid;
  }

  public String getMpSubAppid() {
    return mpSubAppid;
  }

  public void setMpSubAppid(String mpSubAppid) {
    this.mpSubAppid = mpSubAppid;
  }

  public List<String> getMpPics() {
    return mpPics;
  }

  public void setMpPics(List<String> mpPics) {
    this.mpPics = mpPics;
  }
}
