package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
