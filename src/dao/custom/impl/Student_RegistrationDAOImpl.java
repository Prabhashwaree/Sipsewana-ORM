package dao.custom.impl;

import dao.custom.Student_RegistrationDAO;
import entity.Student;
import entity.Student_Registration;
import entity.TrainingProgram;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student_RegistrationDAOImpl implements Student_RegistrationDAO {

    @Override
    public boolean add(Student_Registration student_registration) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory= FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student_registration);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student_Registration student_registration = session.load(Student_Registration.class,s);
        session.delete(student_registration);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student_Registration student_registration) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(student_registration);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student_Registration search(String s) throws SQLException, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student_Registration student_registration=session.get(Student_Registration.class,s);
        transaction.commit();
        session.close();
        return student_registration;
    }

    @Override
    public ArrayList<Student_Registration> getAll() throws Exception, ClassNotFoundException {
        ArrayList<Student_Registration> studentRegisterArrayList;
        Session session=FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("FROM Student_Registration");
        studentRegisterArrayList=(ArrayList<Student_Registration>) query.list();
        transaction.commit();
        session.close();
        return studentRegisterArrayList;
    }

    @Override
    public String genareateId() throws SQLException, ClassNotFoundException {
        Session session=FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("SELECT  registrationId FROM Student_Registration ORDER BY registrationId DESC");
        query.setMaxResults(1);
        String s= (String) query.uniqueResult();
        transaction.commit();
        session.close();

        if(s!=null){
            int registationId=Integer.parseInt(s.replace("R","")) +1;
            return String.format("R%03d",registationId);
        }
        return "R001";
    }
}
