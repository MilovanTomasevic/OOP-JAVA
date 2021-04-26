package rokovi2;

public class Rok implements Comparable<Rok> {
	private static boolean ocenaSort;
	
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
	
	public int compareTo(Rok o) {
		if(ocenaSort)
			return Double.compare(o.prOcena, prOcena);
		else
			return Integer.compare(o.brDesetki, brDesetki);
	}
	
	public static void setOcenaSort(boolean ocenaSort) {
		Rok.ocenaSort = ocenaSort;
	}
	
	public String toString() {
		if(ocenaSort)
			return rok + ": " + String.format("%.2f", prOcena);
		else
			return rok + ": " + brDesetki;
	}
}
