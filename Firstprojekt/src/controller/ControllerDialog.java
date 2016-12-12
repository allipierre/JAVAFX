/**
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Modell.ModellHome;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author yotti
 *
 */
public class ControllerDialog {
	@FXML
	private TextField IDT;

	public ControllerDialog start() {
		try {
			// ModellHome m = new ModellHome();
			// setId(m.getIdm()) ;
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Dialog.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(Main.getMainStage());
			primaryStage.setTitle("My Dialog");
			primaryStage.setResizable(false);
			primaryStage.show();

			return loader.getController();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setId(String id) {
		IDT.setText(String.valueOf(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see application.ControlledScreen#setScreenParent(controller.
	 * ControllerRegistration)
	 */

	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
