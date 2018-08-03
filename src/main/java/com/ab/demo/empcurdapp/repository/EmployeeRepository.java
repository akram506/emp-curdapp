package com.ab.demo.empcurdapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ab.demo.empcurdapp.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	

}
