package jcaga.spring.data.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class SchoolClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Teacher.class)
    private Set<Teacher> teachers;

    public SchoolClass(Long id, String name, Set teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }
}
