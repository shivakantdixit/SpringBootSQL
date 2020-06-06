package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.DAO.EmployeeDAO;
import com.springboot.model.Employee;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired
	EmployeeDAO empDAO;
	
	@PostMapping("/create")
	public Employee create(@Valid @RequestBody Employee emp)
	{
		return empDAO.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return empDAO.findAll();
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value="id") Long empId)
	{
		Optional<Employee> emp = empDAO.findById(empId);
		if(emp.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp.get());
	}
	
	

}
