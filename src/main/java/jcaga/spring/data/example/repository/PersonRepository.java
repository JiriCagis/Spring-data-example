package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
