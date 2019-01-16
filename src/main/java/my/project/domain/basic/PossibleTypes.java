package my.project.domain.basic;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
public class PossibleTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int someInt;
    private short someShort;
    private float someFloat;
    private double someDouble;
    private boolean someBoolean;

    private Integer someInteger;
    private BigDecimal someBigDecimal;
    private BigInteger someBigInteger;

    /*private int[] intArray;
    private double[] doubleArray;*/

    private MyEnum myEnum;

    @Transient
    private int ignoredField;

}
