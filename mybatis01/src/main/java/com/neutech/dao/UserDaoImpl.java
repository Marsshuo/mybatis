package com.neutech.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neutech.bean.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findAll() throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		//执行sql语句
		List<User> list = session.selectList("findAllUser");
		session.close();
	
		return list;
	}

	@Override
	public int addUser(User user) throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();		
		
		
		//执行插入操作
		int i = session.insert("addUser",user);
	    
		// 在执行insert update delete ，注意要提交事务
		session.commit();
		session.close();
		return 0;
	}

	@Override
	public User findUserById(int uid) throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();				
		
		User users=session.selectOne("findUserById",uid);
		session.close();
		return users;
	}

	@Override
	public int deleteUser(int uid) throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();		
		
		session.delete("deleteUserById",uid);
		session.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();	
		session.update("updateUser",user);
		session.commit();
		session.close();	
		return 0;
	}
	

}
