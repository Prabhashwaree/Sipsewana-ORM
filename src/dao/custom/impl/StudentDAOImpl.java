package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean ifStudentExit(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean add(Student student) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory= FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student student = session.load(Student.class,s);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Student student) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student student=session.get(Student.class,s);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public ArrayList<Student> getAll() throws Exception, ClassNotFoundException {
        ArrayList<Student> studentArrayList;
        Session session=FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("FROM Student");
        studentArrayList=(ArrayList<Student>) query.list();
        transaction.commit();
        session.close();
        return studentArrayList;
    }
}
