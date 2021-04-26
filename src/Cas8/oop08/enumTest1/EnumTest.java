package enumTest1;

import java.util.Arrays;
import java.util.Scanner;

public class EnumTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		Velicina velicina = Velicina.MEDIUM;
			
		System.out.println("velicina = " + velicina); // implicitni poziv velicina.toString()
		
		System.out.print("Unesite velicinu: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
		String unos = sc.next().toUpperCase();
		
		velicina = Enum.valueOf(Velicina.class, unos);
		System.out.println("velicina = " + velicina);
			
		/* Nema potrebe koristiti metod equals() za vrednosti
		 * tipa enumeracije, one se porede pomocu == */
		if (velicina == Velicina.SMALL)
			System.out.println("Izabrana je najmanja velicina.");
						
		/* metod ordinal() vraca poziciju konstante enumeracije u enum 
		 * deklaraciji, racunajuci od 0. */
		System.out.println("Redni broj konstante: " + velicina.ordinal());
		
		/* metod compareTo(Velicina v) 
		 * vraca negativan ceo broj ako je tekuca konstanta enumeracije
		 * ispred zadate, 0 ako je this == v, a pozitivan ceo broj inace. 
		 * poredak konstanti dat je enum deklaracijom. */
		int rez;
		if((rez = velicina.compareTo(Velicina.MEDIUM)) == 0)
			System.out.println("tekuca velicina je jednaka " + velicina);
		else if(rez < 0)
			System.out.println("tekuca velicina je manja od " + Velicina.MEDIUM);
		else
			System.out.println("tekuca velicina je veca od " + Velicina.MEDIUM);
		
		/* staticki metod values() vraca niz vrednosti enumeracije. */
		Velicina[] vrednosti = Velicina.values();
		System.out.println("Sve konstante enumeracije za tip Vrednost:");
		System.out.println(Arrays.toString(vrednosti));
		sc.close();
		
	}
}
