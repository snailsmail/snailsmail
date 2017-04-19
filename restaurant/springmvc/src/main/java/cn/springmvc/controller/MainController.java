package cn.springmvc.controller;

import cn.springmvc.model.*;
import cn.springmvc.service.*;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmpService empService;

	@Autowired
	private JobService jobService;

	@Autowired
	private CuisineService cuisineService;

	@Autowired
	private DishesService dishesService;


	Employee currentEmp = null;
	User currentUser = null;

	@RequestMapping("/login")
	public String home(Model model){
		return "views/login";
	}

	@RequestMapping("/home")
	public String loginPage(@RequestParam("name")String name,@RequestParam("pwd")String pwd,@RequestParam("job")String job, Model model) {
		String error = null;
		String url = null;
		List<Employee> emps = empService.getAllEmp();

		List<User> users = userService.getAllUser();
		if (job.equals("学生")){
			for (User user : users) {
				if (user.getUname().equals(name)  && user.getPwd().equals(pwd) ) {
					url = "redirect:/ho.do";
					error = null;
					currentUser = user;
					break;
				} else {
					error = "学生登录名错误或密码错误";
					url = "views/login";
				}
			}
		}else{
			for (Employee emp : emps) {
				if (emp.getEname().equals(name)  && emp.getPwd().equals(pwd) ) {
					url = "redirect:/homein.do";
					error = null;
					currentEmp = emp;
					break;
				} else {
					error = "员工登录名错误或密码错误";
					url = "views/login";
				}
			}
		}
		model.addAttribute("error", error);
		return url;
	}

	@RequestMapping("/homein")
	public ModelAndView homein(ModelAndView model){
		model.addObject("currentEmp",currentEmp);
		model.setViewName("views/home");
		return model;
	}

	@RequestMapping("/ho")
	public ModelAndView ho(ModelAndView model){
		model.addObject("currentUser",currentUser);
		model.setViewName("views/UserLogin");
		return model;
	}

	@RequestMapping("/logout")
	public String logout(){
		return "views/login";
	}

	@RequestMapping("/welcome")
	public String welcome(Model model){
		String url = null;
		model.addAttribute("currentEmp",currentEmp);
		if(currentEmp.isAdmin()){
			url = "views/menu";
		} else {
			url = "views/menuGene";
		}
		return url;
	}

	@RequestMapping("/show")
	public String show(Model model){
		List<Cuisine> cuisines = cuisineService.getAllCuisine();
		model.addAttribute("cuisines",cuisines);
		List<Dishes> dishes = dishesService.getAllDishes();
		model.addAttribute("dishes",dishes);
		String cuisineno = null;
		model.addAttribute("cuisineno",cuisineno);
		return "views/show";
	}

	@RequestMapping("/profile")
	public String profile(Model model){
		Job job = jobService.getJobByJobno(currentEmp.getJobno());
		model.addAttribute("currentEmp",currentEmp);
		model.addAttribute("job",job);
		return "views/my/profile";
	}

	@RequestMapping("/profileUser")
	public String profileUser(Model model){
		model.addAttribute("currentUser",currentUser);
		return "views/my/profileUser";
	}

	@RequestMapping("/password")
	public String password(Model model){
		model.addAttribute("currentEmp",currentEmp);
		return "views/my/password";
	}

	@RequestMapping("/passwordUser")
	public String passwordUser(Model model){
		model.addAttribute("currentUser",currentUser);
		return "views/my/passwordUser";
	}


	@RequestMapping("/forget-password")
	public String forgetPassword(){
		return "views/forget-password";
	}

	@RequestMapping("/sign-up")
	public String signUp(){
		return "views/sign-up";
	}

	@RequestMapping("/updateEmpPwd")
	public String updateEmpPwd(@RequestParam("newpassword") String newpassword, @RequestParam("repassword") String repassword, Model model) {
		String msg = null;
		String url = null;
		if (newpassword.equals(repassword)){
			currentEmp.setPwd(newpassword);
			empService.updateEmpPwd(newpassword,currentEmp.getEmpno());
		}else {
			msg = "密码输入不一致!";
		}
		url = "views/my/password";
		model.addAttribute("msg", msg);
		model.addAttribute("currentEmp",currentEmp);
		return url;
	}

	@RequestMapping("/updateUserPwd")
	public String updateUserPwd(@RequestParam("newpassword") String newpassword, @RequestParam("repassword") String repassword, Model model) {
		String msg = null;
		String url = null;
		if (newpassword.equals(repassword)){
			currentUser.setPwd(newpassword);
			userService.updateUserPwd(newpassword,currentUser.getUserno());
		}else {
			msg = "密码输入不一致!";
		}
		url = "views/my/passwordUser";
		model.addAttribute("msg", msg);
		model.addAttribute("currentUser",currentUser);
		return url;
	}

}
