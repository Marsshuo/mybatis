package com.neutech.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neutech.bean.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAllEmp() throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();		
		
		List<Emp> list = session.selectList("findAllEmp");
		session.close();
		return list;
	}

	@Override
	public Emp finEmpByEmpno(int empno) throws Exception {
		//加载mybatis 的核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();		
		
		Emp emp = session.selectOne("findEmpByempno", empno);
		session.close();	
		return null;
	}

	@Override
	public int addEmp(Emp emp) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		int i = session.insert("addEmp", emp);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public int deleteEmp(int emp) throws Exception {
InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		int i = session.delete("deleteEmpByEmpno", emp);
		session.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateEmp(Emp emp) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//创建数据库连接的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//从工厂中获取与数据库的连接
		SqlSession session = factory.openSession();
		
		session.update("updateEmp", emp);
		session.commit();
		session.close();
		return 0;
	}

	

}
