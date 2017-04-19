package cn.springmvc.service.impl;

import cn.springmvc.dao.OrderDAO;
import cn.springmvc.model.Order;
import cn.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;


	public List<Order> getAllOrder(){
		List<Order> orders = orderDAO.getAllOrder();
		return orders;
	}

	public Order getOrderByOrderno(String orderno){
		Order order = orderDAO.getOrderByOrderno(orderno);
		return order;
	}

	public void insertOrder(Order order){
		orderDAO.insertOrder(order);
	}

	public void deleteOrderByOrderno(String orderno){
		orderDAO.deleteOrderByOrderno(orderno);
	}

	public void updateOrderByOrderno(Order order){
		orderDAO.updateOrderByOrderno(order);
	}


}
