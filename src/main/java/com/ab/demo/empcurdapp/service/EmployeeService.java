package com.ab.demo.empcurdapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.demo.empcurdapp.model.Employee;
import com.ab.demo.empcurdapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee findById(Integer id){
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.isPresent() ? emp.get() : null;
		
	}
	public List<Employee> findAll(){
		return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	public Employee saveEmployee(Employee employee){
		return employeeRepository.save(employee);
		
	}
	
	public Employee updateEmployee(Employee employee){
		return saveEmployee(employee);
	}
	
	public void deleteById(Integer id){
		employeeRepository.deleteById(id);
	}
}
