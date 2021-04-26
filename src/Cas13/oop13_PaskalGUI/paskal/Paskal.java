package paskal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Paskal extends Application {
	
	private static final int PODR_BR_REDOVA = 3;
	
	private TextField txfBrRedova;
	private Button btnNapraviTrougao;
	private Button btnPopuniTrougao;
	
	private VBox vbTrougao;
	
	private int brRedova;
	
	private Button[][] polja;
	
	private boolean bin_koef = true;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Paskalov trougao");
		//primaryStage.setResizable(false);
		
		Scene scene = new Scene(napraviScenu(), 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Parent napraviScenu() {
		
		VBox root = new VBox(10);
		root.setPadding(new Insets(10)); 
		root.setAlignment(Pos.TOP_CENTER); 
		
		FlowPane prviRed = napraviPrviRed();
		
		btnPopuniTrougao = napraviBtnPopuniTrougao();
		
		VBox trougaoSpoljasnji = napraviTrougaoSpoljasnji();

		root.getChildren().addAll(prviRed, btnPopuniTrougao, trougaoSpoljasnji);
		
		return root;
	}

	private FlowPane napraviPrviRed() {
		FlowPane rez = new FlowPane();
		rez.setAlignment(Pos.CENTER);
		rez.setHgap(20);
		rez.setVgap(10);
		
		Label lblPom = new Label("Broj redova:");
		
		txfBrRedova = new TextField();
		txfBrRedova.setPrefColumnCount(3); 
			// prioritetna sirina polja: dovoljna za 3 karaktera
		rez.setPrefHeight(30);
		FlowPane.setMargin(rez, new Insets(0, 0, 0, -18)); // leva margina: -18 piksela
										// -> priblizavamo polje labeli za 18 piksela
		
		btnNapraviTrougao = napraviBtnNapraviTrougao();
		rez.getChildren().addAll(lblPom, txfBrRedova, btnNapraviTrougao);
		return rez;
	}

	private Button napraviBtnNapraviTrougao() {
		
		Button rez = new Button("Napravi trougao");
		rez.setOnAction(new EventHandler<ActionEvent>() {
					
			@Override
			public void handle(ActionEvent arg0) {

				// onemogucavanje klika na dugme
				btnNapraviTrougao.setDisable(true);
				btnPopuniTrougao.setDisable(false);
				
				txfBrRedova.setEditable(false);
				
				if(txfBrRedova.getText().length() != 0)
					brRedova = Integer.parseInt(txfBrRedova.getText());
				else
					brRedova = PODR_BR_REDOVA;
				
				polja = new Button[brRedova][];
				
				// uklanjanje svega sto je prethodno dodato u VBox vbTrougao
				// kada se prvi put izabere broj redova, efekat se ne vidi, 
				// jer prethodno nista nije dodato, ali svaki sledeci put, 
				// prvo treba ukloniti staru dugmad, pa onda dodati novu
				vbTrougao.getChildren().clear(); 
				
				for(int i=0; i<polja.length; i++){
					polja[i] = new Button[i+1];
					
					FlowPane itiRed = new FlowPane(10, 5);
					itiRed.setAlignment(Pos.CENTER);
					
					for(int j=0; j<polja[i].length; j++){
						polja[i][j] = new Button();
						polja[i][j].setPrefSize(50, 30);
						polja[i][j].setAlignment(Pos.CENTER); 
						itiRed.getChildren().add(polja[i][j]);
					}
					vbTrougao.getChildren().add(itiRed);
				}
			}
		});
		return rez;
	}
	
	private VBox napraviTrougaoSpoljasnji() {
		VBox rez = new VBox();
		Label lbl = new Label("Paskalov trougao");
		lbl.setTextFill(Color.BLUE);
		vbTrougao = napraviVbTrougao();
		rez.getChildren().addAll(lbl, vbTrougao);
		
		VBox.setVgrow(rez, Priority.ALWAYS); 
			// ova komponenta ce da raste tako da zauzme svu raspolozivu visinu
		return rez;
	}

	private VBox napraviVbTrougao() {
		VBox rez = new VBox(10);
		rez.setStyle("-fx-border-color: blue");
		rez.setPadding(new Insets(10));
		
		VBox.setVgrow(rez, Priority.ALWAYS); 
			// ova komponenta ce da raste tako da zauzme svu raspolozivu visinu
		return rez;
	}
	
	private Button napraviBtnPopuniTrougao() {
		Button rez = new Button("Popuni Paskalov trougao");
		rez.setDisable(true); // dugme je inicijalno onemoguceno
		rez.setOnAction(new EventHandler<ActionEvent>() {
					
			@Override
			public void handle(ActionEvent arg0) {

				btnPopuniTrougao.setDisable(true);
				btnNapraviTrougao.setDisable(false);
				txfBrRedova.setEditable(true);
				
				for(int i=0; i<polja.length; i++)
					for(int j=0; j<polja[i].length; j++){
						if(j==0 || i==j)
							polja[i][j].setText("1");
						else
							polja[i][j].setText(Integer.parseInt(polja[i-1][j-1].getText()) 
									+ Integer.parseInt(polja[i-1][j].getText()) + "");
						
						// uvodimo pomocne final lokalne promenljive sa odgovarajucim vrednostima
						// (mozemo da im pristupamo iz koda donjih anonimnih klasas)
						final int I = i;
						final int J = j;
						final String stariTekst = polja[i][j].getText();
						
						polja[i][j].setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								Button dugme = (Button)event.getSource();
								if(bin_koef) 
									dugme.setText("C(" + I + ", " + J + ")");
								else
									dugme.setText(stariTekst);
								
								// bez invertovanja indikatora ne moze da radi 
								// naizmenicno prikazivanje binomnog koeficijenta
								// i oznake C(i,j) nakon klika na dugme
								bin_koef = !bin_koef;
							}
						});
					}
			}
		});
		return rez;
	}
}
