package com.arjoo.employee.service;

import com.arjoo.employee.entity.Department;
import com.arjoo.employee.entity.Employee;
import com.arjoo.employee.entity.ResponseWrapper;
import com.arjoo.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RestTemplate template;

	public Employee saveEmployee(Employee employee) {
		logger.info("Inside saveEmployee of EmployeeService");
		return employeeRepository.save(employee);
	}

	public ResponseWrapper findEmployee(Long id) {
		logger.info("Inside findEmployee of EmployeeService");
		Department department = template.getForObject("http://DEPARTMENT-SERVICE/departments/" + id, Department.class);
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		emp.setEmployeeEmail("200@gmail.com");
		emp.setEmployeeFirstName("Arjoo");
		emp.setEmployeeLastName("Kumar");
		emp.setDepartmentId(1l);

		ResponseWrapper wrapper = new ResponseWrapper();
		wrapper.setDepartment(department);
		wrapper.setEmployee(emp);
		
		return wrapper;
	}
}
