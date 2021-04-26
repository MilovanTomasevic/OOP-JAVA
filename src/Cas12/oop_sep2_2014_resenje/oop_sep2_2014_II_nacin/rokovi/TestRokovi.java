package rokovi2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestRokovi extends Application {

	@Override
	public void start(Stage primaryStage) {

		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("RokoviForm.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Scene scene = new Scene(root); // kreiranje scene sa zadatim korenim cvorom
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ispitni rokovi");
		primaryStage.sizeToScene();
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
