package interfejs4;

public class Pravougaonik implements Translacija {
	private Tacka centar;
	private double a, b; 
	
	public Pravougaonik(Tacka centar, double a, double b) {
		this.centar = new Tacka(centar);
		this.a = a;
		this.b = b;
	}
	
	public Pravougaonik(final Pravougaonik p) {
		this(p.centar, p.a, p.b);
	}
	
	public double dijagonala() {
		return Math.sqrt(a*a + b*b);
	}
	
	public Krug opisaniKrug() {
		return new Krug(centar, 0.5*dijagonala());
	}
	
	public double getA() {
		return a;
	}
	
	public Tacka getCentar() {
		return centar;
	}
	
	/* metodi povrsina(), obim() i opisi() vise ne ispunjavaju uslove
	 * za polimorfno pozivanje
	 */
	public double povrsina() {
		return a*b;
	}
	
	public double obim() {
		return 2*(a+b);
	}
	
	public Krug opisi(){
		return opisaniKrug();
	}

	// implementacija metoda iz interfejsa Translacija
	// ispunjava uslove za polimorfno pozivanje
	public void pomeri(double deltaX, double deltaY) {
		centar.pomeri(deltaX, deltaY);
	}

	public String toString() {
		return "pravougaonik: centar u tacki " + centar + " a = " + a + " b = " + b;
	}
}
