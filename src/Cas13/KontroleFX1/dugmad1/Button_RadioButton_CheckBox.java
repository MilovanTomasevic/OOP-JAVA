package dugmad1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioButtonBuilder;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleGroupBuilder;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * Ilustracija koriscenja dugmadi: Button, RadioButton, CheckBox
 * Listener-i za RadioButton i CheckBox
 * 
 * @author Marija
 *
 */

public class Button_RadioButton_CheckBox extends Application {

	
	private Button dugme;
	
	// radio dugmad uvek idu u grupi
	// Uvek je tacno jedno radio dugme iz grupe selektovano
	// (neophodno je svoj radio dugmadi iz iste grupe pridruziti
	//  isti ToggleGroup objekat)
	private RadioButton rbtPlavo;
	private RadioButton rbtZeleno;
	private RadioButton rbtCrveno;
	
	// check box moze da postoji i sam za sebe, kao ovde
	// (i ako ih je vise, ne grupisu se koriscenjem ToggleGroup objekta)
	private CheckBox cbVidljivo;
	
	private String tekuce; // = "plavo"; // tekuca css klasa
							// "plavo" ce biti postavljeno u metodu changed() za ToggleGroup
	
	@Override
	public void start(Stage primaryStage) {
		
		Scene scene = SceneBuilder.create()
				.width(350)
				.height(400)
				.root(kreirajScenu())
				.stylesheets(getClass().getResource("../style.css").toExternalForm())
				.build();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Button, RadioButton, CheckBox");
		primaryStage.show();
		
	}

	private Parent kreirajScenu() {
		VBox rez = VBoxBuilder.create()
				.spacing(20)
				.padding(new Insets(10))
				.fillWidth(false)
				.children(kreirajDugme(), kreirajRadioDugmad(), kreirajCheckBox())
				.build();
		return rez;
	}

	private Node kreirajDugme() {
		dugme = ButtonBuilder.create()
				.text("Obicno dugme")
				.alignment(Pos.BOTTOM_RIGHT)
				.prefWidth(200)
				.prefHeight(200)
				.textFill(Color.DARKBLUE) // boja teksta na dugmetu
				.font(Font.font("Arial", FontPosture.ITALIC, 15)) 
//				.styleClass(tekuce) // ova naredba ce se izvrsiti u metodu changed() za ToggleGroup
				.underline(true) // tekst je podvucen
				.wrapText(true) // bice prelomljen ako dugme nije dovoljne sirine
							    // (prostirace se kroz veci broj redova)
				.graphic(ImageViewBuilder.create()							
						.fitHeight(100)
						.fitWidth(100)
						.image(new Image(getClass().getResource("../ikonice/dugme.jpg").toExternalForm())).build()
					) 
				.graphicTextGap(10) // rastojanje izmedju slike i teksta
				.tooltip(new Tooltip("Kada se klikne na dugme, ono postane nevidljivo."))
				.build();
		
		dugme.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {		
//				dugme.setVisible(false); // dugme postaje nevidljivo
						// (i dalje zauzima prostor na prozoru)
// gornja naredba ce se izvrsiti u metodu changed() za CheckBox				
				cbVidljivo.setSelected(false); // deselektovanje CheckBox-a
			}
		});
		
		return dugme;
	}

	
	private Node kreirajRadioDugmad() {
		
		// objekat koji vodi racuna da je uvek tacno jedno radio dugme iz njegove grupe
		// selektovano
		ToggleGroup tg = ToggleGroupBuilder.create()
				.build();
		
		rbtPlavo = RadioButtonBuilder.create()
				.text("plavo")
				.id("plavo")
				.textFill(Color.BLUE)
				.toggleGroup(tg) // VAZNO! ovo radio dugme pripada grupi tg
				.build();
		
		rbtZeleno = RadioButtonBuilder.create()
				.text("zeleno")
				.id("zeleno")
				.textFill(Color.GREEN)
				.toggleGroup(tg) // VAZNO! i ovo dugme pripada grupi tg
				.build();
		

		rbtCrveno = RadioButtonBuilder.create()
				.text("crveno")
				.id("crveno")
				.textFill(Color.RED)
				.toggleGroup(tg) // VAZNO! i ovo dugme pripada istoj grupi, tg
				.build();
		
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			// za razliku od handle() koji se pridruzuje svakom radio dugmetu ponaosob
			// i koji se izvrsava samo kada korisnik promeni odabrano radio dugme
			// ovaj metod se izvrsava i kada se programski promeni odabrano radio dugme
			// pomocu metoda setSelected(), sto imamo nekoliko naredbi nize
			public void changed(javafx.beans.value.ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton izabrano = (RadioButton)newValue;
				dugme.getStyleClass().remove(tekuce);
				tekuce = izabrano.getId();
				dugme.getStyleClass().add(tekuce);
			}
		});
		
		tg.getToggles().get(0).setSelected(true); // inicijalno ce biti selektovano prvo radio dugme
					// bice pozvan gornji metod changed()
		
		
		VBox rez = VBoxBuilder.create()
				.spacing(10)
				.padding(new Insets(10))
				.style("-fx-border-color: blue")
				.children(rbtPlavo, rbtZeleno, rbtCrveno)
				.build();
		return rez;
	
	}

	
	private Node kreirajCheckBox() {
	
		cbVidljivo = CheckBoxBuilder.create()
				.text("vidljivo")
				.selected(dugme.isVisible()) // CheckBox je inicijalno selektovan
							// jer je dugme inicijalno vidljivo
/*				.onAction(new EventHandler<ActionEvent>() {
					
					// metod se poziva svaki put kada se klikne na CheckBox
					// (cime se promeni njegovo stanje: selektovano - nije selektovano)
					@Override
					public void handle(ActionEvent event) {
						dugme.setVisible(cbVidljivo.isSelected());
					}
				}) */
				.build();
		
		cbVidljivo.selectedProperty().addListener(new ChangeListener<Boolean>() {
			// metod se poziva svaki put kada se promeni stanje check box-a
			// bilo od strane korisnika, bilo programski - pomocu metoda setSelected()
			@Override
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {

				dugme.setVisible(newValue);
			}
		});
		
		return cbVidljivo;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
