package com.springboot.repositary;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Employee;

public interface Employeerepositary extends JpaRepository<Employee, Long> {

}
