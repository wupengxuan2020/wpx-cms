package com.wpx.cms.dao;

import java.util.List;

import com.wpx.cms.domain.Article;
import com.wpx.cms.domain.Comment;

public interface CommentMapper {
	/**
	 * 
	 * @Title: insert 
	 * @Description: ��������
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	/**
	 * 
	 * @Title: selects 
	 * @Description: �������²�ѯ��������
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	List<Comment> selects(Article article);
	
	/**
	 * 
	 * @Title: selectsByCommentNum 
	 * @Description: ����������������
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selectsByCommentNum();
	/**
	   * 
	   * @Title: updateArticle 
	   * @Description: ������������1
	   * @param articleId
	   * @return
	   * @return: int
	   */
		int updateArticle(Integer articleId);
	
	
}
