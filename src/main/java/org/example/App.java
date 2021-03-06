package org.example;

import org.example.entity.Detail;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        /*List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Fedor", "Mulashkin", "IT", 80000));
        employees.add(new Employee("Andrey", "Elin", "School", 15000));
        employees.add(new Employee("Irina", "Vasilieva", "Mass Spectroscopy", 100500));
        employees.add(new Employee("Konstantin", "Anisovich", "Organic Chemistry", 500100));
        employees.add(new Employee("Tatiana", "Mulashkina", "Physical Chemistry", 150000));*/
        try (Session session = factory.openSession()) {

            session.beginTransaction();
            Employee employee = new Employee("Fedor", "Mulashkin", "IT", 80000);
            Detail detail = new Detail("Moscow", "88005553535", "fedor@mulashkin.ru");
            employee.setEmpDetail(detail);
            session.saveOrUpdate(employee);
            //session.delete(employee);
            session.getTransaction().commit();
        }
    }
}
