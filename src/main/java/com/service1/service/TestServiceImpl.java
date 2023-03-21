/**
 * 
 */
package com.service1.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service1.doa.EmployeeRepository;
import com.service1.domain.Employee;

/**
 * @author mahak
 *
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Value("${greeting:Welcome in Microservices}")
	private String greeting;

	@Override
	public String greeting() {
		return this.greeting;
	}
	@Override
	public Employee getEmployeeDetails(int id) throws Exception {
		Optional<Employee> emps= employeeRepository.findById(id);
		if(emps.isPresent()) {
			//Object msg = restTemplate.getForEntity("http://localhost:9090/api/address/B405", Object.class).getBody();
			//System.out.println("msg>>:"+msg.toString());
			return emps.get();
		}
		else {
			throw new Exception("Data not found");
		}
		
	}
	@Override
	public Employee addEmployee(Employee emp) throws Exception {
		this.employeeRepository.save( emp);
		return this.getEmployeeDetails(emp.getEmpId());
	}
	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}
	@Override
	public Employee deleteEmployeeById(int id) {
		Employee emp =null;
		try {
			emp = this.getEmployeeDetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.employeeRepository.deleteById(id);
		return emp;
		
	}


}
