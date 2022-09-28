package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.IdentityInfoIdDocType;

/**
 * @author abel lee
 * @create 2020-06-06 10:36
 **/
public class UboInfo {

  private IdentityInfoIdDocType uboIdDocType;

  /**
   * 正面
   */
  private String uboIdDocCopy;

  /**
   * 反面
   */
  private String uboIdDocCopyBack;

  private String uboIdDocAddress;

  @SpecEncrypt
  private String uboIdDocName;

  @SpecEncrypt
  private String uboIdDocNumber;

  private String uboPeriodBegin;

  private String ublPeriodEnd;


  public IdentityInfoIdDocType getUboIdDocType() {
    return uboIdDocType;
  }

  public void setUboIdDocType(IdentityInfoIdDocType uboIdDocType) {
    this.uboIdDocType = uboIdDocType;
  }

  public String getUboIdDocCopy() {
    return uboIdDocCopy;
  }

  public void setUboIdDocCopy(String uboIdDocCopy) {
    this.uboIdDocCopy = uboIdDocCopy;
  }

  public String getUboIdDocCopyBack() {
    return uboIdDocCopyBack;
  }

  public void setUboIdDocCopyBack(String uboIdDocCopyBack) {
    this.uboIdDocCopyBack = uboIdDocCopyBack;
  }

  public String getUboIdDocAddress() {
    return uboIdDocAddress;
  }

  public void setUboIdDocAddress(String uboIdDocAddress) {
    this.uboIdDocAddress = uboIdDocAddress;
  }

  public String getUboIdDocName() {
    return uboIdDocName;
  }

  public void setUboIdDocName(String uboIdDocName) {
    this.uboIdDocName = uboIdDocName;
  }

  public String getUboIdDocNumber() {
    return uboIdDocNumber;
  }

  public void setUboIdDocNumber(String uboIdDocNumber) {
    this.uboIdDocNumber = uboIdDocNumber;
  }

  public String getUboPeriodBegin() {
    return uboPeriodBegin;
  }

  public void setUboPeriodBegin(String uboPeriodBegin) {
    this.uboPeriodBegin = uboPeriodBegin;
  }

  public String getUblPeriodEnd() {
    return ublPeriodEnd;
  }

  public void setUblPeriodEnd(String ublPeriodEnd) {
    this.ublPeriodEnd = ublPeriodEnd;
  }
}
