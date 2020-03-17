package com.wpx.cms.domain;

import java.util.Date;

public class Choose {
	private Integer id;
	private Date chooseDate;
	private Integer articleId;
	private Character option;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getChooseDate() {
		return chooseDate;
	}
	public void setChooseDate(Date chooseDate) {
		this.chooseDate = chooseDate;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Character getOption() {
		return option;
	}
	public void setOption(Character option) {
		this.option = option;
	}
	
	
	
}
