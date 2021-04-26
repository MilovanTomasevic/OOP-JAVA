package zdravo_main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ZdravoMain2 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Zdravo");
		
		/* LAYOUT:
		 * Layout pane za scenu odredjuje poziciju i velicinu svih cvorova na njoj 
		 * i njime se zadaje izgled grafickog korisnickog interfejsa.
		 * Kako se menja velicina prozora, layout pane automatski odgovara 
		 * i menja velicinu cvorova koje sadrzi u skladu sa njihovim osobinama. 
		 * HBox - cvorovi deca se rasporedjuju u jedan red. 
		 * Velicina cvorova dece se povecava do njihove zeljene sirine, 
		 * ali postoji mogucnost da se zada da se pojedini cvorovi deca 
		 * povecavaju do njihove maksimalne zadate sirine.
		 * VBox - slican HBox-u, jedino sto se cvorovi deca rasporedjuju u jednu kolonu. 
		 * Padding property upravlja rastojanjem izmedju cvorova. 
		 * Margine takodje mogu da se podese da bi se odredila velicina praznog prostora 
		 * oko pojedinih cvorova.
		 * FlowPane - dodaju se komponente u sukcesivnim redovima – kad je red
		 * popunjen, počinje se sa novim. Najcesce se koristi za uredjivanje
		 * dugmadi. Velicina cvorova dece ne moze da se menja.
		 */
		HBox root = new HBox(10);
		
		// Insets - Skup rastojanja od 4 strane pravougaone povrsine.
		// Parametri: top - right - bottom - left
		root.setPadding(new Insets(80, 0, 0, 20));
				
		Label label = new Label("Dugme: ");
		Button dugme = new Button();
		dugme.setText("Zdravo");
		// setLayoutX() i setLayoutY() sada nemaju efekta
		//label.setLayoutX(100);
		//label.setLayoutY(50);
		//dugme.setLayoutX(100);
		//dugme.setLayoutY(80);
		
		root.getChildren().addAll(label, dugme);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
