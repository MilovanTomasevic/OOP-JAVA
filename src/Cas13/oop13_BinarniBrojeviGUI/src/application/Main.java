package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	/* klasna clanica - da bi bila dostupna iz svih metoda */
	private static ArrayList<BinarniBroj> binarniBrojevi = new ArrayList<>();
	
	/* klasna clanica - da bi bila dostupna iz svih metoda */
	private static HashMap<String, String> kodovi = new HashMap<>();
	
	public static void main(String[] args) {
		ucitajBinarneBrojeve();
		ucitajKodove();
		launch(args);
	}

	private static void ucitajKodove() {
		List<String> lines = null;
		
		try {		
			lines = Files.readAllLines(Paths.get("kodovi.txt"));
			
			for(String line : lines) 			
				try(Scanner scLine = new Scanner(line)) {	
					String binBroj = scLine.next();
					String hexKod = scLine.next();
					kodovi.put(binBroj, hexKod);		
					
				}	
		} catch(IOException e) {
			System.err.println("Greska prilikom ucitavanja datoteke kodovi.txt");
			System.exit(1);
		}
	}

	private static void ucitajBinarneBrojeve() {
		List<String> lines = null;
		String[] deloviBroja;

		try {
			lines = Files.readAllLines(Paths.get("brojevi.txt"));

			for (String line : lines) {
				deloviBroja = line.split("\\.");

				// System.out.println(Arrays.toString(deloviBroja));

				String ceoDeo = deloviBroja[0];
				String razlomljeniDeo = "";
				if (deloviBroja.length == 2)
					razlomljeniDeo = deloviBroja[1];

				/*
				 * Deo za prag: kad jos uvek nemamo klasu BinarniBroj
				 * if(deloviBroja.length == 2) sb.append(deloviBroja[0]
				 * + "." + deloviBroja[1] + "\n"); else
				 * sb.append(deloviBroja[0] + "\n");
				 */

				BinarniBroj binarniBroj = new BinarniBroj(ceoDeo, razlomljeniDeo);
				binarniBrojevi.add(binarniBroj);
			}

		} catch (IOException e) {
			System.err.print("Greska prilikom ucitavanja datoteke brojevi.txt");
			System.exit(1);
		}
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(15);
		Scene scene = new Scene(root, 500, 300);

		kreirajGUI(root);

		primaryStage.setTitle("Binarni brojevi");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void kreirajGUI(VBox root) {

		Button ucitajBinBtn = new Button("Prikazi binarne brojeve");
		Button ucitajHexBtn = new Button("Prikazi heksadekadne kodove");
		HBox gornjiPanel = new HBox(30);
		gornjiPanel.setPadding(new Insets(5, 0, 0, 55));
		gornjiPanel.getChildren().addAll(ucitajBinBtn, ucitajHexBtn);

		TextArea ispisBinTA = new TextArea();
		ispisBinTA.setEditable(false);
		ispisBinTA.setPrefWidth(300);

		TextArea ispisHexTA = new TextArea();
		ispisHexTA.setEditable(false);
		ispisHexTA.setPrefWidth(200);

		HBox srednjiPanel = new HBox();
		srednjiPanel.getChildren().addAll(ispisBinTA, ispisHexTA);

		Button hexZapisBtn = new Button("Heksadekadni zapis");
		Button sortirajBtn = new Button("Sortiraj po dekadnoj vrednosti");
		HBox donjiPanel = new HBox(30);
		donjiPanel.setPadding(new Insets(5, 0, 0, 55));
		donjiPanel.getChildren().addAll(hexZapisBtn, sortirajBtn);

		/* dodavanje obrade dogadjaja */
		obradiPrikazBinarnihBrojeva(ucitajBinBtn, ispisBinTA);
		obradiPrikazHeksadnihKodova(ucitajHexBtn, ispisHexTA);
		obradiKonverziju(hexZapisBtn, ispisBinTA);
		obradiSortiranje(sortirajBtn, ispisBinTA);

		root.getChildren().addAll(gornjiPanel, srednjiPanel, donjiPanel);
	}

	private void obradiSortiranje(Button sortirajBtn, TextArea ispisBinTA) {
		
		sortirajBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Collections.sort(binarniBrojevi);
				StringBuffer sb = new StringBuffer();
				for(BinarniBroj binBroj : binarniBrojevi)
					sb.append(binBroj + "\t-\t" + binBroj.dekVr() + "\n");
				ispisBinTA.setText(sb.toString());
			}
		});

	}

	private void obradiKonverziju(Button hexZapisBtn, TextArea ispisBinTA) {
		
		hexZapisBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				StringBuffer sb = new StringBuffer("---- HEKSADEKADNI ZAPIS ----\n");
				
				Iterator<BinarniBroj> iterator = binarniBrojevi.iterator();
				while(iterator.hasNext()) {
					BinarniBroj binarniBroj = iterator.next();
					sb.append(binarniBroj.hexZapis(kodovi) + "\n");
				}
				
				ispisBinTA.setText(sb.toString());
			}
		});
	}

	private void obradiPrikazHeksadnihKodova(Button ucitajHexBtn, TextArea ispisHexTA) {
	
		ucitajHexBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			
				Iterator<String> iterator = kodovi.keySet().iterator();
				StringBuffer sb = new StringBuffer();
				while(iterator.hasNext()) {
					String binBr = iterator.next();
					String hexKod = kodovi.get(binBr);
					sb.append(hexKod + "-" + binBr + "\n");
				}
				ispisHexTA.setText(sb.toString());
			}
		});
	}

	private void obradiPrikazBinarnihBrojeva(Button ucitajBinBtn, TextArea ispisBinTA) {
		ucitajBinBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				StringBuffer sb = new StringBuffer();
				Iterator<BinarniBroj> iterator = binarniBrojevi.iterator();
				while(iterator.hasNext()) {
					BinarniBroj b = iterator.next();
					sb.append(b).append("\n");
				}
				 ispisBinTA.setText(sb.toString());
			}
		});
	}
}
