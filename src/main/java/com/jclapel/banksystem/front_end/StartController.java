package com.jclapel.banksystem.front_end;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController extends Listener {
    /*

	Start controller for controlling user interface, specifically for start UI.

	Main Contributor(s): Albin
	Contributor(s): Liam

	*/

    private Stage stage;
    private Scene scene;

    @FXML
    public Button closeButton;

    //all methods below are for switching scenes, or you could say interfaces

    @FXML//on interface button = main menu
    public void switchToLoginCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginCustomer.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML//on interface button = create account
    public void switchToRegisterCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registerCustomer.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToLoginEmployee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("employeeLogin.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML//on interface button = create account
    public void switchToRegisterEmployee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registerEmployee.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML//on interface button = exit
    public void handelCloseButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
