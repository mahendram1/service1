/**
 * 
 */
package com.service1.service;

import java.util.List;

import com.service1.domain.Employee;

/**
 * @author mahak
 *
 */
public interface TestService {

	public String greeting();
	public Employee getEmployeeDetails(int id) throws Exception;
	public Employee addEmployee (Employee emp) throws Exception;
	public List<Employee> getAllEmployees();
	Employee deleteEmployeeById(int id);
}
