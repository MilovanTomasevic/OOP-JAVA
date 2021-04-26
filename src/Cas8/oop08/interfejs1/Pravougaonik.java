package interfejs1;

public class Pravougaonik extends Povrs {

	private double a;
	private double b;
	
	public Pravougaonik(double a, double b) {
		// super();
		this.a = a;
		this.b = b;
	}
	
	public Pravougaonik(Tacka centar, double a, double b) {
		super(centar);
		this.a = a;
		this.b = b;
	}
	
	public Pravougaonik(final Pravougaonik p) {
		super(p);
		a = p.a;
		b = p.b;
	}
	
	public double dijagonala() {
		return Math.sqrt(a*a + b*b);
	}
	
	public Krug opisaniKrug() {
		return new Krug(getCentar(), 0.5*dijagonala());
	}
	
	/** 
	 * Implementacija apstraktnog polimorfnog metoda.
	 */
	public double povrsina() {
		return a*b;
	}
	
	public double getA() {
		return a;
	}
	
	public String toString() {
		return "pravougaonik " + super.toString() + " a = " + a + " b = " + b;
	}
}
