package jcaga.spring.data.example.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String surname;

    @OneToOne
    private AddressDetail addressDetail;
}
