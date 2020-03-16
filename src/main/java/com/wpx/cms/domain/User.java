package com.wpx.cms.domain;
/**
 * 
 * @ClassName: User 
 * @Description: �û���Ϣ
 * @author: ������
 * @date: 2020��3��3�� ����11:17:43
 */

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID =1L;
	private Integer id;//����
	private String username;
	private String password;//�ǳ�
	private String repassword;//ȷ������
	private String nickname;
	private Date birthday;
	private Integer role;
	private String gender;
	private String locked;//0����1����
	private Date created;//ע��ʱ��
	private Date updated;//�޸�ʱ��
	
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
