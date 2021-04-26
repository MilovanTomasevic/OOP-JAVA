package imenik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestImenik {

	/* imenik se pravi kao hes-mapa:
	 * kljucevi su tipa Osoba, a njima pridruzene vrednosti tipa Broj. 
	 */
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
					/* ucitavanje podataka o osobi (kljuc) i broju telefona (vrednost) i smestanje 
					 * odgovarajuceg para objekata (tj. para referenci na objekte) u mapu metodom put().
					 * Pri tom se pravi objekat klase Node<K,V> koji sadrzi ove reference.
					 * Node<K,V> je staticka ugnjezdena klasa u klasi HashMap<K,V> i vazi:
					 * Node<K,V> implements Map.Entry<K,V>.
					 * U specijalnim okolnostima ce biti napravljen objekat klase ThreeNode<K,V>
					 * (TreeNode<K,V> extends LinkedHashMap.Entry<K,V>).
					 * Parovi se cuvaju u dinamickom nizu, a pozicija u nizu na koju se smesta jedan par racuna se
					 * postupkom hesiranja objekta kljuca (kada se primenjuje i metod hashCode() klase Osoba).
					 * To znaci da parovi nece biti smesteni onim redosledom kako 
					 * su unoseni, vec redosled zavisi od hesiranja. 
					 */
					imenik.put(Osoba.ucitajOsobu(sc), Broj.ucitajBroj(sc)); // reference na postojece objekte (a ne kopije objekata) se smestaju u mapu
					break;
				case 2:
					System.out.println("Podaci o osobi ciji se broj trazi");
					Osoba o = Osoba.ucitajOsobu(sc);
					Broj broj = imenik.get(o); /* za dati kljuc, metod get() vraca pridruzenu vrednost */
					if(broj==null)
						System.out.println("Osoba " + o +  " nije u imeniku");
					else
						System.out.println("Broj telefona osobe " + o + " je " + broj);				
					break;
				case 3:
					/* prikaz sadrzaja imenika prethodno sortiranog leksikografski prema prezimenu i imenu osobe */
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
		/* Metod Collections.sort() primenljiv je samo nad kolekcijama koje imaju 
		 * strukturu liste (argument je tipa List<>).
		 * Kako onda izvrsiti sortiranje objekata u mapi?
		 * Tako sto se izvrsi sortiranje liste kljuceva u mapi. Lista kljuceva se moze 
		 * napraviti na osnovu skupa kljuceva, koji se dobija kao 
		 * pogled nad mapom, pozivom metoda keySet(). 
		 */ 
		List<Osoba> osobe  = new ArrayList<Osoba>(imenik.keySet());
			/* lista 'osobe' sadrzace kopije referenci na kljuceve u mapi */
		Collections.sort(osobe);
			/* sortiranjem liste menja se samo poredak referenci u listi u skladu
			 * sa kriterijumom definisanim metodom compareTo().
			 */
		for(Osoba o : osobe) {
			System.out.println(o + ", broj telefona: " + imenik.get(o));
		}
		/* poredak u mapi nije promenjen sortiranjem */
//		for(Entry<Osoba, Broj> e : imenik.entrySet()) {
//			System.out.println(e.getKey() + ", broj telefona: " + e.getValue());
//		}
		
		/* Bilo koja izmena nad listom 'osobe' nece uticati na sadrzaj mape */
//		for(int i = 0; i < osobe.size(); i++)
//			osobe.set(i, new Osoba("N", "N"));
//		for(Osoba o : osobe) {
//			System.out.println(o);
//		}
	}
}
