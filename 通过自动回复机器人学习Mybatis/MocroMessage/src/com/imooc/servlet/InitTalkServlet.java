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

/**
 * 对话页初始化
 * @author liuhongyang
 *
 */
@SuppressWarnings("serial")
public class InitTalkServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//没有过滤器时，在servlet中
			req.setCharacterEncoding("UTF-8");
			
			//跳转
			req.getRequestDispatcher("/WEB-INF/jsp/front/talk.jsp").forward(req,resp);
			
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			this.doGet(req, resp);
		}

}