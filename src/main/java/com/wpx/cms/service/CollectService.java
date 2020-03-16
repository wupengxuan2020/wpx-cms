package com.wpx.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wpx.cms.domain.Collect;

public interface CollectService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: �ղ�
	 * @param collect
	 * @return
	 * @return: int
	 */
	int insert(Collect collect);
	/**
	 * 
	 * @Title: delete 
	 * @Description: ȡ���ղ�
	 * @param id
	 * @return
	 * @return: int
	 */
	int delete(Integer id);
	/**
	 * 
	 * @Title: selects 
	 * @Description: ��ʾ�ҵ��ղؼ�
	 * @param userId
	 * @return
	 * @return: List<Collect>
	 */
	List<Collect> selects(Integer userId);
	
	/**
	 * 
	 * @Title: selectByUrlAndUserId 
	 * @Description: ����title��userid ��ѯ�������Ƿ񱻸��û��ղع�
	 * @param url
	 * @param userId
	 * @return
	 * @return: Collect
	 */
	Collect selectByTitleAndUserId(@Param("title")String title,@Param("userId")Integer userId);


}
