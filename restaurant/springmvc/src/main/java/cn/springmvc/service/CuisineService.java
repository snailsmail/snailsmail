package cn.springmvc.service;

import cn.springmvc.model.Cuisine;

import java.util.List;


public interface CuisineService {

	public List<Cuisine> getAllCuisine();

	public Cuisine getCuisineByCuisineno(String cuisineno);

	public Cuisine getCuisineByCname(String cname);

	public void insertCuisine(String cuisineno, String cname);

	public void deleteCuisineByCname(String cname);

	public void deleteCuisineByCuisineno(String cuisineno);

	public void updateCuisine(String cname, String cuisineno);

}
