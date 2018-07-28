package com.whbs.market.util;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;
/**   
 * @Description: 密码加密处理
 *     
 * @author wanghao   
 * @version  1.0   
 */
@SuppressWarnings("restriction")
public class PasswordMD5 {

	public String EncoderByMd5(String str) throws Exception{
	    //确定计算方法
	    MessageDigest md5=MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	    //加密后的字符串
	    String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	    return newstr;
	  }
	
//	public static void main(String[] args) throws  Exception {
//		
//		PasswordMD5 sMd5=new PasswordMD5();
//		System.out.println(sMd5.EncoderByMd5("123456"));
//		//4QrcOUm6Wau+VuBX8g+IPg==
//	}
}
