package com.empapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empapp.dto.EmployeeDto;
import com.empapp.entity.Employee;
import com.empapp.service.EmailService;
import com.empapp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private EmailService emailService;

	
	// http://localhost:9080/viewAddEmployee
	@RequestMapping("/viewAddEmployee") // @webservlet
	public String viewAddEmployeePage() {
		return "add_employee"; // request despatcher

	}


	@RequestMapping("/addAddEmployee")
	public String addEmployee(EmployeeDto empDto, Model map) {
		Employee emp = new Employee();
		emp.setName(empDto.getName());
		emp.setEmail(empDto.getEmail());
		emp.setMobile(empDto.getMobile());
		employeeservice.addEmployee(emp);
		emailService.sendEmail(empDto.getEmail(), "Welcome", " Test Message");
		map.addAttribute("msg", "record is saved");
		return "add_employee";
	}

	@RequestMapping("/listEmployee")
	public String getAllEmployees(ModelMap model) {
		List<Employee> employees = employeeservice.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list_employee";

	}

	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id, Model model) {

		employeeservice.deleteEmployee(id);
		List<Employee> employees = employeeservice.getAllEmployees();

		model.addAttribute("employees", employees);
		return "list_employee";

	}

	@RequestMapping("/update")
	public String getEmployeeById(@RequestParam long id, Model model) {

		Optional<Employee> emp = employeeservice.getAllEmployeeById(id);
		Employee employee = emp.get();
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@RequestMapping("/updateEmployee")
	public String updateEmployee(EmployeeDto empDto, ModelMap map) {
		Employee emp = new Employee();
		emp.setId(empDto.getId());

		emp.setName(empDto.getName());
		emp.setEmail(empDto.getEmail());
		emp.setMobile(empDto.getMobile());
		employeeservice.updateEmployee(emp);
		List<Employee> employees = employeeservice.getAllEmployees();

		map.addAttribute("employees", employees);
		return "list_employee";
	}
}
