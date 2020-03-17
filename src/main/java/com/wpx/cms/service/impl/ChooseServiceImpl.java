package com.wpx.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpx.cms.dao.ChooseMapper;
import com.wpx.cms.domain.Choose;
import com.wpx.cms.service.ChooseService;
@Service
public class ChooseServiceImpl implements ChooseService{
	@Resource 
	private ChooseMapper chooseMapper;
	
	@Override
	public int insert(Choose choose) {
		
		return chooseMapper.insert(choose);
	}

}
