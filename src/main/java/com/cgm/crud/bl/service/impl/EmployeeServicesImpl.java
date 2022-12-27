package com.cgm.crud.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.bl.service.EmployeeServices;
import com.cgm.crud.persistence.dao.EmployeeDao;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.web.form.CreateEmpForm;

@Transactional
@Service
public class EmployeeServicesImpl implements EmployeeServices {
	@Autowired
	EmployeeDao dao;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	//add employee
	@Override
	public void addEmp(CreateEmpForm empform) {
		Employee emp=new Employee();
		emp.setName(empform.getName());
		emp.setDepartment(empform.getDepartment());
		emp.setEmail(empform.getEmail());
		emp.setSalary(empform.getSalary());
		emp.setPassword(passwordEncoder.encode(empform.getPassword()));
        emp.setType(empform.getType());
		dao.addEmployee(emp);
	}
	
	//get all employee
	@Override
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
			empDto.setPassword(emp.getPassword());
			empDto.setType(emp.getType());
			employee.add(empDto);
		}
		return employee;
	}
	
	//get employeee by id
	@Override
	public Employee getById(int id) {
		return dao.getEmpById(id);
	}
	
	// update employee
	@Override
    public void updateEmp(Employee emp) {
        dao.updateEmp(emp);
    }

    // delete employee
	@Override
    public void deleteEmployee(int id) {
        dao.deleteEmp(id);
    }
	
	public EmployeeDto findByEmail(String email) {
		Employee emp=dao.findByEmail(email);
		if(emp==null) {
			return null;
		}
		EmployeeDto empDto=new EmployeeDto(emp);
		return empDto;
	}
}
