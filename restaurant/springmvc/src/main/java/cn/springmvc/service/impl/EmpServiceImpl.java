package cn.springmvc.service.impl;

import cn.springmvc.dao.EmpDAO;
import cn.springmvc.model.Employee;
import cn.springmvc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDAO;

	public List<Employee> getAllEmp(){
		return empDAO.getAllEmp();
	}

	public Employee getEmpByEmpno(String empno){
		return empDAO.getEmpByEmpno(empno);
	}

	public Employee getEmpByEname(String ename){
		return empDAO.getEmpByEmpno(ename);
	}

	public void insertEmp(String empno,String jobno,String ename,String sex,int age,String pwd,float sal,Date hiredate,String tel,String email,String address,int isadmin){
		empDAO.insertEmp(empno,jobno,ename,sex,age, pwd,sal,hiredate,tel,email,address,isadmin);
	}

	public void deleteEmpByEname(String ename){
		empDAO.deleteEmpByEname(ename);
	}

	public void deleteEmpByEmpno(String empno){
		empDAO.deleteEmpByEmpno(empno);
	}

	public void updateEmp(String jobno, String ename, String sex, int age, String pwd, float sal, Date hiredate,
						  String tel,String email,String address,int isAdmin,String empno){
		empDAO.updateEmp( jobno, ename,  sex, age, pwd, sal, hiredate,
				 tel, email, address, isAdmin,empno);
	}

	public void updateEmpPwd(String pwd, String empno){
		empDAO.updateEmpPwd(pwd, empno);
	}


}
