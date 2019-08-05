package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.SchoolClass;
import org.springframework.data.repository.CrudRepository;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {
}
