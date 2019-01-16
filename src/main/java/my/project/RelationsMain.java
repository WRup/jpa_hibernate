package my.project;

import my.project.domain.basic.Employee;
import my.project.domain.basic.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RelationsMain {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Project project1 = new Project();
        Project project2 = new Project();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        project1.setName("Projekt 1");
        project2.setName("Projekt 2");

        employee1.setFirstName("Jan");
        employee1.setLastName("Nowak");
        employee1.setSalary(1234.4);

        employee2.setFirstName("Maria");
        employee2.setLastName("Nowak");
        employee2.setSalary(955.25);

        List<Employee> employees = new ArrayList<Employee>();
        List<Project> projects = new ArrayList<Project>();

        employees.add(employee1);
        employees.add(employee2);
        projects.add(project1);
        projects.add(project2);

        project1.setEmployees(employees);
        project2.setEmployees(employees);

        entityManager.getTransaction().begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(project1);
        entityManager.persist(project2);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
