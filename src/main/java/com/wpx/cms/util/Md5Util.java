package com.wpx.cms.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	/**
	 * ֱ�Ӷ��������ɢ�У���ô�ڿͿ��Զ�ͨ������������ɢ��ֵ��
	 * Ȼ��ͨ����ɢ��ֵ�ֵ䣨����MD5�����ƽ���վ�����õ�ĳ�û������롣
	 * ��Salt����һ���̶��Ͻ���������
	 */
	private static String salt ="qazwsx1234";
	public static String encode(String password) {
		
	//   System.out.println(DigestUtils.md5Hex(password + salt));
	   return DigestUtils.md5Hex(password + salt);
	}

	
	public static void main(String[] args) {
		Md5Util.encode("123456");
		Md5Util.encode("1");
		Md5Util.encode("1");
	}
}
