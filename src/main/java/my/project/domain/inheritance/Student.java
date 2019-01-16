package my.project.domain.inheritance;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("Studencik")
public class Student extends Person{

    private double averageGrade;
}
