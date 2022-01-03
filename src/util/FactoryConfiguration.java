package util;

import entity.Student;
import entity.Student_Registration;
import entity.TrainingProgram;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryConfiguration {
    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata metadata=new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(TrainingProgram.class)
                .addAnnotatedClass(Student_Registration.class)

                .getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
