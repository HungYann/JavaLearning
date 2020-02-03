package com.learn.ssm.chapter3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;

public class SqlSessionFactoryUtils {
	
	
	public static SqlSession getSession() throws IOException 
	{
			String resource = "mybatis-config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			return sqlSession;
	}
	
	
	

}
