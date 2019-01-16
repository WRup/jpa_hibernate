package my.project.domain.basic;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

@Data
@Entity
public class DateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date date;
    private Time time;
    private Timestamp timestamp;

    @Temporal(TemporalType.DATE)
    private java.util.Date utilDate;
    @Temporal(TemporalType.TIME)
    private java.util.Date utilTime;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date utilTimestamp;

    @Temporal(TemporalType.DATE)
    private Calendar calendar;
}
