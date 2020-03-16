package com.wpx.cms.service;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.Article;

public interface ArticleService {
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

	PageInfo<Article> selects(Article article, Integer page, Integer pgeSize);

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

