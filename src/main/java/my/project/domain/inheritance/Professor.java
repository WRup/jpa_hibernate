package my.project.domain.inheritance;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Profesorek")
public class Professor extends Person {

    private double salary;



}
