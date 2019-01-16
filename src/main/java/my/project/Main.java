package my.project;

import my.project.domain.basic.Employee;
import my.project.domain.inheritance.Professor;
import my.project.domain.inheritance.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        Professor professor = new Professor();
        professor.setFirstName("Jan");
        professor.setLastName("Nowak");
        professor.setSalary(7563.0);

        Student student = new Student();
        student.setFirstName("Marek");
        student.setLastName("Kowalski");
        student.setAverageGrade(4.75);

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.persist(professor);
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
