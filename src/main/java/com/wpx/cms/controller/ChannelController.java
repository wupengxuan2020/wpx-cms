package com.wpx.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpx.cms.domain.Category;
import com.wpx.cms.domain.Channel;
import com.wpx.cms.service.ChannelService;

@Controller
@RequestMapping("channel")
public class ChannelController {
	@Resource
	ChannelService channelService;
	

	@ResponseBody
	@RequestMapping("channels")
	public List<Channel> channels(){
		return channelService.selects();
	}


	@ResponseBody
	@RequestMapping("selectsByChannelId")
	public List<Category> selectsByChannelId(Integer channelId){
		return channelService.selectsByChannelId(channelId);
	}
}
