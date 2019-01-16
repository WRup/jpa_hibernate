package my.project.domain.inheritance;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Student extends Person {

    private double averageGrade;
}
