/**
 * 
 */
package controller;

import java.awt.Menu;
import java.awt.MenuItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * @author yotti
 *
 */
public class MyController implements Initializable {
	@FXML
	public ComboBox<String> myCombobox;
	@FXML
	public ComboBox<String> name;
	@FXML
	public ComboBox<String> ET;
	@FXML
	public ListView<String> LET;

	// public Menu menur;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setUpAccommodation();
		setMane();
		setEquipmentType();
		setLET();

	}

	private void setUpAccommodation() {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("RV", "Tent", "Cabin/Lodging", "UT");
		myCombobox.setItems(items);
		myCombobox.getSelectionModel().select(0);
	}

	public void setMane() {

		ResultSet rset1;
		String sql1 = "";

		try {

			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt1 = conn.createStatement();

			sql1 = "SELECT name FROM kopf";

			rset1 = stmt1.executeQuery(sql1);
			while (rset1.next()) {

				// System.out.println("Komm" + rset1.getString(1));
				// data.setkommisionnr(rset1.getString(1));

				// System.out.println("hhh" + data.getkommisionnr());

				ObservableList<String> items = FXCollections.observableArrayList();
				String name1 = rset1.getString("name");
				// System.out.println(name1);

				items.addAll(name1);

				name.getItems().addAll(items);

				name.getSelectionModel().select(0);

			}
			stmt1.close();
			rset1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setEquipmentType() {

		ResultSet rset1;
		String sql1 = "";

		try {

			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt1 = conn.createStatement();

			sql1 = "SELECT name FROM Equipment_Type";

			rset1 = stmt1.executeQuery(sql1);
			while (rset1.next()) {

				// System.out.println("Komm" + rset1.getString(1));
				// data.setkommisionnr(rset1.getString(1));

				// System.out.println("hhh" + data.getkommisionnr());

				ObservableList<String> items = FXCollections.observableArrayList();
				String name1 = rset1.getString("name");
				// System.out.println(name1);

				items.addAll(name1);

				ET.getItems().addAll(items);

				ET.getSelectionModel().select(0);

			}
			stmt1.close();
			rset1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLET() {

		ResultSet rset1;
		String sql1 = "";

		try {

			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt1 = conn.createStatement();

			sql1 = "SELECT name FROM Required_Service";

			rset1 = stmt1.executeQuery(sql1);
			while (rset1.next()) {

				// System.out.println("Komm" + rset1.getString(1));
				// data.setkommisionnr(rset1.getString(1));

				// System.out.println("hhh" + data.getkommisionnr());

				ObservableList<String> items = FXCollections.observableArrayList();
				String name1 = rset1.getString("name");
				// System.out.println(name1);

				items.addAll(name1);

				LET.getItems().addAll(items);

				LET.getSelectionModel().select(0);

			}
			stmt1.close();
			rset1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
