package cn.springmvc.controller;

import cn.springmvc.model.*;
import cn.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BillService billService;

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private DishesService dishesService;

    @Autowired
    private BoardService boardService;


    @RequestMapping("/order")
    public String order(Model model){
        List<Bill> bills = billService.getAllBill();
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("bills",bills);
        model.addAttribute("orders",orders);
        return "views/order/search";
    }

    @RequestMapping("/formOrder")
    public String formOrder(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        Bill bill = new Bill();
        model.addAttribute("bill",bill);
        return "views/order/form";
    }

    @RequestMapping("/blurCuisine")
    public String blurCuisine(@RequestParam("cuisine") String cuisinesno, Model model){
        Cuisine cuisine = cuisineService.getCuisineByCuisineno(cuisinesno);
        model.addAttribute("cuisine",cuisine);
//        List<Dishes> dishes = dishesService.getDishesByCuisineno(cuisinesno);
//        model.addAttribute("dishes",dishes);
        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards",boards);
        return "views/order/form";
    }


    @RequestMapping("/deleteOrder")
    public String deleteOrder(Model model){
        return "views/order/delete";
    }

    @RequestMapping("/updateFormOrder")
    public String updateFormOrder(Model model){
        return "views/order/updateForm";
    }

    @RequestMapping("/infoOrder")
    public String infoOrder(Model model){
        return "views/order/info";
    }




}


