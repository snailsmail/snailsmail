package cn.springmvc.controller;

import cn.springmvc.model.Employee;
import cn.springmvc.model.Job;
import cn.springmvc.service.EmpService;
import cn.springmvc.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class EmpController {

  @Autowired
  private EmpService empService;

  @Autowired
  private JobService jobService;

  private Employee currentEmp;

  @RequestMapping("/emp")
  public String emp(Model model) {
    List<Employee> emps = empService.getAllEmp();
    List<Job> jobs = jobService.getAllJob();
    model.addAttribute("jobs", jobs);
    model.addAttribute("emps", emps);
    return "views/employee/search";
  }

  @RequestMapping("/empGene")
  public String empGene(Model model) {
    List<Employee> emps = empService.getAllEmp();
    List<Job> jobs = jobService.getAllJob();
    model.addAttribute("jobs", jobs);
    model.addAttribute("emps", emps);
    return "views/employee/searchGene";
  }


  @RequestMapping("/formEmp")
  public ModelAndView formEmp(ModelAndView model) {
    List<Job> jobs = jobService.getAllJob();
    model.addObject("jobs", jobs);
    List<Employee> emps = empService.getAllEmp();
    model.addObject("emps", emps);
    model.setViewName("views/employee/form");
    return model;
  }

  @RequestMapping("/deleteEmp")
  public ModelAndView deleteEmp(@RequestParam("ids") String[] ids, ModelAndView model) {
    for (String empno : ids) {
      empService.deleteEmpByEmpno(empno);
    }
    List<Employee> emps = empService.getAllEmp();
    List<Job> jobs = jobService.getAllJob();
    model.addObject("jobs", jobs);
    model.addObject("emps", emps);
    model.setViewName("views/employee/search");
    return model;
  }

  @RequestMapping("/updateFormEmp")
  public ModelAndView updateFormEmp(@RequestParam("id") String empno, ModelAndView model) {
    List<Employee> emps = empService.getAllEmp();
    model.addObject("emps", emps);
    List<Job> jobs = jobService.getAllJob();
    model.addObject("jobs", jobs);
    Employee emp = empService.getEmpByEmpno(empno);
    model.addObject("emp", emp);
    model.setViewName("views/employee/updateForm");
    return model;
  }

  @RequestMapping("/infoEmp")
  public ModelAndView infoEmp(@RequestParam("id") String empno, ModelAndView model) {
    Employee emp = empService.getEmpByEmpno(empno);
    model.addObject("emp", emp);
    Job job = jobService.getJobByJobno(emp.getJobno());
    model.addObject("job", job);
    model.setViewName("views/employee/info");
    return model;
  }

  @RequestMapping("/saveEmp")
  public ModelAndView saveEmp(ModelAndView model, HttpServletRequest request) {
    String empno = request.getParameter("empno");
    String jobno = request.getParameter("job");
    String ename = request.getParameter("ename");
    String sex = request.getParameter("sex");
    Integer age = Integer.parseInt(request.getParameter("age"));
    String pwd = request.getParameter("pwd");
    float sal = Float.parseFloat(request.getParameter("sal"));
    String tel = request.getParameter("tel");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String isvip = request.getParameter("isVip");

    int isadmin;
    if (isvip.equals("1")) {
      isadmin = 1;
    } else {
      isadmin = 0;
    }

    Date hiredate = new Date();

    empService.insertEmp(empno, jobno, ename, sex, age, pwd, sal, hiredate, tel, email, address, isadmin);

    List<Employee> emps = empService.getAllEmp();
    List<Job> jobs = jobService.getAllJob();
    model.addObject("jobs", jobs);
    model.addObject("emps", emps);
    model.setViewName("views/employee/search");
    return model;
  }

  @RequestMapping("/updateEmp")
  public ModelAndView updateEmp(ModelAndView model, HttpServletRequest request) {
    String empno = request.getParameter("empno");
    String jobno = request.getParameter("job");
    String ename = request.getParameter("ename");
    String sex = request.getParameter("sex");
    Integer age = Integer.parseInt(request.getParameter("age"));
    String pwd = request.getParameter("pwd");
    Float sal = Float.parseFloat(request.getParameter("sal"));
    String tel = request.getParameter("tel");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String isvip = request.getParameter("isvip");

    String date = request.getParameter("hiredate");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date hiredate = null;
    try {
      hiredate = sdf.parse(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    ;


    int isadmin;
    if (isvip.equals("是")) {
      isadmin = 1;
    } else {
      isadmin = 0;
    }


    empService.updateEmp(jobno, ename, sex, age, pwd, sal, hiredate, tel, email, address, isadmin, empno);

    List<Employee> emps = empService.getAllEmp();
    List<Job> jobs = jobService.getAllJob();
    model.addObject("jobs", jobs);
    model.addObject("emps", emps);
    model.setViewName("views/employee/search");
    return model;
  }

  @RequestMapping("/checkEmp")
  @ResponseBody
  public Boolean checkEmp(@RequestParam("empno") String empno) {
    Boolean result = false;
    List<Employee> emps = empService.getAllEmp();
    for (Employee emp : emps) {
      if (emp.getEmpno().equals(empno)) {
        return result = true;
      }
    }
    return result;
  }


}


