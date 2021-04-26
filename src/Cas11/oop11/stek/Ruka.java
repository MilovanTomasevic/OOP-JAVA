package stek;

import java.util.ArrayList;
import java.util.Collections;

public class Ruka {
	
	// karte u ruci predstavljene su listom karata
	// koja je inicijalno prazna
	private ArrayList<Karta> ruka = new ArrayList<Karta>();
	
	// klasa nema konstruktor: kompajler ce generisati
	// podrazumevani konstruktor sa praznim telom;
	// zahvaljujuci gornjoj naredbi, kreirana ruka
	// ce imati praznu listu karata
	// 
	// ovaj konstruktor se poziva u metodu
	// podeliRuku() klase Spil
	
	// dodavanje zadate karte u ruku
	public void dodajKartu(Karta k){
		ruka.add(k);
	}

	// sortiranje karata u ruci po jacini
	// metod vraca sortiranu ruku karata
	// pa je moguce u test klasi u istoj naredbi
	// podeliti ruku karata, sortirati karte u ruci
	// i izvrsiti naredbu dodele
	public Ruka sortiraj(){
		Collections.sort(ruka);
		return this;
	}
	
	public String toString(){
		StringBuilder rez = new StringBuilder();
		for(Karta k: ruka)
			rez.append(k).append(" ");
		return rez.toString();
	}

}
