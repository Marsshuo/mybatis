package com.neutech.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.neutech.bean.Emp;
import com.neutech.dao.EmpDao;
import com.neutech.dao.EmpDaoImpl;



public class TestEmp {


	@Test
	public void test() throws Exception {
		EmpDao dao = new EmpDaoImpl();
		List<Emp> emps =  dao.findAllEmp();
		for (Emp emp : emps) {
			System.out.println(emp.getEname());
		}	
	}
	
	@Test
	public void testEmpByempno() throws Exception {
		EmpDao dao = new EmpDaoImpl();
		Emp emp = dao.finEmpByEmpno(1001);
		System.out.println(emp.getEname());
		
	}
	
	@Test
	public void testaddEmp() throws Exception {
		
		Emp emp = new Emp();
		emp.setEmpno(1020);
		emp.setEname("lyji");
		emp.setMgr(1033);
		emp.setJob("fhais");
		Date d=new Date();
		emp.setHiredate(d);
		emp.setSal(24125);
		emp.setComm(75);
		EmpDao dao = new EmpDaoImpl();
		dao.addEmp(emp);
	
	}
	@Test
	public void testDeleteEmp() throws Exception {
		EmpDao dao = new EmpDaoImpl();
		dao.deleteEmp(3003);	
	}

	@Test
	public void testUpdateEmp() throws Exception {
		Emp emp = new Emp();
		emp.setEmpno(1009);
		emp.setEname("liji");
		emp.setMgr(1033);
		emp.setJob("fhais");
		//emp.setHiredate("2020-3-3");
		emp.setSal(24125);
		emp.setComm(75);
	}


}
