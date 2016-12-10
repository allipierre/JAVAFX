/**
 * 
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		setUpAccommodation();
	}

	public void setData() {

		myCombobox.getItems().clear();

		myCombobox.getItems().addAll("RV", "Tent", "Cabing");

	}

    private void setUpAccommodation() {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("RV", "ST", "UT");
        myCombobox.setItems(items);
        myCombobox.getSelectionModel().select(0);
    }

}
