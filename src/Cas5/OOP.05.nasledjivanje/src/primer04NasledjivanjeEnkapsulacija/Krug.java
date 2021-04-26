package primer04NasledjivanjeEnkapsulacija;

/// Krug je specijalni slucaj elipse (a == b), tako da umesto
/// da implementiramo slicnu funkcionalnost na dva mesta,
/// mozemo naslediti klasu Elipsa i iskoristiti vec
/// postojece funkcionalnosti uz sitne izmene.
public class Krug extends Elipsa {
	public Krug(Tacka c, double r) {
		// Poziva se konstruktor Elipsa(Tacka c, double a, double b)
		super(c, r, r);
	}

	public Krug(double x, double y, double r) {
		// Poziva se konstruktor Elipsa(double x, double y, double a, double b)
		super(x, y, r, r);
	}
	
	public Krug(double r) {
		// Poziva se konstruktor Elipsa(double a, double b)
		super(r, r);
	}

	/// Konstruktor kopije
	public Krug(Krug k) {
		// Poziva se konstruktor kopije Elipsa(Elipsa e)
		// i vrsi se implicitno kastovanje navise Krug -> Elipsa
		super(k);
	}

	// nasledjeni su metodi getCentar(), getA(), getB() i toString()

	public double getPoluprecnik() {
		return getA(); // duzinu poluose 1 dobijamo metodom getA()
	}

	@Override
	public String toString() {
		return "Krug centar = " + getCentar() + " r = " + this.getA();
	}
}
