package tekstualne;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Primer upotrebe kontrola za unos i prikaz teksta: Label, TextField i TextArea
 * 
 * @author Marija
 *
 */

public class Label_TextField_TextArea extends Application {
	
	private TextField txfPolje;
	private TextArea taOblast;
	

	@Override
	public void start(Stage primaryStage) {

		Scene scene = SceneBuilder.create()
				.width(300)
				.height(400)
				.root(kreirajScenu())
				.build();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Label, TextField, TextArea");
		primaryStage.show();
		
		taOblast.requestFocus(); // kako bi se inicijal	no video promptText u polju,
								 // oblast trazi fokus
	}

	private Parent kreirajScenu() {
		VBox rez = VBoxBuilder.create()
				.spacing(20)
				.padding(new Insets(10))
				.children(kreirajNaslov(), kreirajUnos(), kreirajIspis())
				.build();
		return rez;
	}

	private Node kreirajNaslov() {
		
		Label naslov = LabelBuilder.create()
				.text("Cvorovi za unos i	 prikaz teksta: Label, TextField, TextArea")
																				// velicina fonta
				.font(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.ITALIC, 15))
				.graphic(ImageViewBuilder.create()
							.image(new Image(getClass().getResource("../ikonice/Girls - Blue Dress.png").toExternalForm()))
							.fitHeight(100)
							.fitWidth(100)
							.build()
						)
				.graphicTextGap(30) // rastojanje izmedju slike i teksta
				.cursor(Cursor.DEFAULT) // izgled kursora misa kada je iznad ovog cvora
				.rotate(-10) // rotacija za 10 stepeni u smeru suprotnom od kazaljke na satu
				.textFill(Color.BLUEVIOLET) // boja teksta
				.tooltip(new Tooltip("Labela sa slicicom, zarotirana 10 stepeni u smeru suprotnom od kazaljke na satu"))
											// dodatne informacije koje se prikazuju kada je mis iznad cvora
				.underline(true) // tekst je podvucen
				.wrapText(true) // vrsi se prelom teksta kada sirina labele nije dovoljna
				//.style("-fx-border-color: gray")
				.build();
		return naslov;
	}

	private Node kreirajUnos() {
		FlowPane rez = FlowPaneBuilder.create()
				.alignment(Pos.BOTTOM_LEFT)
				.hgap(10)
				.vgap(10)
				.children(kreirajLabelu(), txfPolje)
				.build();
		
		return rez;
	}

	private Node kreirajLabelu() {
		Label labela = LabelBuilder.create()
				.text("_Nadovezi na sadrzaj oblasti:") // mnemonik je slovo ispred koga je _
				.mnemonicParsing(true) // proverava se da li tekst labele sadrzi karakter _
				.labelFor(txfPolje = kreirajTextField()) // prilikom koriscenja mnemonika, fokus se
														 // salje cvoru txfPolje
						// koriscenje mnemonika: istovremeno pritisnuti tipku "Alt" i mnemonik (ovde: n)
				.build();

		return labela;
	}

	private TextField kreirajTextField() {
		TextField txf = TextFieldBuilder.create()
				.promptText("Kad uneses nesto, pritisni Enter...")
						// tekst koji se prikazuje kada u polju nema teksta koji je uneo
						// korisnik ili koji je programski postavljen
						// korisno umesto tooltip-ova i/ili labela
				.prefWidth(200)
				.tooltip(new Tooltip("Dogadjaj je kada se unutar polja pritisne tipka Enter"))
				.onAction(new EventHandler<ActionEvent>() {
					// metod se izvrsava kada se unutar polja pritisne tipka Enter
					// (kao i kada se koriscenjem mnemonika fokus prebaci na polje)
					@Override
					public void handle(ActionEvent arg0) {
						
						taOblast.appendText(txfPolje.getText()+"\n");
						txfPolje.setText("");
					}
				})
				.build();
		
		return txf;
	}

	private Node kreirajIspis() {
		
		taOblast = TextAreaBuilder.create()
				.editable(false)
				.promptText("Ovde ce biti nadovezivani unosi korisnika...")
				//.cursor(Cursor.HAND)
				//.wrapText(true)
				.tooltip(new Tooltip("Ovde se nadovezuju unosi korisnika, svaki u po jednom redu"))
				.build();

		// taOblast stavljamo u ScrollPane kako bi se po potrebi pojavili klizaci
		ScrollPane rez = ScrollPaneBuilder.create()
				.content(taOblast)
				.fitToHeight(true) // visina oblasti prilagodice se visini ScrollPane
				.fitToWidth(true) // sirina oblasti prilagodice se sirini ScrollPane
				.build();
		
		VBox.setVgrow(rez, Priority.ALWAYS); // rez ce rasti po vertikali tako da popuni svu raspolozivu visinu
		
		return rez;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
