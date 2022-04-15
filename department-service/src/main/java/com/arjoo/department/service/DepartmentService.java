package com.arjoo.department.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arjoo.department.entity.Department;
import com.arjoo.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);


	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department getDepartment(Long id) {
		log.info("Inside getDepartment of DepartmentService");
		Department department = new Department();
		department.setDepartmentId(1l);
		department.setDepartmentName("IT");
		department.setDepartmentAddress("Bangalore");
		department.setDepartmentCode("100");
		return department;
	}
}
