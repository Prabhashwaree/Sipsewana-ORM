package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.ObservableList;
import view.tm.StudentTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    boolean addStudent(StudentDTO studentDTO)throws Exception, ClassNotFoundException;

    boolean updateStudent(StudentDTO studentDTO)throws Exception, ClassNotFoundException;

    boolean deleteStudent(String id)throws  Exception, ClassNotFoundException;

    Student searchStudent(String id)throws SQLException, ClassNotFoundException;

    ObservableList<StudentTm> getAll()throws Exception, ClassNotFoundException;

}

