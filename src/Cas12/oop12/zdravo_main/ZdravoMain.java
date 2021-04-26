package zdravo_main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/* JavaFX aplikacije nasledjuju klasu javafx.application.Application 
 * koja omogucava zivotni ciklus aplikacijama, 
 * kroz funkcije kao sto su pokretanje i zaustavljanje.
 */
public class ZdravoMain extends Application {
	
	/* U metodu main() poziva se metod launch() klase Application i prosledjuju
	 * mu se eventualni argumenti komandne linije.
	 * 
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/* Nakon pokretanja aplikacije, interno se vrsi poziv metoda start() nakon
	 * cega je programeru na raspolaganju JavaFX objekat Stage -
	 * javafx.stage.Stage za dalju upotrebu.
	 */
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Zdravo");
		
		/* Prikaz grafickog korisnickog interfejsa idejno je slican pozoristu, 
		 * gde se predstava igra na bini ispred publike. 
		 * Zbog toga se na jednu binu (javafx.stage.Stage) moze postaviti veci
		 * broj scena (javafx.scene.Scene) na kojima se odigravaju 'predstave'.
		 * 
		 * Graf scene je drvoliki skup podataka gde postoji jedinstven cvor 
		 * koji nema roditelja, koreni cvor (root).   
		 * Preostali cvorovi imaju jednog roditelja i svaki čvor je 
		 * ili list (bez dece) ili grana (ima barem jedno dete). 
		 * 
		 * Cvorovi-grane su specificno tipa javafx.scene.Parent cije su potklase
		 * Group, Region i Control.
		 */
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);

		/* Node je bazna klasa za predstavljanje cvorova grafa scene. Najcesce
		 * se koriste cvorovi kontrole ulaza/izlaza.
		 */

		/* Labele se koriste kao tekst kontrole kojima ne moze da se menja
		 * sadrzaj od strane korisnika.
		 */
		
		/* Label() - pravi labelu sa praznim stringom 
		 * Label(String text) - pravi labelu sa zadatim tekstom
		 * Label(String text, Node graphic) - pravi labelu sa zadatim tekstom i ikonicom
		 */
		Label label = new Label("Dugme: ");
		root.getChildren().add(label); // dodavanje jednog cvora u listu cvorova dece za koreni cvor

		/* Dugme - jednostavna kontrola 
		 * Konstruktori: 
		 * Button() - pravi dugme sa praznim stringom kao labelom
		 * Button(String text) - pravi dugme sa zadatim tekstom kao labelom
		 * Button(String text, Node graphic) - pravi dugme sa zadatim tekstom i ikonicom
		 * kao labelom.
		 */
		Button dugme = new Button();
		dugme.setText("Zdravo");
		root.getChildren().add(dugme);

		/* Nakon dodavanja cvorova, scena se postavlja na binu i poziva se metod
		 * show() za prikaz JavaFX prozora. */

		/* Posto nije izvrseno pozicioniranje labele i dugmeta, oba cvora se pozicioniraju podrazumevano,
		 * u koordinatni pocetak, pa ce samo dugme biti viljivo na prozoru. */
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
