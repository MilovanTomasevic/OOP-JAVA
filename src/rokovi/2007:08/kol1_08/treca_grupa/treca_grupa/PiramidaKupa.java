package treca_grupa;

// Klasa koja predstavlja geometrijsko telo koje moze da se ponasa i kao 
// piramida i kao kupa, u zavisnosti od osnove.
public class PiramidaKupa 
{
	// Posto osnova moze biti Kvadrat ili Krug, treba staviti da je osnova
	// tipa GeometrijskiObjekat, jer je to bazna klasa i za Kvadrat i za Krug
	private GeometrijskiObjekat osnova;
	// Visina piramide/kupe
	private double visina;
	
	// Konstruktor na osnovu date osnove i date visine
	public PiramidaKupa(GeometrijskiObjekat osnova, double visina)
	{
		this.osnova = osnova;
		this.visina = visina;
	}
	
	// Zapremina piramide/kupa
	public double zapremina()
	{
		return (osnova.povrsina() * visina) / 3;
	}
	
	// String reprezentacija piramide/kupe
	public String toString()
	{
		if (osnova instanceof Kvadrat)
			return "Piramida:" + "\nOsnova:		" + osnova + "\nVisina:		" + visina;
		else if (osnova instanceof Krug)
			return "Kupa:" + "\nOsnova:		" + osnova + "\nVisina:		" + visina;
		else
			return "Nepoznati objekat";
	}
	
}
