package com.cgm.crud.bl.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.bl.service.EmployeeServices;
import com.cgm.crud.persistence.dao.EmployeeDao;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.web.form.CreateEmpForm;

/**
 * <h2>EmployeeServicesImpl Class</h2>
 * <p>
 * Process for Displaying EmployeeServicesImpl
 * </p>
 * 
 * @author User
 *
 */
@Transactional
@Service
public class EmployeeServicesImpl implements EmployeeServices {
	/**
	 * <h2>dao</h2>
	 * <p>
	 * dao
	 * </p>
	 */
	@Autowired
	private EmployeeDao dao;

	/**
	 * <h2>passwordEncoder</h2>
	 * <p>
	 * passwordEncoder
	 * </p>
	 */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private MessageSource messageSource;

	/**
	 * <h2>addEmp</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param empform
	 */
	@Override
	public void addEmp(CreateEmpForm empform) {
		Employee emp = new Employee();
		emp.setName(empform.getName());
		emp.setDepartment(empform.getDepartment());
		emp.setEmail(empform.getEmail());
		emp.setSalary(empform.getSalary());
		emp.setPassword(passwordEncoder.encode(empform.getPassword()));
		emp.setType(empform.getType());
		dao.addEmployee(emp);
	}

	/**
	 * <h2>getAllEmp</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<EmployeeDto> getAllEmp() {
		List<Employee> allEmp = dao.getAllEmployee();
		List<EmployeeDto> employee = new ArrayList<EmployeeDto>();
		for (Employee emp : allEmp) {
			EmployeeDto empDto = new EmployeeDto(emp);
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

	/**
	 * <h2>getById</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Employee getById(int id) {
		return dao.getEmpById(id);
	}

	/**
	 * <h2>updateEmp</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param emp
	 */
	@Override
	public void updateEmp(Employee emp) {
		dao.updateEmp(emp);
	}

	/**
	 * <h2>deleteEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 */
	@Override
	public void deleteEmployee(int id) {
		dao.deleteEmp(id);
	}

	/**
	 * <h2>findByEmail</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	public EmployeeDto findByEmail(String email) {
		Employee emp = dao.findByEmail(email);
		if (emp == null) {
			return null;
		}
		EmployeeDto empDto = new EmployeeDto(emp);
		return empDto;
	}

	@SuppressWarnings("resource")
	@Override
	@Transactional
	public String doImportEmp(MultipartFile file) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			Employee emp = new Employee();
			Row row = sheet.getRow(i);
			Cell cellId = row.getCell(0);
			emp.setId((int) cellId.getNumericCellValue());
			Cell cellName = row.getCell(1);
			emp.setName(cellName.getStringCellValue());
			Cell cellDepartment = row.getCell(2);
			emp.setDepartment(cellDepartment.getStringCellValue());
			Cell cellEmail = row.getCell(3);
			emp.setEmail(cellEmail.getStringCellValue());
			Cell cellSalary = row.getCell(4);
			emp.setSalary((int) cellSalary.getNumericCellValue());
			emp.setPassword(passwordEncoder.encode("password"));
			emp.setType("0");
			dao.addEmployee(emp);
		}
		return messageSource.getMessage("M_SC_USR_0008", null, null);
	}
}
