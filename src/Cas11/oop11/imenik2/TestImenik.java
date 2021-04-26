package imenik2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TestImenik {

	public static Map<Osoba, Broj> imenik = new HashMap<>();
	
	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)) {

			for(;;) {
				System.out.println("Unesite:");
				System.out.println("\t1 za novi unos");
				System.out.println("\t2 za pretragu");
				System.out.println("\t3 za listanje leksikografski");
				System.out.println("\t9 za kraj");

				int izbor = 0;
				try {
					izbor = sc.nextInt();
				} catch(InputMismatchException e){
					String greska = sc.next();
					System.out.println("\"" + greska + "\" je pogresan izbor, pokusajte ponovo.");
					continue;
				}

				switch(izbor){
				case 1:
					imenik.put(Osoba.ucitajOsobu(sc), Broj.ucitajBroj(sc));
					break;
				case 2:
					System.out.println("Podaci o osobi ciji se broj trazi");
					Osoba o = Osoba.ucitajOsobu(sc);
					Broj broj = imenik.get(o);
					if(broj==null)
						System.out.println("Osoba " + o +  " nije u imeniku");
					else
						System.out.println("Broj telefona osobe " + o + " je " + broj);				
					break;
				case 3:
					listaj();
					break;
				case 9:
					System.out.println("Kraj!");
					return;
				default:
					System.out.println("Pogresna opcija, pokusajte ponovo");
					break;
				}

			}	
		}
	}
	
	public static void listaj(){
		List<Osoba> osobe  = new ArrayList<Osoba>(imenik.keySet());
		
		/* Sortiranje liste kljuceva:
		 * drugi argument metoda sort() je objekat komparator kojim se definise poredak 
		 * (tj. nacin poredjenja objekata liste).
		 * Komparator se pravi kao objekat anonimne klase koja implementira genericki interfejs Comparator<>.
		 * Ujedno se pravi objekat i definise klasa tog objekta:
		 * - posto je definicija klase ugnjezdena u poziv metoda sort() spoljasnje klase, nije moguce dati joj ime (na standardan nacin);
		 *   zato ona dobija genericko ime u formatu <ImeSpoljasnjeKlase>$<RedniBroj> (redni brojevi pocinju od 1);
		 *   da je klasa zaista napravljena moze se videti u sadrzaju workspace direktorijuma (ovde: TestImenik$1.class)
		 * 
		 * new Comparator<Osoba>()
		 * 	- pravi se objekat klase koja nema ime, ali koja implementira interfejs Comparator<Osoba>, pa se zato
		 *    ime tog interfejsa navodi umesto imena klase u pozivu podrazumevanog konstruktora
		 * 
		 * Definicija anonimne klase navodi se izmedju viticastih zagrada koje slede poziv podrazumevanog konstruktora:
		 * 	- potrebno je implementirati metod compare() interfejsa Comparable<>
		 *    (nakon sto se otkuca 'new Comparator<Osoba>(){' i pritisne Enter,
		 *     kompajler ce fragment koda 'Comparator<Osoba>()' podvuci crvenom linijom; 
		 *     pozicioniranjem misa na njega, bice ponudjena opcija 'Add unimplemented methods'
		 *     koju treba izabrati; bice dodat skelet metoda compare;
		 * 
		 */
		Collections.sort(osobe, new Comparator<Osoba>() {
			
			@Override
			public int compare(Osoba o1, Osoba o2) {
				int rez = o1.getPrezime().compareTo(o2.getPrezime());
				if(rez==0)
					return o1.getIme().compareTo(o2.getIme());
				return rez;
			}
		});
		
		for(Osoba o: osobe)
			System.out.println(o + ", broj telefona: " + imenik.get(o));
		System.out.println();
		
		/* sortiranje utice samo na reference koje se nalaze u listi osobe, ne i na samu mapu, 
		 * sto se moze videti ako se ispise sadrzaj mape na bilo koji od raspolozivih nacina
		 * (metodom toString() ili iteracijom kroz neki od pogleda na mapu) */
		/*
		System.out.println(imenik);
		
		System.out.println();
		Set<Entry<Osoba, Broj>> parovi = imenik.entrySet();
		for(Entry<Osoba, Broj> par : parovi)
			System.out.println(par);
		*/
	}
}
