package radioButton;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/* TestRadioButton.java:
 * 
 * Ilustruje upotrebu radio dugmadi. 
 * Radio dugmad imaju svojstvo da tacno jedno moze biti izabrano u datom trenutku. 
 * To se obezbedjuje smestanjem dugmadi u istu grupu (ToggleGroup).
 * Dugme se deselektuje kada se izabere drugo dugme iz grupe. 
 *  
 * Na sceni se prikazuju dve grupe radio dugmica, 
 * za izbor dana i za izbor vremena.
 * Inicijalno nije izabrano nijedno dugme. 
 * 
 * Nakon izbora dana i vremena, klikom na dugme Potvrdi, 
 * prikazuje se izabrani termin. 
 * Ukoliko se ne izabere neka (ili nijedna) od ponudjenih opcija, 
 * prikazuje se odgovarajuca poruka. 
 */
public class TestRadioButton extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Radio dugmici");
        
        Label danLbl = new Label("Izaberite dan:");

        RadioButton ponedeljakBtn = new RadioButton("ponedeljak");
        // ako zelimo da dugme bude inicijalno selektovano
        //ponedeljakBtn.setSelected(true);
        RadioButton utorakBtn = new RadioButton("utorak");
        RadioButton sredaBtn = new RadioButton("sreda");
        RadioButton cetvrtakBtn = new RadioButton("cetvrtak");
        RadioButton petakBtn = new RadioButton("petak");
        ToggleGroup tg = new ToggleGroup();

        ponedeljakBtn.setToggleGroup(tg);
        utorakBtn.setToggleGroup(tg);
        sredaBtn.setToggleGroup(tg);
        cetvrtakBtn.setToggleGroup(tg);
        petakBtn.setToggleGroup(tg);
        
        HBox hboxDan = new HBox(ponedeljakBtn, utorakBtn, sredaBtn, cetvrtakBtn, petakBtn);
        hboxDan.setSpacing(20);
        hboxDan.setPadding(new Insets(10));
        hboxDan.setStyle("-fx-border-color: blue");
        VBox vboxDan = new VBox(danLbl, hboxDan);
        vboxDan.setSpacing(10);
        
        Label vremeLbl = new Label("Izaberite vreme:");
        
        RadioButton devetBtn = new RadioButton("9-10");
        //devetBtn.setSelected(true);
        RadioButton desetBtn = new RadioButton("10-11");
        RadioButton jedanaestBtn = new RadioButton("11-12");
        ToggleGroup tg1 = new ToggleGroup();

        devetBtn.setToggleGroup(tg1);
        desetBtn.setToggleGroup(tg1);
        jedanaestBtn.setToggleGroup(tg1);
        
        HBox hboxVreme = new HBox(devetBtn, desetBtn, jedanaestBtn);
        hboxVreme.setSpacing(20);
        hboxVreme.setPadding(new Insets(10));
        hboxVreme.setStyle("-fx-border-color: green");
        VBox vboxVreme = new VBox(vremeLbl, hboxVreme);
        vboxVreme.setSpacing(10);
        
        Button potvrdiBtn = new Button("Potvrdi");
        Label lbl = new Label();
        Label lblTermin = new Label("");
        lblTermin.setTextFill(Color.RED);
        HBox hboxTermin = new HBox(potvrdiBtn, lbl, lblTermin);
        hboxTermin.setSpacing(10);
        hboxTermin.setAlignment(Pos.BASELINE_LEFT);
        
        /* obrada dogadjaja */
        potvrdiBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				RadioButton danBtn = (RadioButton)tg.getSelectedToggle();
				RadioButton vremeBtn = (RadioButton)tg1.getSelectedToggle();
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
