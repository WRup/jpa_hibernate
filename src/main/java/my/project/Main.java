package my.project;

import my.project.domain.basic.Employee;
import my.project.domain.inheritance.Professor;
import my.project.domain.inheritance.Student;

import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addEmployees();

        // select e from Emplyee e where e.salary > 3000 and e.salary < 5000

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> employeeCriteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = employeeCriteriaQuery.from(Employee.class);

        Path<Double> salary = employeeRoot.get("salary");

        employeeCriteriaQuery.select(employeeRoot).where(criteriaBuilder.and(criteriaBuilder.greaterThan(salary, 3000.0), criteriaBuilder.lessThan(salary, 5000.0)));

        TypedQuery<Employee> query = entityManager.createQuery(employeeCriteriaQuery);
        List<Employee> employeeList = query.getResultList();

        for(Employee emp : employeeList){
            System.out.println(emp);
        }

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
