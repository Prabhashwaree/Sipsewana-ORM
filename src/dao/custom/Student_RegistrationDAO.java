package dao.custom;

import dao.CrudDAO;
import entity.Student_Registration;

import java.sql.SQLException;

public interface Student_RegistrationDAO extends CrudDAO<Student_Registration,String> {
    String genareateId()throws SQLException, ClassNotFoundException;

}
