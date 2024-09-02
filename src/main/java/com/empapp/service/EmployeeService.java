package com.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empapp.entity.Employee;
import com.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository;

	public void addEmployee(Employee emp) {
		employeerepository.save(emp);

	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeerepository.findAll();
		return employees;

	}

	public void deleteEmployee(long id) {
		employeerepository.deleteById(id);
	}

	public Optional<Employee> getAllEmployeeById(long id) {
		return employeerepository.findById(id);
	}

	public void updateEmployee(Employee emp) {
		employeerepository.save(emp);

	}

}
