package cn.springmvc.model;

import java.util.Date;

public class Order {//订单
	private String orderno;
	private String billno;
	private String boardno;

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean check) {
		isCheck = check;
	}

	private Date orderdate;
	private Float price;
	private boolean isOutside;
	private boolean isCheck;
	private String remark;

	public Order() {
	}

	public Order(String orderno, String billno, String boardno, Date ordrdate,
			Float price, boolean isOutside, boolean isChecked, String remark) {
		super();
		this.orderno = orderno;
		this.billno = billno;
		this.boardno = boardno;
		this.orderdate = ordrdate;
		this.price = price;
		this.isOutside = isOutside;
		this.isCheck = isChecked;
		this.remark = remark;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getBoardno() {
		return boardno;
	}

	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}

	public Date getOrdrdate() {
		return orderdate;
	}

	public void setOrdrdate(Date ordrdate) {
		this.orderdate = ordrdate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean isOutside() {
		return isOutside;
	}

	public void setOutside(boolean isOutside) {
		this.isOutside = isOutside;
	}

	public boolean isChecked() {
		return isCheck;
	}

	public void setChecked(boolean isChecked) {
		this.isCheck = isChecked;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
