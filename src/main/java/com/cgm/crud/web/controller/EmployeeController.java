package com.cgm.crud.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.Validator;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.bl.service.EmployeeServices;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.web.form.CreateEmpForm;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices service;
	
//	@Autowired
//	@Qualifier("employeeValidator")
//	private Validator validator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	@RequestMapping(value = { "/insertEmployee" }, method = RequestMethod.POST)
	public String insertEmployee(@Valid @ModelAttribute("employee") CreateEmpForm emp, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		else {
			service.addEmp(emp);
			return "redirect:/addEmployee";
		}
		
	}
	
//	@RequestMapping(value= {"/insertEmployee"}, method=RequestMethod.POST)
//	public String insertEmployee(@ModelAttribute("insertEmployee") @Validated CreateEmpForm employee,
//			BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "register";
//		}
//		service.addEmp(employee);
//		return "redirect:/addEmployee";
//	}
	
	// lode employee data
    @GetMapping("employeeReport")
    public ModelAndView lodeEmployee() {
        ModelAndView report = new ModelAndView("employeeReport");
        List<EmployeeDto> emp = service.getAllEmp();
        report.addObject("employee", emp);
        report.addObject("title", "Employee Report");

        return report;
    }
    
 // lode edit form
    @GetMapping("/editEmployee/{id}")
    public String lodeEditForm(@PathVariable(value = "id") int id, Model m) {
        Employee emp = service.getById(id);

        System.out.println(emp);
        m.addAttribute("employee", emp);
        m.addAttribute("title", "Edit Employee");

        return "editEmployee";
    }
    
    @PostMapping("/editEmployee/updateEmployee")
    public String updateEmp(@ModelAttribute("updateEmployee") Employee emp) {
        service.updateEmp(emp);

        return "redirect:/employeeReport";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);

        return "redirect:/employeeReport";
    }
}
