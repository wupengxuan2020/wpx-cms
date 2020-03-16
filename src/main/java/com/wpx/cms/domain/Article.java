package com.wpx.cms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: Article 
 * @Description: �������ݱ�
 * @author: ������
 * @date: 2020��3��3�� ����11:25:46
 */
public class Article implements Serializable{
	private static final long serialVersionUID =1L;
	private Integer id;//����
	private String title;//���±���
	private String summary;//����ժҪ
	private String content;//��������
	private String picture;//���µı���ͼƬ
	private Integer channelId;//������ĿID
	private Integer categoryId;//��������ID
	private Integer userId;//���·�����ID
	private Integer hits;//�����
	private Integer hot;//�Ƿ��������� 1������ 0��һ������ 
	private Integer status;//�Ƿ������������״̬ 0������ 1�����ͨ�� -1�����δͨ��
	private Integer deleted;//ɾ��״̬ 0���� 1�߼�ɾ��
	private Date created;//���·���ʱ��
	private Date updated;//�����޸�ʱ��
	private Channel channel;
	private Category category;
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
