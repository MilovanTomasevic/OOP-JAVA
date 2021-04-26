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
 * Slucajno se bira sest brojeva u intervalu [1, 49] koji 
 * se prikazuju kao tekst na dugmadima u panelu "Srecni brojevi".
 *   
 * - klik na pojedinacno dugme menja broj na tom dugmetu 
 * 
 * - klik na dugme "Novi brojevi" simulira novo izvlacenje
 * 
 * - kada se kursor misa nalazi iznad dugmeta sa srecnim brojem
 *   poprima oblik ruke (neobavezno)
 *   
 * - klik na dugme "Menja boju" naizmenicno menja boju pozadine
 *   srecne dugmadi iz zute u crvenu i obratno (neobavezno)
 */
public class Loto extends Application {
	
	public static final int BR_BROJEVA = 6;
	public static final int MAX_BROJ = 49;
	private static final Random izbor = new Random();
	
	// lista brojeva koji se trenutno ne nalaze ni na jednom dugmetu
	private List<Integer> slobodni = new ArrayList<>(MAX_BROJ);

	// da li je tekuca boja pozadine "srecne dugmadi" zuta
	private boolean zuta = true;
	
	// komponente koje isto izgledaju i isto se ponasaju
	// cuvaju se u nizu, matrici ili nekoj kolekciji.
	// Ovde znamo da ih je tacno BR_BROJEVA, pa je iskoriscen niz
	private Button[] brojevi = new Button[BR_BROJEVA];
	
	public static void main(String[] args) {
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) {
		VBox main = new VBox(20);
		
		// CSS stil se pridruzuje cvoru:
		// izmedju dvostrukih navodnika zadaje se jedno ili vise pravila
		// u formatu: 
		// <svojstvo> : <vrednost>
		// ovde je svojstvo boja pozadine (nazivi svojstava imaju prefiks -fx-)
		main.setStyle("-fx-background-color: lavender");
		
		// pomocni metod za pravljenje grafickih komponenti
		napraviGUI(main);
		
		// scena je sadrzaj prozora 
		// (sve komponente koje dodamo u scenu cine cvorove grafa)
		Scene scene = new Scene(main, 600, 400);
			// sirina scene: 600px, visina scene: 400px 
	
		// primaryStage - pozornica, predstavlja prozor aplikacije
		primaryStage.setScene(scene); // postavljanje scene na binu
		primaryStage.setTitle("Loto"); // postavljanje naslova prozora
		primaryStage.sizeToScene(); // velicina bine postavlja se na velicinu scene
		primaryStage.show(); // prikaz prozora
	}
	
	private void napraviGUI(VBox main) {
		
		// popunjavanje liste slobodnih brojeva
		for(int i = 1; i <= MAX_BROJ; i++)
			slobodni.add(i);

		VBox vbBrojevi = new VBox(10);
		vbBrojevi.setPadding(new Insets(10)); // udaljenost ivica komponente od sadrzaja
					// sadrzaj je udaljen od sve 4 ivice za po 10 piksela
		
		Label lbl = new Label("Srecni brojevi:");
		lbl.setTextFill(Color.BLUE);
		vbBrojevi.getChildren().add(lbl);
		
		HBox hbBrojevi = new HBox(20);
		hbBrojevi.setPadding(new Insets(20));
		hbBrojevi.setStyle("-fx-border-color: blue");
				// granica je plave boje (plavi pravougaonik)
		hbBrojevi.setAlignment(Pos.CENTER);
				// poravnanje dece u hbox-u (centrirano)

		// pravljenje srecne dugmadi
		for(int i = 0; i < brojevi.length; i++){
			brojevi[i] = new Button(slobodni.remove(izbor.nextInt(slobodni.size()))+"");
				// iz liste slobodnih brojeva uklanja se slucajan element i njegova
				// string-reprezentacija ispisuje na dugmetu
			brojevi[i].setPrefWidth(70); // prioritetna sirina dugmeta: 70px
			brojevi[i].setPrefHeight(30); // prioritetna visina dugmeta: 30px
			brojevi[i].setStyle("-fx-background-color: yellow");
			brojevi[i].setCursor(Cursor.MOVE); // iznad dugmeta kursor misa ima oblik ruke
											   // (neobavezno)
			// dodavanje obrade dogadjaja za srecno dugme
			obradiSrecnoDugme(brojevi[i]);
			
			// dodavanje novog deteta u listu postojece dece
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
		//HBox.setMargin(menjaBojuBtn, new Insets(0, 0, 0, 50));
		hbKontrole.getChildren().addAll(menjaBojuBtn, noviBrojeviBtn);
		
		main.getChildren().addAll(vbBrojevi, hbKontrole);
	}
	
	private void obradiSrecnoDugme(Button dugme) {
		/* Obrada dogadjaja (klik na dugme):
		 * za obradu je zaduzen objekat anonimne klase koja implementira interfejs EventHandler<>
		 * u ovom interfejsu definisan je samo jedan metod, handle(),
		 * koji ce se izvrsavati svaki put kada se klikne na dugme.
		 */
		dugme.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// "skidamo" stari broj sa dugmeta
				// sve sto pise na komponentama je tipa String i dohvata se metodom getText()
				// potrebna je konverzija iz String-a u int
				int stari = Integer.parseInt(dugme.getText().trim());
				// slucajan broj se uklanja iz liste i njegova String-reprezentacija se postavlja na dugme
				dugme.setText(slobodni.remove(izbor.nextInt(slobodni.size()))+"");
				// stari broj se vraca u listu slobodnih brojeva
				slobodni.add(stari);
			}
		});
	}
	
	private void obradiMenjaBoju(Button menjaBojuBtn, Button[] brojevi) {
		menjaBojuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// promena boje pozadine za svu srecnu dugmad
				for(int i=0; i<brojevi.length; i++)
					// u zavisnosti od tekuce boje pozadine (koja je zuta ili nije zuta)
					if(zuta)
						brojevi[i].setStyle("-fx-background-color: lightgreen");
					else
						brojevi[i].setStyle("-fx-background-color: yellow");
				
				// invertovanje vrednosti koja ukazuje da li je tekuca boja pozadine zuta
				zuta = !zuta;
			}
		});
	}
	
	private void obradiNoviBrojevi(Button noviBrojeviBtn, Button[] brojevi) {
		noviBrojeviBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// za svako srecno dugme
				for(int i=0; i<brojevi.length; i++){
					// skida se stari broj sa njega
					int stari = Integer.parseInt(brojevi[i].getText().trim());
					// na dugme se postavlja novi broj, koji se uklanja iz liste slobodnih
					brojevi[i].setText(slobodni.remove(izbor.nextInt(slobodni.size()))+"");
					// stari broj se vraca u listu slobodnih
					slobodni.add(stari);
				}
			}
		});
	}
}
