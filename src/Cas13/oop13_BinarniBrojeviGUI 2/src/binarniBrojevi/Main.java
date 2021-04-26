package binarniBrojevi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	/* klasne promenljive - da bi bile dostupne iz svih metoda */
	private static List<BinarniBroj> binarniBrojevi = new ArrayList<>();
	private static Map<String, String> kodovi = new HashMap<>();
	private static TextArea ispisBinTA = new TextArea(); /* zbog dela za prag */
	
	public static void main(String[] args) {
		ucitajBinarneBrojeve();
		ucitajKodove();
		launch(args);
	}

	private static void ucitajBinarneBrojeve() {

		try {
			List<String> linije = Files.readAllLines(Paths.get("brojevi.txt"));
			for (String l : linije) {
				String[] deloviBroja = l.split("\\.");

				String ceoDeo = deloviBroja[0];
				String razlomljeniDeo = (deloviBroja.length == 2) ? deloviBroja[1] : "";

				/* Deo za prag: kad jos uvek nemamo klasu BinarniBroj */
				/*
				if(deloviBroja.length == 2) 
					ispisBinTA.appendText(deloviBroja[0] + "." + deloviBroja[1] + "\n"); 
				else
					ispisBinTA.appendText(deloviBroja[0] + "\n");
				*/
				
				BinarniBroj binarniBroj = new BinarniBroj(ceoDeo, razlomljeniDeo);
				binarniBrojevi.add(binarniBroj);
			}

		} catch (IOException e) {
			System.err.print("Greska prilikom ucitavanja datoteke brojevi.txt");
			System.exit(1);
		}
	}

	private static void ucitajKodove() {
		try {		
			List<String> linije = Files.readAllLines(Paths.get("kodovi.txt"));
			
			for(String l : linije) 			
				try(Scanner sc = new Scanner(l)) {
					kodovi.put(sc.next(), sc.next());	
				}
		} catch(IOException e) {
			System.err.println("Greska prilikom ucitavanja datoteke kodovi.txt");
			System.exit(1);
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		Scene scene = new Scene(root, 500, 300);

		napraviGUI(root);

		primaryStage.setTitle("Binarni brojevi");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void napraviGUI(VBox root) {

		Button ucitajBinBtn = new Button("Prikazi binarne brojeve");
		Button ucitajHexBtn = new Button("Prikazi heksadekadne kodove");
		HBox gornjiPanel = new HBox(30);
		gornjiPanel.setPadding(new Insets(10));
		gornjiPanel.setAlignment(Pos.CENTER);
		gornjiPanel.getChildren().addAll(ucitajBinBtn, ucitajHexBtn);

		ispisBinTA.setEditable(false);
		ispisBinTA.setPrefWidth(300);

		TextArea ispisHexTA = new TextArea();
		ispisHexTA.setEditable(false);
		ispisHexTA.setPrefWidth(200);

		HBox srednjiPanel = new HBox(5);
		srednjiPanel.getChildren().addAll(ispisBinTA, ispisHexTA);
		srednjiPanel.setPadding(new Insets(10));

		RadioButton hexZapisBtn = new RadioButton("Heksadekadni zapis");
		RadioButton sortirajBtn = new RadioButton("Sortiraj po dekadnoj vrednosti");
		/* da bi tacno jedno radio dugme moglo da bude selektovano
		 * neophodno je da se radio dugmad smeste u ToggleGroup.
		 */
		ToggleGroup tg = new ToggleGroup();
		hexZapisBtn.setToggleGroup(tg);
		//hexZapisBtn.setSelected(false);
		sortirajBtn.setToggleGroup(tg);
		//sortirajBtn.setSelected(false);
		HBox donjiPanel = new HBox(30);
		donjiPanel.setPadding(new Insets(10));
		donjiPanel.setAlignment(Pos.CENTER);
		donjiPanel.getChildren().addAll(hexZapisBtn, sortirajBtn);
		
		/* dodavanje obrade dogadjaja */
		obradiPrikazBinarnihBrojeva(ucitajBinBtn, ispisBinTA);
		obradiPrikazHeksadnihKodova(ucitajHexBtn, ispisHexTA);
		obradiKonverziju(hexZapisBtn, ispisBinTA);
		obradiSortiranje(sortirajBtn, ispisBinTA);

		root.getChildren().addAll(gornjiPanel, srednjiPanel, donjiPanel);
	}

	private void obradiSortiranje(RadioButton sortirajBtn, TextArea ispisBinTA) {
		sortirajBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Collections.sort(binarniBrojevi);
				StringBuilder sb = new StringBuilder();
				for(BinarniBroj binBroj : binarniBrojevi)
					sb.append(binBroj + "\t-\t" + binBroj.dekVr() + "\n");
				ispisBinTA.setText(sb.toString());
			}
		});
		
	}

	private void obradiKonverziju(RadioButton hexZapisBtn, TextArea ispisBinTA) {
		hexZapisBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ispisBinTA.setText("");
				for(BinarniBroj bb : binarniBrojevi)
					ispisBinTA.appendText(bb.hexZapis(kodovi) + "\n");	
			}
		});
	}

	private void obradiPrikazHeksadnihKodova(Button ucitajHexBtn, TextArea ispisHexTA) {
	
		ucitajHexBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			
				List<String> kljucevi = new ArrayList<>(kodovi.keySet());
				Collections.sort(kljucevi);
				for(String kljuc : kljucevi) {
					String hexKod = kodovi.get(kljuc);
					ispisHexTA.appendText(hexKod + "-" + kljuc + "\n");
				}
				// nakon prikaza kodova dugme moze da se onemoguci
				ucitajHexBtn.setDisable(true);
			}
		});
	}

	private void obradiPrikazBinarnihBrojeva(Button ucitajBinBtn, TextArea ispisBinTA) {
		ucitajBinBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ispisBinTA.setText("");
				for(BinarniBroj bb : binarniBrojevi)
					ispisBinTA.appendText(bb + "\n");
				// nakon prikaza binarnih brojeva dugme moze da se onemoguci
				ucitajBinBtn.setDisable(true);
			}
		});
	}
}
