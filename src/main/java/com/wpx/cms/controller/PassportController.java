package com.wpx.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.wpx.cms.domain.User;
import com.wpx.cms.service.UserService;
import com.wpx.cms.util.CMSException;
import com.wpx.cms.util.Result;

@RequestMapping("passport")
@Controller
public class PassportController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @Title: reg 
	 * @Description: ȥע��
	 * @return
	 * @return: String
	 */
	@GetMapping("reg")
	public String reg() {
		
		return "passport/reg";
		
	}
	
	/**
	 * 
	 * @Title: reg 
	 * @Description: ִ��ע��
	 * @return
	 * @return: boolean
	 */
	@PostMapping("reg")
	@ResponseBody
	public Result<User> reg(User user,Model model) {
		Result<User> result=  new Result<User>();
		try {
			 if(userService.insert(user)>0) {//���ע��ɹ�
				 result.setCode(200);//�ɹ�
				 result.setMsg("ע��ɹ�");
			 }
		} catch (CMSException e) {//������Զ����쳣
			 e.printStackTrace();
			 result.setCode(300);//ע��ʧ��
			 result.setMsg("ע��ʧ��:"+e.getMessage());
			
		}catch (Exception e) {//�����쳣
			e.printStackTrace();//���쳣��Ϣ�ڿ���̨��ӡ���Ա����Ա��BUG
			 result.setCode(500);//ע��ʧ��,����Ԥ֪���쳣
			 result.setMsg("ע��ʧ�ܣ�ϵͳ���ֲ���Ԥ֪�쳣������ϵ����Ա");//���û�����
		}
		return result;
	
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: ȥ��¼-��ͨ�û�
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login() {
		
		
		return "passport/login";
		
	}
	
	
	/**
	 * 
	 * @Title: login 
	 * @Description: ȥ��¼-����Ա�û�
	 * @return
	 * @return: String
	 */
	@GetMapping("admin/login")
	public String adminLogin() {
		return "passport/adminLogin";
		
	}
	
	

	
	
	/**
	 * 
	 * @Title: login 
	 * @Description:ִ�е�¼
	 * @param user
	 * @param model
	 * @return
	 * @return: Result<User>
	 */
	@PostMapping("login")
	@ResponseBody
	public Result<User> login(User formUser,Model model,HttpSession session) {
		Result<User> result=  new Result<User>();
		try {
			//ȥ��¼������ɹ��򷵻��û��Ļ�����Ϣ 
			User user = userService.login(formUser);
			
			if(null !=user) {//�и��û�
				result.setCode(200);
				result.setMsg("��¼�ɹ�");
				if(user.getRole()==0) {//���ݽ�ɫ�жϡ��治ͬ��session
					session.setAttribute("user", user);//��¼�ɹ������û���Ϣ����session
				}else {
					session.setAttribute("admin", user);//��¼�ɹ������û���Ϣ����session
				}
			}
			
		
		} catch (CMSException e) {//������Զ����쳣
			 e.printStackTrace();
			 result.setCode(300);//��¼ʧ��
			 result.setMsg("��¼ʧ��:"+e.getMessage());
			
		}catch (Exception e) {//�����쳣
			e.printStackTrace();//���쳣��Ϣ�ڿ���̨��ӡ���Ա����Ա��BUG
			 result.setCode(500);//��¼ʧ��,����Ԥ֪���쳣
			 result.setMsg("��¼ʧ�ܣ�ϵͳ���ֲ���Ԥ֪�쳣������ϵ����Ա");//���û�����
		}
		return result;
		
	}
	
	/**
	 * 
	 * @Title: logout 
	 * @Description: ע���û�
	 * @return
	 * @return: String
	 */
	@GetMapping("logout")
	public String  logout(HttpSession session) {
		
		//���session
		session.invalidate();
		
		return "redirect:/";//�ص�ϵͳ��ҳ
		
	}
	/**
	 * 
	 * @Title: checkName 
	 * @Description: ���ע���û��Ƿ����
	 * @param username
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("checkName")
	public boolean checkName(String username) {
		
		return userService.selectByUsername(username) == null;
		
	}
}
