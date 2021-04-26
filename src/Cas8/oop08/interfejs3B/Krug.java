package interfejs3B;

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
		return new Kvadrat(centar, 2*radius);
	}

	/** metod rastojanjeDoCentra() zadrzava svoje default ponasanje */
	
	public Tacka getCentar() {
		return centar;
	}
	
	public String toString() {
		return "krug: centar u tacki " + centar + " poluprecnik je " + radius;
	}
}
