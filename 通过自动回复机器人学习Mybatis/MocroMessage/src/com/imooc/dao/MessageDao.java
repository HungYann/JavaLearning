package com.imooc.dao;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * 
 * 和message 表相关的数据库操作
 * @author liuhongyang
 *
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command,String description)
	{
		List<Message> messageList = new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			messageList = sqlSession.selectList("Message.queryMessageList",message);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{	
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
			
		}
		return messageList;
	}
	
	/**
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(int id)
	{
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Message message = new Message();
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
			
			
  		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{	
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
			
		}
	}
	
	
	public void deleteBatch(List<Integer> ids)
	{
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
	
		
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
			
			
  		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{	
			if(sqlSession!=null)
			{
				sqlSession.close();
			}
			
		}
		
	}
	
	
	
	
	
	
}
	
	
//	public static void main(String[] args) {
//		 MessageDao messageDao = new MessageDao();
//		 messageDao.queryMessageList("", "");
//		
//	}
	
	
	
//	public List<Message> queryMessageList(String command,String description){
//		
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","lhy942821");
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1 = 1");
//			
//			List<String> paramList = new ArrayList<String>();
//			
//			if(command!=null && !"".equals(command.trim()))
//			{
//				sql.append(" and COMMAND = ?");
//				paramList.add(command);
//				
//			}
//			
//			if(description!=null && !"".equals(description.trim()))
//			{
//				sql.append(" and DESCRIPTION like '%' ? '%' ");
//				paramList.add(description);
//				
//			}
////			if (description != null && !"".equals(description.trim())) {
////			    sql.append(" and DESCRIPTION like '%' ? '%' ");
////			    paramList.add(description);
////			}
//			
//			//向prepareStatement中添加String
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			
//			//向
//			for(int i=0;i<paramList.size();i++)
//			{
//				statement.setString(i+1,paramList.get(i));
//			}
//			
//			 
//			
//			ResultSet rs = statement.executeQuery();
//			
//		
//			
//			
//			while(rs .next())
//			{
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//				
//			}
//			
//			
//			
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messageList;
//		
//		
//		
//	}

