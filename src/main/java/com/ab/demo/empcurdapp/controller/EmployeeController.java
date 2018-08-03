package com.ab.demo.empcurdapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ab.demo.empcurdapp.model.Employee;
import com.ab.demo.empcurdapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee emp){
		return employeeService.saveEmployee(emp);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee emp){
		return employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("/employee")
	public void deleteeEmployee(@RequestParam(value="id") Integer id){
		employeeService.deleteById(id);
	}
	
	@GetMapping("/employee")
	public Employee findEmployee(@RequestParam(value="id") Integer id){
		return employeeService.findById(id);
	}
	@GetMapping("/employee/all")
	public List<Employee> findAllEmployees(){
		return employeeService.findAll();
	}
	
}
