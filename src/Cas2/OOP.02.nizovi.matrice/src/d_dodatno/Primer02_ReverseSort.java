package d_dodatno;

import java.util.Arrays;
import java.util.Collections;

/**
 * Primer ilustruje sortiranje niza u opadajucem (nerastucem) poretku
 */
public class Primer02_ReverseSort {

	public static void main(String[] args) {

		// NAPOMENA: sortiranje u nerastucem poretku je moguce samo ako imamo niz objekata.
		// Za nizove elemenata primitivnog tipa ovako nesto nije moguce.

		System.out.println("Niz objekata klase Integer:");
		// Ako imamo niz objekata klasa omotaca primitivnih tipova (Integer, Double, ...)
		// postoji nacin da ga sortiramo nerastuce pozivom metoda Arrays.sort():
		Integer aI[] = { new Integer(2), new Integer(-120), new Integer(15),
				         new Integer(7), new Integer(-10), new Integer(6),
                         new Integer(-10)};
		
		show("aI", aI);

		// metod reverseOrder() klase java.util.Collections vraca objekat komparator
		// koji sluzi za poredjenje objekata niza (u opstem slucaju kolekcije) 
		// u obrnutom poretku od prirodnog, neopadajuceg poretka.
		Arrays.sort(aI, Collections.reverseOrder());

		System.out.println("Nakon sortiranja nerastuce: ");
		show("aI", aI);
	}

	static void show(String name, Integer[] a) {
		System.out.println(name + ": " + Arrays.toString(a));
	}
}