package com.wpx.cms.util;
/**
 * 
 * @ClassName: CMSExcetion 
 * @Description: �Զ����쳣
 * @author: charles
 * @date: 2020��3��12�� ����8:59:51
 */
public class CMSException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;//�쳣��Ϣ
	public CMSException() {
		
	}
     public CMSException(String message) {
    	 super(message);
    	 this.message= message;
    	 
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

     
}
