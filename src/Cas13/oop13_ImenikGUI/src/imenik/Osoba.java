package imenik;

import java.util.Objects;
import java.util.Scanner;

public class Osoba implements Comparable<Osoba> {

	private String ime;
	private String prezime;
	
	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public static Osoba ucitajOsobu(Scanner sc) {
		System.out.println("Unesite ime i prezime osobe: ");
		String ime = sc.next();
		String prezime = sc.next();
		
		return new Osoba(ime.trim(), prezime.trim());
	}

	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}
	
	@Override
	public int compareTo(Osoba o) {
		int rez = this.prezime.compareTo(o.prezime);
		
		if(rez == 0)
			return this.ime.compareTo(o.ime);
		else
			return rez;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Osoba))
			return false;
		
		return this.compareTo((Osoba)obj) == 0;
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}

}
