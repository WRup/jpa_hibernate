package my.project;

import my.project.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        Employee employee1 = new Employee();
        employee1.setFirstName("Jan");
        employee1.setLastName("Nowak");
        employee1.setSalary(3333.3);

        Employee employee2 = new Employee();
        employee2.setFirstName("Robert");
        employee2.setLastName("Bednarek");
        employee2.setSalary(4444.4);

        Employee employee3 = new Employee();
        employee3.setFirstName("Damian");
        employee3.setLastName("Stach");
        employee3.setSalary(5555.4);

        entityManager.getTransaction().begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addEmployees() {
        addEmployee("Karol", "     Mateusiak     ", 2633);
        addEmployee("Marika", "Bednarek", 2345);
        addEmployee("Jan", "Mateusiak", 7346);
        addEmployee("Daria", "Kowalska", 2352);
        addEmployee("Monika", "Ucińska", 4264);
        addEmployee("Ernest", "Pająk", 2634);
        addEmployee("Kamil", "Stępień", 2345);
        addEmployee("Przemek", "Maciejewski", 5344);
        addEmployee("Robert", "Woźniak", 3324);
        addEmployee("Agnieeszka", "Nowak", 2000);
        addEmployee("Angeilika", "Bednarska", 1000);
    }

    private static void addEmployee(String name, String surname, double salary) {
        Employee employee = new Employee();
        employee.setFirstName(name);
        employee.setLastName(surname);
        employee.setSalary(salary);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }
}
