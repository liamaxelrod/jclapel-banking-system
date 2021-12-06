package com.jclapel.banksystem.front_end;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jclapel.banksystem.back_end.TestProfile;

public class UserMenuController extends Listener implements Initializable {
	private Stage stage;
	private Scene scene;

	@FXML//on interface button = exit
	private Button closeButton;

	@FXML//on interface image view = upper far right position
	private ImageView imageProfile;

	@FXML//on interface label = username
	private Label userName;

	@FXML//on interface label = next to name:
	private Label fullRealName;

	@FXML//on interface label = bottom left corner
	private Label CheckingTotal;
	@FXML
	private Label OtherTotal;
	@FXML
	private Label SavingTotal;

	//The set-up Methods
	public TestProfile userProfile;

	public void setUserProfile(TestProfile newTestProfile){
		userProfile = newTestProfile;
	}
	public void setUpProfile(){
		fullRealName.setText(" " + RegisterController.firstName + " " + RegisterController.secondName);
		userName.setText(RegisterController.userName);
		SavingTotal.setText(String.valueOf(RegisterController.money));
//        imageProfile.setImage(userProfile.getTheImageView().getImage());
//       still not loading image
	}
	public TestProfile getUserProfile() {
		return userProfile;
	}
	//End of set-up Methods


	@Override//this method takes effect when the scene is loaded
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}

	////all methods below are for switching scenes, or you could say interfaces

	@FXML//on interface button = transfer
	void switchToTransfer(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("transferCustomer.fxml"));
		Parent root = loader.load();
		scene = new Scene(root);

		TransferController thisController = loader.getController();
		thisController.setUserProfile(talkToGoBetween.createTestProfile());
//      thisController.setUpProfile();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	@FXML//on interface button = profile
	void switchToProfile(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("profile.fxml"));
		Parent root = loader.load();
		scene = new Scene(root);

		ProfileController thisController = loader.getController();
		thisController.setUserProfile(getUserProfile());
		thisController.setUpProfile();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	@FXML//on interface button = financial projects loan, portfolio, etc.
	void switchToFinanceProject(ActionEvent event) {

	}
	@FXML//on interface button = logout
	void switchToStart(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("start.fxml"));
		Parent root = loader.load();
		scene = new Scene(root);

//        userMenuController thisController = loader.getController();
//        thisController.setUserProfile(talkToGoBetween.createTestProfile());
//        thisController.setUpProfile();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	@FXML//on interface button = exit
	void handelCloseButtonAction(ActionEvent event) throws IOException {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();

	}
	@FXML//on interface button = transfer history
	void switchToBankStatement(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("bankStatment.fxml"));
		Parent root = loader.load();
		scene = new Scene(root);

//        userMenuController thisController = loader.getController();
//        thisController.setUserProfile(talkToGoBetween.createTestProfile());
//        thisController.setUpProfile();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	void switchToManual(ActionEvent event) throws IOException {

	}


}