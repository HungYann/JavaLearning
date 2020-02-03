package com.learn.ssm.chapter3.mapper;

import java.util.List;

import com.learn.ssm.chapter3.pojo.Role;
//映射器接口
public interface RoleMapper {
	
	public Role getRole(int id);
	public int insertRole(Role role);
	public int deleteRole(int id);
	public int updateRole(Role role);
	public List<Role> findRoles(String roleName);
	
	
}
