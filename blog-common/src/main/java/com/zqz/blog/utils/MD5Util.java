package com.zqz.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: zqz
 * @Description: md5工具类
 * @Date: 3:13 PM 2019/12/19
 */
public class MD5Util {
	/**
	 * 提供16位和32位md5加密
	 * @param src 明文
	 * @param length 加密长度 16或32位加密，默认32位
	 * @return
	 */
	public static String Md5(String src, int length) {
		try {
			if (null == src) {
				return null;
			}
			String returnValue = "";
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src.getBytes());
			byte[] b = md.digest();
			int i;
			StringBuffer buf = new StringBuffer();
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			switch (length) {
			// 16位的加密
			case 16:
				returnValue = buf.toString().substring(8, 24);
				break;
			// 32位的加密
			case 32:
				returnValue = buf.toString();
				break;
			// 默认32位的加密
			default:
				returnValue = buf.toString();
				break;
			}
			return returnValue;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 对字符串进行md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return md5(str.getBytes());
	}

	/**
	 * 对字符串进行md5加密
	 *
	 * @param bytes
	 * @return
	 */
	public static String md5(byte[] bytes) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bytes);

			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			byteToHex(b, sb);

			return sb.toString();
		} catch (Exception e) {
		}
		return "";
	}

	private static void byteToHex(byte[] b, StringBuffer sb) {
		for (int i = 0; i < b.length; i++) {
			int v = b[i];
			v = v < 0 ? 0x100 + v : v;
			String cc = Integer.toHexString(v);
			if (cc.length() == 1)
				sb.append('0');
			sb.append(cc);
		}
	}



	public static void main(String[] args) {
		String srcStr = "123";
		System.out.println("原始信息：" + srcStr);
		System.out.println("MD5加密后(密文长度16位)：" + Md5(srcStr, 16));
		System.out.println("MD5加密后(密文长度32位)：" + Md5(srcStr, 32));
	}
}
