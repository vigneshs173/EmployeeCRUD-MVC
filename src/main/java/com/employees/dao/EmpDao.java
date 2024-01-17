package com.employees.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.employees.model.Employee;

import java.util.List;

@Repository
public class EmpDao {

    private final SessionFactory sessionFactory;

    public EmpDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        }
    }

    public Employee isExistRecord(Integer empid) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, empid);
        }
    }

    public List<Employee> getAllRecords() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Employee where active = 1";
            return session.createQuery(hql, Employee.class).getResultList();
        }
    }

    public Employee getEmployeeById(Integer empid) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, empid);
        }
    }

    public void updateEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        }
    }





}
