/**
 * 
 */
package com.service1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service1.domain.Employee;
import com.service1.service.TestService;

/**
 * @author mahak
 *
 */
@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	private TestService testService;
	@GetMapping("/greeting")
	public String greeting() {
		return testService.greeting();
	}
	
	@GetMapping("/employee")
	public Employee getEmployee(@RequestParam("id") int id) throws Exception {
		System.out.println("HI");
		return testService.getEmployeeDetails(id);
	}
	@GetMapping("/employee/{id}")
	public Employee getEmployeeByPath(@PathVariable int id) throws Exception {
		
		return testService.getEmployeeDetails(id);
	}
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) throws Exception  {
		System.out.println("Hello");
		return testService.addEmployee(emp);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()  {
		return testService.getAllEmployees();
	}
	@DeleteMapping("/employee")
	public Employee deleteEmployee(@RequestParam("id") int id)  {
		return testService.deleteEmployeeById(id);
	}

}
