package my.project.domain.basic;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Data
@Entity
public class Employee {

    @Id
    @TableGenerator(name = "mojGenerator",
        table = "tabela_z_identyfikatorami",
            pkColumnName = "nazwa_sekwencji",
            valueColumnName = "wartosc_identyfikatora",
            pkColumnValue = "id_pracownika",
            initialValue = 10,
            allocationSize = 15
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "mojGenerator")
    private long id;
    private String firstName;
    private String lastName;
    private double salary;


}
