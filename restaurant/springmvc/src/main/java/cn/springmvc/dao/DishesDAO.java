package cn.springmvc.dao;

import cn.springmvc.model.Dishes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface DishesDAO {


    /**
     * 获得所有对象
     *
     */
    public List<Dishes> getAllDishes();

    /**
     * 通过用户dishesno获得对象
     * @param dishesno
     * @return
     */
    public Dishes getDishesByDishesno(@Param("dishesno") String dishesno);

    /**
     * 通过用户dname获得对象
     * @param dname
     * @return
     */
    public Dishes getDishesByDname(@Param("dname") String dname);

    /**
     * 添加新对象
     * @param cuisineno
     * @return
     */
    public void insertDishes(@Param("dishesno") String dishesno, @Param("cuisineno") String cuisineno, @Param("dname") String dname, @Param("price") Float price);

    /**
     * 通过dname删除对象
     * @param dname
     * @return
     */
    public void deleteDishesBydname(@Param("dname") String dname);


    /**
     * 通过dishesno删除对象
     * @param dishesno
     * @return
     */
    public void deleteDishesByDishesno(@Param("dishesno") String dishesno);


    /**
     * 更新对象
     * @param
     * @return
     */
    public void updateDishes(@Param("cuisineno") String cuisineno, @Param("dname") String dname, @Param("price") Float price, @Param("dishesno") String dishesno);


    /**
     * 更新对象
     * @param cuisineno
     * @return
     */
    public List<Dishes> getDishesByCuisineno(@Param("cuisineno") String cuisineno);



}
