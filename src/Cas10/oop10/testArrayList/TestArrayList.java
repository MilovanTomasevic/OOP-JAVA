package testArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Klasa ilustruje prostu upotrebu metoda klase java.util.ArrayList<>
 * 
 *   konstruktori:
 * - podrazumevani, pravi prazan ArrayList
 *   				inicijalnog kapaciteta 10
 * - sa argumentom tipa Collection<> (pravi ArrayList
 *   koji sadrzi reference objekata iz zadate kolekcije)
 * - sa argumentom tipa int, pravi prazan ArrayList
 * 					zadatog inicijalnog kapaciteta
 *   
 *   
 *   metodi:
 * - add() sa jednim i dva argumenta
 * - set()
 * - addAll() sa jednim i dva argumenta
 * - get()
 * - iterator()
 * - listIterator() bez argumenata i sa jednim argumentom
 * - toArray() (argument je niz dovoljne velicine)
 * - List<T> = Arrays.asList(T[]) --> konverzija niza u kolekciju
 *      koja se moze proslediti drugom od opisanih konstruktora
 *      klase ArrayList<>
 * - subList()
 * - remove(int), remove(T)
 * - removeAll(), retainAll()
 * - clear()
 * - isEmpty()
 * - indexOf(), lastIndexOf(), contains(), containsAll() (PREDEFINISATI equals() u klasi objekata <-- ovde: Osoba)
 * - size()
 * - ensureCapacity(), trimToSize()
 * - toString() (vraca String istog oblika kao Arrays.toString())
 */
public class TestArrayList {
	
	public static void main(String[] args) {
		// poziv podrazumevanog konstruktora
		ArrayList<String> imena = new ArrayList<>(); // zagradice <> su obavezne!
								// prazna lista stringova (elementi su tipa String)
				
		System.out.println("ArrayList<String> imena = new ArrayList<>();");
		// implicitni poziv metoda toString()
		System.out.println("imena: " + imena); // ekvivalentno sa imena.toString()
		System.out.println("Lista je inicijalno prazna.");
		System.out.println();
		
		
		ArrayList<Integer> listaCelihBrojeva = new ArrayList<>(50);
			// ako se zele cuvati vrednosti primitivnog tipa, za tip elemenata
			// navodi se odgovarajuca omotac-klasa.
			// Prazna lista celih brojeva, inicijalnog kapaciteta 50.
		
		System.out.println("ArrayList<Integer> listaCelihBrojeva = new ArrayList<>(50);");
		System.out.println("Prazna lista celih brojeva, inicijalnog kapaciteta 50: " + listaCelihBrojeva);
		
		listaCelihBrojeva.add(5); // dodavanje elementa na kraj liste, vraca true
		listaCelihBrojeva.add(-10);
		
		System.out.println("listaCelihBrojeva.add(5);");
		System.out.println("listaCelihBrojeva.add(-10);");
		System.out.println("Dodali smo dva broja tipa int: " + listaCelihBrojeva);
		System.out.println("Broj elemenata u listi je: " + listaCelihBrojeva.size());
		System.out.println();
		
		
		imena.add("Milica"); // dodavanje elementa na kraj liste
		
		System.out.println("imena.add(\"Milica\");");
		System.out.println("imena: " + imena);
		System.out.println("Broj elemenata u listi je: " + imena.size());
		System.out.println();
		
		imena.add(0, "Pavle"); // umetanje elementa na poziciju zadatu prvim argumentom
		
		System.out.println("imena.add(0, \"Pavle\");");
		System.out.println("imena: " + imena);
		System.out.println("Broj elemenata u listi je: " + imena.size());
		System.out.println();
		
		String stariPrvi = imena.set(0, "Sava"); // zamena elementa na zadatoj poziciji novim
										// vraca se stari element sa te pozicije
		
		System.out.println("String stariPrvi = imena.set(0, \"Sava\");");
		System.out.println("imena: " + imena);
		System.out.println("Zamenjen je element: " + stariPrvi);
		System.out.println();
		
		ArrayList<String> drugaImena = new ArrayList<>();
		drugaImena.add("Pera");
		drugaImena.add("Mika");
		drugaImena.add("Laza");
		drugaImena.add("Steva");
		
		System.out.println("drugaImena: " + drugaImena);
		System.out.println();
		
		imena.addAll(drugaImena); // dodavanje svih elemenata zadate kolekcije na kraj liste 
								  // u poretku kojim ih vraca iterator za kolekciju (vrca true)
		
		System.out.println("imena.addAll(drugaImena);");
		System.out.println("imena: " + imena);
		System.out.println();
		
		imena.addAll(1, drugaImena); // umetanje svih elemenata zadate kolekcije pocev od
			// pozicije zadate prvim argumentom (vraca true)
		
		System.out.println("imena.addAll(1, drugaImena);");
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		System.out.println("\n\n PRISTUP ELEMENTIMA LISTE \n\n");
		
		String poslednjeIme = imena.get(imena.size()-1); // pristup elementu sa zadate pozicije
		System.out.println("String poslednjeIme = imena.get(imena.size()-1);");
		System.out.println("poslednjeIme: " + poslednjeIme);
		System.out.println();
		
		ListIterator<String> listIter1 = imena.listIterator(1);
	
		System.out.println("ListIterator<String> listIter1	 = imena.listIterator(1);");
		String imeSaPozicije1 = listIter1.next(); // inicijalni poziv metoda next() vraca element na poziciji 1
		System.out.println("String imeSaPozicije1 = listIter1.next();");
		System.out.println("imeSaPozicije1: " + imeSaPozicije1);
		System.out.println("Vratimo se korak nazad (poziv metoda previous): " + listIter1.previous());
		System.out.println("\t--> napred, pa nazad: dodjemo na isto!");
		System.out.println("Jos jedan korak nazad (poziv metoda previous): " + listIter1.previous());
		System.out.println("Korak napred (poziv metoda next): " + listIter1.next());
		System.out.println("\t--> nazad, pa napred: dodjemo na isto!");
		System.out.println();
		
		List<String> podLista = imena.subList(1, 5); // pogled na deo liste

		System.out.println("List<String> podLista = imena.subList(1, 5);");
		System.out.println("podLista: " + podLista);
		
		podLista.set(0, "BIVSI_PERA");
			// nestrukturalne promene na pogledu odrazavaju se na originalnu listu
		
		System.out.println("podLista.set(0, \"BIVSI_PERA\");");
		System.out.println("imena: " + imena);
		System.out.println();
		
				
		System.out.println("\n\n KONVERZIJA LISTE U NIZ \n\n");

		Object[] imenaNiz = imena.toArray();
		// alocira se novi niz, u njega se smestaju kopije referenci na elemente liste
		// i isti se vraca
		System.out.println("Object[] imenaNiz = imena.toArray();");
		System.out.println("imenaNiz: " + Arrays.toString(imenaNiz));
		
		if(imenaNiz[0] == imena.get(0))
			System.out.println("reference na isti objekat!");
		
		imenaNiz[0] = "BIVSI_SAVA"; // promena niza ne utice na promenu originalne liste
		
		System.out.println("imenaNiz[0] = \"BIVSI_SAVA\";");
		System.out.println("imenaNiz: " + Arrays.toString(imenaNiz));
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		String[] podaci = imena.toArray(new String[imena.size()]);
		// ukoliko je prosledjeni niz odgovarajuce velicine, isti se vraca;
		// inace se alocira novi niz (istog tipa kao zadati i velicine koja 
		// odgovara velicini liste)
		// ukoliko je prosledjeni niz vece duzine od liste, element koji neposredno
		// sledi za elementima liste postavlja se na null
		// izbacuje izuzetak tipa ArrayStoreException ako tip niza nije isti
		// kao tip elemenata liste ili nije njegova natklasa
		System.out.println("String[] podaci = imena.toArray(new String[imena.size()]);");
		System.out.println("podaci: " + Arrays.toString(podaci));
		
		podaci[0] = "BIVSI_SAVA"; // ni u ovom slucaju promena niza ne utice na promenu liste
		
		System.out.println("podaci[0] = \"BIVSI_SAVA\";");
		System.out.println("podaci: " + Arrays.toString(podaci));
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		System.out.println("\n\n KONVERZIJA NIZA U LISTU \n\n");
		
		String[] ljudi = { "Pera", "Mika", "Laza", "Steva" };
		ArrayList<String> imena1 = new ArrayList<>(Arrays.asList(ljudi));
		System.out.println("String[] ljudi = { \"Pera\", \"Mika\", \"Laza\", \"Steva\" };");
		System.out.println("ArrayList<String> imena1 = new ArrayList<>(Arrays.asList(ljudi));");
		System.out.println("imena1: " + imena1);
		System.out.println();
		
		
		System.out.println("\n\n******* ZA VECINU METODA KOJI SU ILUSTROVANI NIZE NEOPHODNO JE DA ");
		System.out.println("        KLASA ELEMENATA LISTE IMA ISPRAVNU DEFINICIJU METODA equals()! *******\n\n");
		
		System.out.println(" UKLANJANJE OBJEKATA IZ LISTE \n\n");
		
		System.out.println("imena1: " + imena1);
		
		imena1.remove(1); // uklanjanje elementa sa pozicije 1 
					// (nije neophodno predefinisanje metoda equals u klasi elemenata liste)
		System.out.println("imena1.remove(1);");
		System.out.println("imena1: " + imena1);
		System.out.println();
		
		
		imena1.add(0, "Steva");
		System.out.println("imena1.add(0, \"Steva\");");
		System.out.println("imena1: " + imena1);
		imena1.add(3, "Pera");
		System.out.println("imena1.add(3, \"Pera\");");
		System.out.println("imena1: " + imena1);
		boolean uklonjenPrviPera = imena1.remove("Pera"); // koristi metod equals() klase elemenata liste!
		System.out.println("boolean uklonjenPrviPera = imena1.remove(\"Pera\");");
		if(uklonjenPrviPera)
			System.out.println("Uklonjena prva pojava elementa Pera!");
		System.out.println("imena1: " + imena1);
		System.out.println();
		
		
		// pravimo kopiju liste imena
		ArrayList<String> kopijaImena = new ArrayList<>(imena); 
		System.out.println("ArrayList<String> kopijaImena = new ArrayList<>(imena);");
		System.out.println("kopijaImena: " + kopijaImena);
		System.out.println();
		
		System.out.println("imena: " + imena);
		imena.removeAll(imena1);
		System.out.println("imena.removeAll(imena1);"); // koristi metod equals() klase elemenata liste!
		// uklanjanje iz liste imena svih elemenata koji se pojavljuju u kolekciji imena1
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		// jos jednom pravimo kopiju
		imena = new ArrayList<>(kopijaImena);
		System.out.println("kopijaImena: " + kopijaImena);
		kopijaImena.retainAll(imena1); // koristi metod equals() klase elemenata liste
				// uklanja sve elemente liste koji nisu sadrzani u kolekciji imena1
		System.out.println("kopijaImena.retainAll(imena1);");
		System.out.println("kopijaImena: " + kopijaImena);
		System.out.println();
		
		// provera da li je lista prazna
		if(imena1.isEmpty())
			System.out.println("imena1 je prazna lista.");
		else
			System.out.println("imena1 nije prazna lista.");
		
		
		// praznjenje liste
		imena1.clear();
		System.out.println("imena1.clear();");

		if(imena1.isEmpty())
			System.out.println("imena1 je prazna lista.");
		else
			System.out.println("imena1 nije prazna lista.");
		
		
		System.out.println("\n\n PRETRAGA LISTE \n\n");		

		
		System.out.println("imena: " + imena);
		// svi dole ilustrovani metodi koriste metod equals() klase elemenata liste!
		System.out.println("Indeks prve pojave elementa Mika: " + imena.indexOf("Mika"));
		System.out.println("Indeks poslednje pojave elementa Mika: " + imena.lastIndexOf("Mika"));
		if(imena.contains("Mika"))
			System.out.println("Lista imena sadrzi element Mika.");
		else
			System.out.println("Lista imena ne sadrzi element Mika.");
		
		
		if(imena.contains("SAVA"))
			System.out.println("Lista imena sadrzi element SAVA.");
		else
			System.out.println("Lista imena ne sadrzi element SAVA.");
		
		System.out.println("drugaImena: " + drugaImena);
		if(imena.containsAll(drugaImena))
			System.out.println("Lista imena sadrzi sve elemente kolekcije drugaImena.");
		else
			System.out.println("Lista imena ne sadrzi sve elemente kolekcije drugaImena.");
		
		System.out.println();
		
		drugaImena.add("Starac Foco od stotinu leta!");
		System.out.println("drugaImena.add(\"Starac Foco od stotinu leta!\");");
		System.out.println("drugaImena: "  + drugaImena);
		if(imena.containsAll(drugaImena))
			System.out.println("Lista imena sadrzi sve elemente kolekcije drugaImena.");
		else
			System.out.println("Lista imena ne sadrzi sve elemente kolekcije drugaImena.");
		
		
	}
}
