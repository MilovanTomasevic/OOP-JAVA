package interfejs1;

import java.util.Random;

/** 
 * Ilustruje upotrebu interfejsa za polimorfno pozivanje metoda
 * 
 * nije moguce napraviti objekat tipa interfejsa
 * ali je moguce deklarisati promenljivu tipa interfejsa
 * koja moze biti referenca na objekat proizvoljne
 * klase koja implementira taj interfejs
 * 
 * ova promenljiva se moze koristiti za polimorfno pozivanje
 * metoda iz interfejsa
 */
public class TestPolimorfizam {

	public static void main(String[] args) {
		// Niz povrsi, da bi elementi bili tipa Krug,
		// Pravougaonik, Kvadrat, niz je tipa bazne klase
		// Moze da bude i tipa interfejsa Povrsina,
		// s obzirom da sve izvedene klase nasledjuju klasu Povrs
		// koja implementira taj interfejs. 
		// Povrsina povrsi[] = ...
		Povrs povrsi[] = { new Krug(new Tacka(),1),
				           new Krug(new Tacka(1,1),2),
				           new Pravougaonik(new Tacka(),3,4),
				           new Kvadrat(new Tacka(4,6), 2) };
		
		Random izbor = new Random();
		
		for(int i=0; i<5; i++)
		{
			// p je promenljiva tipa bazne klase ili tipa interfejsa Povrsina
			Povrs p = povrsi[izbor.nextInt(povrsi.length)];  // Povrsina p = ...
			System.out.println(p); // Polimorfno se poziva metod toString()
			        
			// Polimorfno pozivanje metoda povrsina()
			System.out.println("Povrsina je " + p.povrsina());
			
			if(p instanceof Pravougaonik)
				System.out.println("Opisani "+((Pravougaonik)p).opisaniKrug());
			System.out.println();
		}
	}
}
