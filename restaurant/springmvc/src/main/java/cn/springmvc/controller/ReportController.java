package cn.springmvc.controller;

import cn.springmvc.model.Kitchen;
import cn.springmvc.model.Order;
import cn.springmvc.service.KitchenService;
import cn.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class ReportController {

    @Autowired
    private KitchenService kitchenervice;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/report",method = RequestMethod.GET)
    public String report(){
        return "views/report/index";
    }

    @RequestMapping(value = "/reportData",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<Float,Float> reportData(){
        List<Order> orders = orderService.getAllOrder();
        List<Kitchen> kitchens = kitchenervice.getAllKitchen();

        Map<Float,Float> map = new HashMap<Float,Float>();

        for (Kitchen kitchen : kitchens){
            Order order = orderService.getOrderByOrderno(kitchen.getOrderno());
            map.put(kitchen.getCost(),order.getPrice());
        }

        return map;
    }




}



