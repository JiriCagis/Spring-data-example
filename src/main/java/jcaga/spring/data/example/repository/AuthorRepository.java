package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
