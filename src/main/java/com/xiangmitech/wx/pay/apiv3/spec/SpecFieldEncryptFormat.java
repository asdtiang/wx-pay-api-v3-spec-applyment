package com.xiangmitech.wx.pay.apiv3.spec;

import com.wechat.pay.java.core.cipher.PrivacyEncryptor;
import com.xiangmitech.wx.pay.apiv3.spec.anno.SpecEncrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * @author abel lee
 * @create 2020-05-25 10:45
 **/
public class SpecFieldEncryptFormat {


  public static void encryptField(Object encryptObject, PrivacyEncryptor encryptor) throws IllegalAccessException, IOException, IllegalBlockSizeException {
    Class<?> infoClass = encryptObject.getClass();
    Field[] infoFieldArray = infoClass.getDeclaredFields();
    for (Field field : infoFieldArray) {
      if (field.isAnnotationPresent(SpecEncrypt.class)) {
        if (field.getType().getTypeName().equals("java.lang.String")) {
          field.setAccessible(true);
          Object oldValue = field.get(encryptObject);
          if (oldValue != null) {
            String oldStr = (String) oldValue;
            if (!oldStr.trim().equals("'")) {
              field.set(encryptObject, rsaEncryptOAEP(oldStr, encryptor));
            }
          }
        } else {
          field.setAccessible(true);
          Object obj = field.get(encryptObject);
          if (obj != null) {
            encryptField(field.get(encryptObject), encryptor);
          }
        }
      }
    }
  }

  //TODO 证书加密
  public static String rsaEncryptOAEP(String message, PrivacyEncryptor encryptor) throws IllegalBlockSizeException, IOException {
   return encryptor.encrypt(message);
  }

  public static String rsaDecryptOAEP(String ciphertext, PrivateKey privateKey)
    throws BadPaddingException, IOException {
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
      byte[] data = Base64.getDecoder().decode(ciphertext);
      return new String(cipher.doFinal(data), "utf-8");
    } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
      throw new RuntimeException("当前Java环境不支持RSA v1.5/OAEP", e);
    } catch (InvalidKeyException e) {
      throw new IllegalArgumentException("无效的私钥", e);
    } catch (BadPaddingException | IllegalBlockSizeException e) {
      throw new BadPaddingException("解密失败");
    }
  }


}
