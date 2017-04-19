package cn.springmvc.model;

public class Cuisine {//菜系
	private String cuisineno;
	private String cname;

	public Cuisine() {
	}

	public Cuisine(String cuisineno, String cname) {
		super();
		this.cuisineno = cuisineno;
		this.cname = cname;
	}

	public String getCuisineno() {
		return cuisineno;
	}

	public void setCuisineno(String cuisineno) {
		this.cuisineno = cuisineno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
