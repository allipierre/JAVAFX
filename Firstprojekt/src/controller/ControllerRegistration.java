/**
 * 
 */
package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Modell.ModellDialog;
import Modell.ModellHome;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author yotti
 *
 */
public class ControllerRegistration {

	@FXML
	private Menu menuRegister;
	@FXML
	private TableColumn IDTA;

	@FXML
	private TableColumn IDTA1;

	@FXML
	private TableColumn IDTA2;

	@FXML
	private TableColumn IDTA3;
	@FXML
	private TableColumn IDTA4;
	@FXML
	private TableColumn IDTA5;
	@FXML
	private TableView<Record> tableView;

	@FXML
	private MenuBar IDM;

	@FXML
	private void initialize() {
		Label lblRegister = new Label("Registration");
		lblRegister.setOnMouseClicked((e) -> performRegistration());
		menuRegister.setGraphic(lblRegister);
		menuRegister.setText("");
		setTable();

	}

	@FXML
	private void performRegistration() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/MyView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException s) {

			s.printStackTrace();
		}
	}

	public void setTable() {
		ResultSet rset1;
		String sql1 = "";

		try {

			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.25:1521:demo12", "atlantic",
					"Abc#123");
			Statement stmt1 = conn.createStatement();

			sql1 = "SELECT * FROM emp";
			ObservableList<Record> items = FXCollections.observableArrayList();
			rset1 = stmt1.executeQuery(sql1);
			while (rset1.next()) {

				// String name1 = rset1.getString("ename");
				// ObservableList<Record> dataList =
				// FXCollections.observableArrayList(new Record("January"),
				// new Record("February"), new Record("March"), new
				// Record("April"), new Record("May"),
				// new Record("June"), new Record("July"), new Record("August"),
				// new Record("September"),
				// new Record("October"), new Record("November"), new
				// Record("December"));

				IDTA.setCellValueFactory(new PropertyValueFactory<Record, String>("Accomodation"));
				IDTA2.setCellValueFactory(new PropertyValueFactory<Record, String>("Name"));
				IDTA1.setCellValueFactory(new PropertyValueFactory<Record, String>("Guests"));
				IDTA3.setCellValueFactory(new PropertyValueFactory<Record, String>("Contact"));
				IDTA4.setCellValueFactory(new PropertyValueFactory<Record, String>("Equipment"));
				IDTA5.setCellValueFactory(new PropertyValueFactory<Record, String>("DUMMY"));

				Callback<TableColumn<Record, String>, TableCell<Record, String>> cellFactory = new Callback<TableColumn<Record, String>, TableCell<Record, String>>() {
					@Override
					public TableCell call(final TableColumn<Record, String> param) {
						final TableCell<Record, String> cell = new TableCell<Record, String>() {

							final Button btn = new Button("Just Do It");

							@Override
							public void updateItem(String item, boolean empty) {
								super.updateItem(item, empty);
								btn.setPrefWidth(175);
								btn.setPrefHeight(55);
								btn.setId("IDB");
								if (empty) {
									setGraphic(null);
									setText(null);
								} else {
									btn.setOnAction((ActionEvent event) -> {
										
										Record person = getTableView().getItems().get(getIndex());
										ModellHome m = new ModellHome();
										// ModellDialog d=new
										// ModellDialog(person.getName());
										m.setIdm(person.getName());
										System.out.println("hallo" + m.getIdm());
										System.out.println(m.getIdm());
										ControllerDialog c = new ControllerDialog();
										// c.setIDT();
										System.out.println(person.getName() + "   " + person.getName());
										c.performDialog();

										// Alert alert = new
										// Alert(AlertType.INFORMATION);
										// alert.setTitle("Information Dialog");
										// alert.setHeaderText(null);
										// alert.setContentText("I have a great
										// message for you!");
										//
										// alert.showAndWait();
									});
									setGraphic(btn);
									setText(null);
								}
							}
						};
						return cell;
					}
				};

				IDTA5.setCellFactory(cellFactory);

				// tableView.setItems(dataList);
				// tableView.getColumns().addAll(IDTA);

				Record cm = new Record();
				cm.Accomodation.set(rset1.getString("ename"));
				cm.Name.set(rset1.getString("EMPNO"));
				cm.Guests.set(rset1.getString("JOB"));
				cm.Guests.set(rset1.getString("JOB"));
				cm.Contact.set(rset1.getString("MGR"));
				cm.Equipment.set(rset1.getString("HIREDATE"));
				items.add(cm);
			}
			tableView.setItems(items);

		} catch (Exception e) {
			JDialog.setDefaultLookAndFeelDecorated(true);
			int response = JOptionPane.showConfirmDialog(null, "Sie müssen eine Wahl treffen!", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}

	}

	public class Record {
		private SimpleStringProperty Accomodation = new SimpleStringProperty();
		private SimpleStringProperty Name = new SimpleStringProperty();
		private SimpleStringProperty Guests = new SimpleStringProperty();
		private SimpleStringProperty Contact = new SimpleStringProperty();
		private SimpleStringProperty Equipment = new SimpleStringProperty();

		public String getAccomodation() {
			return Accomodation.get();
		}

		public String getName() {
			return Name.get();
		}

		public String getGuests() {
			return Guests.get();
		}

		public String getContact() {
			return Contact.get();
		}

		public String getEquipment() {
			return Equipment.get();
		}

	}
}
