package cn.springmvc.dao;

import cn.springmvc.model.Kitchen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface KitchenDAO {

    public List<Kitchen> getAllKitchen();

    public Kitchen getKitchenByKitchenno(@Param("kitchenno") String kitchenno);

    public Kitchen getKitchenByOrderno(@Param("orderno") String orderno);

    public void insertKitchen(@Param("kitchenno") String kitchenno, @Param("orderno") String orderno, @Param("state") boolean state, @Param("cost") Float cost);

    public void deleteKitchenByKitchenno(@Param("kitchenno") String kitchenno);

    public void updateKitchen(@Param("orderno") String orderno, @Param("state") boolean state, @Param("cost") Float cost, @Param("kitchenno") String kitchenno);


}
