package sa_radio_dugmadima_bez_izracunajBtn;
	
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import bez_radio_dugmadi.Artikal;
import bez_radio_dugmadi.Tablet;
import bez_radio_dugmadi.Telefon;
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

	/* artikli - klasna clanica da bi bila dostupna svim metodima 
	 * (klasa je jer se poziva u metodu ucitajArtikle() koji je staticki) */
	private static LinkedList<Artikal> artikli = new LinkedList<>();
	
	/* cvorovi grafa koji se koriste u obradi dogadjaja takodje mogu da budu 
	 * clanice klase (nije neophodno da budu staticke, jer se koriste unutar
	 * pomocnih metoda koji se odnose na pravljenje grafa scene, sto 
	 * se radi u odvojenoj niti od one gde se izvrsava staticki metod main).  
	 */
	private Button artikliBtn;
	private TextArea ispisTA;
	private RadioButton telefoniBtn, tabletiBtn;
	private ToggleGroup tg = new ToggleGroup();
	
	public static void main(String[] args) {
		ucitajArtikle();
		launch(args);
	}
	
	private static void ucitajArtikle() {
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("uredjaji.txt"));
			
			for(String line: lines) {
				try(Scanner scLine = new Scanner(line)) {
					scLine.useDelimiter(", ");
					
					Oznaka oznaka = Oznaka.valueOf(scLine.next());
					String naziv = scLine.next();
					float cena = scLine.nextFloat();
					String dodatnaKarakteristika = scLine.next();
					
					if(oznaka == Oznaka.TEL) {
					
						Telefon telefon = dodatnaKarakteristika.equals("DA") ? 
									new Telefon(naziv, cena, true) : 
									new Telefon(naziv,cena, false);
						artikli.add(telefon);
					}
					else {
						int odobrenPopust = Integer.parseInt(dodatnaKarakteristika);
						
						Tablet tablet = new Tablet(naziv, cena, odobrenPopust);
						artikli.add(tablet);
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Greska prilikom ucitavanja artikala.");
			System.exit(1);
		} 
	}

	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox(10);
		Scene scene = new Scene(root,550,250);
		
		kreirajGUI(root);
		
		primaryStage.setTitle("Nabavka uredjaja");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void kreirajGUI(VBox root) {

		ispisTA = new TextArea();
		ispisTA.setEditable(false);
		
		telefoniBtn = new RadioButton("Telefoni");
		tabletiBtn = new RadioButton("Tableti");
		telefoniBtn.setPrefWidth(100);
		tabletiBtn.setPrefWidth(100);
		telefoniBtn.setToggleGroup(tg);
		tabletiBtn.setToggleGroup(tg);
		VBox desniPanel = new VBox(telefoniBtn, tabletiBtn);
		desniPanel.setSpacing(10);
		desniPanel.setAlignment(Pos.CENTER);
		
		artikliBtn = new Button("Prikazi sve artikle");
		
		HBox gornjiPanel = new HBox(10);
		gornjiPanel.getChildren().addAll(ispisTA, desniPanel);
		
		HBox donjiPanel = new HBox(25);
		donjiPanel.setPadding(new Insets(5, 0, 0, 150));
		donjiPanel.getChildren().addAll(artikliBtn);

		/* obrada dogadjaja */
		obradiPrikazSvihArtikala();
		obradiListanjeTelefona();
		obradiListanjeTableta();
			
		root.getChildren().addAll(gornjiPanel, donjiPanel);
	}

	private void obradiListanjeTableta() {
		tabletiBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				StringBuilder sb = new StringBuilder();
				float suma = 0f;
				for(Artikal artikal : artikli)
					if(artikal instanceof Tablet) {
						sb.append(artikal + "\n");
						suma += artikal.prodajnaCena();
					}
				
				if(suma != 0) {
					sb.append("--------------------------------");
					sb.append("\nUKUPNO: " + suma);
				}
				if(!sb.equals(""))
					ispisTA.setText(sb.toString());
				else
					ispisTA.setText("Nema kupljenih telefona");
			}
		});		
	}

	private void obradiListanjeTelefona() {
		telefoniBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				StringBuilder sb = new StringBuilder();
				float suma = 0f;
				Iterator<Artikal> iterator = artikli.iterator();
				while(iterator.hasNext()) {
					Artikal a = iterator.next();
					if(a instanceof Telefon) {
						sb.append(a + "\n");
						suma += a.prodajnaCena();
					}
				}
				if(suma != 0) {
					sb.append("--------------------------------");
					sb.append("\nUKUPNO: " + suma);
				}
				if(!sb.equals(""))
					ispisTA.setText(sb.toString());
				else
					ispisTA.setText("Nema kupljenih telefona");
			}
		});
	}
	
	private void obradiPrikazSvihArtikala() {
		artikliBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				try {
					List<String> lines = Files.readAllLines(Paths.get("uredjaji.txt"));
					ispisTA.setText("--------------- DEO ZA PRAG ---------------\n");

					for(String line : lines)
						ispisTA.appendText(line + "\n");
					
					ispisTA.appendText("-----------------------------------------------\n");				
					
				} catch (IOException e) {
					ispisTA.setText("Greska prilikom ucitavanja artikala.");
				} 
			}
		});
	}
}
