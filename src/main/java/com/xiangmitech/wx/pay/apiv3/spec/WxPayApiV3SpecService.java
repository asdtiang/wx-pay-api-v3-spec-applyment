package com.xiangmitech.wx.pay.apiv3.spec;

import com.xiangmitech.wx.pay.apiv3.spec.been.ApplymentInfo;
import com.xiangmitech.wx.pay.apiv3.spec.been.BankAccountInfo;
import com.xiangmitech.wx.pay.apiv3.spec.been.result.ApplymentStatusResult;
import com.xiangmitech.wx.pay.apiv3.spec.been.result.BankAccountResult;

import javax.crypto.IllegalBlockSizeException;
import java.io.File;
import java.io.IOException;

/**
 * @author abel lee
 * @create 2020-05-25 10:07
 **/
public interface WxPayApiV3SpecService {

  String APPLYMENT_URL = "https://api.mch.weixin.qq.com/v3/applyment4sub/applyment/";

  String SEARCH_APPLY_STATUS_URL = "https://api.mch.weixin.qq.com/v3/applyment4sub/applyment/business_code/{business_code}";

  String CHANGE_SUB_MCH_BANK_URL = "https://api.mch.weixin.qq.com/v3/apply4sub/sub_merchants/{sub_mchid}/modify-settlement";

  String QUERY_SUB_MCH_BANK_URL = "https://api.mch.weixin.qq.com/v3/apply4sub/sub_merchants/{sub_mchid}/settlement";

  String UPLOAD_FILE_URL = "https://api.mch.weixin.qq.com/v3/merchant/media/upload";

  String applyment4sub(ApplymentInfo applymentInfo) throws IOException, IllegalBlockSizeException, IllegalAccessException;

  ApplymentStatusResult applymentStatus(String businessCode) throws IOException;

  boolean changeSubBank(String subMchid, BankAccountInfo bankAccountInfo) throws IOException;

  BankAccountResult querySubMch(String submchId) throws IOException;

  String upload(File file) throws IOException;
}
