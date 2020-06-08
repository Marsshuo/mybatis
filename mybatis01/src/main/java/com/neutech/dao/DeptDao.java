package com.neutech.dao;

import java.util.List;

import com.neutech.bean.Dept;

public interface DeptDao {
	
	List<Dept> findAllDept()throws Exception;
	
	Dept findDeptByDeptno(int deptno)throws Exception;
	
	int addDept(Dept dept)throws Exception;
	
	int deleteDept(int deptno)throws Exception;
	
	int updateDept(Dept dept)throws Exception;
	

}
