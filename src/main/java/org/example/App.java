package org.example;

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
                .buildSessionFactory();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Fedor", "Mulashkin", "IT", 80000));
        employees.add(new Employee("Andrey", "Elin", "School", 15000));
        employees.add(new Employee("Irina", "Vasilieva", "Mass Spectroscopy", 100500));
        employees.add(new Employee("Konstantin", "Anisovich", "Organic Chemistry", 500100));
        employees.add(new Employee("Tatiana", "Mulashkina", "Physical Chemistry", 150000));
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            /*for (Employee emp: employees) {
                session.saveOrUpdate(emp);
            }*/
            /*session.createQuery("delete Employee where name = 'Irina' OR name = 'Konstantin'").executeUpdate();*/
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
