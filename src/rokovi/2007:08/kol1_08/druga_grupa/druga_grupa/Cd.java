package druga_grupa;

public abstract class Cd 
{
	  private String  naslov;    // naziv cd-a
	  private int     duzina;    // trajanje u minutima
	  private Datum   datum_uzimanja; //datum kada je korisnik uzeo cd
	  	  	  
	  // Podrazumevani konstruktor
	  public Cd()
	  {
		  naslov = "Nepoznat";
		  duzina = 0;
		  datum_uzimanja = new Datum();
	  }
	  
	  // Konstruktor na osnovu naslova		  
	  public Cd(String naslov )
	  {
		  this.naslov = naslov;
		  duzina = 90; 
		  datum_uzimanja = new Datum();
	  }

	  // Konstruktor na osnovu naslova, trajanja i datuma iznajmljivanja
	  public Cd( String naslov, int trajanje, Datum datum)
	  {
		  this.naslov = naslov;
		  duzina = trajanje;
		  datum_uzimanja = new Datum(datum);
	  }

	  public String naslov()
	  {
		  return naslov;
	  }
		  
	  public int duzina()
	  {
		  return duzina;
	  }
		 
	  public Datum datum()
	  {
		  return datum_uzimanja; 
	  }
	
	  //Metod koji ce u potklasama racunati datum kada treba da se vrati cd
	  public abstract Datum datumVracanja();
	  
	  //Metod za ispis Cd-a
	  public String toString() 
	  {
		  return "\n"+"Naslov : "+ naslov + "\n"+"Duzina trajanja : "+ duzina ;
	  }	
}

