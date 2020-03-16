package com.wpx.cms.service;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.Article;

public interface ArticleService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 展示列表
	 * @param article
	 * @return
	 * @return: List<Article>
	*/

	PageInfo<Article> selects(Article article, Integer page, Integer pgeSize);

	/**
	 * 
	 * @Title: select 
	 * @Description: 单个文章
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
	
}

