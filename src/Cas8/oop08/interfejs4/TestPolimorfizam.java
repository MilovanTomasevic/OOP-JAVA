package interfejs4;

import java.util.Random;

public class TestPolimorfizam 
{
	/* argument metoda je tipa interfejsa, pa je moguce prilikom poziva
	 * proslediti mu referencu na objekat proizvoljne klase
	 * koja implementira ovaj interfejs (Krug, Pravougaonik, Kvadrat, 
	 * ali i Tacka)
	 */
	public static void pomeranje(Translacija t, double dx, double dy){
		// polimorfni poziv metoda
		t.pomeri(dx, dy);
	}
	
	public static void main(String[] args) 
	{
		// da bi elementi bili tipa Krug, Pravougaonik, Kvadrat ili Tacka
		// niz je tipa interfejsa koji implementiraju sve klase
		Translacija povrsi[] = {
						new Krug(new Tacka() , 1),
				        new Krug(new Tacka(1, 1), 2),
				        new Pravougaonik(new Tacka(), 3, 4),
				        new Kvadrat(new Tacka(4, 6), 2),
				        new Tacka(-1, -1),
				        new Tacka(0, 99)
								};
		
		Random izbor = new Random();

		for(int i = 0; i < 5; i++) 
		{
			// p je promenljiva interfejsnog tipa koja cuva
			// referencu na objekat izvedene klase 
			Translacija p = povrsi[izbor.nextInt(povrsi.length)];
			System.out.println(p); // polimorfno se poziva metod toString()
			         
			// polimorfno pozivanje metoda pomeri() pozivom statickog metoda pomeranje()
			// translacija povrsi za 1 duz x-ose i -1 duz y-ose
			pomeranje(p, 1, -1);
			System.out.println("*** Nakon translacije ***\n" + p);
			System.out.println();
		}
	}
}
