package com.neutech.dao;

import java.util.List;

import com.neutech.bean.User;

public interface UserDao {
	List<User> findAll()throws Exception;
	
	int addUser(User user) throws Exception;
	
	//�����û���Ž��в�ѯ
	User findUserById(int uid) throws Exception;
	
	//���ݱ��ɾ���û�
	int deleteUser(int uid)throws Exception;
	
	//�޸��û���Ϣ
	int updateUser(User user)throws Exception;

}
