package com.xiangmitech.wx.pay.apiv3.spec.been.result;


import com.xiangmitech.wx.pay.apiv3.spec.enumbeen.BankAccountType;

/**
 * @author abel lee
 * @create 2020-05-25 15:15
 **/
public class BankAccountResult {

  private BankAccountType accountType;
  private String accountBank;
  private String bankBranchId;
  private String bankName;
  private String accountNumber;
  private String verifyResult;
  private String sourceJson;

  public BankAccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(BankAccountType accountType) {
    this.accountType = accountType;
  }

  public String getAccountBank() {
    return accountBank;
  }

  public void setAccountBank(String accountBank) {
    this.accountBank = accountBank;
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

  public String getVerifyResult() {
    return verifyResult;
  }

  public void setVerifyResult(String verifyResult) {
    this.verifyResult = verifyResult;
  }

  public String getSourceJson() {
    return sourceJson;
  }

  public void setSourceJson(String sourceJson) {
    this.sourceJson = sourceJson;
  }
}
