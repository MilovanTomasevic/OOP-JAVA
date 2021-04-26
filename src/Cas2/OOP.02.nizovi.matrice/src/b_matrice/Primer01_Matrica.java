package b_matrice;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Primer ilustruje pravljenje matrice zadavanjem inicijalnih vrednosti elemenata
 * i ispis elemenata matrice.
 */
public class Primer01_Matrica {

	/**
	 * Matrice su realizovane kao niz nizova.
	 */
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		System.out.println("ispisi1(a):");
		ispisi1(a);
		
		System.out.println("\nispis2(a):");
		ispisi2(a);
		
		System.out.println("\nispis3(a):");
		ispisi3(a);
		
	}

	static void ispisi1(int[][] a) {
		// a.length -> broj vrsta
		for (int i = 0; i < a.length; i++) {
			// a[i] -> i-ta vrsta, koja je niz
			// a[i].length -> broj elemenata i-te vrste, tj. broj kolona matrice
			for (int j = 0; j < a[i].length; j++)
				System.out.printf("%d ", a[i][j]);
			System.out.println();
		}
	}

	static void ispisi2(int[][] a) {
		// Matrica je niz nizova (vrsta)
		// iteracija kroz matricu nam daje nizove
		for (int[] tmp: a) {
			// iteracija kroz pojedinacni niz nam daje elemente jedne vrste
			for (int e: tmp)
				System.out.print(e + " ");
			System.out.println();
		}
	}

	static void ispisi3(int[][] a) {
		// metod deepToString() zna da prebaci matricu u String
		System.out.println(Arrays.deepToString(a));
		// Probati:
		// System.out.println(Arrays.toString(a));
        //    ...umesto elemenata vrsta bice ispisane vrednosti referenci!
	}
}