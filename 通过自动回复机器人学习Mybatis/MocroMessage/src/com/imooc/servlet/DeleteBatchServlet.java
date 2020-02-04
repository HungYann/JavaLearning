package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

/**
 * 批量删除控制层
 * @author liuhongyang
 *
 */

public class DeleteBatchServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//没有过滤器时，在servlet中
		req.setCharacterEncoding("UTF-8");
		//接受页面的值(多个)
		String[] ids = req.getParameterValues("id");
		
		//----如何接收值
		MaintainService maintatinService = new MaintainService();
				
		maintatinService.deleteBatch(ids);
		
		
		//maintatinService.deleteBatch();
		
		
		//跳转
		req.getRequestDispatcher("/List.action").forward(req,resp);
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}
}
