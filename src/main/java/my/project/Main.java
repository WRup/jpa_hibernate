package my.project;

import my.project.domain.Address;
import my.project.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addEmployees();

        Query query = entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), e.salary * 0.20 from Employee e");
        Iterator<?> iterator = query.getResultList().iterator();
        while(iterator.hasNext()){
            Object[] item = (Object[]) iterator.next();
            String name = (String) item[0];
            Double tax = (Double) item[1];
            System.out.println(name + " has to pay " + tax);
        }

//        TypedQuery<Employee> query = entityManager.createQuery("select pracownik from Employee pracownik where pracownik.salary > 3000 order by pracownik.salary", Employee.class);
//        List<Employee> employeeList = query.getResultList();
//        for ( Employee employee : employeeList){
//            System.out.println(employee);
//        }
        //System.out.println(employee);

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addEmployees(){
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
        addEmployee("Angeilika", "Bednarska" , 1000);
    }

    private static void addEmployee(String name, String surname, double salary){
        Employee employee = new Employee();
        employee.setFirstName(name);
        employee.setLastName(surname);
        employee.setSalary(salary);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }
}
