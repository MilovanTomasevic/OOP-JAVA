package cetvra_grupa;

public abstract class Funkcija 
{
	// Metod koji racuna vrednost funkcije u datoj tacki. Metod je apstraktan,
	// jer generalno ne znamo o kojoj se funkciji radi
	public abstract double vrednost(double x);
	
	// Apstraktini metod koji racuna izvod funkcije koji je takodje funkcija
	public abstract Funkcija izvod();
	
	// Metod koji racuna vrednost izvoda funkcije u datoj tacki. Ovaj metod je
	// moguce definisati na osnovu prethodna dva metoda: metodom izvod() odredi
	// se funkcija koja predstavlja izvod polazne funkcije, a zatim se nad 
	// dobijenom funkcijom primeni meotod vrednost() kojim se sracuna vrednost
	// u datoj tacki.
	public double vrednostIzvoda(double x)
	{
		return izvod().vrednost(x);
	}
	
	// Apstraktni metod za String reprezentaciju funkcije.
	public abstract String toString();
	
	
}
