package controller;

import bo.BOFactory;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.Student_RegistrationBOImpl;
import bo.custom.impl.TrainingProgramBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import dto.Student_RegistrationDTO;
import dto.TrainingProgramDTO;
import entity.Student;
import entity.TrainingProgram;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.StudentTm;
import view.tm.TrainingProgramTm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;


public class DashBoardcontroller {
    public AnchorPane dashBoardPane;
    public JFXTextField txtStudentName;
    public JFXTextField txtAge;
    public ComboBox cmbGender;
    public JFXTextField txtAddress;
    public Label lblRegisterId;
    public JFXTextField txtStudentId;
    public JFXTextField txtDate;
    public JFXTextField txtProgramingId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAge;
    public TableColumn colStudentGender;
    public TableColumn colStudentAddress;
    public TableColumn colProgramDate;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colProgramFee;
    public TableColumn colProgramDuration;
    public TableView tblStudent;
    public TableView tblProgram;
    public Label lblDate;
    public Label lblDates;
    public ComboBox cmbProgramIdRegistration;
    public ComboBox cmbStudentIdRegistration;
    public JFXTextField txtPayment;
    public TableColumn colRegisterId;
    public TableColumn colRegisterDate;
    public TableColumn colProgramIdRegister;
    public TableColumn colStudentIdRegister;
    public TableColumn colPaymentRegister;
    public TableView tblRegister;

    StudentBOImpl studentBOImpl= (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOType.STUDENT);
    TrainingProgramBOImpl trainingProgramBOImpl = (TrainingProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOType.TRAININGPROGRAM);
    Student_RegistrationBOImpl student_registrationBOImpl = (Student_RegistrationBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOType.STUDENT_REGISTRATION);

    public void clear() {
        txtStudentId.clear();
        txtStudentName.clear();
        txtAge.clear();
        txtAddress.clear();

        txtProgramingId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
        txtPayment.clear();

    }

    public void initialize() {
        genarateId();
        try {
            loadStudentId();
            loadProgramId();
            loadDateAndTime();
            setStudentToTable();
            loadAllStudent_registration();
            loadAllTrainingProgram();
            loadAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* -----------------------------------StudentDetail-----------------------------------*/

        cmbGender.getItems().addAll("Female", "Male");


        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentId.setStyle("-fx-alignment:center");
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStudentName.setStyle("-fx-alignment:center");
        colStudentAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colStudentAge.setStyle("-fx-alignment:center");
        colStudentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colStudentGender.setStyle("-fx-alignment:center");
        colStudentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStudentAddress.setStyle("-fx-alignment:center");

        /* -----------------------------------Training Program-----------------------------------*/

        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramId.setStyle("-fx-alignment:center");
        colProgram.setCellValueFactory(new PropertyValueFactory<>("program"));
        colProgram.setStyle("-fx-alignment:center");
        colProgramDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colProgramDuration.setStyle("-fx-alignment:center");
        colProgramFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colProgramFee.setStyle("-fx-alignment:center");

        /* -----------------------------------Student Register-----------------------------------*/

        colRegisterId.setCellValueFactory(new PropertyValueFactory<>("registerId"));
        colRegisterId.setStyle("-fx-alignment:center");
        colRegisterDate.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        colRegisterDate.setStyle("-fx-alignment:center");
        colProgramIdRegister.setCellValueFactory(new PropertyValueFactory<>("programIdRegister"));
        colProgramIdRegister.setStyle("-fx-alignment:center");
        colStudentIdRegister.setCellValueFactory(new PropertyValueFactory<>("studentIdRegister"));
        colStudentIdRegister.setStyle("-fx-alignment:center");
        colPaymentRegister.setCellValueFactory(new PropertyValueFactory<>("payment"));
        colPaymentRegister.setStyle("-fx-alignment:center");
    }


    /* -----------------------------------StudentDetail-----------------------------------*/

    private void loadStudentId() throws Exception {
        ObservableList<StudentTm> studentTm=studentBOImpl.getAll();
        for(StudentTm studentTm1:studentTm){
            cmbStudentIdRegistration.getItems().add(studentTm1.getId());
        }
    }


    private void setStudentToTable() throws Exception {
        tblStudent.setItems(studentBOImpl.getAll());
    }
    private void loadAllStudent() throws Exception {

            tblStudent.setItems(studentBOImpl.getAll());
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/EnterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) dashBoardPane.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btnSaveStudentOnAction(ActionEvent actionEvent) {
        try {
            if(studentBOImpl.addStudent(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtAge.getText()
            ,(String) cmbGender.getValue(),txtAddress.getText())));
            loadAllStudent();
            loadStudentId();

            new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Save it?").showAndWait();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
        clear();
    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) throws Exception {
        if(studentBOImpl.updateStudent(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtAge.getText()
                ,(String) cmbGender.getValue(),txtAddress.getText()))){

            new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Update it?").showAndWait();
            clear();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
        try {
            if(studentBOImpl.deleteStudent(txtStudentId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Delete it?").showAndWait();
                clear();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();

        }
    }

    public void studentIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String studentId=txtStudentId.getText();
        Student student=studentBOImpl.searchStudent(studentId);
        if(student==null){
            new Alert(Alert.AlertType.WARNING, "Empty set Data..?").show();
        }else {
            setStudentData(student);
        }
    }

    public void setStudentData(Student student){
        txtStudentId.setText(student.getId());
        txtStudentName.setText(student.getName());
        txtAge.setText(student.getAge());
        cmbGender.setValue(String.valueOf(student.getGender()));
        txtAddress.setText(student.getAddress());
    }


    /* -----------------------------------Training Program-----------------------------------*/

    private void loadProgramId() throws Exception {
        ObservableList<TrainingProgramTm> programTm=trainingProgramBOImpl.getAll();
        for (TrainingProgramTm trainingProgramTm:programTm){
            cmbProgramIdRegistration.getItems().add(trainingProgramTm.getProgramId());
        }
    }

    private void loadAllTrainingProgram() throws Exception {
        tblProgram.setItems(trainingProgramBOImpl.getAll());
    }

    public void btnSaveProgramOnAction(ActionEvent actionEvent) {
        try {
            if(trainingProgramBOImpl.addProgram(new TrainingProgramDTO(txtProgramingId.getText(),txtProgram.getText(),txtDuration.getText()
                    ,Double.parseDouble(txtFee.getText()))));
            loadAllTrainingProgram();
            loadProgramId();

            new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Save it?").showAndWait();
            clear();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnUpdateProgramOnAction(ActionEvent actionEvent) throws Exception {
        if(trainingProgramBOImpl.updateProgram(new TrainingProgramDTO(txtProgramingId.getText(),txtProgram.getText(),txtDuration.getText()
                ,Double.parseDouble(txtFee.getText())))){
            new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Update it?").showAndWait();
            clear();
        }else{
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnDeleteProgramOnAction(ActionEvent actionEvent) {
        try {
            if(trainingProgramBOImpl.deleteProgram(txtProgramingId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Delete it?").showAndWait();
                clear();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void programIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String programId=txtProgramingId.getText();
        TrainingProgram trainingProgram=trainingProgramBOImpl.searchProgram(programId);
        if(trainingProgram==null){
            new Alert(Alert.AlertType.WARNING, "Empty set Data..?").show();
        }else {
            setProgramData(trainingProgram);
        }
    }

    public void setProgramData(TrainingProgram trainingProgram){
        txtProgramingId.setText(trainingProgram.getProgramId());
        txtProgram.setText(trainingProgram.getProgram());
        txtDuration.setText(trainingProgram.getDuration());
        txtFee.setText(String.valueOf(trainingProgram.getFee()));
    }


    /* -----------------------------------Student Register-----------------------------------*/

    private void genarateId(){
        try {
           lblRegisterId.setText(student_registrationBOImpl.genarateId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAllStudent_registration() throws Exception {

        tblRegister.setItems(student_registrationBOImpl.getAll());
    }
    
    public void btnSaveRegistrationOnAction(ActionEvent actionEvent) {
        try {
            if(student_registrationBOImpl.addRegister(new Student_RegistrationDTO(lblRegisterId.getText(),lblDate.getText(),(String) cmbProgramIdRegistration.getValue()
                    ,(String) cmbStudentIdRegistration.getValue(),Double.parseDouble(txtPayment.getText()))));
            loadAllStudent_registration();

            new Alert(Alert.AlertType.CONFIRMATION, "Do you want a Save it?").showAndWait();
            genarateId();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnDeleteRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DeleteRegister.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

    }

    public void btnTopupMoveWindow(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/joinProgramInformation.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
