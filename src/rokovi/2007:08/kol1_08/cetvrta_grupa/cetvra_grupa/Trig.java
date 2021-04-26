package cetvra_grupa;

/* 
 * Klasa koja predstavlja trigonometrijske funkcije oblika a*sin(x) + b*cos(x)
 */
public class Trig extends Funkcija 
{
	// Svaka funkcija ovog tipa se karakterise koeficijentima a i b 
	private double a;
	private double b;
	
	// Konstruktor na osnovu datih koeficijenata
	public Trig(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	// Izvod funkcije a*sin(x)+b*cos(x) je (-b)*sin(x)+a*cos(x)
	public Funkcija izvod() 
	{
		return new Trig(-b, a);
	}

	// Vrednost f-je u datoj tacki
	public double vrednost(double x) 
	{
		return a*Math.sin(x) + b*Math.cos(x);
	}	
	
	// String reprezentacija trigonometrijske funkcije
	public String toString() {
		return "Trigonometrijska: " + a + "*sinx + " + b + "*cosx";
	}

}
