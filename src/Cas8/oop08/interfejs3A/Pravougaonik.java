package interfejs3A;

/** Klasa Pravougaonik implementira interfejse Povrsina, Obim i Opisivanje. 
 *  Nema vise bazne apstraktne klase Povrs.
 */
public class Pravougaonik implements Povrsina, Obim, Opisivanje {

	private Tacka centar;
	private double a;
	private double b;
	
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
	
	/** Implementacija apstraktnog metoda iz interfejsa Povrsina 
	 *  racunanje povrsine tekuceg pravougaonika */
	public double povrsina() {
		return a*b;
	}
	
	/** implementacija metoda iz interfejsa Obim
	 *  racunanje obima tekuceg pravougaonika */
	public double obim() {
		return 2*(a+b);
	}
	
	/** implementacija metoda iz interfejsa Opisivanje
	 *  poziva prethodno definisani metod opisaniKrug() */
	public Krug opisi() {
		return opisaniKrug();
	}
	
	/** implementacija preostalih metoda iz interfejsa Opisivanje */
	
	public double rastojanjeDoCentra(Opisivanje p) {
		return centar.rastojanje(p.getCentar());
	}
	
	/** Vraca centralnu tacku pravougaonika; bice nasledjen u izvedenoj klasi Kvadrat */
	public Tacka getCentar() {
		return centar;
	}
	
	/** Vraca duzinu stranice a; bice nasledjen u izvedenoj klasi Kvadrat */
	public double getA() {
		return a;
	}
	
	public String toString() {
		return "pravougaonik: centar u tacki " + centar + " a = " + a + " b = " + b;
	}
}
