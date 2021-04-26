package prva_grupa;

public class Djak extends Osoba
{
	// Suma prosecnih ocena svih kreiranih objekata klase Djak
	private static double suma_prosecnih_ocena_svih_ucenika = 0.0;
	// Ukupan broj kreiranih objekata klasa Djak
	private static int count = 0;
	
	private String skola;			// Skola koju djak pohadja
	private int razred;				// Razred koji djak pohadja
	private double prosecna_ocena;	// Prosecna ocena djaka
	
	// Konstruktor na osnovu zadatih kompletnih podataka kojim se opisuje djak
	public Djak(String ime, String adresa, String datum, String skola, int razred, double prosecna_ocena)
	{
		// Poziv konstruktora bazne klase Osoba
		super(ime, adresa, datum);
		this.skola = skola;
		this.razred = razred;
		this.prosecna_ocena = prosecna_ocena;
		count++;
		suma_prosecnih_ocena_svih_ucenika += prosecna_ocena;
		
	}	
	
	// Konstruktor kopije
	public Djak(final Djak dj)
	{
		// Neophodno je najpre kreirati objekat pozivom konstruktora - u ovom
		// slucaju konstruktora natklase, kako bi se kasnije postavile odgovarajuce
		// vrednosti za promenljive clanice
		super();
		// Clanice ime, adresa i datum se ne vide u klasi Djak, pa je potrebno
		// koristiti set-metode za postavljanje njihovih vrednosti
		setIme(dj.getIme());
		setDatum(dj.getDatum());
		setAdresa(dj.getAdresa());
		skola = dj.skola;
		razred = dj.razred;
		prosecna_ocena = dj.prosecna_ocena;
		// Drugi nacin:
		// super(dj.getIme(), dj.getDatum(), dj.getAdresa());
		// skola=dj.skola;
		// razred=dj.razred;
		// prosecna_ocena=dj.prosecna_ocena;
		
		// Generalno, treba azurirati staticke clanice count i 
		// suma_prosecnih_ocena_svih_ucenika, ali nije neophodno. Semanticki
		// gledano, ako smo kreirali kopiju nekog djaka, radi se o objektu
		// sa istim podacima, sto ne menja sumu prosecnih ocena.
		// count++;
		// suma_prosecnih_ocena_svih_ucenika += prosecna_ocena;
		
	}
	
	public static double prosek()
	{
		return suma_prosecnih_ocena_svih_ucenika / count;
	}
	
	public void bojaMarkice()
	{
		System.out.println("  Boja markice je plava");
	}
	
	public String toString()
	{
		return "\n" + super.toString() + "\nSkola: " + skola + "\nRazred: " + razred + "\nProsecna_ocena: "
						+ prosecna_ocena; 
	}

	
	
	
}
