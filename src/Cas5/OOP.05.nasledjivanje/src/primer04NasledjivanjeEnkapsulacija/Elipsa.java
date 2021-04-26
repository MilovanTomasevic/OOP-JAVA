package primer04NasledjivanjeEnkapsulacija;

public class Elipsa extends Oblik {

    /* Pored svega sto ima Oblik (centralne tacke)
     * elipsa ima jos i... */

    // Polja oznacavamo kao private
	private double /* poluosa 1 */ a, /* poluosa 2 */ b;

    /* Objekat izvedene klase ima sve sto ima i objekat bazne klase
     * i jos ono sto je definisano u izvedenoj klasi
     * pa je u konstruktoru potrebno izvrsiti
     * inicijalizaciju svih polja
     * (ovde: i centralne tacke (bazni deo) i poluosa)
     */

	public Elipsa(Tacka centar, double a, double b) {
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
		
		// Koristimo privatnu funkciju 'init' koja inicijalizuje poluose elipse
		// kako bi smanjili visestruko ponavljanje iste logike.
		init(a, b);
	}

	public Elipsa(double x, double y, double a, double b) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
		init(a, b);
	}

	public Elipsa(double a, double b) {
		// Poziva konstruktor Oblik()
		super();
		init(a, b);
	}

	/// Konstruktor kopije
	public Elipsa(Elipsa p) {
		// I varijanta:
		super(p); 	// Inicijalizacija baznog dela objekta:
					// kompaktna, uvek izgleda ovako
					// poziva se konstruktor kopije bazne klase:
					// Oblik(Oblik o)
					// a kao argument mu se prosledi referenca na objekat
					// izvedene klase ciju kopiju pravimo.
					// Ovo je u redu, jer objekat izvedene klase je ujedno
					// i objekat bazne klase
					//(elipsa JE oblik, jer je klasa Elipsa izvdena iz klase Oblik).

					// vrsi se implicitno kastovanje navise
					// Elipsa -> Oblik
		init(p.a, p.b);

		// II varijanta:
		//super(p.getCentar()); // Inicijalizacija baznog dela:
							// umesto konstruktora kopija bazne klase poziva se
							// konstruktor bazne koji prima sve neophodne podatke
							// umesto p.centar sada je neophodno p.getCentar()
		// init(p.a, p.b);

		// III varijanta:
		// poziva se konstruktor ove klase koji ocekuje sve neophodne podatke
		// this(p.getCentar(), p.a, p.b);  // obratiti paznju na p.getCentar()
	}

	// private metodi se ne nasledjuju
	private void init(double a, double b) {
		this.a = a;
		this.b = b;
	}

	// public metodi ce biti nasledjeni

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	// predefinisanje (overriding) nasledjenog metoda
	// toString() natklase
	// ako se donja definicija stavi pod komentar
	// kada izvrsimo program bice pozvan toString() iz natklase
	public String toString() {
		return "Elipsa a = " + a + " b = " + b;
	}
}
