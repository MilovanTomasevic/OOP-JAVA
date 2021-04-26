package imenik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TestImenikGUI extends Application {

	Imenik imenik = new Imenik();
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Imenik");
		int width = 400;
		
		Label imeLbl = new Label("Ime:");
		TextField imeTF = new TextField();
		
		Label prezimeLbl = new Label("Prezime:");
		TextField prezimeTF = new TextField();
		
		Label brojLbl = new Label("Broj telefona:");
		TextField brojTF = new TextField();
		
		Label logLbl = new Label();
		logLbl.setTextAlignment(TextAlignment.CENTER);

		TextArea ispisTA = new TextArea();
		ispisTA.setEditable(false);
		ispisTA.setPrefHeight(250);
		
		Button unosBtn = new Button("Unesi");
		unosBtn.setPrefWidth(width);
		unosBtn.setPrefHeight(50);
		
		unosBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				try {
					logLbl.setText("");
					String ime = imeTF.getText();
					String prezime = prezimeTF.getText();				
					String brojStr = brojTF.getText();
					String[] brojDelovi = brojStr.split(" ");
				
					Osoba osoba = new Osoba(ime, prezime);
					Broj broj = new Broj(brojDelovi[0], brojDelovi[1]);
					
					imenik.dodajKontakt(osoba, broj);	
					logLbl.setTextFill(Color.DARKORCHID);
					logLbl.setPrefHeight(50);
					logLbl.setPrefWidth(width);
					logLbl.setText(osoba + " je dodat-a u imenik");
				}
				catch(Exception e) {
					logLbl.setTextFill(Color.RED);
					logLbl.setText("Greska pri dodavanju");
					return;
				}
			}
		});
		
		Button ocistiBtn = new Button("Ocisti polja");
		ocistiBtn.setPrefWidth(width);
		ocistiBtn.setPrefHeight(50);
		
		ocistiBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				imeTF.setText("");
				prezimeTF.setText("");
				brojTF.setText("");
				logLbl.setText("");
				ispisTA.setText("");
			}
		});
		
		Button pretragaBtn = new Button("Pretraga po imenu");
		pretragaBtn.setPrefWidth(width);
		pretragaBtn.setPrefHeight(50);
		
		pretragaBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				logLbl.setText("");
				
				String ime = imeTF.getText();
				String prezime = prezimeTF.getText();
				
				if(!ime.equals("") && !prezime.equals("")) {
					Osoba osoba = new Osoba(ime, prezime);
					Broj broj = imenik.nadjiBroj(osoba);
					if(broj != null)
						ispisTA.setText("Broj telefona osobe " + osoba + " je " + broj);
					else
						ispisTA.setText("Osoba " + osoba + " nije u imeniku.");
				} 
				else {
					logLbl.setTextFill(Color.RED);
					logLbl.setText("Unesite ime i prezime osobe koju trazite.");
				}
			}
		});

		Button prikaziBtn = new Button("Listaj");
		prikaziBtn.setPrefWidth(width);
		prikaziBtn.setPrefHeight(50);
		
		prikaziBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				imeTF.setText("");
				prezimeTF.setText("");
				brojTF.setText("");
				logLbl.setText("");
				ispisTA.setText("");
				
				ispisTA.setText(imenik.toString());
			}
		});
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(imeLbl, imeTF, prezimeLbl, prezimeTF, brojLbl, brojTF, unosBtn, ocistiBtn, pretragaBtn, prikaziBtn, ispisTA, logLbl);
		vbox.setSpacing(5);
		
		Scene scene = new Scene(vbox, width, 700);
		
		stage.setScene(scene);
		stage.show();
	}

}
