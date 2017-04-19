package cn.springmvc.dao;

import cn.springmvc.model.Cuisine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface CuisineDAO {


    /**
     * 获得所有对象
     *
     */
    public List<Cuisine> getAllCuisine();

    /**
     * 通过用户cuisineno获得对象
     * @param cuisineno
     * @return
     */
    public Cuisine getCuisineByCuisineno(@Param("cuisineno") String cuisineno);

    /**
     * 通过用户cname获得对象
     * @param cname
     * @return
     */
    public Cuisine getCuisineByCname(@Param("cname") String cname);

    /**
     * 添加新对象
     * @param
     * @return
     */
    public void insertCuisine(@Param("cuisineno") String cuisineno, @Param("cname") String cname);

    /**
     * 通过cname删除
     * @param cname
     * @return
     */
    public void deleteCuisineByCname(@Param("cname") String cname);


    /**
     * 通过cuisineno删除
     * @param cuisineno
     * @return
     */
    public void deleteCuisineByCuisineno(@Param("cuisineno") String cuisineno);


    /**
     * 更新对象
     * @param
     * @return
     */
    public void updateCuisine(@Param("cname") String cname, @Param("cuisineno") String cuisineno);


}
