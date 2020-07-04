package com.xiangmitech.wx.pay.apiv3.spec.been;

import java.util.List;

/**
 * @author abel lee
 * @create 2020-06-06 10:45
 **/
public class WeworkInfo {

  private String subCorpId;

  private List<String> weworkPics;

  public String getSubCorpId() {
    return subCorpId;
  }

  public void setSubCorpId(String subCorpId) {
    this.subCorpId = subCorpId;
  }

  public List<String> getWeworkPics() {
    return weworkPics;
  }

  public void setWeworkPics(List<String> weworkPics) {
    this.weworkPics = weworkPics;
  }
}
