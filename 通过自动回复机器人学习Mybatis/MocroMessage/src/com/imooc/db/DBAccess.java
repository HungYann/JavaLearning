package com.imooc.db;

import java.io.IOException;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	//通过配置文件获取数据库连接
	
	public SqlSession getSqlSession() throws IOException 
	{
		
		//通过配置文件获取数据库连接信息
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		//通过sqlSessionFctory打开图个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	
}
