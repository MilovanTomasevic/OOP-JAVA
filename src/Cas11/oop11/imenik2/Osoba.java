package imenik2;

import java.util.Objects;
import java.util.Scanner;

/* Klasa Osoba ne implementira interfejs Comparable<>, pa 
 * ne sadrzi metod compareTo().
 * Za sortiranje ce biti koriscen metod Collections.sort() sa 
 * dva argumenta, gde ce se drugim argumentom zadati kriterijum poredjenja
 * objekata kljuceva u mapi.
 */
public class Osoba {
	
	private String ime, prezime;
	
	public Osoba(String ime, String prezime){
		this.ime = ime;
		this.prezime = prezime;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Osoba))
			return false;
		Osoba o = (Osoba)obj;
		return Objects.equals(prezime, o.prezime) && Objects.equals(ime, o.ime); 
	}
	
	public int hashCode(){
		return Objects.hash(ime, prezime);
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String toString(){
		return prezime + " " + ime;
	}
	
	public static Osoba ucitajOsobu(Scanner sc){
		System.out.println("Unesite ime i prezime osobe:");
		return new Osoba(sc.next(), sc.next());
	}
}
