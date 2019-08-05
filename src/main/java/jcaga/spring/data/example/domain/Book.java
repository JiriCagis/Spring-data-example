package jcaga.spring.data.example.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
