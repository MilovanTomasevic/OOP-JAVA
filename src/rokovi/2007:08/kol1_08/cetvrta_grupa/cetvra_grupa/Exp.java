package cetvra_grupa;

/* 
 * Klasa koja predstavlja eksponencijalne funkcije oblika a*e^b
 */
public class Exp extends Funkcija 
{
	// Svaka funkcija ovog tipa se karakterise koeficijentima a i b
	private double a;
	private double b;
	
	// Konstruktor na osnovu datih koeficijenata
	public Exp(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	// Izvod funkcije a*e^b je (a*b)*e^b
	public Funkcija izvod() 
	{
		return new Exp(a*b, b);
	}

	// Vrednost funkcije u tacki
	public double vrednost(double x) 
	{
		return a*Math.exp(b*x);
	}
	
	// String reprezentacija eksponencijalne funkcije
	public String toString() 
	{
		return "Eksponencijalna: " + a + "*e^(" + b + "*x)";
	}

}
