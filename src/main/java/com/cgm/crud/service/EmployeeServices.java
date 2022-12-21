package com.cgm.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cgm.crud.dao.EmployeeDao;
import com.cgm.crud.dto.EmployeeDto;
import com.cgm.crud.entity.Employee;
import com.cgm.crud.form.CreateEmpForm;

@Component
@Service
public class EmployeeServices {

	@Autowired
	EmployeeDao dao;
	
	//add employee
	public void addEmp(CreateEmpForm empform) {
		Employee emp=new Employee();
		emp.setName(empform.getName());
		emp.setDepartment(empform.getDepartment());
		emp.setEmail(empform.getEmail());
		emp.setSalary(empform.getSalary());
		dao.addEmployee(emp);
	}
	
	//get all employee
	public List<EmployeeDto> getAllEmp(){
		List<Employee> allEmp=dao.getAllEmployee();
		List<EmployeeDto> employee=new ArrayList<EmployeeDto>();
		for(Employee emp:allEmp) {
			EmployeeDto empDto=new EmployeeDto(emp);
			empDto.setId(emp.getId());
			empDto.setName(emp.getName());
			empDto.setDepartment(emp.getDepartment());
			empDto.setEmail(emp.getEmail());
			empDto.setSalary(emp.getSalary());
			employee.add(empDto);
		}
		return employee;
	}
	
	//get employeee by id
	public Employee getById(int id) {
		return dao.getEmpById(id);
	}
	
	// update employee
    public void updateEmp(Employee emp) {
        dao.updateEmp(emp);
    }

    // delete employee
    public void deleteEmployee(int id) {
        dao.deleteEmp(id);
    }
}
