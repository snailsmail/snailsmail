package cn.springmvc.model;

public class User {//用户
	private String userno;
	private String uname;
	private String sex;
	private String pwd;

	public User() {
	}

	public User(String userno, String uname, String sex) {
		super();
		this.userno = userno;
		this.uname = uname;
		this.sex = sex;
	}

	public User(String userno, String uname, String sex, String pwd) {
		this.userno = userno;
		this.uname = uname;
		this.sex = sex;
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
