package com.wpx.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.Article;
import com.wpx.cms.domain.Category;
import com.wpx.cms.domain.Channel;
import com.wpx.cms.domain.Choose;
import com.wpx.cms.domain.Collect;
import com.wpx.cms.domain.Comment;
import com.wpx.cms.domain.Slide;
import com.wpx.cms.domain.User;
import com.wpx.cms.service.ArticleService;
import com.wpx.cms.service.ChannelService;
import com.wpx.cms.service.ChooseService;
import com.wpx.cms.service.CollectService;
import com.wpx.cms.service.CommentService;
import com.wpx.cms.service.SlideService;



@Controller
public class IndexController {
	@Resource
	private ChannelService channelService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	@Resource
	private CommentService commentService;
	
	@Resource
	private CollectService collectService;
	
	/*@Resource
	private VoteService voteService;*/
	//文章点击排行榜
			/*List<Article> topArticles = articleLogService.selects();
			model.addAttribute("topArticles", topArticles);*/
	
	/**
	 * 
	 * @Title: index 
	 * @Description:进入首页
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		
		article.setStatus(1);
		article.setDeleted(0);
		
	    model.addAttribute("article", article);//封装查询条件
	    
		//查询左侧栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		
		//如果栏目ID 不为空则查查其下所有的分类
		if(article.getChannelId()!=null) {
		List<Category> categorys = channelService.selectsByChannelId(article.getChannelId());
		model.addAttribute("categorys", categorys);
		}
		
		if (article.getChannelId()==null) {
			article.setHot(1);
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides", slides);
		}
		
		//查询所有的文章
		
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		
		//在右侧显示最新10遍文章
		Article article2 = new Article();
		article2.setStatus(1);
		article2.setDeleted(0);
		
		PageInfo<Article> lastArticles = articleService.selects(article2, 1, 10);
		model.addAttribute("lastArticles", lastArticles);
		
		return "index/index";
		
	}
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(Integer id,Model model,HttpSession session,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="5")Integer pageSize) {
		Article article = articleService.select(id);
		model.addAttribute("article", article);
		PageInfo<Comment> info = commentService.selects(article, page, pageSize);
		//查询所有文章的评论
		PageInfo<Article> info2 = commentService.selectsByCommentNum(1, 10);
		model.addAttribute("info", info);
		model.addAttribute("info2", info2);
		//查询该文章是否被收藏过
				User user = (User) session.getAttribute("user");
				  Collect collect =null;
				if(null !=user) {//如果用户已经登录，则查询是否没收藏过
				   collect = collectService.selectByTitleAndUserId(article.getTitle(), user.getId());
				}
				model.addAttribute("collect", collect);
				
		
		return "index/articleDetail";
	}
	
	
	
	//收藏文章
	@ResponseBody
	@RequestMapping("deleteCollect")
	public boolean collect(Integer id){
		
		return collectService.delete(id)>0;
	}
	//收藏文章
	@ResponseBody
	@RequestMapping("collect")
	public boolean collect(Collect collect,HttpSession session){
		User user=(User) session.getAttribute("user");
		if (null==user) {
			return false;//没有登陆不能收藏
		}
		collect.setUser(user);
		collect.setCreated(new Date());
		return collectService.insert(collect)>0;
	}
	
	//增加评论
		@ResponseBody
		@RequestMapping("addComment")
		public boolean addComment(Comment comment,Integer articleId,HttpSession session) {
			User user = (User) session.getAttribute("user");
			if(null ==user)
			return false;//没有登录的用户不能评论
			comment.setUserId(user.getId());
			comment.setArticleId(articleId);
			comment.setCreated(new Date());
			
			return commentService.insert(comment)>0;
		}
		@Resource
		private ChooseService chooseService;
		
		@GetMapping("publishVote")
		public String publishVote(){
			return "/index/vote";
		}
		@ResponseBody
		@RequestMapping("publishVote")
		public boolean 	publishVote(Choose choose){
			
			return chooseService.insert(choose)>0;
		}

}
