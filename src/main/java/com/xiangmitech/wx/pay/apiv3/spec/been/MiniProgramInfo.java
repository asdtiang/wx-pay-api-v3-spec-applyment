package com.xiangmitech.wx.pay.apiv3.spec.been;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-05-25 11:42
 **/
public class MiniProgramInfo {

  private String miniProgramAppid;

  private String miniProgramSubAppid;

  private List<String> miniProgramPics;

  public String getMiniProgramAppid() {
    return miniProgramAppid;
  }

  public void setMiniProgramAppid(String miniProgramAppid) {
    this.miniProgramAppid = miniProgramAppid;
  }

  public String getMiniProgramSubAppid() {
    return miniProgramSubAppid;
  }

  public void setMiniProgramSubAppid(String miniProgramSubAppid) {
    this.miniProgramSubAppid = miniProgramSubAppid;
  }

  public List<String> getMiniProgramPics() {
    return miniProgramPics;
  }

  public void setMiniProgramPics(List<String> miniProgramPics) {
    this.miniProgramPics = miniProgramPics;
  }
}
