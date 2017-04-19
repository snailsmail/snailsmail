package cn.springmvc.model;

public class Dishes {//菜品
	private String dishesno;
	private String cuisineno;
	private String dname;
	private Float price;
	private String url;

	public Dishes(String dishesno, String cuisineno, String dname, Float price, String url) {
		this.dishesno = dishesno;
		this.cuisineno = cuisineno;
		this.dname = dname;
		this.price = price;
		this.url = url;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Dishes() {
	}

	public Dishes(String dishesno, String cuisineno, String dname,
			Float price) {
		super();
		this.dishesno = dishesno;
		this.cuisineno = cuisineno;
		this.dname = dname;
		this.price = price;
	}

	public String getDishesno() {
		return dishesno;
	}

	public void setDishesno(String dishesno) {
		this.dishesno = dishesno;
	}

	public String getCuisineno() {
		return cuisineno;
	}

	public void setCuisineno(String cuisineno) {
		this.cuisineno = cuisineno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
