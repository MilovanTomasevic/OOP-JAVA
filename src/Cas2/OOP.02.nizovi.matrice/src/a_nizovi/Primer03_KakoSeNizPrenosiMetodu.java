package a_nizovi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Unos i ispis niza koristeci metode (funkcije).
 */
public class Primer03_KakoSeNizPrenosiMetodu {

	public static void main(String[] args) {
		int[] a = unesi();
		ispisi1(a);
		ispisi2(a);
		ispisi3(a);
	}

	// Primetiti da se duzina niza ne prenosi kao drugi parametar!
	static void ispisi1(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	static void ispisi2(int[] a) {
		for (int e: a)
			System.out.print(e + " ");
		System.out.println();
	}

	static void ispisi3(int[] a) {
        // Metod toString zna da prebaci JEDNOSTAVNE nizove u String
        // (probajte ga kasnije na matrici).
        System.out.println(Arrays.toString(a));
    }

	static int[] unesi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite velicinu niza:");
		int n = sc.nextInt();

		System.out.println("Unesite elemente niza:");
		int[] tmp = new int[n];
		for (int i = 0; i < n; i++)
			tmp[i] = sc.nextInt();
		return tmp;
	}
}
