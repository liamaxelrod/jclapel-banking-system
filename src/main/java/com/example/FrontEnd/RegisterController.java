package com.example.FrontEnd;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class RegisterController {//Albin worked on this, Liam partly worked on this


    private Stage stage;
    private Scene scene;

    @FXML//on interface text field = First and last name
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;

    @FXML//on interface password field = confirm password
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML//On the interface = pops up if you put in the wrong thing
    private Label warningText;


    @FXML
    void onActionCreateAccount(ActionEvent event) throws IOException {
        int theID;
        if (    StartApplication.facade.validatePassword(setPasswordField.getText()) &&
                StartApplication.facade.validatePassword(confirmPasswordField.getText()) &&
                StartApplication.facade.validateName(firstnameTextField.getText()) &&
                StartApplication.facade.validateName(lastnameTextField.getText())) {

            theID = StartApplication.facade.createCustomer(firstnameTextField.getText(), setPasswordField.getText());

            UserMenuController.activeID = theID;//resets the user

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("userMenu.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            //This is for testing will be deleted later
        } else if (!StartApplication.facade.validatePassword(setPasswordField.getText())) {
            theID = StartApplication.facade.createCustomer("liam", "!Q1qaaaaa");
            UserMenuController.activeID = theID;//resets the user
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("userMenu.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            //It will be deleted down to hear
        } else {
            warningText.setText("The password must have: \n - At least 8 characters \n - Must consist of 'a-z, A-Z, 0 -9' \n - Special character ex. '!' '&' '?' ");
        }

    }

    @FXML
    void switchToLoginCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginCustomer.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToStart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("start.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Methods to make buttons glow
    @FXML
    private Button loginButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private void confirmHoverInMainMenu() {
        mainMenuButton.setStyle("-fx-background-color: #52779C;");
    }

    @FXML
    private void confirmHoverOutMainMenu() {
        mainMenuButton.setStyle("-fx-background-color: #414D59;");
    }

    @FXML
    private void confirmHoverInLogin() {
        loginButton.setStyle("-fx-background-color: #52779C;");
    }

    @FXML
    private void confirmHoverOutLogin() {
        loginButton.setStyle("-fx-background-color: #414D59;");
    }

    @FXML
    private void confirmHoverInCancel() {
        cancelButton.setStyle("-fx-background-color: #676D5E;");
    }

    @FXML
    private void confirmHoverOutCancel() {
        cancelButton.setStyle("-fx-background-color: #474B40;");
    }

    @FXML
    private void confirmHoverInCreAcc() {
        createAccountButton.setStyle("-fx-background-color: #676D5E;");
    }

    @FXML
    private void confirmHoverOutCreAcc() {
        createAccountButton.setStyle("-fx-background-color: #474B40;");
    }

}
