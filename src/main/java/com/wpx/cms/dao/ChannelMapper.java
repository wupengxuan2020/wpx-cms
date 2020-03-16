package com.wpx.cms.dao;

import java.util.List;

import com.wpx.cms.domain.Category;
import com.wpx.cms.domain.Channel;


public interface ChannelMapper {

	List<Channel> selects();
	
	
	List<Category> selectsByChannelId(Integer channelId);
}
