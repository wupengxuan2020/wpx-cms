package com.wpx.cms.dao;

import java.util.List;

import com.wpx.cms.domain.User;

public interface UserMapper {

	List<User> selects(User user);

	
	int update(User user);
	
	//ע���û�
	int insert(User user);
	//�����û���ѯ��ѯ�û��Ƿ����
	User selectByUsername(String username);

}
