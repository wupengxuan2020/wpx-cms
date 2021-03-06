package com.wpx.cms.domain;
/**
 * 
 * @ClassName: User 
 * @Description: 用户信息
 * @author: 吴鹏轩
 * @date: 2020年3月3日 上午11:17:43
 */

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID =1L;
	private Integer id;//主键
	private String username;
	private String password;//昵称
	private String repassword;//确认密码
	private String nickname;
	private Date birthday;
	private Integer role;
	private String gender;
	private String locked;//0正常1禁用
	private Date created;//注册时间
	private Date updated;//修改时间
	
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
