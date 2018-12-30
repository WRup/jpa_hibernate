package my.project.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String locality;
    private String zipCode;
    private String street;
    private int streetNumber;
}
