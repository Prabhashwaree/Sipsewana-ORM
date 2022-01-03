package dao.custom.impl;

import dao.custom.QueryDAO;
import dto.customDTO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<customDTO> getAllDetailsList(String id) throws SQLException, ClassNotFoundException {
        ArrayList<customDTO> customDTO = new ArrayList();
        Session session = FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select  s.name ,p.programId, p.program, p.duration   from TrainingProgram p inner join  Student_Registration r on p.programId = r.trainingProgram LEFT JOIN Student s on r.student = s.id  where r.student = :studentId");
        query.setParameter("studentId",session.load(Student.class,id));
        List<Object[]> list = query.list();
        transaction.commit();
        session.close();

        for(Object[] objects: list){
            customDTO.add(new customDTO((String) objects[0],(String) objects[1],(String) objects[2],(String) objects[3]));
        }
        return customDTO;
    }
}
