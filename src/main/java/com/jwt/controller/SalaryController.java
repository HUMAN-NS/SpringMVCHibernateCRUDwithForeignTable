package com.jwt.controller;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Employee;
import com.jwt.model.Salary;
import com.jwt.service.SalaryService;
import com.jwt.service.EmployeeService;

@Controller
public class SalaryController {
 
    private static final Logger logger = Logger
            .getLogger(SalaryController.class);
 
    public SalaryController() {
        System.out.println("SalaryController()");
    }
 
    @Autowired
    private SalaryService salaryService;
    
   @Autowired
   private EmployeeService employeeService;
 
    @RequestMapping(value = "/Salary")
    public ModelAndView listSalary(ModelAndView model) throws IOException {
        List<Salary> listSalary = salaryService.getAllSalary();
        model.addObject("listSalary", listSalary);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newSalary", method = RequestMethod.GET)
    public ModelAndView newContact(HttpServletRequest request) {
    	int employeeId = Integer.parseInt(request.getParameter("id"));
    	Employee employee = employeeService.getEmployee(employeeId);
    	Salary salary = new Salary();
        salary.setEmployee(employee);
    	ModelAndView model = new ModelAndView("SalaryForm");
    	model.addObject("salary", salary);
     	model.setViewName("SalaryForm");
        return model;
    }
 
    @RequestMapping(value = "/saveSalary", method = RequestMethod.POST)
    public ModelAndView saveSalary(@ModelAttribute Salary salary) {
    	if (salary.getId() == 0) {
    	Employee employee = employeeService.getEmployee(salary.getEmployee().getId());
     	salary.setEmployee(employee);
        salaryService.addSalary(salary);
        } else {
        	salaryService.updateSalary(salary);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteSalary", method = RequestMethod.GET)
    public ModelAndView deleteSalary(HttpServletRequest request) {
        int salaryId = Integer.parseInt(request.getParameter("id"));
        System.out.println("salaaryid"+salaryId);
        salaryService.deleteSalary(salaryId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editSalary", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("empid"));
        int salaryId = Integer.parseInt(request.getParameter("id"));
        Salary salary = salaryService.getSalary(salaryId);
        Employee employee = employeeService.getEmployee(employeeId);
        salary.setEmployee(employee);
        ModelAndView model = new ModelAndView("SalaryForm");
        model.addObject("salary", salary);
        return model;
    }
 
    @RequestMapping(value = "/listSalary")
    public ModelAndView listEmployee(ModelAndView model, HttpServletRequest request) throws IOException {
    	int employeeId = Integer.parseInt(request.getParameter("id"));
        List<Employee> listEmployee = employeeService.getAllEmployees();
        List<Salary> listSalary = salaryService.getAllSalary(employeeId);
        Employee employee = employeeService.getEmployee(employeeId);
        model.addObject("listSalary", listSalary);
        model.addObject("listEmployee", listEmployee);
        model.addObject("employee", employee);
        model.setViewName("home");
        return model;
    }

	public static Logger getLogger() {
		return logger;
	}
}