package primer01Polimorfizam;

public class Oblik {
	// Polje oznacavamo kao private
	private Tacka centar;	// centralna tacka, kojom je odredjena pozicija u ravni

	public Oblik(Tacka centar) {
		// instanca klase Oblik dobija SOPSTVENU KOPIJU tacke od koje se pravi,
		// ne koristi prosledjenu tacku direktno.
		this.centar = new Tacka(centar);
	}

	public Oblik(double x, double y) { centar = new Tacka(x, y); }

    // Ako nam korisnik ne prosledi argumente pri pozivu konstruktora,
    // centar oblika postavljamo na podrazumevanu vrednost (u ovom slucaju (0, 0))
	public Oblik() {
		centar = new Tacka();
	}

	/// Konstruktor kopije.
	public Oblik(final Oblik o) {
		// Mozemo delegirati odgovornost vec implementiranom konstruktoru.
		this(o.centar);
	}

	public Tacka getCentar() {
		return centar;
	}

    /* Polimorfni metodi getPovrsina() i getObim() */

    // U klasi Oblik ne znamo kako bismo implementirali ova dva metoda
    // jer nam nije poznato koji je oblik u pitanju.
    // Metodi vracaju podrazumevanu vrednost povratnog tipa.
    public double getPovrsina() {
        return 0;
    }

    public double getObim() {
	    return 0;
    }

    /* Racuna i vraca rastojanje od centra tekuceg oblika (this) do
     * centra datog oblika p.
     * Nasledjuje se u izvedenim klasama, jer je public.
     * Parametar p metoda je tipa bazne klase Oblik
     * te ce kao stvarni argument moci da se prosledi
     * referenca na objekat tipa Oblik,
     * ali i referenca na objekat bilo koje izvedene klase
     * pri cemu se onda vrsi
     * implicitno kastovanje navise kroz hijerarhiju klasa
     */
    public double rastojanjeDoCentra(Oblik p) {
        return centar.distance(p.centar);
    }

    public String toString() {
		return "centar = " + centar;
	}
}
