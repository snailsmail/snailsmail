package cn.springmvc.service;

import cn.springmvc.model.Order;

import java.util.List;


public interface OrderService {

	public List<Order> getAllOrder();

	public Order getOrderByOrderno(String orderno);

	public void insertOrder(Order order);

	public void deleteOrderByOrderno(String orderno);

	public void updateOrderByOrderno(Order order);


}

