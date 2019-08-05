package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.Department;
import org.springframework.data.repository.CrudRepository;


public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
