package com.neutech.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neutech.bean.Dept;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAllDept() throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();		
				
		//执行sql语句
		List<Dept> list = session.selectList("findAllDept");
		session.close();
	
		return list;		
	}

	@Override
	public Dept findDeptByDeptno(int deptno) throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();		
		
		Dept dept = session.selectOne("findByDeptno", deptno);
		session.close();
		return dept;
	}

	@Override
	public int addDept(Dept dept) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		int i = session.insert("addDept", dept);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public int deleteDept(int deptno) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		int i = session.delete("deleteDeptByDeptno", deptno);
		session.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateDept(Dept dept) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		session.update("updateDept", dept);
		session.commit();
		session.close();
		return 0;
	}

}
