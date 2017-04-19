package cn.springmvc.dao;

import cn.springmvc.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface OrderDAO {


    /**
     * 获得所有对象
     *
     */
    public List<Order> getAllOrder();

    /**
     * 通过用户orderno获得对象
     * @param orderno
     * @return
     */
    public Order getOrderByOrderno(@Param("orderno") String orderno);



    /**
     * 添加新对象
     * @param order
     * @return
     */
    public void insertOrder(Order order);


    /**
     * 通过orderno删除
     * @param orderno
     * @return
     */
    public void deleteOrderByOrderno(@Param("orderno") String orderno);


    /**
     * 更新对象
     * @param order
     * @return
     */
    public void updateOrderByOrderno(Order order);


}
