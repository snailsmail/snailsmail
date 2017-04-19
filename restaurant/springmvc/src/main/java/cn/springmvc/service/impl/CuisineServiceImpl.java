package cn.springmvc.service.impl;

import cn.springmvc.dao.CuisineDAO;
import cn.springmvc.model.Cuisine;
import cn.springmvc.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CuisineServiceImpl implements CuisineService {

	@Autowired
	private CuisineDAO cuisineDAO;

	public List<Cuisine> getAllCuisine(){
		List<Cuisine> cuisines= cuisineDAO.getAllCuisine();
		return cuisines;
	}

	public Cuisine getCuisineByCuisineno(String cuisineno){
		Cuisine cuisine = cuisineDAO.getCuisineByCuisineno(cuisineno);
		return cuisine;
	}

	public Cuisine getCuisineByCname(String cname){
		Cuisine cuisine = cuisineDAO.getCuisineByCname(cname);
		return cuisine;
	}

	public void insertCuisine(String cuisineno,String cname){
		cuisineDAO.insertCuisine(cuisineno,cname);
	}

	public void deleteCuisineByCname(String cname){
		cuisineDAO.deleteCuisineByCname(cname);
	}

	public void deleteCuisineByCuisineno(String cuisineno){
		cuisineDAO.deleteCuisineByCuisineno(cuisineno);
	}

	public void updateCuisine(String cname,String cuisineno){
		cuisineDAO.updateCuisine(cname,cuisineno);
	}


}
