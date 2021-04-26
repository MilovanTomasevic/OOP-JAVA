package interfejs4;

public class Krug implements Translacija {
	private Tacka centar;
	private double radius;
	
	public Krug(Tacka centar, double radius) {
		this.centar = new Tacka(centar);
		this.radius = radius;	
	}
	
	public Krug(final Krug k) {
		this(k.centar, k.radius);
	}

	/* metodi povrsina(), obim() i opisi() vise ne ispunjavaju uslove
	 * za polimorfno pozivanje
	 */
	public double povrsina() {
		return radius * radius * Math.PI;
	}
	
	public double obim() {
		return 2 * radius * Math.PI;
	}
	
	public Kvadrat opisi(){
		return new Kvadrat(centar, 2*radius);
	}

	// implementacija metoda iz interfejsa Translacija
	// ispunjava uslove za polimorfno pozivanje
	public void pomeri(double deltaX, double deltaY) {
		centar.pomeri(deltaX, deltaY);
	}
	
	public String toString() {
		return "krug: centar u tacki " + centar + " poluprecnik je " + radius;
	}
}
