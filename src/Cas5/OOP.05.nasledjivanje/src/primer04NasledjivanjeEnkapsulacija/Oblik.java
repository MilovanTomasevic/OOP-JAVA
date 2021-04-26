package primer04NasledjivanjeEnkapsulacija;

public class Oblik {
	// Polje oznacavamo kao private
	private Tacka centar;	// centralna tacka, kojom je odredjena pozicija u ravni

	public Oblik(Tacka centar) {
		// Primetimo da instanca klase Oblik dobija
		// SOPSTVENU KOPIJU tacke od koje se pravi,
		// ne koristi prosledjenu tacku direktno.
		
		// Pozivamo konstruktor kopije za tacku.
		this.centar = new Tacka(centar);

		// Ukoliko se navede:
		// this.centar = centar;
		// prosledjena tacka upravo postaje centralna
		// tacke instance klase Oblik
	}

	public Oblik(double x, double y) { centar = new Tacka(x, y); }

	public Oblik() {
		centar = new Tacka();
	}

	/// Konstruktor kopije.
	public Oblik(Oblik o) {
		// Mozemo delegirati odgovornost vec implementiranom konstruktoru.
		this(o.centar);
	}

	// public metodi getCentar() i toString() ce biti nasledjeni
	// u izvedenim klasama

	// metod getCentar() za pristup polju centar je sada neophodan
	public Tacka getCentar() {
		return centar;
	}

	public String toString() {
		return "Oblik centar = " + centar.toString();
	}
}
