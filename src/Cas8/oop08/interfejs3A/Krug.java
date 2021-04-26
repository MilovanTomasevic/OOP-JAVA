package interfejs3A;

/** Klasa Krug implementira interfejse Povrsina, Obim i Opisivanje. 
 *  Nema vise bazne apstraktne klase Povrs.
 */
public class Krug implements Povrsina, Obim, Opisivanje
{
	private Tacka centar;
	private double radius;
	
	public Krug(Tacka centar, double radius) {
		this.centar = new Tacka(centar);
		this.radius = radius;
	}
	
	public Krug(final Krug k) {
		this(k.centar, k.radius);
	}
	
	/** implementacija metoda iz interfejsa Povrsina
     *  racunanje povrsine tekuceg kruga */
	public double povrsina() {
		return radius * radius * Math.PI;
	}
		
	/** implementacija metoda iz interfejsa Obim
	 *  racunanje obima tekuceg kruga */
	public double obim() {
		return 2 * radius * Math.PI;
	}
		
	/** implementacija metoda iz interfejsa Opisivanje
	 *  povratni tip je Kvadrat */
	public Kvadrat opisi() {
		// kvadrat opisan oko kruga ima isti centar
		// i stranicu dva puta duzu od poluprecnika kruga
		return new Kvadrat(centar, 2*radius);
	}
	
	/** implementacija preostalih metoda iz interfejsa Opisivanje */
	
	public double rastojanjeDoCentra(Opisivanje p) {
		// Kako je referenca na objekat konkretne povrsi tipa Opisivanje, 
		// da bi pristup centralnoj tacki bio moguc, neophodno je da 
		// interfejs Opisivanje sadrzi takav metod.   
		return centar.rastojanje(p.getCentar());
	}
	
	public Tacka getCentar() {
		return centar;
	}
	
	public String toString() {
		return "krug: centar u tacki " + centar + " poluprecnik je " + radius;
	}
}
