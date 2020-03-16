package com.wpx.cms.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.Article;
import com.wpx.cms.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {
	@Resource
	private ArticleService articleService;
	@Test
	public void testInsert() {
		Article article = new Article();
		article.setTitle("admain");
		article.setContent("123456");
		article.setUserId(1);
		article.setChannelId(1);
		article.setCategoryId(1);
		article.setCreated(new Date());
		articleService.insert(article);
	}

	@Test
	public void testSelects() {
		Article article = new Article();
		PageInfo<Article> selects=articleService.selects(article, 1, 1);
		System.out.println(selects);
		
	}

}
