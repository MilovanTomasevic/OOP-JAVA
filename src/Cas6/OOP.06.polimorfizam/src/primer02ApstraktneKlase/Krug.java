package primer02ApstraktneKlase;

public class Krug extends Elipsa {
	public Krug(Tacka centar, double r) {
		// Poziva se konstruktor Elipsa(Tacka c, double a, double b)
		super(centar, r, r);
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

	public double getR() {
		return getA();
	}

	@Override
	public String toString() {
		return "Krug{centar = " + getCentar() + " r = " + getR() + "}";
	}
}
