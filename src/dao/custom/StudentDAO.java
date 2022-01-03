package dao.custom;

import dao.CrudDAO;
import entity.Student;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student,String> {
    boolean ifStudentExit(String id)throws SQLException, ClassNotFoundException;
}
