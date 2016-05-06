package com.ziroom.mytesla.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
	
	/**
	 * 将源字符串使用MD5加密为字节数组
	 * @param source
	 * @return
	 */
	public static byte[] encode2bytes(String source) {
		byte[] result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(source.getBytes("UTF-8"));
			result = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 将源字符串使用MD5加密为32位16进制数
	 * @param source
	 * @return
	 */
	public static String encode2hex(String source) {
		byte[] data = encode2bytes(source);

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String hex = Integer.toHexString(0xff & data[i]);
			
			if (hex.length() == 1) {
				hexString.append('0');
			}
			
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
	
	/**
	 * 验证字符串是否匹配
	 * @param unknown 待验证的字符串
	 * @param okHex	使用MD5加密过的16进制字符串
	 * @return	匹配返回true，不匹配返回false
	 */
	public static boolean validate(String unknown , String okHex) {
		return okHex.equals(encode2hex(unknown));
	}
	
	
	
	public static String encodeMD5(String str, String key) {
		try {
			return MD5(str + key);
		} catch (Exception e) {
			
		}
		return null;
	}
	
	/**
	 * 进行MD5加密
	 * @param s 需要加密的字符串
	 * @return 加密后的字符串
	 */
	private static String MD5(String str) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
        	if(StringUtil.isEmpty(str)) {
        		return null;
        	}
            byte[] btInput = str.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char strs[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                strs[k++] = hexDigits[byte0 >>> 4 & 0xf];
                strs[k++] = hexDigits[byte0 & 0xf];
            }
            
            return new String(strs).toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }
}