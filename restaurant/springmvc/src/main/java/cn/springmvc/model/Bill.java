package cn.springmvc.model;

public class Bill {//菜单
	private String billno;
	private String descriptions;

	public Bill() {
	}

	public Bill(String billno, String description) {
		super();
		this.billno = billno;
		this.descriptions = description;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
}
