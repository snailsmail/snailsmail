package cn.springmvc.controller;

import cn.springmvc.model.Cuisine;
import cn.springmvc.model.Dishes;
import cn.springmvc.model.Order;
import cn.springmvc.service.CuisineService;
import cn.springmvc.service.DishesService;
import cn.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("")
public class ShowController {

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private DishesService dishesService;

    @Autowired
    private OrderService orderService;

    List<Dishes> advanceDish = new ArrayList<Dishes>();

    Cuisine currCuisine = new Cuisine();

    @RequestMapping("/MyDishes")
    public String MyDishes(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders",orders);
        model.addAttribute("advanceDish",advanceDish);
        return "views/showDishes";
    }

    @RequestMapping("/showback")
    public String showback(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Order> orders = orderService.getAllOrder();
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        model.addAttribute("orders",orders);
        return "views/show";
    }

    @RequestMapping("/showdelete")
    public String showdelete(@RequestParam("ids") String[] ids,Model model){
        List<Dishes> dishes = dishesService.getAllDishes();
        for (String dishesno : ids){
            Dishes dish = dishesService.getDishesByDishesno(dishesno);
            Iterator it = advanceDish.iterator();
            while (it.hasNext()){
                Dishes d = (Dishes) it.next();
                if (d.getDishesno().equals(dish.getDishesno())){
                    it.remove();
                }
            }
        }
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        model.addAttribute("advanceDish",advanceDish);
        return "views/showDishes";
    }

    @RequestMapping("/check")
    public String check(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        return "views/check";
    }


    @RequestMapping("/advance")
    public boolean advance(@RequestParam("dishesno")String dishesno){
        Boolean result = false;
        Iterator it = advanceDish.iterator();
        while (it.hasNext()){
            Dishes d = (Dishes) it.next();
            if (dishesno.equals(d.getDishesno())){
                it.remove();
            }
        }
        List<Dishes> dishes = dishesService.getAllDishes();
        for (Dishes dish : dishes){
            if (dishesno.equals(dish.getDishesno())){
                advanceDish.add(dish);
                return result = true;
            }
        }
        return result;
    }


    @RequestMapping(value = "/inquiry",method = RequestMethod.GET)
    public ModelAndView inquiry(@RequestParam("cuisineno") String cuisineno, ModelAndView model){
        List<Dishes> dishes;
        if (cuisineno.equals("")){
            dishes = dishesService.getAllDishes();
        }else {
            dishes = dishesService.getDishesByCuisineno(cuisineno);
        }
        model.addObject("dishes",dishes);
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        currCuisine = cuisineService.getCuisineByCuisineno(cuisineno);
        model.addObject("cuisines",cuisines);
        model.addObject("currCuisine",currCuisine);
        model.setViewName("views/show");
        return model;
    }


    @RequestMapping(value = "/firmOrder",method = RequestMethod.GET)
    public String firmOrder(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders",orders);
        model.addAttribute("advanceDish",advanceDish);
        return "views/firmOrder";
    }

    @RequestMapping(value = "/yeepay",method = RequestMethod.GET)
    public String yeepay(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders",orders);
        model.addAttribute("advanceDish",advanceDish);
        return "views/yeepay/pay";
    }

}


