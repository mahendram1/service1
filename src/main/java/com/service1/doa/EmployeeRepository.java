/**
 * 
 */
package com.service1.doa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service1.domain.Employee;

/**
 * @author mahak
 *
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
