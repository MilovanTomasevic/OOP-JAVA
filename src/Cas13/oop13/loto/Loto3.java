package loto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX aplikacija: Loto 6 od 49
 * 
 * Verzija 3: 
 * drugacija organizacija koda za obradu dogadjaja 
 * 'Klik na srecno dugme'.
 */
public class Loto3 extends Application {
	
	public static final int BR_BROJEVA = 6;
	public static final int MAX_BROJ = 49;
	private static final Random izbor = new Random();
	
	private List<Integer> slobodni = new ArrayList<>(MAX_BROJ);
	private boolean zuta = true;
	private Button[] brojevi = new Button[BR_BROJEVA];
	
	public static void main(String[] args) {
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) {
		VBox main = new VBox(20);
		main.setStyle("-fx-background-color: lavender");
		
		napraviGUI(main);
		
		Scene scene = new Scene(main, 500, 400);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Loto"); 
		primaryStage.sizeToScene(); 
		primaryStage.show();
	}
	
	private void napraviGUI(VBox main) {
		
		for(int i = 1; i <= MAX_BROJ; i++)
			slobodni.add(i);

		VBox vbBrojevi = new VBox(10);
		vbBrojevi.setPadding(new Insets(10)); 
		
		Label lbl = new Label("Srecni brojevi:");
		lbl.setTextFill(Color.BLUE);
		vbBrojevi.getChildren().add(lbl);
		
		HBox hbBrojevi = new HBox(20);
		hbBrojevi.setPadding(new Insets(20));
		hbBrojevi.setStyle("-fx-border-color: blue");
		hbBrojevi.setAlignment(Pos.CENTER);
				
		for(int i = 0; i < brojevi.length; i++){
			brojevi[i] = new Button(slobodni.remove(izbor.nextInt(slobodni.size())) + "");
			brojevi[i].setPrefWidth(70);
			brojevi[i].setPrefHeight(30); 
			brojevi[i].setStyle("-fx-background-color: yellow");
			brojevi[i].setCursor(Cursor.HAND); 
			
			// vrednost brojaca i ce biti potrebna u telu metoda handle() koji je 
			// metod ugnjezdene anonimne klase;
			// kako se radi o lokalnoj promenljivoj metoda spoljasnje klase, nece 
			// biti moguc pristup ukoliko promenljiva nije final;
			// zato se uvodi final promenljiva koja ima vrednost brojaca i
			final int I = i;
			brojevi[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					int stari = Integer.parseInt(brojevi[I].getText().trim());
					brojevi[I].setText(slobodni.remove(izbor.nextInt(slobodni.size()))+"");
					slobodni.add(stari);
				}
			});
						
			hbBrojevi.getChildren().add(brojevi[i]);
		}
		
		vbBrojevi.getChildren().add(hbBrojevi);
				
		Button menjaBojuBtn = new Button("Menja boju");
		menjaBojuBtn.setPrefSize(100, 30);
		menjaBojuBtn.setStyle("-fx-background-color: SkyBlue");
		
		Button noviBrojeviBtn = new Button("Novi brojevi");
		noviBrojeviBtn.setPrefSize(100, 30);
		noviBrojeviBtn.setStyle("-fx-background-color: violet");
		
		/* dodavanje obrade dogadjaja */
		obradiMenjaBoju(menjaBojuBtn, brojevi);
		obradiNoviBrojevi(noviBrojeviBtn, brojevi);
		
		HBox hbKontrole = new HBox(20);
		hbKontrole.setAlignment(Pos.CENTER);
		hbKontrole.getChildren().addAll(menjaBojuBtn, noviBrojeviBtn);
		
		main.getChildren().addAll(vbBrojevi, hbKontrole);
	}
	
	private void obradiMenjaBoju(Button menjaBojuBtn, Button[] brojevi) {
		menjaBojuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for(int i=0; i<brojevi.length; i++)
					brojevi[i].setStyle(zuta ? "-fx-background-color: lightgreen" 
											 : "-fx-background-color: yellow");
				zuta = !zuta;
			}
		});
	}
	
	private void obradiNoviBrojevi(Button noviBrojeviBtn, Button[] brojevi) {
		noviBrojeviBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(int i = 0; i < brojevi.length; i++){
					int stari = Integer.parseInt(brojevi[i].getText().trim());
					brojevi[i].setText(slobodni.remove(izbor.nextInt(slobodni.size()))+"");
					slobodni.add(stari);
				}
			}
		});
	}
}
