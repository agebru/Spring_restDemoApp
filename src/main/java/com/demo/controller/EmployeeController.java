package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.EmployeeRepository;
import com.demo.dto.EmployeeDTO;
import com.demo.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	@PostMapping("/create")
	public ResponseEntity<List<Employee>> createEmployee( @RequestBody Employee employee) {

		if (employee != null) {
			employeeRepo.save(employee);
		}
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(), HttpStatus.CREATED);
		// return ResponseEntity.ok(employeeRepo.findAll());

	}

	@GetMapping("/all")
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();

	}
	
	@GetMapping("/findAll2")
	public List<Employee> findAllJoinFetch() {
		return employeeRepo.findAllJoinFetch();

	}
	
	@GetMapping("/emp-project")
	public List<EmployeeDTO> getEmployeesProjection() {
		return employeeRepo.findBy();

	}

}
