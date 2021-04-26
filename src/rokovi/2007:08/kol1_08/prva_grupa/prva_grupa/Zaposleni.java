package prva_grupa;

public class Zaposleni extends Osoba 
{
	private static int count = 0;
	private static double suma_mesecnih_zarada_svih_zaposlenih = 0.0;
	
	private String naziv_firme;
	private String naziv_odeljenja;
	private double mesecna_zarada;
	
	public Zaposleni(String ime, String adresa, String datum, String firma, String odeljenje, double plata)
	{
		super(ime,adresa,datum);
		naziv_firme = firma;
		naziv_odeljenja = odeljenje;
		mesecna_zarada = plata;
		count++;
		suma_mesecnih_zarada_svih_zaposlenih += plata;
	}
	
	public Zaposleni(final Zaposleni radnik)
	{
		// Neophodno je najpre kreirati objekat pozivom konstruktora - u ovom
		// slucaju konstruktora natklase, kako bi se kasnije postavile odgovarajuce
		// vrednosti za promenljive clanice
		super();
		// Clanice ime, adresa i datum se ne vide u klasi Zaposleni, pa je potrebno
		// koristiti set-metode za postavljanje njihovih vrednosti
		setIme(radnik.getIme());
		setDatum(radnik.getDatum());
		setAdresa(radnik.getAdresa());
		
		naziv_firme = radnik.naziv_firme;
		naziv_odeljenja = radnik.naziv_odeljenja;
		mesecna_zarada = radnik.mesecna_zarada;
		
		// super(radnik.getIme(), radnik.getDatum(), radnik.getAdresa());
		// naziv_firme = radnik.naziv_firme;
		// naziv_odeljenja = radnik.naziv_odeljenja;
		// mesecna_zarada = radnik.mesecna_zarada;
	}
	
	public void bojaMarkice()
	{
		System.out.println("Boja markice je crvena");
	}
	
	public static double prosek()
	{
		return suma_mesecnih_zarada_svih_zaposlenih / count;
	}
	
	public String toString(){
		return "\n" + super.toString() + "\nFirma: " + naziv_firme + "\nOdeljenje: " +
		                      naziv_odeljenja + "\nMesecna zarada: " + mesecna_zarada;
	}
	
}
