package my.project;

import my.project.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addEmployees();

        TypedQuery<Employee> query = entityManager.createQuery("select e from Pracownik e where e.lastName in :names", Employee.class);

        List<String> names= new ArrayList<String>();
        names.add("Mateusiak");
        names.add("Bednarek");

        query.setParameter("names", names);

        for (Employee employee: query.getResultList()){
            System.out.println(employee);
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addEmployees() {
        addEmployee("Karol", "Mateusiak", 2633);
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
