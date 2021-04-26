package radioButton2;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* TestRadioButton.java:
 * 
 * Verzija 2: 
 * Radio dugmici se smestaju u liste i prilikom pravljenja dugmica se 
 * koriste enumeracije Dan i Vreme. 
 * 
 * Razlog upotrebe listi je sto se za svako radio dugme vezuje 
 * ista obrada dogadjaja: 
 * prikazuje se koja je opcija upravo izabrana.  
 */
public class TestRadioButton extends Application  {

	private enum Dan {ponedeljak, utorak, sreda, cetvrtak, petak};
	private Label lbl = new Label();
    private Label lblTermin = new Label("");
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Radio dugmici");
        
        Label danLbl = new Label("Izaberite dan:");

        HBox hboxDan = new HBox(20);
        ToggleGroup tg = new ToggleGroup();
        List<RadioButton> danDugmici = new ArrayList<>();
        Dan[] dani = Dan.values();
        for(int i = 0; i < dani.length; i++) {
        	RadioButton dugme = new RadioButton(dani[i].toString());
        	dugme.setToggleGroup(tg);
        	dugme.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					lbl.setText("Izabrani dan: ");
					lblTermin.setStyle("-fx-text-fill: blue");
					lblTermin.setText(dugme.getText());
				}
			});
        	danDugmici.add(dugme);
        	hboxDan.getChildren().add(dugme);
        }
        hboxDan.setPadding(new Insets(10));
        hboxDan.setStyle("-fx-border-color: blue");
        VBox vboxDan = new VBox(danLbl, hboxDan);
        vboxDan.setSpacing(10);
        
        HBox hboxVreme = new HBox(20);
        Label vremeLbl = new Label("Izaberite vreme:");
        ToggleGroup tg1 = new ToggleGroup();
        List<RadioButton> vremeDugmici = new ArrayList<>();
        Vreme[] vremena = Vreme.values();
        for(int i = 0; i < vremena.length; i++) {
        	RadioButton dugme = new RadioButton(vremena[i].toString());
        	dugme.setToggleGroup(tg1);
        	dugme.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					lbl.setText("Izabrano vreme: ");
					lblTermin.setStyle("-fx-text-fill: green");
					lblTermin.setText(dugme.getText());
				}
			});
        	vremeDugmici.add(dugme);
        	hboxVreme.getChildren().add(dugme);
        }
        hboxVreme.setPadding(new Insets(10));
        hboxVreme.setStyle("-fx-border-color: green");
        VBox vboxVreme = new VBox(vremeLbl, hboxVreme);
        vboxVreme.setSpacing(10);
        
        Button potvrdiBtn = new Button("Potvrdi");
        HBox hboxTermin = new HBox(potvrdiBtn, lbl, lblTermin);
        hboxTermin.setSpacing(10);
        hboxTermin.setAlignment(Pos.BASELINE_LEFT);
        
        /* obrada dogadjaja */
        potvrdiBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RadioButton danBtn = (RadioButton)tg.getSelectedToggle();
				RadioButton vremeBtn = (RadioButton)tg1.getSelectedToggle();
				lblTermin.setStyle("-fx-text-fill: red");
				lbl.setText("");
				if(danBtn == null && vremeBtn == null)
					lblTermin.setText("Niste izabrali ni dan ni vreme!");
				else if(danBtn == null)
					lblTermin.setText("Niste izabrali dan!");
				else if (vremeBtn == null)
					lblTermin.setText("Niste izabrali vreme!");
				else {
					lbl.setText("Izabrali ste termin: ");
					lblTermin.setText(danBtn.getText() + ", " + vremeBtn.getText());
				}
			}
		});
        
        VBox root = new VBox(vboxDan, vboxVreme, hboxTermin);
        root.setSpacing(20);
        root.setPadding(new Insets(15));
        
        Scene scene = new Scene(root, 450, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
