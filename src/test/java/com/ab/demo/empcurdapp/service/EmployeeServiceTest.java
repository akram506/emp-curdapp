package com.ab.demo.empcurdapp.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ab.demo.empcurdapp.model.Employee;
import com.ab.demo.empcurdapp.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmployeeServiceTest {

	@TestConfiguration
	static class UserServiceTestContextConfiguration {
		@Bean
		public EmployeeService userService() {
			return new EmployeeService();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() {

		Employee employee = createDummyEmployee();
		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));

		Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
	}

	private Employee createDummyEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("test");
		emp.setDept("Test");
		emp.setSal(123.45);
		emp.setEmail("test@example.com");
		return emp;
	}

	@Test
	public void saveEmpTest() {

		Employee emp = createDummyEmployee();
		emp = employeeService.saveEmployee(emp);
		assertTrue(emp != null);
	}

	@Test
	public void updateEmpTest() {

		Employee emp = createDummyEmployee();
		emp.setSal(321.54);
		emp = employeeService.updateEmployee(emp);
		assertTrue(emp != null);
	}

	@Test
	public void findEmpTest() {

		Employee emp = createDummyEmployee();
		Employee empFound = employeeService.findById(emp.getId());
		assertTrue(empFound.equals(emp));
	}
	
	@Test
	public void findAllEmpTest() {
		assertTrue(!employeeService.findAll().isEmpty());
	}

}
