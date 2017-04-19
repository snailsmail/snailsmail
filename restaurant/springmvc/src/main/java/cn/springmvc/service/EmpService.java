package cn.springmvc.service;

import cn.springmvc.model.Employee;

import java.util.Date;
import java.util.List;


public interface EmpService {

	public List<Employee> getAllEmp();

	public Employee getEmpByEmpno(String empno);

	public Employee getEmpByEname(String ename);

	public void insertEmp(String empno, String jobno, String ename, String sex, int age, String pwd, float sal, Date hiredate, String tel, String email, String address, int isadmin);

	public void deleteEmpByEname(String ename);

	public void deleteEmpByEmpno(String empno);

	public void updateEmp(String jobno, String ename, String sex, int age, String pwd, float sal, Date hiredate,
						  String tel, String email, String address, int isAdmin, String empno);

	public void updateEmpPwd(String pwd, String empno);

}
