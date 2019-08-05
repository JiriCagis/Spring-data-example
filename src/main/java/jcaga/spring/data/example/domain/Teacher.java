package jcaga.spring.data.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String subject;

    @ManyToMany(targetEntity = SchoolClass.class)
    private Set<SchoolClass> schoolClasses;

    public Teacher(Long id, String name, String subject, Set schoolClasses) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.schoolClasses = schoolClasses;
    }
}
