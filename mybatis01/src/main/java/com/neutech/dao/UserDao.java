package com.neutech.dao;

import java.util.List;

import com.neutech.bean.User;

public interface UserDao {
	List<User> findAll()throws Exception;
	
	int addUser(User user) throws Exception;
	
	//按照用户编号进行查询
	User findUserById(int uid) throws Exception;
	
	//根据编号删除用户
	int deleteUser(int uid)throws Exception;
	
	//修改用户信息
	int updateUser(User user)throws Exception;

}
