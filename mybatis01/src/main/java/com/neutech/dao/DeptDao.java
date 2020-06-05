package com.neutech.dao;

import java.util.List;

import com.neutech.bean.Dept;

public interface DeptDao {
	
	List<Dept> findAll()throws Exception;
	
	Dept finDeptById(int deptno)throws Exception;
	
	int addDept(Dept dept)throws Exception;
	
	int deleteDept(int deptno)throws Exception;
	
	int updateDept(Dept dept)throws Exception;
	

}
