package interfejs3A;

import java.util.Random;

public class TestPolimorfizam 
{
	public static void main(String[] args) 
	{
		// da bi elementi bili tipa Krug,
		// Pravougaonik, Kvadrat, niz je tipa interfejsa koji implementiraju sve klase
		// moze se izabrati neki od tri interfjesa, posto ih sve klase implementiraju
		Povrsina povrsi[] = {
						new Krug(new Tacka() , 1),
				        new Krug(new Tacka(1, 1), 2),
				        new Pravougaonik(new Tacka(), 3, 4),
				        new Kvadrat(new Tacka(4, 6), 2)
							};
		
		Random izbor = new Random();
		
		Krug k = new Krug(new Tacka(-4,2), 5);
		
		for(int i = 0; i < 5; i++) 
		{
			Povrsina p = povrsi[izbor.nextInt(povrsi.length)];
			System.out.println(p); // polimorfno se poziva metod toString()
			         
			// polimorfno pozivanje metoda povrsina()
			System.out.println("Povrsina je " + p.povrsina());
			
			// da bismo polimorfno pozvali metod obim()
			// moramo izvrsiti kastovanje u tip Obim
			// Posto sve tri klase implementiraju interfejs Obim, nema potrebe
			// za prethodnom proverom legitimnosti kastovanja 
			// pomocu operatora instanceof
			System.out.println("Obim je " + ((Obim)p).obim());
			
			
			if(p.getClass() == Krug.class)
				System.out.println(((Krug)p).obim()); // kastovanje u stvarni tip objekta
													  // pa poziv metododa obim() nije polimorfan
		
			
			// polimorfno pozivanje metoda opisi()
			// (iz istih razloga kao u prethodnom slucaju i ovde je neophodno kastovanje)
			System.out.println("Opisani " + ((Opisivanje)p).opisi());
					
			// polimorfno pozivanje metoda rastojanjeDoCentra()
			// implicitno kastovanje navise tipa Krug u tip Opisivanje (za referencu k)
			System.out.println("Rastojanje do centra " + ((Opisivanje)p).rastojanjeDoCentra(k));
						
			System.out.println();
		}
	}
}
