package cn.springmvc.model;

public class Job {//职位
	private String jobno;
	private String jname;

	public Job() {
	}

	public Job(String jobno, String jname) {
		super();
		this.jobno = jobno;
		this.jname = jname;
	}

	public String getJobno() {
		return jobno;
	}

	public void setJobno(String jobno) {
		this.jobno = jobno;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

}
