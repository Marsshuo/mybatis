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
		List<Dept> depts = dao.findAllDept();
	    for (Dept dept : depts) {
		System.out.println(dept.getDeptno()+dept.getDname()+dept.getLoc());
	    }
		
	}
	
	@Test
	public void testByDeptno() throws Exception {
		DeptDao dao = new DeptDaoImpl();
		Dept dept = dao.findDeptByDeptno(20);
		System.out.println(dept.getDname());
		
	}
	
	@Test
	public void testAddDept() throws Exception {
		DeptDao dao = new DeptDaoImpl();
		Dept dept = new Dept();
		dept.setDeptno(100);
		dept.setDname("助理办");
		dept.setLoc("上海");
		dao.addDept(dept);
		System.out.println(1);
	}
	
	@Test
	public void testDeleteDept() throws Exception {
		DeptDao dao = new DeptDaoImpl();
		dao.deleteDept(87);
	}
	
	@Test
	public void testUpdateDept() throws Exception {
		Dept dept = new Dept();
		dept.setDeptno(87);
		dept.setDname("天津");
		dept.setLoc("tianji");
		DeptDao dao = new DeptDaoImpl();
		dao.updateDept(dept);
	}

}
