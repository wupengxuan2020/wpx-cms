package com.wpx.cms.dao;

import java.util.List;

import com.wpx.cms.domain.User;

public interface UserMapper {

	List<User> selects(User user);

	
	int update(User user);
	
	//注册用户
	int insert(User user);
	//根据用户查询查询用户是否存在
	User selectByUsername(String username);

}
