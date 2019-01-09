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

        addEmployees();


        Query query = entityManager.createQuery("select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Pracownik e where e.firstName='Karol'");

//        Query query = entityManager.createQuery("select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e) from Pracownik e");
//
        Object [] result = (Object[]) query.getSingleResult();
        System.out.println("Pierwsze litery imienia: " + result[0]);
        System.out.println("Naziwsko: |" + result[1] + "|");
        System.out.println("Imie malymi literami: " + result[2]);
        System.out.println("Imie wielkimi literami: " + result[3]);
        System.out.println("Dlugosc imienia: " + result[4]);


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
