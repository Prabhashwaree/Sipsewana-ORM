package bo.custom.impl;

import bo.custom.Student_RegistrationBO;
import dao.DAOFactory;
import dao.custom.impl.Student_RegistrationDAOImpl;
import dto.Student_RegistrationDTO;
import entity.Student;
import entity.Student_Registration;
import entity.TrainingProgram;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.tm.Student_RegistrationTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student_RegistrationBOImpl implements Student_RegistrationBO {

    Student_RegistrationDAOImpl student_registrationDAOImpl= (Student_RegistrationDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT_REGISTRATION);

    @Override
    public boolean addRegister(Student_RegistrationDTO r) throws Exception, ClassNotFoundException {
        return student_registrationDAOImpl.add(new Student_Registration(r.getRegisterId(),r.getRegisterDate(),new TrainingProgram(r.getProgramIdRegister()),new Student(r.getStudentIdRegister()),r.getPayment()));
    }

    @Override
    public boolean updateRegister(Student_RegistrationDTO s) throws Exception, ClassNotFoundException {
        return student_registrationDAOImpl.update(new Student_Registration(s.getRegisterId(),s.getRegisterDate(),new TrainingProgram(s.getProgramIdRegister()),new Student(s.getStudentIdRegister()),s.getPayment()));
    }

    @Override
    public boolean deleteRegister(String id) throws Exception, ClassNotFoundException {
        return student_registrationDAOImpl.delete(id);
    }

    @Override
    public boolean ifRegisterExit(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<Student_RegistrationTm> getAll() throws Exception, ClassNotFoundException {
        ArrayList<Student_Registration> studentRegidterList = student_registrationDAOImpl.getAll();
        ObservableList<Student_RegistrationTm> observableList= FXCollections.observableArrayList();
        studentRegidterList.forEach(e->observableList.addAll(new Student_RegistrationTm(e.getRegistrationId(),e.getDate(),e.getTrainingProgram().getProgramId(),e.getStudent().getId(),e.getPayment())));
        return observableList;

    }

    @Override
    public String genarateId() throws Exception, ClassNotFoundException {
        return student_registrationDAOImpl.genareateId();
    }

    @Override
    public Student_Registration searchRegister(String id) throws SQLException, ClassNotFoundException {
       return student_registrationDAOImpl.search(id);
    }
}
