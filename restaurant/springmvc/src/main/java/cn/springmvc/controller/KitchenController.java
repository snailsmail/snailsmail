package cn.springmvc.controller;

import cn.springmvc.model.Kitchen;
import cn.springmvc.model.Order;
import cn.springmvc.service.KitchenService;
import cn.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")
public class KitchenController {

    @Autowired
    private KitchenService kitchenervice;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/kitchen")
    public String kitchen(Model model){
        List<Kitchen> kitchens = kitchenervice.getAllKitchen();
        model.addAttribute("kitchens",kitchens);
        return "views/kitchen/search";
    }

    @RequestMapping("/formKitchen")
    public ModelAndView formKitchen(ModelAndView model) {
        List<Order> orders = orderService.getAllOrder();
        model.addObject("orders",orders);

        List<Kitchen> kitchens = kitchenervice.getAllKitchen();
        model.addObject("kitchens", kitchens);
        model.setViewName("views/kitchen/form");
        return model;
    }


    @RequestMapping("/deleteKitchen")
    public ModelAndView deleteUKitchen(@RequestParam("ids") String[] ids, ModelAndView model) {
        for (String kitchenno : ids) {
            kitchenervice.deleteKitchenByKitchenno(kitchenno);
        }

        List<Kitchen> kitchens = kitchenervice.getAllKitchen();
        model.addObject("kitchens",kitchens);
        model.setViewName("views/kitchen/search");
        return model;
    }

    @RequestMapping("/updateFormKitchen")
    public ModelAndView updateFormKitchen(@RequestParam("id") String kitchenno, ModelAndView model) {
       Kitchen kitchen = kitchenervice.getKitchenByKitchenno(kitchenno);
        model.addObject("kitchen", kitchen);
        model.setViewName("views/kitchen/updateForm");
        return model;
    }


    @RequestMapping("/infoKitchen")
    public ModelAndView infoKitchen(@RequestParam("id") String kitchenno, ModelAndView model) {
        Kitchen kitchen = kitchenervice.getKitchenByKitchenno(kitchenno);
        model.addObject("kitchen", kitchen);
        model.setViewName("views/kitchen/info");
        return model;
    }

    @RequestMapping("/saveKitchen")
    public ModelAndView saveKitchen(ModelAndView model, HttpServletRequest request) {
        String kitchenno = request.getParameter("kitchenno");
        String orderno = request.getParameter("orderno");
        Float cost = Float.parseFloat(request.getParameter("cost"));

        kitchenervice.insertKitchen(kitchenno,orderno,false,cost);
        List<Kitchen> kitchens = kitchenervice.getAllKitchen();
        model.addObject("kitchens",kitchens);
        model.setViewName("views/kitchen/search");
        return model;
    }

    @RequestMapping("/updateKitchen")
    public ModelAndView updateKitchen(ModelAndView model, HttpServletRequest request) {
        String kitchenno = request.getParameter("kitchenno");
        String orderno = request.getParameter("orderno");
        Float cost = Float.parseFloat(request.getParameter("cost"));
        int state = Integer.parseInt(request.getParameter("state"));

        boolean b;

        if (state==1){
            b = true;
        }else{
            b = false;
        }

        kitchenervice.updateKitchen(orderno,b,cost,kitchenno);

        List<Kitchen> kitchens = kitchenervice.getAllKitchen();
        model.addObject("kitchens",kitchens);
        model.setViewName("views/kitchen/search");
        return model;
    }

    @RequestMapping("/freshKitchen")
    public ModelAndView freshKitchen(ModelAndView model) {
        List<Kitchen>  kitchens = kitchenervice.getAllKitchen();
        model.addObject("kitchens", kitchens);
        model.setViewName("views/kitchen/search");
        return model;
    }
}


