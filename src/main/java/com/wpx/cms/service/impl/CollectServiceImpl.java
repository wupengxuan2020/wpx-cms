package com.wpx.cms.service.impl;

import java.awt.color.CMMException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpx.cms.dao.CollectMapper;
import com.wpx.cms.domain.Collect;
import com.wpx.cms.service.CollectService;
import com.wpx.common.utils.StringUtil;
@Service
public class CollectServiceImpl implements CollectService{
	@Resource
	private CollectMapper collectMapper;
	
	
	
	@Override
	public int insert(Collect collect) {
		if(!StringUtil.isHttpUrl(collect.getUrl()))
			throw new CMMException("不是合法的url");
		return collectMapper.insert(collect);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
				return collectMapper.delete(id);
	}

	@Override
	public List<Collect> selects(Integer userId) {
		// TODO Auto-generated method stub
		return collectMapper.selects(userId);
	}

	@Override
	public Collect selectByTitleAndUserId(String title, Integer userId) {
		// TODO Auto-generated method stub
		return collectMapper.selectByTitleAndUserId(title, userId);
	}

}
