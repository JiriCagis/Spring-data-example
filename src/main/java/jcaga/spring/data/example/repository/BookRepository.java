package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
