package controller;

import bo.BOFactory;
import bo.custom.JoinQueryBO;
import bo.custom.impl.JoinQueryBOImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class JoinProgramInformationcontroller {
    public AnchorPane topUpWindowPane;
    public TableView tblTopUp;
    public TableColumn colStudentIdTopup;
    public TableColumn colStudentNameTopup;
    public TableColumn colProgramNameTopup;
    public TableColumn colDurationTopup;
    public TableColumn colProgramIdTopup;
    public TextField txtSearchTopup;

    JoinQueryBOImpl joinQueryBO = (JoinQueryBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BOType.PROGRAM_INFORMATION);

    public void initialize(){
        colStudentNameTopup.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStudentNameTopup.setStyle("-fx-alignment:center");
        colProgramIdTopup.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramIdTopup.setStyle("-fx-alignment:center");
        colProgramNameTopup.setCellValueFactory(new PropertyValueFactory<>("program"));
        colProgramNameTopup.setStyle("-fx-alignment:center");
        colDurationTopup.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colDurationTopup.setStyle("-fx-alignment:center");

    }
    public void loadJoinQueryDetails(String id) throws SQLException, ClassNotFoundException {
        tblTopUp.setItems(joinQueryBO.observebleCustomList(id));
    }

    public void searchIdToUpOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

    }

    public void btnSearchOnActionToUp(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       /* joinQueryBO.observebleCustomList(txtSearchTopup.getText());*/
        loadJoinQueryDetails(txtSearchTopup.getText());

    }


}
