package osobe;

import java.util.Objects;

public class Osoba implements Comparable<Osoba> {

	private String ime;
	private String prezime;
	private int godiste;
	
	public Osoba(String ime, String prezime, int godiste){
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
	}
	
	/* za sortiranje leksikografski po prezimenu i imenu;
	 * za sortiranje po godinama starosti rastuce bice koriscen komparator
	 * (objekat anonimne klase koja implementira interfejs Comparator<>)
	 */
	@Override
	public int compareTo(Osoba o) {
		int rez = prezime.compareTo(o.prezime);
		if(rez != 0)
			return rez;
		rez = ime.compareTo(o.ime);
		if(rez != 0)
			return rez;
		return Integer.compare(o.godiste, godiste);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(!(obj instanceof Osoba))
			return false;
		return compareTo((Osoba)obj) == 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime, godiste);
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public int getGodiste() {
		return godiste;
	}
	
	public String toString(){
		return prezime + " " + ime + " " + godiste;
	}
}
