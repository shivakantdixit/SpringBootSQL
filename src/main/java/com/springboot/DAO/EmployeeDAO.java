package com.springboot.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.repositary.Employeerepositary;



@Service
public class EmployeeDAO {
	
	@Autowired
	Employeerepositary empRepo;
	
	/* Add Employee */
	public Employee save(Employee emp)
	{
		return empRepo.save(emp);
	}
	
	
	/*Get All Employee */
	
	public List<Employee> findAll()
	{
		return empRepo.findAll();
	}
	
	public Optional<Employee> findById(Long empId)
	{
		Optional<Employee> emp = empRepo.findById(empId);
		return emp;
	}

}
