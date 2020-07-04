package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.IdentityInfoIdDocType;

/**
 * @author abel lee
 * @create 2020-05-25 11:25
 **/
public class IdentityInfo {

  private IdentityInfoIdDocType idDocType; // TODO 其它类型

  @SpecEncrypt
  private IdCardInfo idCardInfo;

  private boolean owner = true;

  //TODO id_doc_info owner

  public IdentityInfoIdDocType getIdDocType() {
    return idDocType;
  }

  public void setIdDocType(IdentityInfoIdDocType idDocType) {
    this.idDocType = idDocType;
  }

  public IdCardInfo getIdCardInfo() {
    return idCardInfo;
  }

  public void setIdCardInfo(IdCardInfo idCardInfo) {
    this.idCardInfo = idCardInfo;
  }

  public boolean isOwner() {
    return owner;
  }

  public void setOwner(boolean owner) {
    this.owner = owner;
  }
}
