package nemaDusko;

import java.util.Random;

/* Klasa opisuje zeca iz magicnog sesira */
public class Zec{

	// niz osnovnih imena zeceva 
	private static String[] imenaZeceva = {"Dusko", "Peka", "Zeka", "Djura"};
	// brojaci - koliko je kojih imena vec upotrebljeno 
	private static int[] brZeceva = new int[imenaZeceva.length];
	// generator pseudo-slucajnih brojeva
	private static Random izbor = new Random();
			
	// svaki zec ima svoje (jedinstveno) ime
	private String ime;
	
	public Zec() {
		int indeks = izbor.nextInt(imenaZeceva.length);
		// pre dopisivanja broja na slucajno izabrano
		// osnovno ime
		// neophodno je najpre uvecati odgovarajuci brojac
		ime = imenaZeceva[indeks] + (++brZeceva[indeks]);
	}
	
	public String getIme() {
		return ime;
	}
	
	public String toString(){
		return ime;
	}
}
