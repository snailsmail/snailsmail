package cn.springmvc.dao;

import cn.springmvc.model.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface BillDAO {


    /**
     * 获得所有对象
     *
     */
    public List<Bill> getAllBill();

    /**
     * 通过用户billno获得对象
     * @param billno
     * @return
     */
    public Bill getBillByBillno(@Param("billno") String billno);

    /**
     * 添加新对象
     * @param bill
     * @return
     */
    public void insertBill(Bill bill);


    /**
     * 通过billno删除
     * @param billno
     * @return
     */
    public void deleteBillByBillno(@Param("billno") String billno);


    /**
     * 更新对象
     * @param bill
     * @return
     */
    public void updateBill(Bill bill);

}
