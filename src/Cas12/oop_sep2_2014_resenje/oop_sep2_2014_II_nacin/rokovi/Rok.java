package rokovi2;

public class Rok implements Comparable<Rok> {
	private String rok;
	private double prOcena;
	private int brDesetki;
	
	public Rok(String rok, double prOcena, int brDesetki) {
		this.rok = rok;
		this.prOcena = prOcena;
		this.brDesetki = brDesetki;
	}

	public String getRok() {
		return rok;
	}
	
	public double getPrOcena() {
		return prOcena;
	}
	
	public int getBrDesetki() {
		return brDesetki;
	}
	
	public int compareTo(Rok o) {
		return Double.compare(o.prOcena, prOcena);
	}
	
	public String toString() {
		return rok;
	}
}
