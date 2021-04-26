package primer02ApstraktneKlase;

// Ne proverava se da li se od datih tacaka moze formirati trougao
public class Trougao extends Oblik {
	private Tacka a, b, c;

	public Trougao(Tacka centar, Tacka a, Tacka b, Tacka c) {
		super(centar);
		init(a, b, c);
	}

	public Trougao(Tacka a, Tacka b, Tacka c) {
		// implicitni poziv: super();
		init(a, b, c);
	}

	public Trougao(final Trougao t) {
		super(t);  // implicitno kastovanje navise: Trougao -> Oblik
		init(t.a, t.b, t.c);
	}

    // pomocni metod za inicijalizaciju
    private void init(Tacka a, Tacka b, Tacka c) {
        this.a = new Tacka(a);
        this.b = new Tacka(b);
        this.c = new Tacka(c);
    }

    public Tacka getA() {
		return a;
	}

	public Tacka getB() {
		return b;
	}

	public Tacka getC() {
		return c;
	}

	// duzina stranice AB
	public double getAB() {
		return a.distance(b);
	}

	// duzina stranice BC
	public double getBC() {
		return b.distance(c);
	}

	// duzina stranice CA
	public double getCA() {
		return c.distance(a);
	}

    @Override
    public double getObim() {
        return getAB() + getBC() + getCA();
    }

    @Override
    public double getPovrsina() {
        double o = getObim()/2;
        return Math.sqrt(o * (o - getAB()) * (o - getBC()) * (o - getCA()));
    }

	@Override
	public String toString() {
		return "Trougao{" + super.toString() + " A = " + a + " B = " + b + " C = " + c + "}";
	}
}
