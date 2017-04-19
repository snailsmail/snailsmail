package cn.springmvc.controller;

import cn.springmvc.model.Cuisine;
import cn.springmvc.model.Dishes;
import cn.springmvc.service.CuisineService;
import cn.springmvc.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private DishesService dishesService;

    Cuisine currCuisine = new Cuisine();

    @RequestMapping("/cuisine")
    public String cuisine(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        model.addAttribute("currCuisine",currCuisine);
        return "views/cuisine/search";
    }

    @RequestMapping("/formCuisine")
    public String formCuisine(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/form";
    }

    @RequestMapping("/deleteCuisine")
    public String deleteCuisine(@RequestParam("ids") String[] ids,Model model){
        for (String dishesno : ids){
            dishesService.deleteDishesByDishesno(dishesno);
        }

        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        return "views/cuisine/search";
    }

    @RequestMapping("/updateFormCuisine")
    public String updateFormCuisine(@RequestParam("id") String dishesno,Model model){
        Dishes dishes = dishesService.getDishesByDishesno(dishesno);
        Cuisine cuisine = cuisineService.getCuisineByCuisineno(dishes.getCuisineno());
        model.addAttribute("dishes",dishes);
        model.addAttribute("cuisine",cuisine);
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/updateForm";
    }

    @RequestMapping("/infoCuisine")
    public String infoCuisine(@RequestParam("id") String dishesno,Model model){
        Dishes dishes = dishesService.getDishesByDishesno(dishesno);
        Cuisine cuisine = cuisineService.getCuisineByCuisineno(dishes.getCuisineno());
        model.addAttribute("dishes",dishes);
        model.addAttribute("cuisine",cuisine);
        return "views/cuisine/info";
    }

    @RequestMapping(value = "/inquiryDishes",method = RequestMethod.GET)
    public ModelAndView inquiryDishes(@RequestParam("cuisineno") String cuisineno,ModelAndView model){
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
        model.setViewName("views/cuisine/search");
        return model;
    }

    @RequestMapping("/updateDishes")
    public String updateDishes(HttpServletRequest request, Model model){
        String dishesno = request.getParameter("dishesno");
        String cuisineno = request.getParameter("cuisine");
        String dname = request.getParameter("dname");
        Float price = Float.parseFloat(request.getParameter("price"));
        dishesService.updateDishes(cuisineno,dname,price,dishesno);
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        return "views/cuisine/search";
    }

    @RequestMapping("/saveDishes")
    public String saveDishes(HttpServletRequest request, Model model){
        String dishesno = request.getParameter("dishesno");
        String cuisineno = request.getParameter("cuisine");
        String dname = request.getParameter("dname");
        Float price = Float.parseFloat(request.getParameter("price"));
        dishesService.insertDishes(dishesno,cuisineno,dname,price);
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);
        return "views/cuisine/search";
    }


    @RequestMapping("/saveCuisine")
    public String saveCuisine(HttpServletRequest request, Model model){

        String cuisineno = request.getParameter("cuisineno");
        String cname = request.getParameter("cname");

        cuisineService.insertCuisine(cuisineno,cname);

        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);

        return "views/cuisine/form";
    }


    @RequestMapping("/opaCuisine")
    public String opaCuisine(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/searchCuisine";
    }

    @RequestMapping("/addCuisine")
    public String addCuisine(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/addCuisine";
    }

    @RequestMapping("/addC")
    public String addC(Model model,HttpServletRequest request){
        String cuisineno = request.getParameter("cuisineno");
        String cname = request.getParameter("cname");
        cuisineService.insertCuisine(cuisineno,cname);
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/searchCuisine";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("ids") String[] cuisinenos,Model model){
        for (String cuisineno : cuisinenos){
            cuisineService.deleteCuisineByCuisineno(cuisineno);
        }
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/searchCuisine";
    }

    @RequestMapping("update")
    public String up(@RequestParam("id") String id,Model model){
        Cuisine cuisine = cuisineService.getCuisineByCuisineno(id);
        model.addAttribute("cuisine",cuisine);
        return  "views/cuisine/updateCuisine";
    }

    @RequestMapping("/updateC")
    public String update(HttpServletRequest request, Model model){
        String cuisineno = request.getParameter("cuisineno");
        String cname = request.getParameter("cname");
        cuisineService.updateCuisine(cname,cuisineno);
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/searchCuisine";
    }

    @RequestMapping("back")
    public String back(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        return "views/cuisine/form";
    }

    @RequestMapping("backD")
    public String backD(Model model){
        List<Cuisine> cuisines = cuisineService.getAllCuisine();
        model.addAttribute("cuisines",cuisines);
        List<Dishes> dishes = dishesService.getAllDishes();
        model.addAttribute("dishes",dishes);

        return "views/cuisine/search";
    }
}


