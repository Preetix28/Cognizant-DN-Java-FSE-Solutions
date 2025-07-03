package com.cognizant.learn.manual;

import com.cognizant.learn.model.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeHibernateDAO {

    private static SessionFactory factory;

    public EmployeeHibernateDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeID;
    }
}
