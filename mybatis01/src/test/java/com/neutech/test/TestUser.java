package com.neutech.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.neutech.bean.User;
import com.neutech.dao.UserDao;
import com.neutech.dao.UserDaoImpl;

public class TestUser {

	@Test
	public void test() throws Exception {
		UserDao dao = new UserDaoImpl();
		List<User> users = dao.findAll();
		for (User u : users) {
			System.out.println(u.getUid()+"---"+u.getUname()+"--"+u.getPwd());
		}
	}
	
	@Test
	public void testAdd() throws Exception {
		UserDao dao = new UserDaoImpl();
		//准备数据
		User users = new User();
		users.setUname("caixukun");
		users.setPwd("11111");
		dao.addUser(users);
		System.out.println(users.getUname());
	}
	
	@Test
	public void testFindById() throws Exception {
		UserDao dao = new UserDaoImpl();
		User users = dao.findUserById(1003);
		System.out.println(users.getUid()+"---"+users.getUname()+"---"+users.getPwd());
	}
	
	
	@Test
	public void testdeleteById() throws Exception {
		UserDao dao = new UserDaoImpl();
		dao.deleteUser(1005);
		System.out.println(1);
	}

	@Test
	public void updateUser() throws Exception {
		User user = new  User();
		user.setUid(1007);
		user.setUname("caixukun");
		user.setPwd("000");
		UserDao dao = new UserDaoImpl();
		dao.updateUser(user);
		System.out.println(1);
				
	}

}
