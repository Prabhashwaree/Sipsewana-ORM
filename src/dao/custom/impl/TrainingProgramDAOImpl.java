package dao.custom.impl;

import dao.custom.TrainingProgramDAO;
import entity.TrainingProgram;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;


public class TrainingProgramDAOImpl implements TrainingProgramDAO {

    @Override
    public boolean add(TrainingProgram trainingProgram) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory = FactoryConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(trainingProgram);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String s) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        TrainingProgram trainingProgram = session.load(TrainingProgram.class,s);
        session.delete(trainingProgram);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(TrainingProgram trainingProgram) throws Exception, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(trainingProgram);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public TrainingProgram search(String s) throws SQLException, ClassNotFoundException {
        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        TrainingProgram trainingProgram=session.get(TrainingProgram.class,s);
        transaction.commit();
        session.close();
        return trainingProgram;
    }

    @Override
    public ArrayList<TrainingProgram> getAll() throws Exception, ClassNotFoundException {
        ArrayList<TrainingProgram> programArrayList ;
        Session session = FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM TrainingProgram");
        programArrayList = (ArrayList<TrainingProgram>) query.list();
        transaction.commit();
        session.close();
        return programArrayList;
    }

}