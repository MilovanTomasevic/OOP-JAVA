package primer02ApstraktneKlase;

public class Elipsa extends Oblik {
   	private double a, b;

	public Elipsa(Tacka centar, double a, double b) {
	    // Poziva se konstruktor Oblik(Tacka t)
		super(centar);
		init(a, b);
	}

	public Elipsa(double x, double y, double a, double b) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
	    init(a, b);
	}

	public Elipsa(double a, double b) {
		// Implicitno se poziva konstruktor Oblik()
		init(a, b);
	}

	/// Konstruktor kopije
	public Elipsa(Elipsa p) {
		super(p); // implicitno kastovanje navise: Elipsa -> Oblik
		init(a, b);
	}

	// private metodi se ne nasledjuju
	private void init(double a, double b) {
		this.a = a;
		this.b = b;
	}

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    // Jedna od poznatih aproksimacija obima elipse.
    public double getObim() {
        double h = ((a-b)*(a-b))/((a+b)*(a+b));
        return Math.PI * (a + b) * (1 + 1/4*h + 1/64*h*h + 1/256*h*h*h);
    }

    @Override
    public double getPovrsina() {
        return a * b * Math.PI;
    }

    @Override
    public String toString() {
        return "Elipsa{" + super.toString() + " a = " + a + " b = " + b + "}";
    }
}
