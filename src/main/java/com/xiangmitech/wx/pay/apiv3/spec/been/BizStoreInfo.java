package com.xiangmitech.wx.pay.apiv3.spec.been;

/**
 * @author abel lee
 * @create 2020-06-06 10:41
 **/
public class BizStoreInfo {

  private String bizStoreName;

  private String bizAddressCode;

  private String bizStoreAddress;

  private String storeEntrancePic;

  private String indoorPic;

  private String bizSubAppid;

  public String getBizStoreName() {
    return bizStoreName;
  }

  public void setBizStoreName(String bizStoreName) {
    this.bizStoreName = bizStoreName;
  }

  public String getBizAddressCode() {
    return bizAddressCode;
  }

  public void setBizAddressCode(String bizAddressCode) {
    this.bizAddressCode = bizAddressCode;
  }

  public String getBizStoreAddress() {
    return bizStoreAddress;
  }

  public void setBizStoreAddress(String bizStoreAddress) {
    this.bizStoreAddress = bizStoreAddress;
  }

  public String getStoreEntrancePic() {
    return storeEntrancePic;
  }

  public void setStoreEntrancePic(String storeEntrancePic) {
    this.storeEntrancePic = storeEntrancePic;
  }

  public String getIndoorPic() {
    return indoorPic;
  }

  public void setIndoorPic(String indoorPic) {
    this.indoorPic = indoorPic;
  }

  public String getBizSubAppid() {
    return bizSubAppid;
  }

  public void setBizSubAppid(String bizSubAppid) {
    this.bizSubAppid = bizSubAppid;
  }
}
