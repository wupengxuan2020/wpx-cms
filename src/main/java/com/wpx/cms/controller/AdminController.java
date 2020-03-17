package com.wpx.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.Article;
import com.wpx.cms.domain.User;
import com.wpx.cms.service.ArticleService;
import com.wpx.cms.service.UserService;
@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private UserService userService;
	
		/*<insert id="insert">
	
		insert into cms_log(visit_date,article_id,username)
		values(#{visitDate},#{articleId},#{username})
	</insert>
	
	<update id="update">
	
	
	insert into cms_count(article_id,visit_num) select article_id ,count(id) from cms_log group by article_id 
	 
	</update>
	
	<delete id="delete">
	delete from cms_count 
	
	</delete>
	
	<select id="selects" resultType="Article">
	select a.article_id as id, a.visit_num as hits,b.title from cms_count a  
	LEFT JOIN cms_article  b on a.article_id  =b.id 
	order by visit_num desc
	
	</select>*/
	/*去设置
	@GetMapping("settings")
	public String settings() {
		return "admin/settings";
		
	}*/
	/*执行SQL
	@Resource
	ArticleLogService articleLogService;
	@ResponseBody
	@PostMapping("execute")
	public boolean execute() {
		return articleLogService.update() >0;
	}*/
	
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入管理员首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "admin/index";
		
	}
	
	
	/**
	 * 
	 * @Title: users 
	 * @Description: 用户列表
	 * @param model
	 * @param user
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "18") Integer pageSize) {
		
		PageInfo<User> info = userService.selects(user, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("user", user);
		return "admin/users";
		
	}
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 更新用户
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("updateUser")
	public boolean updateUser(User user) {
		
		return userService.update(user) >0;
	}
	
	
	
	
	
	

	/**
	 * 
	 * @Title: articles 
	 * @Description: 进入文章审核列表
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model ,Article article,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "18") Integer pageSize) {
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("article", article);
		
		return "admin/articles";
		
	}
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id) {
		
		return articleService.select(id);
		
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改文章
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Article article) {
		return articleService.update(article) >0;
	}
	
}
