package druga_grupa;

public class MuzickiCd extends Cd
{
	// Autor muzickog cd-a
	private String autor;
	  
	// Podrazumevani konstruktor
	public MuzickiCd()
	{
		super();
		autor   = "Nepoznat";
	}
	  
	// konstruktor sa argumentima naslov, duzina, autor i datum vracanja
	public MuzickiCd(String naslov, int duzina, String autor, Datum datum)
	{
		super(naslov, duzina, datum);
	    this.autor   = autor;
	}
	  
	// Pristupne metode
	public String autor()
	{
		return autor;
	}
	  
	// Metod koji racuna datum kada treba da se vrati cd
	public Datum datumVracanja()
	{
		for(int i=0; i<3; i++)
			datum().sledeci();
		return datum();
	}
	  
	// Metod za ispis Muzickog cd-a
	public String toString() 
	{
		return "Muzicki CD:" + super.toString()+"\n"+ 
			"Autor : " + autor()+"\n";
	}		
}
