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
	//���µ�����а�
			/*List<Article> topArticles = articleLogService.selects();
			model.addAttribute("topArticles", topArticles);*/
	
	/**
	 * 
	 * @Title: index 
	 * @Description:������ҳ
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		
		article.setStatus(1);
		article.setDeleted(0);
		
	    model.addAttribute("article", article);//��װ��ѯ����
	    
		//��ѯ�����Ŀ
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		
		//�����ĿID ��Ϊ�������������еķ���
		if(article.getChannelId()!=null) {
		List<Category> categorys = channelService.selectsByChannelId(article.getChannelId());
		model.addAttribute("categorys", categorys);
		}
		
		if (article.getChannelId()==null) {
			article.setHot(1);
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides", slides);
		}
		
		//��ѯ���е�����
		
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		
		//���Ҳ���ʾ����10������
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
	 * @Description: ��������
	 * @param id
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(Integer id,Model model,HttpSession session,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="5")Integer pageSize) {
		Article article = articleService.select(id);
		model.addAttribute("article", article);
		PageInfo<Comment> info = commentService.selects(article, page, pageSize);
		//��ѯ�������µ�����
		PageInfo<Article> info2 = commentService.selectsByCommentNum(1, 10);
		model.addAttribute("info", info);
		model.addAttribute("info2", info2);
		//��ѯ�������Ƿ��ղع�
				User user = (User) session.getAttribute("user");
				  Collect collect =null;
				if(null !=user) {//����û��Ѿ���¼�����ѯ�Ƿ�û�ղع�
				   collect = collectService.selectByTitleAndUserId(article.getTitle(), user.getId());
				}
				model.addAttribute("collect", collect);
				
		
		return "index/articleDetail";
	}
	
	
	
	//�ղ�����
	@ResponseBody
	@RequestMapping("deleteCollect")
	public boolean collect(Integer id){
		
		return collectService.delete(id)>0;
	}
	//�ղ�����
	@ResponseBody
	@RequestMapping("collect")
	public boolean collect(Collect collect,HttpSession session){
		User user=(User) session.getAttribute("user");
		if (null==user) {
			return false;//û�е�½�����ղ�
		}
		collect.setUser(user);
		collect.setCreated(new Date());
		return collectService.insert(collect)>0;
	}
	
	//��������
		@ResponseBody
		@RequestMapping("addComment")
		public boolean addComment(Comment comment,Integer articleId,HttpSession session) {
			User user = (User) session.getAttribute("user");
			if(null ==user)
			return false;//û�е�¼���û���������
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
