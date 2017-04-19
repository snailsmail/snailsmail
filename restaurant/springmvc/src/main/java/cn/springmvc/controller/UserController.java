package cn.springmvc.controller;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    private User rechargeUser = null;

    private User openUser = null;

    private User openGeneUser = null;

    @RequestMapping("/user")
    public ModelAndView ho(ModelAndView model) {
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/search");
        return model;
    }

    @RequestMapping("/userGene")
    public ModelAndView userGene(ModelAndView model) {
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/searchGene");
        return model;
    }

    @RequestMapping("/formUser")
    public ModelAndView formUser(ModelAndView model) {
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/form");
        return model;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(@RequestParam("ids") String[] ids, ModelAndView model) {
        for (String uname : ids) {
            userService.deleteUserByUserno(uname);
        }

        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/search");
        return model;
    }

    @RequestMapping("/updateFormUser")
    public ModelAndView updateFormUser(@RequestParam("id") String userno, ModelAndView model) {
        User user = userService.getUserByUserno(userno);
        model.addObject("user", user);
        model.setViewName("views/user/updateForm");
        return model;
    }

    @RequestMapping("/infoUser")
    public ModelAndView infoUser(@RequestParam("id") String userno, ModelAndView model) {
        User user = userService.getUserByUserno(userno);
        model.addObject("user", user);
        model.setViewName("views/user/info");
        return model;
    }

    @RequestMapping("/saveUser")
    public ModelAndView saveUser(ModelAndView model, HttpServletRequest request) {
        String userno = request.getParameter("userno");
        String uname = request.getParameter("uname");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        Float balance = Float.parseFloat(request.getParameter("balance"));
        String address = request.getParameter("address");

        userService.insertUser(userno, uname, sex, tel, balance, address, 0);

        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/search");
        return model;
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(ModelAndView model, HttpServletRequest request) {
        String userno = request.getParameter("userno");
        String uname = request.getParameter("uname");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        Float balance = Float.parseFloat(request.getParameter("balance"));
        String address = request.getParameter("address");
        int isvip = Integer.parseInt(request.getParameter("isvip"));

        userService.updateUser(uname, sex, tel, balance, address, isvip, userno);

        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/search");
        return model;
    }

    @RequestMapping("/recharge")
    public ModelAndView recharge(@RequestParam("id") String userno, ModelAndView model) {
        User user = userService.getUserByUserno(userno);
        model.addObject("user", user);
        rechargeUser = user;
        model.setViewName("views/user/recharge");
        return model;
    }


    @RequestMapping("/rechargeUpdate")
    public ModelAndView rechargeUpdate(ModelAndView model, HttpServletRequest request) {
        String addmoney = request.getParameter("addmoney");
        Float money = Float.parseFloat(addmoney);
        Float balance = money + rechargeUser.getBalance();
        rechargeUser.setBalance(balance);
        int vip = 0;
        if (rechargeUser.isVip()){
            vip = 1;
        }
        userService.updateUser(rechargeUser.getUname(),rechargeUser.getSex(),rechargeUser.getTel(),rechargeUser.getBalance(),rechargeUser.getAddress(),vip,rechargeUser.getUserno());
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/search");
        return model;
    }


    @RequestMapping("/rechargeGene")
    public ModelAndView rechargeGene(@RequestParam("id") String userno, ModelAndView model) {
        User user = userService.getUserByUserno(userno);
        model.addObject("user", user);
        rechargeUser = user;
        model.setViewName("views/user/rechargeGene");
        return model;
    }

    @RequestMapping("/rechargeUpdateGene")
    public ModelAndView rechargeUpdateGene(ModelAndView model, HttpServletRequest request) {
        String addmoney = request.getParameter("addmoney");
        Float money = Float.parseFloat(addmoney);
        Float balance = money + rechargeUser.getBalance();
        rechargeUser.setBalance(balance);
        int vip = 0;
        if (rechargeUser.isVip()){
            vip = 1;
        }
        userService.updateUser(rechargeUser.getUname(),rechargeUser.getSex(),rechargeUser.getTel(),rechargeUser.getBalance(),rechargeUser.getAddress(),vip,rechargeUser.getUserno());
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/searchGene");
        return model;
    }

    @RequestMapping("/open")
    public ModelAndView open(@RequestParam("id") String userno, ModelAndView model) {
        User user = userService.getUserByUserno(userno);
        openUser = user;
        model.addObject("user", user);
        model.setViewName("views/user/open");
        return model;
    }

    @RequestMapping("/openUpdate")
    public ModelAndView openUpdate(ModelAndView model, HttpServletRequest request) {
        String isVip = request.getParameter("isVip");
        int vip = 0;
        if ("是".equals(isVip)){
            vip = 1;
        }
        userService.updateUser(openUser.getUname(),openUser.getSex(),openUser.getTel(),openUser.getBalance(),openUser.getAddress(),vip,openUser.getUserno());
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/search");
        return model;
    }

    @RequestMapping("/openGene")
    public ModelAndView openGene(@RequestParam("id") String userno, ModelAndView model) {
        User user = userService.getUserByUserno(userno);
        openGeneUser = user;
        model.addObject("user", user);
        model.setViewName("views/user/openGene");
        return model;
    }

    @RequestMapping("/openUpdateGene")
    public ModelAndView openUpdateGene(ModelAndView model, HttpServletRequest request) {
        String isVip = request.getParameter("isVip");
        int vip = 0;
        if ("是".equals(isVip)){
            vip = 1;
        }
        userService.updateUser(openGeneUser.getUname(),openGeneUser.getSex(),openGeneUser.getTel(),openGeneUser.getBalance(),openGeneUser.getAddress(),vip,openGeneUser.getUserno());
        List<User> users = userService.getAllUser();
        model.addObject("users", users);
        model.setViewName("views/user/searchGene");
        return model;
    }


    @RequestMapping("/newUser")
    public String newUser(ModelAndView model, HttpServletRequest request){
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String error = null;
        String url = null;
        Random rand = new Random();
        int math = rand.nextInt(999);
        String userno = "u"+math;

        List<User> users = userService.getAllUser();
        for (User user:users){
            if (userno.equals(user.getUserno())){
                math = rand.nextInt(999);
            }
        }

        float b = 0;

        if (password.equals(repassword)){
            userService.insertUser1pwd(userno, uname, sex, tel, b, address, 0, password);
            url = "redirect:/login.do";
            error = null;
        } else {
            error = "重复密码错误";
            url = "views/sign-up";
        }
        model.addObject("users", users);
        model.setViewName("views/login");
        return url;
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public Boolean checkUser(@RequestParam("uname") String uname){
        Boolean result = false;
        List<User> users = userService.getAllUser();

        for (User user : users){
            if (user.getUname().equals(uname)){
                return result = true;
            }
        }

        return result;
    }



}