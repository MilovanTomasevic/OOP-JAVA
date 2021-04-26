package a_nizovi;

import java.util.Scanner;

/**
 * Primer prikazuje pravljenje niza duzine n, unos elemenata
 * i njihov ispis.
 */
public class Primer01_NizDateDuzine {

	public static void main(String[] args) {
		// Kada Scanner vezujemo na standardni ulaz,
		// necemo ga zatvarati (jer ce to zatvarati standardni ulaz,
		// tako da nas program ne moze da ga koristi na dalje).
		// Eventualno, mozemo ga zatvoriti na samom kraju programa
		// kada smo sigurni da nam vise nece trebati standardni ulaz.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite duzinu niza: ");
		int n = sc.nextInt();
		
		// Pravimo niz duzine n

        int[] a; // deklarisemo nizovsku promenljivu a
        // koja moze da cuva referencu na niz celih brojeva tipa int

        a = new int[n]; // pravimo niz duzine n
        // svi elementi su inicijalizovani na 0

        // ili krace:
        // int[] a = new int[n];

        System.out.println("Unesite " + n + " broja/brojeva:");
		for (int i = 0; i < n;  i++)
			a[i] = sc.nextInt();
		
		System.out.println("Uneti brojevi (for petlja):");
		for (int i = 0; i < n;  i++)
			System.out.print(a[i] + " ");
		System.out.println();

		System.out.println("Uneti brojevi (foreach petlja):");
		for (int e: a)
			System.out.print(e + " ");
		System.out.println();

        // NAPOMENA: promenljiva 'a' postaje referenca na napravljeni niz, ne i sam niz.
        // Da je to zaista tako, mozemo se uveriti ako ispisemo vrednost
        // promenljive 'a' na standardni izlaz:
        System.out.println("a = " + a);
        // Dobicemo nesto poput:
        // a = [I@330bedb4
        // gde zagrada '[' oznacava da je u pitanju referenca na niz, slovo 'I' ukazuje
        // na tip elemenata niza (int), a iza simbola '@' je vrednost promenljive 'a'
        // data u heksadekadnom formatu (vrednost reference)
        // na osnovu koje JVM moze da locira niz u memoriji.

        // NE ZATVARAMO SCANNER
		// sc.close();
	}
}
