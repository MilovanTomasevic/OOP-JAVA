package treca_grupa;

public abstract class GeometrijskiObjekat 
{
	private String tip;		// Tip geometrijskog objekta
	private Tacka centar;	// Centralna tacka
	
	// Konstruktor na osnovu datog tipa (centralna tacka je u koordinatnom pocetku)
	public GeometrijskiObjekat(String tip)
	{
		centar = new Tacka();
		this.tip = tip;
	}
	
	// Konstruktor na osnovu datog tipa i date centralne tacke
	public GeometrijskiObjekat(String tip, final Tacka c)
	{
		centar = new Tacka(c);
		this.tip = tip;
	}
	
	// Konstruktor na osnovu datog tipa i datih koordinata centralne tacke
	public GeometrijskiObjekat(String tip, double x, double y)
	{
		centar = new Tacka(x, y);
		this.tip = tip;
	}
	
	// Vraca centralnu tacku
	public Tacka vratiCentar()
	{
		return centar;
	}
	
	// Postavlja centralnu tacku
	public void postaviCentar(final Tacka t)
	{
		centar = new Tacka(t);
	}
	
	// Apstraktni metod za racunanje povrsine geometrijskog objekta
	public abstract double povrsina();
	
	// Ispis geometrijskog objekta - format za ispis se odredjuje na
	// osnovu toga kako treba ispisati Kvadrat i Krug sto je navedeno
	// u postavci zadatka
	public String toString()
	{
		return tip + ": " + centar;
	}
	
}
