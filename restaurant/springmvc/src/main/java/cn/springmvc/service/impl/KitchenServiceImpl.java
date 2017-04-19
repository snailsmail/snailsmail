package cn.springmvc.service.impl;

import cn.springmvc.dao.KitchenDAO;
import cn.springmvc.model.Kitchen;
import cn.springmvc.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KitchenServiceImpl implements KitchenService {

	@Autowired
	private KitchenDAO kitchenDAO;

	public List<Kitchen> getAllKitchen(){
		List<Kitchen> kitchens = kitchenDAO.getAllKitchen();
		return kitchens;
	}

	public Kitchen getKitchenByKitchenno(String kitchenno){
		Kitchen kitchen = kitchenDAO.getKitchenByKitchenno(kitchenno);
		return kitchen;
	}

	public void insertKitchen(String kitchenno,String orderno,boolean state,Float cost){
		kitchenDAO.insertKitchen(kitchenno,orderno,state,cost);
	}

	public void deleteKitchenByKitchenno(String kitchenno){
		kitchenDAO.deleteKitchenByKitchenno(kitchenno);
	}

	public void updateKitchen(String orderno,boolean state,Float cost,String kitchenno){
		kitchenDAO.updateKitchen(orderno,state,cost,kitchenno);
	}

	public Kitchen getKitchenByOrderno(String orderno){
		Kitchen kitchen = kitchenDAO.getKitchenByOrderno(orderno);
		return kitchen;
	}

}
