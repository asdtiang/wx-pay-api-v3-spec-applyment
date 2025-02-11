[![Release](https://jitpack.io/v/User/Repo.svg)](https://jitpack.io/#asdtiang/wx-pay-api-v3-spec-applyment)

## 注意：2.0版本切换为微信平台公钥


集成maven repo

https://jitpack.io/#asdtiang/wx-pay-api-v3-spec-applyment 

微信api v3 特约商户进件集成sdk


使用说明：

```java 

        ApplymentInfo applymentInfo = new ApplymentInfo();

        applymentInfo.setBusinessCode("businessCode");
        //设置其它信息
        
         //验证字段
        String validateStr = ApplymentValidator.validateAndFormat(applymentInfo);
        if (StringUtils.isNotBlank(validateStr)) {
           //验证出错处理
        }
        
        
        businessLicenseInfo.setLicenseCopy(getWxImageId(businessLicenseInfo.getLicenseCopy()));
        // 图片上传
        idCardInfo.setIdCardCopy(getWxImageId(idCardInfo.getIdCardCopy()));
        // 图片上传
        idCardInfo.setIdCardNational(getWxImageId(idCardInfo.getIdCardNational()));

        String applymentId = wxPayApiV3SpecService.applyment4sub(applymentInfo);
        
   /**
   如果缓存有图片mediaId,则不用再上传，这里的图片事先存储到阿里云，这只是一个示例
   **/
   
   
   
   private String getWxImageId(String aliyunOssName) throws IOException {
        String mediaId = redisCache.getCacheObject(WxConstants.PAYMENT_APPLYMENT_MEDIA_REDIS_CACHE_PREFIX + aliyunOssName);
        if (StringUtils.isBlank(mediaId)) {
            File file = OSSManager.downloadToTempFile(aliyunOssName);
            mediaId = wxPayApiV3SpecService.upload(file);  //调用微信上传图片接口
            redisCache.setCacheObject(WxConstants.PAYMENT_APPLYMENT_MEDIA_REDIS_CACHE_PREFIX + aliyunOssName, mediaId);
        }
        return mediaId;
    }
    
```


# 欢迎大家打赏

<p align="center">
  <a href="https://www.asdtiang.org/wp-content/uploads/2020/07/wx.jpg">
    <img src="https://www.asdtiang.org/wp-content/uploads/2020/07/wx.jpg" 
    alt="" width="251" height="350">
  </a>
</p>

<p align="center">
  <a href="https://www.asdtiang.org/wp-content/uploads/2020/07/al.jpg">
    <img src="https://www.asdtiang.org/wp-content/uploads/2020/07/al.jpg" 
    alt="" width="251" height="350">
  </a>
</p>
