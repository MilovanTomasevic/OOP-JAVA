package yamb;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.VBox;

public class YambForm implements Initializable {

	private static final int BR_KOCKICA = 6;

	@FXML
	private Button btnBaci;
	
	@FXML
	private VBox vb;
	
	@FXML
	private ImageView iv; // kontrola za prikaz slike
	
	@FXML
	private TextField txfBrBacanja;
	
	@FXML
	private Label lblRezultat;
	
	private int brBacanja = 1;
	
	private Button[] kockice = new Button[BR_KOCKICA];
	private CheckBox[] checkovi = new CheckBox[BR_KOCKICA];
	
	private Random izbor = new Random();
	
	// metod je u Code panelu Scene Builder-a izabran za On Action dugmeta ciji je
	// fx:id "btnBaci"
	public void baciAction(Event e){
		
		// ako CheckBox nije selektovan, menja se broj na odgovarajucem dugmetu
		for(int i=0; i<kockice.length; i++)
			if(!checkovi[i].isSelected())
				kockice[i].setText(1 + izbor.nextInt(BR_KOCKICA) + "");
		
		brBacanja++;
		txfBrBacanja.setText(brBacanja + "");
		iv.setImage(new Image(getClass().getResource("../ikonice/pile" + brBacanja + ".png").toExternalForm()));
		
		if(brBacanja == 3){
			btnBaci.setDisable(true);
			
			// prebrojavanje koliko je kojih brojeva palo
			int[] brojaci = new int[BR_KOCKICA];
			for(int i=0; i<kockice.length; i++)
				brojaci[Integer.parseInt(kockice[i].getText())-1]++;
			
			for(int i=0; i<brojaci.length; i++)
				if(brojaci[i]>=5){
					lblRezultat.setText("YAMB: " + (i+1));
					return;
				}else if(brojaci[i] == 4){
					lblRezultat.setText("KARE: " + (i+1));
					return;
				}
			
			boolean kenta1 = true; // 1 2 3 4 5
			boolean kenta2 = true; // 2 3 4 5 6
			
			for(int i=0; i<5; i++){
				kenta1 = kenta1 && brojaci[i]>=1;
				kenta2 = kenta2 && brojaci[i+1]>=1;
			}
			
			if(kenta1)
				lblRezultat.setText("KENTA: 1 2 3 4 5");
			else if(kenta2)
				lblRezultat.setText("KENTA: 2 3 4 5 6");
			else
				lblRezultat.setText("Nista od trazenog!");
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		txfBrBacanja.setText(brBacanja+"");
		// postavljanje prve slicice u iv
		iv.setImage(new Image(getClass().getResource("../ikonice/pile1.png").toExternalForm()));
		
		GridPane grid = GridPaneBuilder.create()
				.hgap(20) // (horizontalni) razmak izmedju susednih cvorova u istoj vrsti
				.vgap(5) // (vertikalni) razmak izmedju susednih vrsta
				.padding(new Insets(20, 0, 20, 0)) // sadrzaj u grid-u je po 20 piksela
									// udaljen od njegove gornje i donje ivice
									
				//.gridLinesVisible(true) // bice vidljive linije oko sadrzaja grida
				.build();
		
		for(int i=0; i<kockice.length; i++){
			final int I = i;
			kockice[i] = ButtonBuilder.create()
					.text(1 + izbor.nextInt(BR_KOCKICA) + "")
					.prefWidth(30)
					.prefHeight(30)
					.onAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							checkovi[I].setSelected(!checkovi[I].isSelected());
									// invertovanje stanja odgovarajuceg CheckBox-a:
									// selektovan - nije selektovan
						}
					})
					.build();
			
			grid.add(kockice[i], i, 0); // sta se dodaje, u koju kolonu i koju vrstu
			
			checkovi[i] = CheckBoxBuilder.create()
					//.style("-fx-border-color: blue")
					.translateX(2) // transliranje za 2 piksela zbog malo praznog prostora desno
								// otkomentarisati gornji red, pa videti
					.build();
			
			GridPane.setHalignment(checkovi[i], HPos.CENTER);
						// checkovi[i] ce biti centriran po horizontali u svom polju grid-a
			
			grid.add(checkovi[i], i, 1);
					// i je indeks kolone, a 1 vrste u koju se dodaje cvor checkovi[i]
		}
		
		vb.getChildren().add(0, grid); // grid se dodaje na poziciju 0 u listi dece za vb
									   // pa ce biti na njegovom vrhu
	}

}
