package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class MainFormcontroller {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public AnchorPane mainFormPane;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        mainFormPane.getChildren().clear();
        mainFormPane.getChildren().add(load);
    }
}
