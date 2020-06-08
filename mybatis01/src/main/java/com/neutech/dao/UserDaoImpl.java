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
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();
		
		//ִ��sql���
		List<User> list = session.selectList("findAllUser");
		session.close();
	
		return list;
	}

	@Override
	public int addUser(User user) throws Exception {
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();		
		
		
		//ִ�в������
		int i = session.insert("addUser",user);
	    
		// ��ִ��insert update delete ��ע��Ҫ�ύ����
		session.commit();
		session.close();
		return 0;
	}

	@Override
	public User findUserById(int uid) throws Exception {
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();				
		
		User users=session.selectOne("findUserById",uid);
		session.close();
		return users;
	}

	@Override
	public int deleteUser(int uid) throws Exception {
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();		
		
		session.delete("deleteUserById",uid);
		session.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		//����mybatis �ĺ��������ļ�
		InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
		
		//�������ݿ����ӵĹ���
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//�ӹ����л�ȡ�����ݿ������
		SqlSession session = factory.openSession();	
		session.update("updateUser",user);
		session.commit();
		session.close();	
		return 0;
	}
	

}
