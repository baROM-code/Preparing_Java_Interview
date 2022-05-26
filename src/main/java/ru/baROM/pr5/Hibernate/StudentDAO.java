package ru.baROM.pr5.Hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    /*
    public Student findById(int id) {
        return (Student) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery("SELECT s FROM student s WHERE s.id = id").list();
    }

     */

    public void save(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(student);
        tx.commit();
        session.close();
    }

    public Student findById(int id) {
        Student student = (Student) HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
        return student;
    }

    public List<Student> findAll() {
        List<Student> students = HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Student").list();
        return students;
    }

}
