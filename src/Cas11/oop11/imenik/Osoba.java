package imenik;

import java.util.Objects;
import java.util.Scanner;

/**
 * Klasa Osoba opisuje kljuceve u mapi. 
 * Iz tog razloga je neophodno predefinisati metode:
 * equals() i hashCode().
 * Implementacija interfejsa Comparable<> je neophodna
 * za potrebe sortiranja objekata kljuceva. 
 */
public class Osoba implements Comparable<Osoba> {
	
	private String ime, prezime;
	
	public Osoba(String ime, String prezime){
		this.ime = ime;
		this.prezime = prezime;
	}

	@Override
	public int compareTo(Osoba o) {	
		int rez = prezime.compareTo(o.prezime);
		if(rez==0)
			return ime.compareTo(o.ime);
		return rez;
	}
	
	/* equals() i hashCode() treba da koriste isti skup atributa i
	 * treba da vazi relacija:
	 * objekti za koje equals() vrati true (tj. koji su jednaki) treba da imaju isti hes kod. 
	 */

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Osoba))
			return false;
		return compareTo((Osoba)obj) == 0;
	}

	@Override
	public int hashCode() {
		// Staticki metod hash() klase java.util.Objects generise hes kod na osnovu date liste atributa (argumenata).
		// Metod moze da ima proizvoljan broj argumenata univerzalnog tipa Object. 
		// Ne generise dobar hes kod kada se koristi samo jedan atribut klase, pa je preporuka da se u tu svrhu koristi
		// metod Objects.hashCode(Object). 
		return Objects.hash(prezime, ime);
	}
	
	@Override
	public String toString(){
		return prezime + " " + ime;
	}
	
	/* staticki metod za ucitavanje osobe */
	public static Osoba ucitajOsobu(Scanner sc){
		System.out.println("Unesite ime i prezime osobe:");
		return new Osoba(sc.next(), sc.next());
	}
}
