package cn.springmvc.model;

import java.util.Date;

public class Employee {//员工
	private String empno;
	private String jobno;
	private String ename;
	private String sex;
	private int age;
	private String pwd;
	private double sal;
	private Date hiredate;
	private String tel;
	private String email;
	private String address;
	private boolean isAdmin;

	public Employee() {
	}

	public Employee(String empno, String jname, String ename, String sex,
			int age, String pwd, double salary, Date hiredate, String tel,
			String email, String address, boolean isAdmin) {
		this.empno = empno;
		this.jobno = jname;
		this.ename = ename;
		this.sex = sex;
		this.age = age;
		this.pwd = pwd;
		this.sal = salary;
		this.hiredate = hiredate;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.isAdmin = isAdmin;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getJobno() {
		return jobno;
	}

	public void setJobno(String jobno) {
		this.jobno = jobno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
