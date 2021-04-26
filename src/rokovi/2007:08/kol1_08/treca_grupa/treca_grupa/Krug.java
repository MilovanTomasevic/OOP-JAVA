package treca_grupa;

public class Krug extends GeometrijskiObjekat 
{
	// Krug se karakterise i poluprecnikom
	private double poluprecnik;
	
	// Konstruktor na osnovu zadatog poluprecnika
	public Krug(double r)
	{
		// Poziv konstruktora natklase gde se postavi tip na "Krug", 
		// a centralna tacka u koordinatni pocetak
		super("Krug");
		poluprecnik = r;
	}
	
	// Konstruktor na osnovu zadatog poluprecnika i centra
	public Krug(double r, final Tacka centar)
	{
		// Poziv konstruktora natklase gde se postavi tip na "Krug", 
		// a centralna tacka na datu tacku
		super("Krug", centar);
		poluprecnik = r;
	}
	
	// Konstruktor kopije	
	public Krug(final Krug k)
	{
		super("Krug", k.vratiCentar());
		// Alternativa:
		// super("Krug");
		// postaviCentar(new Tacka(k.vratiCentar()));
		this.poluprecnik = k.poluprecnik;
		
	}
	
	// Povrsina kruga
	public double povrsina() 
	{
		return Math.pow(poluprecnik, 2);
	}
	
	// String reprezentacija kruga
	public String toString()
	{
		return super.toString() + ", " + poluprecnik; 
	}
	
	
}

	
