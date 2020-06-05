package com.neutech.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.neutech.bean.Dept;
import com.neutech.dao.DeptDao;
import com.neutech.dao.DeptDaoImpl;

public class TestDept {

	@Test
	public void test() throws Exception {
		DeptDao dao = new DeptDaoImpl();
		List<Dept> depts = dao.findAll();
	    for (Dept dept : depts) {
		System.out.println(dept.getDeptno()+dept.getDname()+dept.getLoc());
	    }
		
	}

}
