package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;

/**
 * @author abel lee
 * @create 2020-05-25 11:27
 **/
public class IdCardInfo {

  /**
   * 正面
   */
  private String idCardCopy;

  /**
   * 反面
   */
  private String idCardNational;

  @SpecEncrypt
  private String idCardName;

  @SpecEncrypt
  private String idCardNumber;

  private String cardPeriodBegin;

  private String cardPeriodEnd;

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

  public String getIdCardName() {
    return idCardName;
  }

  public void setIdCardName(String idCardName) {
    this.idCardName = idCardName;
  }

  public String getIdCardNumber() {
    return idCardNumber;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public String getCardPeriodBegin() {
    return cardPeriodBegin;
  }

  public void setCardPeriodBegin(String cardPeriodBegin) {
    this.cardPeriodBegin = cardPeriodBegin;
  }

  public String getCardPeriodEnd() {
    return cardPeriodEnd;
  }

  public void setCardPeriodEnd(String cardPeriodEnd) {
    this.cardPeriodEnd = cardPeriodEnd;
  }
}
