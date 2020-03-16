package com.wpx.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpx.cms.dao.ArticleMapper;
import com.wpx.cms.domain.Article;
import com.wpx.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{
	@Resource
	private ArticleMapper  articleMapper;

	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insert(article);
	}

	@Override
	public PageInfo<Article> selects(Article article, Integer page, Integer pgeSize) {
		PageHelper.startPage(page, pgeSize);
		List<Article> list = articleMapper.selects(article);
		return new PageInfo<Article>(list);
	}

	@Override
	public Article select(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.select(id);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}


	
	
	

}
