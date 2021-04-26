package rokovi2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

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
	
	@FXML 
	private RadioButton brDesetkiBtn;

	@FXML 
	private RadioButton prOcenaBtn;

	@FXML
	private TextArea ta;

	private FileChooser fc;
			
	public void procitajFajl(ActionEvent event) {
		rokoviM.clear();
		ta.setText("");
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
				
				// popunjavanje liste rokova 
				for(String rok : rokoviM.keySet()){
					double prOcena = 0.0; /* prosek ocena u jednom roku */
					int brOcena = 0; /* broj ocenjenih studenata u jednom roku */
					for(OcenaBroj ocena : rokoviM.get(rok)) {
						brOcena += ocena.getBroj();
						prOcena += ocena.getOcena().getNum() * ocena.getBroj();
					}
					rokoviL.add(new Rok(rok, prOcena/brOcena, 
							rokoviM.get(rok).get(4).getBroj()));
				}
				
				// azuriranje radio dugmadi na osnovu liste rokova
				rb1.setText(rokoviL.get(0).getRok());
				rb2.setText(rokoviL.get(1).getRok());
				rb3.setText(rokoviL.get(2).getRok());
				
				ucitaj.setDisable(true);
				brDesetkiBtn.setDisable(false);
				prOcenaBtn.setDisable(false);
					
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else
			ta.setText("Dokument nije izabran!\n\nPokusajte ponovo...");
	}
	
	// metod koji se poziva pri izboru nekog od radio dugmadi sa ispitnim rokovima
	// jedan metod se primenjuje na sva tri radio dugmeta
	// (postavljen je u polje onAction u SceneBuilder-u za svako dugme)
	public void ispitniRokAction(Event e) {
		// saznajemo o kome se dugmetu radi
		RadioButton rbt_rok = (RadioButton)e.getSource();
		// saznajemo koji je rok pridruzen tom dugmetu
		String rok = rbt_rok.getText();
		ta.setText("");
		ta.appendText("Ispitni rok: " + rok + "\n");
		for(OcenaBroj ocena : rokoviM.get(rok)) 
			ta.appendText(ocena + "\n");
		for(Rok r : rokoviL) 
			// pronalazimo rok u listi
			if(r.getRok().equalsIgnoreCase(rok))
				// i ispisujemo podatke o prosecnoj oceni u ta
				ta.appendText(String.format(
								"Prosecna ocena: %.2f", r.getPrOcena()));
	}
	
	public void sortiraj(ActionEvent e) {
		ta.setText("");
		if(!rokoviL.isEmpty()){ // da bi se sprecio NullPointerException u slucaju prazne liste
			if(prOcenaBtn.isSelected()) {
				Collections.sort(rokoviL);
				for (Rok rok : rokoviL) 
					ta.appendText(rok + ": " + String.format("%.2f", rok.getPrOcena()) + "\n");	
			}
			else {
				Collections.sort(rokoviL, new Comparator<Rok>() {
					public int compare(Rok o1, Rok o2) {
						return Integer.compare(o2.getBrDesetki(), o1.getBrDesetki());
					}
				});
				for (Rok rok : rokoviL) 
					ta.appendText(rok + ": " + rok.getBrDesetki() + "\n");	
			}
		}
		else System.out.println("prazna lista");
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		fc = new FileChooser();
		fc.setTitle("Ocene po rokovima");
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".txt fajlovi", "*.txt"),
						             new FileChooser.ExtensionFilter("svi fajlovi", "*.*"));
	}
}
