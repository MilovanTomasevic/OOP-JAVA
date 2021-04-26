package stek;

import java.util.Collections;
import java.util.Stack;

/* klasa Stack<> je izvedena iz klase Vector<>
 * pa se za objekat mogu pozivati svi metodi
 * nasledjeni od klase Vector<>, ali i:
 * push() - "guranje" objekta na vrh steka
 * pop() - skidanje objekta sa vrha steka
 * peek() - "zavirimo" u vrh steka (ali ne skidamo objekat)
 * search() - trazenje pozicije elementa na steku
 *            pozicija vrha steka je 1, jedna ispod 2, itd.
 *            ako nema trazenog elementa, metod vraca -1. 
 * empty() - da li je stek prazan (poziva se pre pop(),
 *           kako bi se sprecilo izbacivanje EmptyStackException)
 */
public class Spil {
	
	// spil je predstavljen stekom karata
	// jer se karte dele tako sto se jedna po jedna
	// karta skida sa vrha spila
	private Stack<Karta> spil = new Stack<>();
	
	public Spil(){
		// za svaku boju i svaku vrednost
		// kreira se odgovarajuca karta i
		// smesta na vrh spila
		// Boja.values() vraca niz svih konstanti
		// enumeracije tipa Boja
		for(Boja b: Boja.values())
			// Vrednost.values() vraca niz svih konstanti enumeracije tipa Vrednost
			for(Vrednost v: Vrednost.values())
				spil.push(new Karta(b,v));
	}
	
	// mesanje elemenata kolekcije na slucajan nacin
	public void promesaj(){
		Collections.shuffle(spil);
	}
	
	// kreira se prazna ruka
	// a zatim brKarata puta
	// skida karta sa vrha spila i dodaje u ruku
	// metod vraca tako kreiranu ruku
	// (ako na spilu nema dovoljno karata, bice dato
	//  onoliko koliko ih ima, mozda i 0)
	// Svaki put kada se nesto zeli skinuti sa vrha steka,
	// treba prethodno proveriti da stek nije prazan jer
	// u slucaju pokusaja skidanja elementa sa praznog steka
	// dolazi do izbacivanja izuzetka tipa 
	// EmptyStackException
	public Ruka podeliRuku(int brKarata){
		Ruka ruka = new Ruka();
		for(int i = 0; i < brKarata; i++)
			// ako ima karata na spilu (tj. stek nije prazan)
			if(!spil.empty())
				ruka.dodajKartu(spil.pop());
			else
				break;
		return ruka;
	}
	
	public String toString(){
		StringBuilder rez = new StringBuilder();
		for(Karta k: spil)
			rez.append(k+" ");
		return rez.toString();
	}

}
