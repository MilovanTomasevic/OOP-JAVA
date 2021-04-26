package treca_grupa;

public class Kvadrat extends GeometrijskiObjekat 
{
	// Kvadrat se karakterise jos jednim (bilo kojim) temenom
	private Tacka teme;
	
	// Konstruktor na osnovu zadatog temena
	public Kvadrat(Tacka teme)
	{
		// Poziv konstruktora natklase gde se postavi tip na "Kvadrat", 
		// a centralna tacka u koordinatni pocetak
		super("Kvadrat");
		this.teme = teme;
	}
	
	// Konstruktor na osnovu zadatog temena i centralen tacke
	public Kvadrat(Tacka teme, final Tacka centar)
	{
		// Poziv konstruktora natklase gde se postavi tip na "Kvadrat", 
		// a centralna tacka na datu tacku
		super("Kvadrat", centar);
		this.teme = teme;
	}
	
	// Konstruktor kopije
	public Kvadrat(final Kvadrat k)
	{
		super("Kvadrat", k.vratiCentar());
		// Alternativa:
		// super("Kvadrat");
		// postaviCentar(new Tacka(k.vratiCentar()));
		
		this.teme = new Tacka(k.teme);
		
	}
	
	public Tacka vratiTeme()
	{
		return teme;
	}
	
	// Racuna stranicu kvadrata
	public double stranica()
	{
		return teme.rastojanje(vratiCentar()) * Math.sqrt(2);
	}
	
	// Racuna povrsinu kvadrata
	public double povrsina() 
	{
		return Math.pow(stranica(), 2);
	}
	
	// String reprezentacija kvadrata
	public String toString()
	{
		return super.toString() + ", " + teme; 
	}
	
	

}
