package com.panda.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MD5Utils {
	private static final String HEX_NUMS_STR = "0123456789ABCDEF";
	private static final String HMAC_MD5_NAME = "HmacMD5";
	private static final int SALT_LENGTH = 12;

	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithmException caught!" + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}

		if(null == messageDigest){
			return null;
		}

		byte[] byteArray = messageDigest.digest();
		return Hex.toString(byteArray);
	}

	public static String hmacMD5(String str, String salt) {
		byte[] saltBytes;
		if (null == salt) {
			saltBytes = new byte[] {-1};
		} else {
			saltBytes = salt.getBytes(Charset.forName("UTF-8"));
		}
		SecretKeySpec sk = new SecretKeySpec(saltBytes, HMAC_MD5_NAME);
		Mac mac;
		try {
			mac = Mac.getInstance(HMAC_MD5_NAME);
			mac.init(sk);
			byte[] encryptionBytes = mac.doFinal(str.getBytes(Charset.forName("UTF-8")));
			return byteToHexString(encryptionBytes);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(HMAC_MD5_NAME+"参数不能为空");
		} catch (InvalidKeyException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException("MD5Salt参数不能为空");
		}
	}

	public static String generateSalt() {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWSYZ";
		StringBuffer stb = new StringBuffer();
		for (int i = 0; i < SALT_LENGTH; i++) {
			int rand = (int) (Math.random() * chars.length());
			stb.append(chars.charAt(rand));
		}
		return stb.toString();
	}

	/**
	 * 将16进制字符串转换成字节数组
	 *
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] hexChars = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
		}
		return result;
	}

	/**
	 * 将指定byte数组转换成16进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHexString(byte[] b) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}

	public static void main(String[] args) {
		String pwd = hmacMD5("123123","admin");
		String s = "gxlO7LQSF7kI";
		String dpwd = hmacMD5(pwd,s);
		System.out.println(pwd);
		System.out.println(s);
		System.out.println(dpwd);
	}
}
