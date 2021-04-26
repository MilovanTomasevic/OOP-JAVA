package primer01Polimorfizam;

public class Pravougaonik extends Oblik {
	private double sirina, visina;

	public Pravougaonik(Tacka centar, double sirina, double visina) {
		// Poziva konstruktor Oblik(Tacka c)
		super(centar);
		init(sirina, visina);
	}

	public Pravougaonik(double x, double y, double sirina, double visina) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
		init(sirina, visina);
	}

	public Pravougaonik(double sirina, double visina) {
		// Implicitno se poziva konstruktor Oblik()
		init(sirina, visina);
	}

	/// Konstruktor kopije
	public Pravougaonik(Pravougaonik p) {
		super(p); 	// implicitno kastovanje navise: Pravougaonik -> Oblik
		init(p.sirina, p.visina);
	}

	// private metodi se ne nasledjuju
	private void init(double sirina, double visina) {
		this.visina = visina;
		this.sirina = sirina;
	}

	public double getSirina() {
		return sirina;
	}

	public double getVisina() {
		return visina;
	}

	@Override
	public double getObim() {
		return 2*sirina + 2*visina;
	}

	@Override
	public double getPovrsina() {
		return sirina * visina;
	}

	// Vraca duzinu dijagonale pravougaonika
	public double getDijagonala() {
		return Math.sqrt(sirina*sirina + visina*visina);
	}

    // Pravi i vraca krug opisan oko tekuceg pravougaonika */
    public Krug opisaniKrug() {
        // Poluprecnik kruga opisanog oko pravougaonika jednak je polovini njegove dijagonale.
        // NAPOMENA: nasledjeni metod getCentar() bazne klase
        // poziva se samo navodjenjem svog imena unutar tela ove klase,
        // na isti nacin kao i metod getDijagonala() definisan u ovoj klasi.
        return new Krug(getCentar(), 0.5*getDijagonala());
    }

	@Override
	public String toString() {
		return "Pravougaonik{" + super.toString() + " sirina = " + sirina + " visina = " + visina + "}";
	}

}
