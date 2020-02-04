package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.ListService;
import com.imooc.service.MaintainService;

/**
 * 单条删除控制层
 * @author liuhongyang
 *
 */
public class DeleteOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//没有过滤器时，在servlet中
		req.setCharacterEncoding("UTF-8");
		
		
		//接受页面的值
		String id = req.getParameter("id");
		MaintainService maintatinService = new MaintainService();
		maintatinService.deleteOne(id);
		
		
		//跳转
		req.getRequestDispatcher("/List.action").forward(req,resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}
}
