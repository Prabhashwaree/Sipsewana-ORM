package bo.custom.impl;

import bo.BOFactory;
import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.tm.StudentTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAOImpl= (StudentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean addStudent(StudentDTO s) throws Exception, ClassNotFoundException {
        return studentDAOImpl.add(new Student(s.getId(),s.getName(),s.getAge(),s.getGender(),s.getAddress()));
    }

    @Override
    public boolean updateStudent(StudentDTO s) throws Exception, ClassNotFoundException {
        return studentDAOImpl.update(new Student(s.getId(),s.getName(),s.getAge(),s.getGender(),s.getAddress()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception, ClassNotFoundException {
        return studentDAOImpl.delete(id);
    }

    @Override
    public Student searchStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAOImpl.search(id);
    }

    @Override
    public ObservableList<StudentTm> getAll() throws Exception {
        ArrayList<Student> studentList = studentDAOImpl.getAll();
        ObservableList<StudentTm> observableList= FXCollections.observableArrayList();
        studentList.forEach(e->observableList.addAll(new StudentTm(e.getId(),e.getName(),e.getAge(),e.getGender(),e.getAddress())));
        return observableList;
    }
}
