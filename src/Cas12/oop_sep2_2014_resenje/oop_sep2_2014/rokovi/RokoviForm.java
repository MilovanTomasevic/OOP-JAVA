package rokovi2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

/**
 * Drugi nacin (neobavezno):
 * 
 * Radio dugmad za izbor ispitnog roka se smestaju dodatno 
 * u listu, radi lakse obrade dogadjaja koja se radi rucno:
 * - za svako dugme se pozivom metoda setOnAction() postavlja
 * objekat-slusalac dogadjaja nad tim dugmetom.
 * Radi se o objektu koji implementira interfejs EventHandler
 * i treba definisati ponasanje metoda handle ovog interfejsa
 * koji se i poziva kada se izabere neko radio dugme. 
 * 
 * Kod sortiranja se izbor nekog od dva radio dugmeta
 * registruje zahvaljujuci objektu slusaocu - koji implementira
 * interfejs ChangeListener.
 * Svaki put kada dodje do promene izabranog radio dugmeta u grupi,
 * poziva se njegov metod change koji je potrebno adekvatno implementirati. 
 * 
 */
public class RokoviForm implements Initializable {

	private HashMap<String, List<OcenaBroj>> rokoviM = new HashMap<>();
	private List<Rok> rokoviL = new ArrayList<>();
	
	@FXML
	private Button ucitaj;

	@FXML
	private RadioButton rb1;
	
	@FXML
	private RadioButton rb2;
	
	@FXML
	private RadioButton rb3;
	
	private List<RadioButton> rokoviBtn = new ArrayList<>(); /* radio dugmad koja odgovaraju rokovima;
			prave se automatski, ali se smestaju dodatno u listu, radi lakse obrade dogadjaja */
		
	@FXML 
	private RadioButton brDesetkiBtn;

	@FXML 
	private RadioButton prOcenaBtn;

	@FXML
	private ToggleGroup stg;

	@FXML
	private TextArea ta;

	private FileChooser fc;
			
	public void procitajFajl(ActionEvent event) {
		rokoviM.clear();
		ta.setText("");
		rokoviBtn.add(rb1);
		rokoviBtn.add(rb2);
		rokoviBtn.add(rb3);
		File dat = fc.showOpenDialog(ucitaj.getScene().getWindow());
		if(dat != null) {
			// otvara se izabrani fajl za citanje
			try (Scanner sc = new Scanner(dat.toPath(), StandardCharsets.UTF_8.name())) {
				/* petlja za izdvajanje rokova - ne zna se unapred broj rokova*/
				while(sc.hasNextLine()) {
					// cita se rok
					String rok = sc.nextLine();
					System.out.println(rok);
					rok = rok.replaceAll(":", "");

					/* petlja za izdvajanje podataka o jednom roku - za svaki rok 
					 * ima tacno pet linija u nastavku, sto olaksava parsiranje */
					for(int i = 0; i < 5 && sc.hasNextLine(); i++){
						// cita se linija sa ocenom i brojem
						String linija = sc.nextLine();
						Ocena ocena = Ocena.valueOf(linija.substring(0, linija.indexOf("-")));
						int broj = Integer.parseInt(linija.substring(linija.indexOf("-") + 1,
								linija.length()));
						OcenaBroj ob = new OcenaBroj(ocena, broj);
						System.out.println(ob);
						// Ako rok ne postoji u mapi, dodaje se zajedno sa podacima za jednu ocenu
						if (!rokoviM.containsKey(rok)) {
							List<OcenaBroj> ocene = new ArrayList<>();
							ocene.add(ob);
							rokoviM.put(rok, ocene);
						} else
							// dodaju se podaci za jednu ocenu
							rokoviM.get(rok).add(ob);
					}
				}
				
				int rbr = 0;
				// popunjavanje liste rokova i azuriranje radio dugmadi
				for(String rok : rokoviM.keySet()){
					double prOcena = 0.0; /* prosek ocena u jednom roku */
					int brOcena = 0; /* broj ocenjenih studenata u jednom roku */
					for(OcenaBroj ocena : rokoviM.get(rok)) {
						brOcena += ocena.getBroj();
						prOcena += ocena.getOcena().getNum() * ocena.getBroj();
					}
					rokoviL.add(new Rok(rok, prOcena/brOcena, 
							rokoviM.get(rok).get(4).getBroj()));

					/* Kako nije dozvoljena upotreba lokalnih promenljivih 
					 * rok i prosek u metodu handle() anonimne ugnjezdene klase, 
					 * uvode se final promenljive R i prosek (cija je upotreba
					 * dozvoljena).
					 */
					final String R = rok;
					final double prosek = prOcena/brOcena;
					rokoviBtn.get(rbr).setText(rok);
					rokoviBtn.get(rbr)
						.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent arg0) {
									ta.setText("");
									ta.appendText("Ispitni rok: " + R + "\n");
									for(OcenaBroj ocena : rokoviM.get(R)) 
										ta.appendText(ocena + "\n");
									ta.appendText(String.format(
											"Prosecna ocena: %.2f", prosek));
								}
							});
							
							
					rbr++;
				}
				ucitaj.setDisable(true);
				brDesetkiBtn.setDisable(false);
				prOcenaBtn.setDisable(false);
					
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else
			ta.setText("Dokument nije izabran!\n\nPokusajte ponovo...");
	}

	public void sortiraj(ActionEvent e) {
		ta.setText("");
		if(!rokoviL.isEmpty()){ // da bi se sprecio NullPointerException u slucaju prazne liste
			Collections.sort(rokoviL); 			
			for (Rok rok : rokoviL) 
				ta.appendText(rok.toString() + "\n");	
		}
		else System.out.println("prazna lista");
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		fc = new FileChooser();
		fc.setTitle("Ocene po rokovima");
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".txt fajlovi", "*.txt"),
						             new FileChooser.ExtensionFilter("svi fajlovi", "*.*"));
		
		stg.selectedToggleProperty().addListener(new ChangeListener<Object>() {
			// metod koji se poziva svaki put kada dodje do promene izabranog radio dugmeta u grupi
			public void changed(ObservableValue<? extends Object> observable,
					Object oldValue, Object newValue) {
				
				RadioButton izabrano = (RadioButton)stg.getSelectedToggle();
				Rok.setOcenaSort(izabrano.getId().equals("prOcenaBtn"));
			}
		});
		
	}
}
