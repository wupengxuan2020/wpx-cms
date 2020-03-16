package com.wpx.cms.dao;

import java.util.List;

import com.wpx.cms.domain.Article;

public interface ArticleMapper {
	/**
	 * 
	 * @Title: insert 
	 * @Description: ��������
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	/**
	 * 
	 * @Title: selects 
	 * @Description: չʾ�б�
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article article);
	
	
	/**
	 * 
	 * @Title: select 
	 * @Description: ��������
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	
	
	/**
	 * 
	 * @Title: update 
	 * @Description: ����
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
}
