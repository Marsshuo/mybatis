package com.neutech.dao;

import java.util.List;

import com.neutech.bean.Emp;



public interface EmpDao {
    List<Emp> findAllEmp()throws Exception;
	
    Emp finEmpByEmpno(int empno)throws Exception;
	
	int addEmp(Emp emp)throws Exception;
	
	int deleteEmp(int emp)throws Exception;
	
	int updateEmp(Emp emp)throws Exception;
}
