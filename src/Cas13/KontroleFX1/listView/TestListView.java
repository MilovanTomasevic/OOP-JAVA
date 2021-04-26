package listView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 * Primer upotrebe ListView
 * 
 * modifikacija primera sa adrese 
 * https://blogs.oracle.com/turuga/entry/working_with_listview
 * 
 */

public class TestListView extends Application {

	private ListView<String> lvImena; 
	private TextField txfPromeni;
	private TextField txfDodaj;
	
	private ObservableList<String> imena = FXCollections.observableArrayList("Pera", "Mika", "Laza");
	
	@Override
	public void start(Stage primaryStage) {

		Scene scene = SceneBuilder.create()
				.width(600)
				.height(400)
				.root(kreirajScenu())
				.build();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ListView");
		primaryStage.show();
	}	

	private Parent kreirajScenu() {
		
		VBox rez = VBoxBuilder.create()
				.spacing(20)
				.padding(new Insets(10))
				.children(kreirajListView(), kreirajPromeniPanel(), kreirajBtnObrisi(), kreirajDodajPanel())
				.build();
		
		return rez;
	}
	
	private Node kreirajListView() {
		lvImena = new ListView<String>();
		lvImena.setItems(imena); // povezivanje sa listom ciji sadrzaj prikazuje
		lvImena.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			
			// metod se poziva svaki put kada se promeni izabrana stavka liste
			// (prvi put oldValue je null)
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				txfPromeni.setText(newValue);
			}
		});
		
		return lvImena;
	}


	private Node kreirajPromeniPanel() {
		FlowPane rez = FlowPaneBuilder.create()
				.hgap(5)
				.vgap(10)
				.children(new Label("Promeni izabrano ime:"), kreirajTxfPromeni())
				.build();
		return rez;
	}

	private Node kreirajTxfPromeni() {
		txfPromeni = TextFieldBuilder.create()
				.promptText("Izabrano ime...")
				.tooltip(new Tooltip("Nakon promene imena pritisnuti Enter..."))
				.onAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// indeks izabrane stavke u ListView
						int indeks = lvImena.getSelectionModel().getSelectedIndex();
						// ukoliko nijedna stavka nije izabrana, gornji metod vraca vrednost -1
						if(indeks != -1)
							// unetim stringom menja se odgovarajuci element u ObservableList
							imena.set(indeks, txfPromeni.getText());
					}
				})
				.build();
		
		return txfPromeni;
	}

	private Node kreirajBtnObrisi() {
		Button rez = ButtonBuilder.create()
				.text("Obrisi izabrano ime")
				.onAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// indeks izabrane stavke u ListView
						int indeks = lvImena.getSelectionModel().getSelectedIndex();
						if(indeks != -1)
							imena.remove(indeks);
						lvImena.getSelectionModel().select(-1); // nije izabrano nista
					}
				})
				.build();
		return rez;
	}

	private Node kreirajDodajPanel() {
		FlowPane rez = FlowPaneBuilder.create()
				.hgap(5)
				.vgap(10)
				.children(new Label("Dodaj ime:"), kreirajTxfDodaj())
				.build();
		return rez;
	}

	private Node kreirajTxfDodaj() {
		txfDodaj = TextFieldBuilder.create()
				.promptText("Novo ime...")
				.tooltip(new Tooltip("Nakon unosa novog imena pritisnuti Enter..."))
				.onAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						imena.add(txfDodaj.getText());
						lvImena.getSelectionModel().selectLast(); // izabira se upravo uneta stavka
						txfDodaj.setText("");
					}
				})
				.build();
		
		return txfDodaj;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
