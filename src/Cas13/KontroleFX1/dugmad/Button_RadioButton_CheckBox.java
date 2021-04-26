package dugmad;

import javafx.application.Application;
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
 * onAction() za RadioButton i CheckBox
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
	
	private String tekuce = "plavo"; // tekuca css klasa
	
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
				// poravnanje sadrzaja na dugmetu
				.alignment(Pos.BOTTOM_RIGHT)
				.prefWidth(200)
				.prefHeight(200)
				.textFill(Color.DARKBLUE) // boja teksta na dugmetu
				.font(Font.font("Arial", FontPosture.ITALIC, 15)) 
				.styleClass(tekuce)
				.underline(true) // tekst je podvucen
				.wrapText(true) // bice prelomljen ako dugme nije dovoljne sirine
							    // (prostirace se kroz veci broj redova)
				.graphic(ImageViewBuilder.create()
						// visina i sirina koju zauzima slika
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
				dugme.setVisible(false); // dugme postaje nevidljivo
						// (i dalje zauzima prostor na prozoru)
				cbVidljivo.setSelected(false); // deselektovanje checkBox-a
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
				.textFill(Color.BLUE)
				.toggleGroup(tg) // VAZNO! ovo radio dugme pripada grupi tg
				.selected(true)  // "obicno dugme" bice inicijalno plave boje
						// jer je ovo radio dugme inicijalno selektovano
				
				// metod koji se poziva svaki put kada se klikne na ovo radio dugme
				// ovakva obrada dogadjaja pridruzena je svakom radio dugmetu ponaosob.
				// Drugi nacin za reagovanje na promenu izbora radio dugmeta u grupi
				// (koriscenjem objekta ToggleGroup u kombinaciji sa Id-jevima dugmadi)
				// prikazan je u zadatku OsobeFX i paketu dugmad1
				.onAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						dugme.getStyleClass().remove(tekuce);
						tekuce = "plavo";
						dugme.getStyleClass().add(tekuce);
					}
				})
				.build();
		rbtZeleno = RadioButtonBuilder.create()
				.text("zeleno")
				.textFill(Color.GREEN)
				.toggleGroup(tg) // VAZNO! i ovo dugme pripada grupi tg
				.onAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						dugme.getStyleClass().remove(tekuce);
						tekuce = "zeleno";
						dugme.getStyleClass().add(tekuce);
					}
				})
				.build();
		

		rbtCrveno = RadioButtonBuilder.create()
				.text("crveno")
				.textFill(Color.RED)
				.toggleGroup(tg) // VAZNO! i ovo dugme pripada istoj grupi, tg
				.onAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						dugme.getStyleClass().remove(tekuce);
						tekuce = "crveno";
						dugme.getStyleClass().add(tekuce);
					}
				})
				.build();
		
		
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
				.selected(true) // CheckBox je inicijalno selektovan
				.onAction(new EventHandler<ActionEvent>() {
					
					// metod se poziva svaki put kada se klikne na CheckBox
					// (cime se promeni njegovo stanje: selektovano - nije selektovano)
					@Override
					public void handle(ActionEvent event) {
						dugme.setVisible(cbVidljivo.isSelected());
					}
				})
				.build();
		
		return cbVidljivo;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
