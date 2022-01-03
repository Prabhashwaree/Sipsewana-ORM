package controller;

import bo.BOFactory;
import bo.custom.impl.Student_RegistrationBOImpl;
import dto.Student_RegistrationDTO;
import dto.TrainingProgramDTO;
import entity.Student;
import entity.Student_Registration;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class DeleteRegistercontroller {
    public TextField txtPayment;
    public TextField txtStudentId;
    public TextField txtProgramId;
    public TextField txtDate;
    public TextField txtId;
    public AnchorPane deletePane;

    Student_RegistrationBOImpl student_registrationBOImpl = (Student_RegistrationBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOType.STUDENT_REGISTRATION);

    public void registerBtnDeleteOnAction(ActionEvent actionEvent) {
        try {
            if(student_registrationBOImpl.deleteRegister(txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Delete it?").showAndWait();
                /*clear();*/
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();

        }
    }

    public void registerIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String studentRegisterId=txtId.getText();
        Student_Registration student_registration=student_registrationBOImpl.searchRegister(studentRegisterId);
        if(student_registration==null){
            new Alert(Alert.AlertType.WARNING, "Empty set Data..?").show();
        }else {
            setStudentRegisterData(student_registration);
        }
    }

    public void setStudentRegisterData(Student_Registration registration){
        txtId.setText(registration.getRegistrationId());
        txtDate.setText(registration.getDate());
        txtProgramId.setText(registration.getTrainingProgram().getProgramId());
        txtStudentId.setText(registration.getStudent().getId());
        txtPayment.setText(String.valueOf(registration.getPayment()));
    }

    public void registerBtnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        if(student_registrationBOImpl.updateRegister(new Student_RegistrationDTO(txtId.getText(),txtDate.getText(),txtProgramId.getText()
                ,txtStudentId.getText(),Double.parseDouble(txtPayment.getText())))){
            new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Update it?").showAndWait();

        }else{
            /*new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();*/
        }
    }
}
