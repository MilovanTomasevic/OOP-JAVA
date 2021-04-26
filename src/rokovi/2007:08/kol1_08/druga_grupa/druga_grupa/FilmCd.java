package druga_grupa;

public class FilmCd extends Cd{
	
	  private String  reziser;      // ime rezisera
	  private String  glumac;       // ime glavnog glumca
	  
	  // konstruktor na osnovu naziva dela, rezisera i glavnog glumca
	  public FilmCd( String naslov, String reziser, String glumac )
	  {
		  super( naslov );    
		  this.reziser = reziser;  
		  this.glumac = glumac;  
	  }
	  
	  // konstruktor na osnovu naziva dela, duzine trajanja, rezisera, glavnog glumca i datuma iznajmljivanja
	  public FilmCd( String naslov, int duzina, String reziser, String glumac, Datum datum )
	  {
		  super(naslov, duzina, datum);
		  this.reziser = reziser;  
		  this.glumac = glumac;  
	  }
	  
	  // Metod koji racuna datum kada treba da se vrati cd
	  public Datum datumVracanja()
	  {
		  for(int i=0; i<5; i++)
			  datum().sledeci();
		  return datum();
	  }

	  public String reziser()
	  {
		  return reziser;
	  }
	  
	  public String glumac()
	  {
		  return glumac;
	  }
	  
	//Metod za ispis Film cd-a
	public String toString() {
		return "Filmski CD:" + super.toString()+"\n"+ 
		"Reziser : " + reziser()+"\n"+
		"Glavni glumac : " + glumac()+"\n";
	}		

}
