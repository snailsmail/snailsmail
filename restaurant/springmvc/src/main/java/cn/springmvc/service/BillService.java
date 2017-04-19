package cn.springmvc.service;

import cn.springmvc.model.Bill;

import java.util.List;


public interface BillService {

	public List<Bill> getAllBill();

	public Bill getBillByBillno(String billno);

	public void insertBill(Bill bill);

	public void deleteBillByBillno(String billno);

	public void updateBill(Bill bill);

}

