package com.wpx.cms.util;

/**
 * 
 * @ClassName: Result 
 * @Description: ����ͳһ�Ľ��ֵ
 * @author: charles
 * @date: 2020��1��11�� ����3:09:12 
 * @param <T>
 */
public class Result<T> {
   //���ؽ����״̬
	private Integer code;
	private String  msg;
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}