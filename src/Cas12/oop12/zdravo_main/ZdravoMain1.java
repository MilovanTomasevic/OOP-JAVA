package zdravo_main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ZdravoMain1 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Zdravo");

		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);

		Label label = new Label("Dugme: ");
		/* pozicioniranje labele */
		label.setLayoutX(100);
		label.setLayoutY(50);

		Button dugme = new Button("Zdravo");
		/* pozicioniranje dugmeta */
		dugme.setLayoutX(100);
		dugme.setLayoutY(80);

		// dodavanje cvorova dece metodom addAll()
		root.getChildren().addAll(label, dugme);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
