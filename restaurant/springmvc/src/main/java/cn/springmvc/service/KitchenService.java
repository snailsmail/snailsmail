package cn.springmvc.service;

import cn.springmvc.model.Kitchen;

import java.util.List;


public interface KitchenService {
    public List<Kitchen> getAllKitchen();

    public Kitchen getKitchenByKitchenno(String kitchenno);

    public Kitchen getKitchenByOrderno(String orderno);

    public void insertKitchen(String kitchenno, String orderno, boolean state, Float cost);

    public void deleteKitchenByKitchenno(String kitchenno);

    public void updateKitchen(String orderno, boolean state, Float cost, String kitchenno);

}
