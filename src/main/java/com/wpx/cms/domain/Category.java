package com.wpx.cms.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName: Category 
 * @Description: ��Ŀ�ӷ���
 * @author: ������
 * @date: 2020��3��3�� ����11:24:00
 */
public class Category implements Serializable{
	
	private static final long serialVersionUID =1L;
	private Integer id;//����
	private String name;
	private Integer channelId;//������Ŀ��ID
	private Integer sorted;//����
	private Channel channel;
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
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
