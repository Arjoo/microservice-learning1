package com.arjoo.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjoo.department.entity.Department;
import com.arjoo.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id) {
		log.info("Inside getDepartment of DepartmentController");
		return departmentService.getDepartment(id);
	}
}
