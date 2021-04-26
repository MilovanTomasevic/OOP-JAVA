package c_klasaArrays;

import java.util.Arrays;

/**
 * Program prikazuje primer upotrebe funkcije za sortiranje i binarne pretrage.
 */
public class Primer01_SortBSearch {

	public static void main(String[] args) {
		int[] a = {10, 5, 3, 1, 7, 4, 2, 9, 6, 8};
		
		// Sortiramo
		// (podrazumeva se rastuci (neopadajuci) poredak)
		// NAPOMENA: Ne moramo uvek da importujemo klasu,
		// mozemo jednostavno navesti njeno puno ime.
		// Dakle: U paketu java nalazi se paket util koji sadrzi klasu Arrays.
		// Mehanizam klasa i paketa ce biti jasniji u narednim nedeljama.
		Arrays.sort(a);  // ili: java.util.Arrays.sort();
		
		// Prikazujemo sortiran niz:
		System.out.println(Arrays.toString(a));
		
		// Vrsimo binarnu pretragu.
		int x = 7;
		int i = Arrays.binarySearch(a, x);
		
		// Ako binarna pretraga vrati negativan broj,
		// onda element ne postoji u nizu.
		if (i < 0)
			System.out.println(x + " ne postoji u nizu.");
		else
			System.out.println(x + " se nalazi na poziciji " + i);
		
		x = 42;
		i = Arrays.binarySearch(a, x);
		if (i < 0)
			System.out.println(x + " ne postoji u nizu.");
		else
			System.out.println(x + " se nalazi na poziciji " + i);
	}
}
