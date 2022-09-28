package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.CardInfoType;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.IdentityInfoIdDocType;

/**
 * @author abel lee
 * @create 2020-05-25 11:25
 **/
public class IdentityInfo {

  private CardInfoType idHolderType;

  private IdentityInfoIdDocType idDocType;

  private String authorizeLetterCopy;

  @SpecEncrypt
  private IdCardInfo idCardInfo;

  @SpecEncrypt
  private IdCardInfo idDocInfo;

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

  public CardInfoType getIdHolderType() {
    return idHolderType;
  }

  public void setIdHolderType(CardInfoType idHolderType) {
    this.idHolderType = idHolderType;
  }

  public String getAuthorizeLetterCopy() {
    return authorizeLetterCopy;
  }

  public void setAuthorizeLetterCopy(String authorizeLetterCopy) {
    this.authorizeLetterCopy = authorizeLetterCopy;
  }

  public IdCardInfo getIdDocInfo() {
    return idDocInfo;
  }

  public void setIdDocInfo(IdCardInfo idDocInfo) {
    this.idDocInfo = idDocInfo;
  }
}
