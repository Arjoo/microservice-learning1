package com.arjoo.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjoo.employee.entity.Employee;
import com.arjoo.employee.entity.ResponseWrapper;
import com.arjoo.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/")
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.info("Inside saveEmployee of EmployeeController");
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public ResponseWrapper findEmployee(@PathVariable("id") Long id) {
		logger.info("Inside findEmployee of EmployeeService");
		return employeeService.findEmployee(id);
	}
}
