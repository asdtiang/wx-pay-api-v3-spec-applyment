package com.xiangmitech.wx.pay.apiv3.spec.been;

import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;
import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.BankAccountType;

/**
 * @author abel lee
 * @create 2020-05-25 11:50
 **/
public class BankAccountInfo {

  private BankAccountType bankAccountType;
  @SpecEncrypt
  private String accountName;
  private String accountBank;
  private String bankAddressCode;
  private String bankBranchId;
  private String bankName;
  @SpecEncrypt
  private String accountNumber;


  public BankAccountType getBankAccountType() {
    return bankAccountType;
  }

  public void setBankAccountType(BankAccountType bankAccountType) {
    this.bankAccountType = bankAccountType;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountBank() {
    return accountBank;
  }

  public void setAccountBank(String accountBank) {
    this.accountBank = accountBank;
  }

  public String getBankAddressCode() {
    return bankAddressCode;
  }

  public void setBankAddressCode(String bankAddressCode) {
    this.bankAddressCode = bankAddressCode;
  }

  public String getBankBranchId() {
    return bankBranchId;
  }

  public void setBankBranchId(String bankBranchId) {
    this.bankBranchId = bankBranchId;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
}
