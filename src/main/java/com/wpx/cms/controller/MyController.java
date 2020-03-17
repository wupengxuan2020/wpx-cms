package com.wpx.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.Article;
import com.wpx.cms.domain.Choose;
import com.wpx.cms.domain.Collect;
import com.wpx.cms.domain.User;
import com.wpx.cms.service.ArticleService;
import com.wpx.cms.service.ChooseService;
import com.wpx.cms.service.CollectService;

/**
 * 
 * @ClassName: MyController 
 * @Description: TODO
 * @author: 吴鹏轩
 * @date: 2020年3月4日 下午6:39:39
 */
@RequestMapping("my")
@Controller
public class MyController {
	@Resource
	private ArticleService  articleService;
	
	@Resource
	private CollectService collectService;
	/**
	 * 
	 * @Title: index 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping(value={"","/","index"})
	public String index(){
		
		return "my/index";
	}
	
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id){
		
		return articleService.select(id);
	}
	/**
	 * 
	 * @Title: articles 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model,HttpSession session,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3")Integer pageSize){
		
		Article article = new Article();
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		
		model.addAttribute("info", info);
		return "my/articles";
	}
	
	/**
	 * 
	 * @Title: publish 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("publish")
	public String publish(){
		
		return "my/publish";
	}
	@ResponseBody
	@PostMapping("publish")
	public boolean publish(MultipartFile file, Article article,HttpSession session){
		
		if (null!=file && !file.isEmpty()) {
			
			String path="d:/pic/";
			
			String filename=file.getOriginalFilename();
			String newFilename=UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
			File f = new File(path,newFilename);
			
			try {
				file.transferTo(f);
				article.setPicture(newFilename);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
				
				User user = (User) session.getAttribute("user");
				article.setUserId(user.getId());
				article.setCreated(new Date());
				article.setHits(0);//点击量默认 0
				article.setDeleted(0);//默认未删除
				article.setHot(0);//默认非热门
				article.setStatus(0);//默认待审核
				return articleService.insert(article) >0;//增加文章
		
		
		
	}

	
	
	@RequestMapping("showCollect")
	public String collect(Integer id,Article article,Model model,User user,HttpSession session,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		List<Collect> list = collectService.selects(222);
		
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		
		model.addAttribute("info", info);
		
		model.addAttribute("list", list);
		return "my/showCollect";
	}
	
	
}
