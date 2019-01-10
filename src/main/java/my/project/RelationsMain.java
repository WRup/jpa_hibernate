package my.project;

import my.project.domain.Employee;
import my.project.domain.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RelationsMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(1234.4);
        phone1.setType("mobile");
        phone2.setType("home");
        phone1.setNumber("323123123");
        phone2.setNumber("73888499983");
        List<Phone> phones = new ArrayList<Phone>();
        phones.add(phone1);
        phones.add(phone2);
        employee.setPhones(phones);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
