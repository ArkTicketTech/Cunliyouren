package com.clyr.utils;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.UUID;


public class SignUtil {
	

	
	
	/**
     * 获得分享链接的签名。
     * @param ticket
     * @param nonceStr
     * @param timeStamp
     * @param url
     * @return
     * @throws Exception
     */
    public static String getSignature(String ticket, String nonceStr, long timeStamp, String url) throws Exception {
        String sKey = "jsapi_ticket=" + ticket
                + "&noncestr=" + nonceStr + "&timestamp=" + timeStamp
                + "&url=" + url;
        System.out.println(sKey);
        return getSignature(sKey);
    }
//具体签名方法如下
 
    public static String create_nonce_str() {

        return UUID.randomUUID().toString();

    }
    
    public static long create_timestamp() {

        return System.currentTimeMillis() / 1000;

    }
 
 
 /**
     * 验证签名。
     * 
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String getSignature(String sKey) throws Exception {
    	String signature = "";
    	MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(sKey.getBytes("UTF-8"));
        signature = byteToHex(crypt.digest());
        return signature;
    }
    
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
 
// /** 
//     * 将字节数组转换为十六进制字符串 
//     *  
//     * @param byteArray 
//     * @return 
//     */ 
//    private static String byteToStr(byte[] byteArray) {  
//        String strDigest = "";  
//        for (int i = 0; i < byteArray.length; i++) {  
//            strDigest += byteToHexStr(byteArray[i]);  
//        }  
//        return strDigest;  
//    }  
//  /** 
//     * 将字节转换为十六进制字符串 
//     *  
//     * @param mByte 
//     * @return 
//     */ 
//    private static String byteToHexStr(byte mByte) {  
//        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
//        char[] tempArr = new char[2];  
//        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
//        tempArr[1] = Digit[mByte & 0X0F];  
//   
//        String s = new String(tempArr);  
//        return s;  
//    }

}
