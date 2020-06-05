package com.neutech.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neutech.bean.Dept;
import com.neutech.bean.User;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAll() throws Exception {
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();
		
		//ִ��sql���
		List<Dept> list = session.selectList("findAll");
		session.close();
	
		return list;		
	}

	@Override
	public Dept finDeptById(int deptno) throws Exception {
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();		
		
		return null;
	}

	@Override
	public int addDept(Dept dept) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();
		return 0;
	}

	@Override
	public int deleteDept(int deptno) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();
		return 0;
	}

	@Override
	public int updateDept(Dept dept) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();
		return 0;
	}

}
