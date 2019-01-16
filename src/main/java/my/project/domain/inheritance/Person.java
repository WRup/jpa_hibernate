package my.project.domain.inheritance;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Person {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
}
