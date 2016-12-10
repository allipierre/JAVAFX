/**
 * 
 */
package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

/**
 * @author yotti
 *
 */
public class ControllerRegistration {

	@FXML
	private Menu menuRegister;

	@FXML
	private void initialize() {
		Label lblRegister = new Label("Registration");
		lblRegister.setOnMouseClicked((e)->performRegistration());
		menuRegister.setGraphic(lblRegister);
        menuRegister.setText("");
	}

	@FXML
	private void performRegistration() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/MyView.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			// MyController p = new MyController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
