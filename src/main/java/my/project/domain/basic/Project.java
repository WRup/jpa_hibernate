package my.project.domain.basic;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "pracownicy_w_projektach",
            joinColumns = {@JoinColumn(name = "id_projektu")},
            inverseJoinColumns = {@JoinColumn(name = "id_pracownika")}
    )
    List<Employee> employees;

}
