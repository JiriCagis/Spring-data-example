package jcaga.spring.data.example.repository;

import jcaga.spring.data.example.domain.AddressDetail;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressDetail,Long> {
}
