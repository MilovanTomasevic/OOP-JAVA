package anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnagramTest extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Generator anagrama");
		// velicina prozora aplikacije ne moze da se menja
		primaryStage.setResizable(false);
		
		/* koreni cvor */
		VBox main = new VBox();
		
		/* prvo dete - layout cvor: HBox */
		HBox top = new HBox();
		top.setSpacing(50);
			
		/* HBox cvor ima sledecu decu: 
		 * VBox left i VBox right */
		VBox left = new VBox();
		left.setSpacing(10);
		left.setPadding(new Insets(10, 0, 0, 10));
		Label unosLbl = new Label("Unesite Vase ime:");
		TextField unosTF = new TextField();
		unosTF.setMaxWidth(150);
		left.getChildren().addAll(unosLbl, unosTF);
		
		VBox right = new VBox();
		right.setSpacing(10);
		right.setPadding(new Insets(20, 0, 0, 0));
		Button unosBtn = new Button("Potvrdi");
		unosBtn.setPrefWidth(150);
		Button ocistiBtn = new Button("Ocisti");
		ocistiBtn.setPrefWidth(150);
		Button izadjiBtn = new Button("Izadji");
		izadjiBtn.setPrefWidth(150);
		right.getChildren().addAll(unosBtn, ocistiBtn, izadjiBtn);
		
		top.getChildren().addAll(left, right);
		
		/* drugo dete - layout cvor: VBox */		
		VBox bottom = new VBox(10);
		bottom.setPadding(new Insets(0, 0, 0, 10));
		
		/* VBox cvor ima sledecu decu: 
		 * Label ispisLbl, TextArea ispisTA, Label porukaLbl */
		Label ispisLbl = new Label();
		ispisLbl.setText("Ispis: ");

		TextArea ispisTA = new TextArea();
		/* nije moguce uneti tekst sa tastature u ispisTA */
		ispisTA.setEditable(false);
		ispisTA.setMaxWidth(350);
		
		Label porukaLbl = new Label("");
		
		bottom.getChildren().addAll(ispisLbl, ispisTA, porukaLbl);		
		
		main.getChildren().add(top);
		main.getChildren().add(bottom);
		
		/* akcija za dugme unosBtn - klikom na dugme izvrsava se metod handle(). 
		 * 
		 * Nakon sto se otkuca new, treba pozvati Content Assist (Ctrl-space) i 
		 * iz padajuceg menija izabrati prvu stavku: 
		 * EventHandler() Anonymous Inner Type
		 * nakon cega ce biti dodat skelet kompletnog potrebnog koda. 
		 * 
		 * Pravi se objekat anonimne klase koja implementira interfejs EventHandler<ActionEvent>.
		 * Anonimna klasa se ujedno i definise implementacijom metoda handle().
		 */
		unosBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			/* metod handle() kao argument ima referencu 'event' na sam objekat 
			 * dogadjaj (koji je tipa ActionEvent).
			 * Za dogadjaj se moze metodom getSource() dobiti referenca na 
			 * cvor grafa nad kojim se dogadjaj desio (event.getSource()).
			 */
			public void handle(ActionEvent event) {
				porukaLbl.setText("");
				String unetoIme = unosTF.getText();
				if(!unetoIme.equals(""))
					ispisTA.setText("Dragi/draga " + unetoIme + ", "
								             + "\n\n"
							                 + "Anagram Vaseg imena glasi:\n" + izracunajAnagram(unetoIme) + "."
							                 + "\n\n\n"
							                 + "Pozdrav,"
							                 + "\n"
							                 + "Vasa Aplikacija");
				else {
					ispisTA.setText("");
					porukaLbl.setTextFill(Color.RED);
					porukaLbl.setText("Upisite svoje ime!");
				}
			}
		});
		
		ocistiBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				unosTF.setText("");
				porukaLbl.setText("");
				ispisTA.setText("");
			}
			
		});
		
		izadjiBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});
		
		Scene scene = new Scene(main, 370, 360);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/* 
	 * metod koji generise anagram za dato ime (nisku) 
	 * I nacin: */
	public static String izracunajAnagram(String unetoIme) {
		/* lista koja ce sadrzati pojedinacne karaktere date niske */
		ArrayList<Character> chars = new ArrayList<>();
		for(int i = 0; i < unetoIme.length(); i++)
			// dodavanje u listu 
			// (implicitna konverzija char -> Character, tj. autoboxing)
			chars.add(unetoIme.charAt(i));
		// na slucajan nacin se promesaju elementi kolekcije
		Collections.shuffle(chars);
		StringBuilder anagram = new StringBuilder();
		for(Character c : chars)
			anagram.append(c); // implicitna konverzija Character -> char, tj. autounboxing
		return anagram.toString();
	}
	
	/* metod koji generise anagram za dato ime (nisku) 
	 * II nacin: */
//	public static String izracunajAnagram(String unetoIme) {
//		char[] karakteri = unetoIme.toCharArray();
//		
//		Random r = new Random();
//		int n = karakteri.length;
//		ArrayList<Integer> izvuceniIndeksi = new ArrayList<>();
//		
//		StringBuilder anagram = new StringBuilder();
//		for(int i = 0; i < n; ) {
//			int indeks = r.nextInt(n);
//			
//			if(!izvuceniIndeksi.contains(indeks)) {
//				izvuceniIndeksi.add(indeks);
//				char c = karakteri[indeks];
//				anagram.append(c);
//				i++;
//			}		
//
//		}
//		return anagram.toString();
//	}
	
}
