package my.project;

import my.project.domain.Address;
import my.project.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        Address address = new Address();
        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(3333.3);
        address.setLocality("Krakow");
        address.setZipCode("31-243");
        address.setStreet("Powstancow Wlkp.");
        address.setStreetNumber(111);
        employee.setAddress(address);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
