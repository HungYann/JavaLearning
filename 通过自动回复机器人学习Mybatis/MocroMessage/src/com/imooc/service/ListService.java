package com.imooc.service;

import java.util.List;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;

/**
 * 列表相关的业务
 * @author liuhongyang
 *
 */
public class ListService {
	public List<Message> queryMesageList(String command,String description)
	{
		 
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
		
		//return messageDao.qu
		
	}
}
