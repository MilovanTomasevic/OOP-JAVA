package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestListaOsoba {
	
	public static Scanner sc = new Scanner(System.in);

	// osobe se smestaju u listu
	public static List<Osoba> osobe = new ArrayList<>();
	
	public static void main(String[] args) {

		Osoba neko = null;
		while(true) {
			neko = ucitajOsobu();
			// petlja se prekida kada nema vise osoba
			if(neko == null)
				break;
			// ako je ucitana osoba, ista se dodaje na kraj liste
			osobe.add(neko);
		}
		
		System.out.println("Broj osoba u listi: " + osobe.size());

		// Ispis osoba iz liste na vise nacina
		
		System.out.println("\nIterator: ");
		ispisiOsobeIterator();
		System.out.println("\nIterator 2: ");
		ispisiOsobeIterator2();
		
		System.out.println("\nget()");
		ispisiOsobeGet();
		
		System.out.println("\ncollection-based for-petlja:");
		ispisiOsobeFor();
		
		// sortiranje liste
		// (moguce je jer klasa Osoba, ciji objekti
		//  su elementi liste, implementira
		//  Comparable<> interfejs)
		Collections.sort(osobe);
		
		System.out.println("\nSortirano leksikografski:");
		ispisiOsobeFor();
		
		System.out.println("\nPodaci o osobi koja se trazi u listi:");
		Osoba traziSe = ucitajOsobu();
		// klasa objekata koji se cuvaju u kolekciji (Osoba)
		// mora imati adekvatno predefinisan metod equals()
		// koji nasledjuje od univerzalne superklase Object
		if(osobe.contains(traziSe))
			System.out.println("Osoba " + traziSe + " se nalazi u listi.");
		else
			System.out.println("Osoba " + traziSe + " se NE nalazi u listi.");
	}

	public static void ispisiOsobeIterator() {
		// prvi nacin prolaska kroz listu
		// koriscenjem iteratora
		Iterator<Osoba> iter = osobe.iterator();
		// uobicajena upotreba iteratora:
		// kombinacija metoda hasNext() i next().
		while(iter.hasNext()){
			System.out.println(iter.next());
			// iter.remove();
			/** nakon next() moglo bi: iter.remove(); (ako to ima smisla) */
		}
	}
	
	public static void ispisiOsobeIterator2() {
		// upotreba iteratora bez poziva metoda hasNext().
		// primetiti da je neophodan ponovni poziv metoda iterator()!
		Iterator<Osoba> iter = osobe.iterator();
		while(true) {
			try {
				System.out.println(iter.next());
			// ako nema objekta koji treba vratiti
			} catch(NoSuchElementException e) {
				System.out.println("Kraj liste: " + e.getMessage());
				break;
			}
		}
	}
	
	public static void ispisiOsobeGet() {
		// drugi nacin prolaska kroz listu
		// "indeksiranjem" pomocu metoda get()
		// (vraca element liste koji se nalazi
		//  na zadatoj poziciji i
		//  pozicije se broje od 0)
		for(int i = 0; i < osobe.size(); i++) {
			System.out.println(osobe.get(i));
			/** osobe.remove(i); uklonilo bi samo elemente koji su se
			    inicijalno nalazili na parnim pozicijama
			    jer nakon brisanja dolazi do shift-ovanja preostalih elemenata */
		}
	}

	public static void ispisiOsobeFor() {
		// treci nacin prolaska kroz listu
		// collection-based for-petlja
		for(Osoba o: osobe){
			System.out.println(o);
			// osobe.remove(o);
			/** osobe.remove(o); dovelo bi do izbacivanja izuzetka tipa:
			    ConcurrentModificationException */
		}
	}
		
	// pomocni metod za ucitavanje Osobe sa standardnog ulaza
	// ako se umesto imena unese "Kraj"
	// metod vraca vrednost null kao oznaku
	// da nema vise osoba
	// metod moze biti i u klasi Osoba, sto bi bilo prirodnije:
	// public static Osoba ucitajOsobu(Scanner sc);
	public static Osoba ucitajOsobu(){
		System.out.println("Unesite ime osobe ili 'Kraj' za kraj");
		// sc je staticki atribut ove klase 
		String ime = sc.next();
		if(ime.equalsIgnoreCase("Kraj"))
			return null;
		System.out.println("Unesite prezime osobe");
		return new Osoba(ime, sc.next());
	}
}
