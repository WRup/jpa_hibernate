package my.project.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Pracownicy")
@SecondaryTable(name = "Adresy", pkJoinColumns = @PrimaryKeyJoinColumn(name = "employeeId"))
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

    @Column(table = "Adresy", name = "miejscowosc")
    private String locality;
    @Column(table = "Adresy", name = "kodPocztowy")
    private String zipCode;
    @Column(table = "Adresy", name = "ulica")
    private String street;
    @Column(table = "Adresy", name = "numerDomu")
    private int streetNumber;
}
