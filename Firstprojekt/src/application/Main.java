package application;

import controller.ScreensController;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Group;

import javafx.scene.Scene;

public class Main extends Application {
	private static Stage mainStage;
	public static String screen1ID = "Menu";
	public static String screen1File = "/application/Menu.fxml";
	public static String screen2ID = "MyView";
	public static String screen2File = "/application/MyView.fxml";
	// public static String screen3ID = "MyView";
	// public static String screen3File = "MyView.fxml";

	@Override
	public void start(Stage primaryStage) {
		ScreensController mainContainer = new ScreensController();
		primaryStage.setResizable(false);

		mainContainer.loadScreen(Main.screen1ID, Main.screen1File);
		mainContainer.loadScreen(Main.screen2ID, Main.screen2File);
		// mainContainer.loadScreen(Main.screen3ID, Main.screen3File);

		mainContainer.setScreen(Main.screen1ID);

		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	// returns the main stage to be set as owner
	public static Stage getMainStage() {
		return mainStage;
	}
}
