package my.project.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="Pracownicy")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "imie", nullable = false, length = 10)
    private String firstName;
    @Column(name = "naziwsko", columnDefinition = "VARCHAR(10) NOT NULL")
    private String lastName;
    @Column(name = "pensja")
    private double salary;
    @Column(precision = 10, scale = 2)
    private BigDecimal salary2;
}
