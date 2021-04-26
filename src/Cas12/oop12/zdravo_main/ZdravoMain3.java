package zdravo_main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ZdravoMain3 extends Application {
	 
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Zdravo");

		VBox root = new VBox(30);
		Label label = new Label("Dugme: ");
		Button dugme = new Button("Zdravo");

		root.setPadding(new Insets(20, 40, 0, 20));
		root.getChildren().addAll(label, dugme);

		Scene scene = new Scene(root, 400, 250);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
