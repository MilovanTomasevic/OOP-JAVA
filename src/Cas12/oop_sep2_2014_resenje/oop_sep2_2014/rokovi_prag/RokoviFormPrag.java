package rokovi_prag2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooserBuilder;
import rokovi2.Ocena;

public class RokoviFormPrag implements Initializable {

	private List<String> rokoviL = new ArrayList<>();

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
		ta.setText("");
		File dat = fc.showOpenDialog(ucitaj.getScene().getWindow());
		if(dat != null) {
			// otvara se izabrani fajl za citanje
			try (Scanner sc = new Scanner(dat.toPath(), StandardCharsets.UTF_8.name())) {
				while(sc.hasNextLine()) {
					// cita se linija
					String linija = sc.nextLine();
					// ako je procitan rok, dodaje se u listu
					if(linija.contains(":")) {
						System.out.println(linija);
						rokoviL.add(linija.replaceAll(":", ""));
					}
					else {
						Ocena ocena = Ocena.valueOf(linija.substring(0, linija.indexOf("-")));
						int broj = Integer.parseInt(linija.substring(linija.indexOf("-") + 1,
								linija.length()));
						System.out.println(ocena + " (" + ocena.getNum() + ") - " + broj);
					}
				}
				
				rb1.setText(rokoviL.get(0));
				rb2.setText(rokoviL.get(1));
				rb3.setText(rokoviL.get(2));
				
				ucitaj.setDisable(true);
				brDesetkiBtn.setDisable(false);
				prOcenaBtn.setDisable(false);

			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else
			ta.setText("Pogresno ste izabrali dokument!!!\n\nPokusajte ponovo...");
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		fc = new FileChooser();
		fc.setTitle("Ocene po rokovima");
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".txt fajlovi", "*.txt"),
						             new FileChooser.ExtensionFilter("svi fajlovi", "*.*"));
						            
	}
}
