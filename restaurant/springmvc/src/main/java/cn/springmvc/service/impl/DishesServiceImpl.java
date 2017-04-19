package cn.springmvc.service.impl;

import cn.springmvc.dao.DishesDAO;
import cn.springmvc.model.Dishes;
import cn.springmvc.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DishesServiceImpl implements DishesService {

	@Autowired
	private DishesDAO dishesDAO;

	public List<Dishes> getAllDishes(){
		List<Dishes> dishes = dishesDAO.getAllDishes();
		return dishes;
	}

	public Dishes getDishesByDishesno(String dishesno){
		Dishes dishes = dishesDAO.getDishesByDishesno(dishesno);
		return dishes;
	}

	public Dishes getDishesByDname(String dname){
		Dishes dishes = dishesDAO.getDishesByDname(dname);
		return dishes;
	}

	public void insertDishes(String dishesno,String cuisineno,String dname,Float price){
		dishesDAO.insertDishes( dishesno, cuisineno, dname,price);
	}

	public void deleteDishesBydname(String dname){
		dishesDAO.deleteDishesBydname(dname);
	}

	public void deleteDishesByDishesno(String dishesno){
		dishesDAO.deleteDishesByDishesno(dishesno);
	}

	public void updateDishes(String cuisineno,String dname,Float price,String dishesno){
		dishesDAO.updateDishes(cuisineno, dname, price, dishesno);
	}

	public List<Dishes> getDishesByCuisineno(String cuisineno){
		List<Dishes> dishes = dishesDAO.getDishesByCuisineno(cuisineno);
		return dishes;
	}



}
