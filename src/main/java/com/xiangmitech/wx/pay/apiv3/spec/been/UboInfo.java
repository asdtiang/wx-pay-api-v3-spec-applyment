package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.IdentityInfoIdDocType;

/**
 * @author abel lee
 * @create 2020-06-06 10:36
 **/
public class UboInfo {

  private IdentityInfoIdDocType idType;

  /**
   * 正面
   */
  private String idCardCopy;

  /**
   * 反面
   */
  private String idCardNational;

  private String idDocCopy;

  @SpecEncrypt
  private String name;

  @SpecEncrypt
  private String idCardNumber;

  private String idPeriodBegin;

  private String idPeriodEnd;


  public IdentityInfoIdDocType getIdType() {
    return idType;
  }

  public void setIdType(IdentityInfoIdDocType idType) {
    this.idType = idType;
  }

  public String getIdCardCopy() {
    return idCardCopy;
  }

  public void setIdCardCopy(String idCardCopy) {
    this.idCardCopy = idCardCopy;
  }

  public String getIdCardNational() {
    return idCardNational;
  }

  public void setIdCardNational(String idCardNational) {
    this.idCardNational = idCardNational;
  }

  public String getIdDocCopy() {
    return idDocCopy;
  }

  public void setIdDocCopy(String idDocCopy) {
    this.idDocCopy = idDocCopy;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdCardNumber() {
    return idCardNumber;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public String getIdPeriodBegin() {
    return idPeriodBegin;
  }

  public void setIdPeriodBegin(String idPeriodBegin) {
    this.idPeriodBegin = idPeriodBegin;
  }

  public String getIdPeriodEnd() {
    return idPeriodEnd;
  }

  public void setIdPeriodEnd(String idPeriodEnd) {
    this.idPeriodEnd = idPeriodEnd;
  }
}
