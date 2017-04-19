package cn.springmvc.service;

import cn.springmvc.model.Dishes;

import java.util.List;


public interface DishesService {

	public List<Dishes> getAllDishes();

	public Dishes getDishesByDishesno(String dishesno);

	public Dishes getDishesByDname(String dname);

	public void insertDishes(String dishesno, String cuisineno, String dname, Float price);

	public void deleteDishesBydname(String dname);

	public void deleteDishesByDishesno(String dishesno);

	public void updateDishes(String cuisineno, String dname, Float price, String dishesno);

	public List<Dishes> getDishesByCuisineno(String cuisineno);



}
