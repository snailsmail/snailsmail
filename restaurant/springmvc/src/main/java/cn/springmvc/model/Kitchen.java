package cn.springmvc.model;

public class Kitchen {//职位
	private String kitchenno;
	private String orderno;
	private boolean state;
	private float cost;

	public Kitchen() {
	}

	public Kitchen(String kitchenno, String orderno, boolean state, float cost) {
		this.kitchenno = kitchenno;
		this.orderno = orderno;
		this.state = state;
		this.cost = cost;
	}

	public String getKitchenno() {
		return kitchenno;
	}

	public void setKitchenno(String kitchenno) {
		this.kitchenno = kitchenno;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
}
