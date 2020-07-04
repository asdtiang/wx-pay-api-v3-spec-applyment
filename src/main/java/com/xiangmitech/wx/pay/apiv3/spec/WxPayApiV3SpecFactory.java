package com.xiangmitech.wx.pay.apiv3.spec;

/**
 * @author abel lee
 * @create 2020-05-25 10:07
 **/
public class WxPayApiV3SpecFactory {

  public static WxPayApiV3SpecService wxApiV3SpecService;

  public static WxPayApiV3SpecService getWxPayApiV3SpecService(WxPayApiV3SpecConfig wxPayApiV3SpecConfig) {
    synchronized (WxPayApiV3SpecFactory.class) {
      if (wxApiV3SpecService == null) {
        wxApiV3SpecService = new WxPayApiV3SpecServiceDefaultImpl(wxPayApiV3SpecConfig);
      }
    }
    return wxApiV3SpecService;
  }

}
