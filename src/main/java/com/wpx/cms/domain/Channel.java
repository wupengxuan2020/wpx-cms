package com.wpx.cms.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName: Channel 
 * @Description: ������Ŀ��
 * @author: ������
 * @date: 2020��3��3�� ����11:21:40
 */
public class Channel implements Serializable{
	private static final long serialVersionUID =1L;
	private Integer id;//����
	private String name;//��Ŀ������
	private String description;//����
	private String icon;//��Ŀͼ��
	private Integer sorted;//����
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}
	
	
	
}
