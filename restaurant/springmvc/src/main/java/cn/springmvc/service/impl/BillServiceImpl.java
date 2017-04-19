package cn.springmvc.service.impl;

import cn.springmvc.dao.BillDAO;
import cn.springmvc.model.Bill;
import cn.springmvc.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDAO billDAO;


	public List<Bill> getAllBill(){
		List<Bill> bills = billDAO.getAllBill();
		return bills;
	}

	public Bill getBillByBillno(String billno){
		Bill bill = billDAO.getBillByBillno(billno);
		return bill;
	}

	public void insertBill(Bill bill){
		billDAO.insertBill(bill);
	}

	public void deleteBillByBillno(String billno){
		billDAO.deleteBillByBillno(billno);
	}

	public void updateBill(Bill bill){
		billDAO.updateBill(bill);
	}



}
