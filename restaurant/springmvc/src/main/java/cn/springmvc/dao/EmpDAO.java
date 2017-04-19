package cn.springmvc.dao;

import cn.springmvc.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface EmpDAO {

	/**
	 * 获得所有员工
	 *
	 */
	public List<Employee> getAllEmp();

	/**
	 * 通过用户empno获得员工对象
	 * @param empno
	 * @return
	 */
	public Employee getEmpByEmpno(@Param("empno") String empno);

	/**
	 * 通过用户ename获得员工对象
	 * @param ename
	 * @return
	 */
	public Employee getEmpByEname(@Param("ename") String ename);

	/**
	 * 添加新员工
	 * @param
	 * @return
	 */
	public void insertEmp(@Param("empno") String empno, @Param("jobno") String jobno, @Param("ename") String ename, @Param("sex") String sex, @Param("age") int age, @Param("pwd") String pwd, @Param("sal") float sal, @Param("hiredate") Date hiredate, @Param("tel") String tel, @Param("email") String email, @Param("address") String address, @Param("isadmin") int isadmin);

	/**
	 * 通过ename删除员工
	 * @param ename
	 * @return
	 */
	public void deleteEmpByEname(@Param("ename") String ename);


	/**
	 * 通过empno删除员工
	 * @param empno
	 * @return
	 */
	public void deleteEmpByEmpno(@Param("empno") String empno);


	/**
	 * 更新员工
	 * @param empno
	 * @return
	 */
	public void updateEmp(@Param("jobno") String jobno, @Param("ename") String ename, @Param("sex") String sex, @Param("age") int age, @Param("pwd") String pwd, @Param("sal") float sal, @Param("hiredate") Date hiredate, @Param("tel") String tel, @Param("email") String email, @Param("address") String address, @Param("isadmin") int isadmin, @Param("empno") String empno);

	public void updateEmpPwd(@Param("pwd") String pwd, @Param("empno") String empno);


}
