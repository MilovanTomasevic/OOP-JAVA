package krug;

// Klasa kojom se opisuje krug. 
// Krug je predstavljen koordinatama centra i poluprecnikom.
public class Krug 
{
	// brojac napravljenih objekata klase Krug
	private static int brojac = 0;
	
	// instancne promenljive
	private double x;
	private double y;
	private double poluprecnik;
	
	// Podrazumevani konstruktor pravi jedinicni krug sa centrom u koordinatnom pocetku.
	public Krug() {
		// Koordinate centra su inicijalno postavljene na 0.0
		poluprecnik = 1.0;
		++ brojac;
	}
	
	// Konstruktor koji pravi krug sa datim koordinatama centra i datim poluprecnikom
	public Krug(double x, double y, double poluprecnik) {
		// Poziv podrazumevanog konstruktora.
		this();
		this.x = x;
		this.y = y;
		this.poluprecnik = poluprecnik;
	}
	
	// Pristupni metod za x koordinatu centra kruga.
	// Metod nije automatski generisan (u suprotnom bi ime metoda bilo getX())
	public double vratiX() {
		return x;
	}
	
	// Pristupni metod za y koordinatu centra kruga.
	public double vratiY() {
		return y;
	}
	
	// Pristupni metod za poluprecnik kruga.
	public double vratiR() {
		return poluprecnik;
	}
	
	// Metod racuna i vraca vrednost obima kruga.
	public double obim() {
		return 2 * poluprecnik * Math.PI;
	}
	
	// Metod racuna i vraca povrsinu kruga.
	public double povrsina() {
		return poluprecnik * poluprecnik * Math.PI;
	}
	
	// Metod ispituje da li je tacka sa zadatim koordinatama u krugu.
	// Tacka je u krugu ukoliko je njeno rastojanje do centra kruga manje od poluprecnika.
	public boolean tackaUKrugu(double x, double y) 	{
		return  Math.sqrt((this.x - x)*(this.x - x) + (this.y - y)*(this.y - y)) < poluprecnik 
				? true : false;
	}
	
	// Pristupni metod za vrednost staticke promenljive brojac. 
	public static int brojKrugova() {
		return brojac;
	}
	
	public String toString() {
		return "Krug: centar (" + x + ", " + y + ") R = " + poluprecnik;
	}
}
