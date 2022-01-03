package bo.custom;

import bo.SuperBO;
import dto.Student_RegistrationDTO;
import entity.Student_Registration;
import javafx.collections.ObservableList;
import view.tm.Student_RegistrationTm;

import java.sql.SQLException;

public interface Student_RegistrationBO extends SuperBO {
    boolean addRegister(Student_RegistrationDTO student_registrationDTO)throws Exception, ClassNotFoundException;

    boolean updateRegister(Student_RegistrationDTO student_registrationDTO)throws Exception, ClassNotFoundException;

    boolean deleteRegister(String id)throws  Exception, ClassNotFoundException;

    boolean ifRegisterExit(String id)throws SQLException, ClassNotFoundException;

    ObservableList<Student_RegistrationTm> getAll()throws Exception, ClassNotFoundException;

    String genarateId()throws Exception, ClassNotFoundException;

    Student_Registration searchRegister(String id)throws SQLException, ClassNotFoundException;
}
