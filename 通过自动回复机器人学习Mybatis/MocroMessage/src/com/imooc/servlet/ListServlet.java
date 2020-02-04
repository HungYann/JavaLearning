/**
 * 
 */
/**
 * @author liuhongyang
 *
 */
package com.imooc.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.*;
import com.imooc.service.ListService;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//没有过滤器时，在servlet中
			req.setCharacterEncoding("UTF-8");
			
			
			//接受页面的值
			String command = req.getParameter("command");
			String description= req.getParameter("description");
			
			
			//查询消息列表并传给页面
			req.setAttribute("command",command);
			req.setAttribute("description", description);
			
			//调用Service
			ListService listService = new ListService();
			
			req.setAttribute("messageList", listService.queryMesageList(command, description));
			
			//跳转
			req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
			
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			this.doGet(req, resp);
		}

}