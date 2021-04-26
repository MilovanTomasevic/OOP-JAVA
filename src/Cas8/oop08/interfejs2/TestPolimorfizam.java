package interfejs2;

import java.util.Random;

public class TestPolimorfizam {

	public static void main(String[] args) {
		Povrs povrsi[] = { new Krug(new Tacka(),1),
				           new Krug(new Tacka(1,1),2),
				           new Pravougaonik(new Tacka(),3,4),
				           new Kvadrat(new Tacka(4,6), 2) };
		
		Random izbor = new Random();
		
		for(int i=0; i<5; i++)
		{
			// p je promenljiva tipa bazne klase, posto ce se koristiti za polimorfno pozivanje 
			// i metoda obim() (iz interfejsa Obim)
			// i metoda povrsina() (iz interfejsa Povrsina)
			Povrs p = povrsi[izbor.nextInt(povrsi.length)];
			System.out.println(p); // Polimorfno se poziva metod toString()
			         
			// Polimorfno pozivanje metoda povrsina()
			System.out.println("Povrsina je " + p.povrsina());
			
			// Polimorfno pozivanje metod obim()
			System.out.println("Obim je " + p.obim());
			System.out.println();
		}
	}
}
