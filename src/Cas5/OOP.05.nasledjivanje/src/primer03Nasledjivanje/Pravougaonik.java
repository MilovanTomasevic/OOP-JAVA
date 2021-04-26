package primer03Nasledjivanje;

public class Pravougaonik extends Oblik {
	/* Pored svega sto ima Oblik (centralne tacke)
	 * pravougaonik ima jos i... */

	// Polja oznacavamo kao protected kako bi im mogli
	// DIREKTNO pristupiti iz potklase (klase Kvadrat).
	protected double sirina, visina;

	/* Objekat izvedene klase ima sve sto ima i objekat bazne klase
	 * i jos ono sto je definisano u izvedenoj klasi
	 * pa je u konstruktoru potrebno izvrsiti
	 * inicijalizaciju svih polja
	 * (ovde: i centralne tacke (bazni deo) i sirine i visine)
	 */

	public Pravougaonik(Tacka centar, double sirina, double visina) {
		// Potrebno je da pozovemo konstruktor natklase (UVEK PRI NASLEDJIVANJU)
		// za inicijalizaciju baznog dela objekta i to mora
		// da bude prva naredba!
		// koristimo sintaksu slicnu this(...) osim sto koristimo super;
		// super je u stvari referenca na bazni deo objekta, dok se
		// sa super(...) obracamo konkretnom konstruktoru bazne klase
		// Ako se to izostavi, kompajler implicitno pokusava da pozove
		// podrazumevani konstruktor natklase:
		// super();
		// a ukoliko njega nema, dobija se poruka o gresci

		// Poziva konstruktor Oblik(Tacka c)
		super(centar);

		// Koristimo privatnu funkciju 'init' koja inicijalizuje sirinu i visinu
		// kako bi smanjili visestruko ponavljanje iste logike.
		init(sirina, visina);
	}

	public Pravougaonik(double x, double y, double sirina, double visina) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
		init(sirina, visina);
	}

	public Pravougaonik(double sirina, double visina) {
		// Poziva konstruktor Oblik()
		super();
		init(sirina, visina);
	}

	/// Konstruktor kopije
	public Pravougaonik(Pravougaonik p) {
		// I varijanta:
		super(p); 	// Inicijalizacija baznog dela objekta:
			// kompaktna, uvek izgleda ovako
			// poziva se konstruktor kopije bazne klase:
			// Oblik(Oblik o)
			// a kao argument mu se prosledi referenca na objekat
			// izvedene klase ciju kopiju pravimo.
			// Ovo je u redu, jer objekat izvedene klase je ujedno
			// i objekat bazne klase
			// (pravougaonik JE oblik, jer je klasa Pravougaonik izvdena iz klase Oblik).

			// vrsi se implicitno kastovanje navise
			// Pravougaonik -> Oblik
		init(p.sirina, p.visina);

		// II varijanta:
		// super(p.centar); // Inicijalizacija baznog dela:
		// umesto konstruktora kopija bazne klase poziva se
		// konstruktor bazne koji prima sve neophodne podatke.
		// init(p.a, p.b);

		// III varijanta:
		// poziva se konstruktor ove klase koji ocekuje sve neophodne podatke
		// this(p.centar, p.sirina, p.visina);
	}

	// private metodi se ne nasledjuju
	private void init(double sirina, double visina) {
		this.visina = visina;
		this.sirina = sirina;
	}

	// public metodi ce biti nasledjeni

	public double getSirina() {
		return sirina;
	}

	public double getVisina() {
		return visina;
	}

	// duzina dijagonale pravougaonika
	public double dijagonala() {
		return Math.sqrt(sirina*sirina + visina*visina);
	}

	// predefinisanje (overriding) nasledjenog metoda
	// toString() natklase
	// ako se donja definicija stavi pod komentar
	// kada izvrsimo program bice pozvan toString() iz natklase
	public String toString() {
		return "Pravougaonik centar = " + centar + " sirina = " + sirina + " visina = " + visina;
	}
}
