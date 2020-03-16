package com.wpx.cms.service;

import com.github.pagehelper.PageInfo;
import com.wpx.cms.domain.User;

public interface UserService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: �û��б�
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	PageInfo<User> selects(User user,Integer page,Integer pageSize);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: ����
	 * @param user
	 * @return
	 * @return: int
	 */
	
	int update(User user);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: ע���û�
	 * @param user
	 * @return
	 * @return: int
	 */
	int insert(User user);
	/**
	 * 
	 * @Title: selectByUsername 
	 * @Description: �����û���ѯ��ѯ�û��Ƿ����
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByUsername(String username);
	
	/**
	 * 
	 * @Title: login 
	 * @Description: ��¼
	 * @param user
	 * @return
	 * @return: User
	 */
	User login(User user); 
	
	

}
