package yamb;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Ispitni zadatak iz juna 2009.
 * 
 * @author Marija
 *
 */

public class Yamb extends Application {

	@Override
	public void start(Stage primaryStage) {

		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("YambForm.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("YAMB");
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			// metod koji se izvrsava nakon sto se klikne na x u gornjem desnom uglu prozora
			@Override
			public void handle(WindowEvent event) {

				System.out.println("Vidimo se na ispitu");
			}
		});
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
