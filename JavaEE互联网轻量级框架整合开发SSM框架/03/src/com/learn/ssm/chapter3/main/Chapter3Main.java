package com.learn.ssm.chapter3.main;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;

//import org.apache.log4j.Logger;


public class Chapter3Main {
	public static void main(String[] args) throws IOException {
		
		Logger log = Logger.getLogger(Chapter3Main.class);
		
		SqlSession sqlSession = SqlSessionFactoryUtils.getSession();
		
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = roleMapper.getRole(2);
		
		
		log.info(roleMapper.getRole(2));
		log.info(role.getRoleName());
		
		
	}
}
