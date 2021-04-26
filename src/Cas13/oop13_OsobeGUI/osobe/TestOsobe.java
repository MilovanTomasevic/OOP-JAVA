package osobe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Drugi kolokvijum 2008 - zadatak Osobe:
 * 
 * Zadatak je delimicno izmenjen u skladu sa elementima
 * grafickog korisnickog interfejsa koji su obradjeni na vezbama. 
 */
public class TestOsobe extends Application {

	private static Insets DEFAULT_PADDING = new Insets(10);
	
	private TextField txfIP1, txfG1, txfIP2, txfG2;
	private RadioButton rbtPI, rbtG;
	private ToggleGroup tg = new ToggleGroup();

	private TextArea ta;
	private List<Osoba> osobe = new ArrayList<Osoba>();
	
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPadding(DEFAULT_PADDING);
		root.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(root, 500, 430);

		napraviGUI(root);

		primaryStage.setTitle("Osobe");
		//primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void napraviGUI(VBox root) {
		root.getChildren().addAll(napraviTFUnose(), napraviDugmad(), napraviRDugmad(), napraviDugmeSort(), napraviIzlaz1(), napraviIzlaz2());
	}
	
	private Node napraviTFUnose() {
		// FlowPane - rastojanje izmedju cvorova u jednom redu je 20px, rastojanje izmedju uzastopnih redova je 20px
		FlowPane rez = new FlowPane(20, 20);
		rez.setAlignment(Pos.CENTER);
		rez.setPadding(DEFAULT_PADDING);
		txfIP1 = new TextField();
		txfIP1.setPrefWidth(200);
		txfIP1.setPrefHeight(25);
		// postavlja se negativna margina za tekstualno polje, kako bi se smanjio otklon od labele 
		FlowPane.setMargin(txfIP1, new Insets(0, 0, 0, -18));
		txfG1 = new TextField();
		txfG1.setPrefHeight(25);
		txfG1.setPrefWidth(50);
		FlowPane.setMargin(txfG1, new Insets(0, 0, 0, -18));
		rez.getChildren().addAll(new Label("Ime i prezime:"), txfIP1, new Label("Godiste:"), txfG1);
		return rez;
	}

	private Node napraviDugmad() {
		FlowPane rez = new FlowPane(10, 10);
		rez.setAlignment(Pos.CENTER);
		rez.setPadding(DEFAULT_PADDING);
		rez.getChildren().addAll(napraviBtnUnesi(), napraviBtnPonisti());
		return rez;
	}

	private Node napraviBtnUnesi() {
		Button unesi = new Button("Unesi");
		unesi.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				String imePrezimeStr = txfIP1.getText().trim();
				int indeksRazmaka = imePrezimeStr.indexOf(' ');
				if(indeksRazmaka == -1){
					txfIP1.setText("Neispravan unos!");
					return;
				}
				
				String ime = imePrezimeStr.substring(0, indeksRazmaka);
				String prezime = imePrezimeStr.substring(indeksRazmaka + 1).trim();
				
				int godiste = 0;
				try {
					godiste = Integer.parseInt(txfG1.getText().trim());
				} catch(NumberFormatException nfe){
					txfIP1.setText("Neispravno godiste!");
					return;
				}
				osobe.add(new Osoba(ime, prezime, godiste));
			}
		});
		return unesi;
	}

	private Node napraviBtnPonisti() {
		Button ponisti = new Button("Ponisti");
		ponisti.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				txfIP1.setText("");
				txfG1.setText("");
			}
		});
		return ponisti;
	}

	private Node napraviRDugmad() {
		VBox rez = new VBox(new Label("Sortiranje"));
		VBox vboxRbt = new VBox(10);
		vboxRbt.setStyle("-fx-border-color: blue");
		vboxRbt.setPadding(DEFAULT_PADDING);
		rbtPI = new RadioButton("po prezimenu i imenu");
		rbtPI.setSelected(true);
		rbtPI.setToggleGroup(tg);
		rbtG = new RadioButton("po godinama starosti, rastuce");
		rbtG.setToggleGroup(tg);
		vboxRbt.getChildren().addAll(rbtPI, rbtG);
		rez.getChildren().add(vboxRbt);
		return rez;
	}

	private Node napraviDugmeSort() {
		Button rez = new Button("Sortiraj i ispisi rezultat");
		rez.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {

						if(!osobe.isEmpty()){
							if(rbtPI.isSelected())
								Collections.sort(osobe);
							else
								// sortiranje kolekcije pomocu komparatora
								Collections.sort(osobe, new Comparator<Osoba>() {

									@Override
									public int compare(Osoba o1, Osoba o2) {
										// rastuce po godinama starosti (tj. opadajuce po godistu)
										return Integer.compare(o2.getGodiste(), o1.getGodiste());
									}
								});
							
							Osoba prva = osobe.get(0);
							
							txfIP2.setText(prva.getPrezime() + " " + prva.getIme());
							txfG2.setText(prva.getGodiste() + "");
							
							StringBuilder rez = new StringBuilder();
							for(Osoba osoba: osobe)
								rez.append(osoba + "\n");
							ta.setText(rez.toString());
							
						}
					}
				});
		return rez;
	}

	private Node napraviIzlaz1() {
		FlowPane rez = new FlowPane(20,20);
		rez.setAlignment(Pos.CENTER);
		rez.setPadding(DEFAULT_PADDING);
		txfIP2 = new TextField();
		txfIP2.setPrefWidth(200);
		txfIP2.setPrefHeight(25);
		txfIP2.setEditable(false);
		FlowPane.setMargin(txfIP2, new Insets(0, 0, 0, -18));
		txfG2 = new TextField();
		txfG2.setPrefWidth(50);
		txfG2.setPrefHeight(25);
		txfG2.setEditable(false);
		FlowPane.setMargin(txfIP2, new Insets(0, 0, 0, -18));
		rez.getChildren().addAll(new Label("Ime i prezime:"), txfIP2, new Label("Godiste:"), txfG2);
		return rez;
	}
	
	private Node napraviIzlaz2() {
		ta = new TextArea();
		ta.setEditable(false);
		HBox rez = new HBox(ta);
		// Sa uvecanjem prozora raste i TextArea tako da ispunjava citavu sirinu hbox-a.
		HBox.setHgrow(ta, Priority.ALWAYS);
		return rez;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
