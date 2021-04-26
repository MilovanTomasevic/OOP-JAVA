package agencija;

public class Ponuda implements Comparable<Ponuda> {

	private String agencija;
	private String nazivDestinacije;
	private Datum datumPolaska;
	private int brojNocenja;
	private int cena;
	
	public Ponuda(String agencija, String nazivDestinacije, Datum datumPolaska, int brojNocenja, int cena) {
		this.agencija = agencija;
		this.nazivDestinacije = nazivDestinacije;
		this.datumPolaska = datumPolaska;
		this.brojNocenja = brojNocenja;
		this.cena = cena;
	}
	
	public int getCena() {
		return cena;
	}

	public Datum getDatumPolaska() {
		return datumPolaska;
	}

	@Override
	public String toString() {
		return nazivDestinacije + ": " + agencija + " " + datumPolaska + " " + brojNocenja + " " + cena;
	}

	@Override
	public int compareTo(Ponuda o) {
		return this.cena - o.cena;
	}

}
