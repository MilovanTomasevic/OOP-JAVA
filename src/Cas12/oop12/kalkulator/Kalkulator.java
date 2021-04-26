package kalkulator;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Kalkulator extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		ArrayList<Button> dugmad = new ArrayList<>();
		
		stage.setTitle("Kalkulator");	
		
		Label prviOperandLbl = new Label("Prvi operand:");
		TextField prviOperandTF = new TextField();
		Label drugiOperandLbl = new Label("Drugi operand:");
		TextField drugiOperandTF = new TextField();		
		VBox topLeft = new VBox(10);
		topLeft.getChildren().addAll(prviOperandLbl, prviOperandTF, drugiOperandLbl, drugiOperandTF);
		
		Button saberiBtn = new Button("+");
		Button oduzmiBtn = new Button("-");
		Button pomnoziBtn = new Button("*");
		HBox topRightTop = new HBox(10);
		topRightTop.getChildren().addAll(saberiBtn, oduzmiBtn, pomnoziBtn);
		
		Button podeliBtn = new Button("/");
		Button korenBtn = new Button("\u221A");
		Button ocistiBtn = new Button("C");
		HBox topRightBotom = new HBox(10);
		topRightBotom.getChildren().addAll(podeliBtn, korenBtn, ocistiBtn);
		
		dugmad.addAll(Arrays.asList(saberiBtn, oduzmiBtn, pomnoziBtn, podeliBtn, korenBtn, ocistiBtn));
		for(Button dugme : dugmad) {
			dugme.setPrefHeight(50);
			dugme.setPrefWidth(50);
		}
		
		VBox topRight = new VBox(10);
		topRight.getChildren().addAll(topRightTop, topRightBotom);
		
		HBox top = new HBox(25);
		top.getChildren().addAll(topLeft, topRight);
		
		Label ispisLbl = new Label("Rezultat:");
		TextField ispisTF = new TextField();
		ispisTF.setEditable(false);
		ispisTF.setAlignment(Pos.CENTER);
		ispisTF.setMaxWidth(300);
		Label porukaLbl = new Label("");
		porukaLbl.setTextFill(Color.RED);
		VBox bottom = new VBox(5);
		bottom.setPadding(new Insets(20, 0, 0, 0));
		bottom.getChildren().addAll(ispisLbl, ispisTF, porukaLbl);
		
		saberiBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				double a, b;
				try {
					a = Double.parseDouble(prviOperandTF.getText());
					b = Double.parseDouble(drugiOperandTF.getText());
					
					Izraz izraz = new Izraz(a, b, '+');
					ispisTF.setText(izraz + " = " + izraz.rezultatIzraza());
				} catch(NumberFormatException e) {
					porukaLbl.setText("Neispravan unos operanada.");
				}
			}
		});
		
		oduzmiBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				double a, b;
				try {
					a = Double.parseDouble(prviOperandTF.getText());
					b = Double.parseDouble(drugiOperandTF.getText());
					
					Izraz izraz = new Izraz(a, b, '-');
					ispisTF.setText(izraz + " = " + izraz.rezultatIzraza());
				} catch(NumberFormatException e) {
					porukaLbl.setText("Neispravan unos operanada.");
				}
			}
		});
		
		pomnoziBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				double a, b;
				try {
					a = Double.parseDouble(prviOperandTF.getText());
					b = Double.parseDouble(drugiOperandTF.getText());
					
					Izraz izraz = new Izraz(a, b, '*');
					ispisTF.setText(izraz + " = " + izraz.rezultatIzraza());
				} catch(NumberFormatException e) {
					porukaLbl.setText("Neispravan unos operanada.");
				}
			}
		});
		
		podeliBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				double a, b;
				try {
					a = Double.parseDouble(prviOperandTF.getText());
					b = Double.parseDouble(drugiOperandTF.getText());
					
					if(b != 0) {
						Izraz izraz = new Izraz(a, b, '/');
						ispisTF.setText(izraz + " = " + izraz.rezultatIzraza());
					}
					else {
						ispisTF.setText("");
						porukaLbl.setText("Nedozvoljeno deljenje nulom.");
					}
				} catch(NumberFormatException e) {
					porukaLbl.setText("Neispravan unos operanada.");
				}
			}
		});
		
		korenBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				double a;
				try {
					a = Double.parseDouble(prviOperandTF.getText());
					
					if(a > 0) {
						Izraz izraz = new Izraz(a, a, '\u221A');
						ispisTF.setText("\u221A (" + a + ") = " + izraz.rezultatIzraza());
					}
					else {
						ispisTF.setText("");
						porukaLbl.setText("Nedozvoljen kvadratni koren negativnog broja.");
					}
				} catch(NumberFormatException e) {
					porukaLbl.setText("Neispravan unos operanada.");
				}
			}
		});
		
		ocistiBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				prviOperandTF.setText("");
				drugiOperandTF.setText("");
				ispisTF.setText("");
			}
		});
		
		VBox main = new VBox();
		main.setPadding(new Insets(20, 0, 0, 20));
		main.getChildren().addAll(top, bottom);
		
		Scene scene = new Scene(main, 400, 250);
		stage.setScene(scene);
		stage.show();
	}
}
