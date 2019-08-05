package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
}
