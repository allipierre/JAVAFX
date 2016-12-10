/**
 * 
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * @author yotti
 *
 */
public class MyController implements Initializable {
	@FXML
	public ComboBox<String> myCombobox;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setData() {

		myCombobox.getItems().clear();

		myCombobox.getItems().addAll("RV", "Tent", "Cabing");

	}

}
