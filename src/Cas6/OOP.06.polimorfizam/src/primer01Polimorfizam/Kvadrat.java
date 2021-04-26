package primer01Polimorfizam;

public class Kvadrat extends Pravougaonik {
	public Kvadrat(Tacka c, double a) {
		// Poziva se konstruktor Pravougaonik(Tacka c, double sirina, double visina)
		super(c, a, a);
	}

	public Kvadrat(double x, double y, double a) {
		// Poziva se konstruktor Pravougaonik(double x, double y, double sirina, double visina)
		super(x, y, a, a);
	}
	
	public Kvadrat(double a) {
		// Poziva se konstruktor Pravougaonik(double sirina, double visina)
		super(a, a);
	}

	/// Konstruktor kopije
	public Kvadrat(Kvadrat t) {
		// Poziva se konstruktor kopije Pravougaonik(Pravougaonik p)
		// i vrsi se implicitno kastovanje navise Kvadrat -> Pravougaonik
		super(t);
	}

	public double getDuzinaStranice() {
		return getSirina();
	}

	@Override
	public String toString() {
		// nije moguce super.super.toString()
		return "Kvadrat{centar = " + getCentar() +  " a = " + getDuzinaStranice() + "}";
	}
}
