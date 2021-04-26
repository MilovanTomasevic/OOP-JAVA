package prva_grupa;

public class Osoba 
{
	private String ime;		// Ime i prezime osobe
	private String adresa;	// Adresa osobe
	private String datum;	// Datum rodjenja osobe
	
	// Podrazumevani konstruktor (nije neophodan)
	public Osoba()
	{
		this.ime = new String("");
		this.adresa = new String("");
		this.datum = new String("");
	}
	
	// Konstruktor na osnovu datog imena, adrese i datuma rodjenja
	public Osoba(String ime, String adresa, String datum)
	{
		this.ime = ime;
		this.adresa = adresa;
		this.datum = datum;
	}
	
	// Konstruktor kopije (nije neoghodan)
	public Osoba(final Osoba o)
	{
		ime = o.ime;
		adresa = o.adresa;
		datum = o.datum;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public String getAdresa()
	{
		return adresa;
	}
	
	public String getDatum()
	{
		return datum;
	}
	
	public void setIme(String ime)
	{
		this.ime = ime;
	}
	
	public void setAdresa(String adresa)
	{
		this.adresa = adresa;
	}
	
	public void setDatum(String datum)
	{
		this.datum = datum;
	}
	
	// Polimorfan metod za prikaz boje markice
	public void bojaMarkice()
	{}
	
	public String toString()
	{
		return "Ime: " + ime + "\nAdresa: " + adresa + "\nDatum rodjenja: " + datum;
	}
	
	
}
