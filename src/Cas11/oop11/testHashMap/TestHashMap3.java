package testHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Skup svih kljuceva, skup svih parova kljuc/vrednost i kolekcija svih vrednosti,
 * koji se dobijaju, redom, metodima: keySet(), entrySet() i values()
 * predstavljaju poglede na sadrzaj mape: 
 * promene na mapi odrazavaju se na poglede i obrnuto.
 * Ukoliko se mapa menja dok je u toku iteriranje kroz skup, odnosno kolekciju,
 * (osim pomocu metoda remove() samog iteratora 
 * ili metoda setValue() za par kljuc/vrednost vracen iteratorom <- u slucaju iteriranja
 * kroz skup parova kljuc/vrednost), 
 * rezultat iteracije nije definisan.
 * 
 * Promene koje su podrzane nad pogledima: 
 * - poziv metoda remove() za iterator (kojim se prolazi kroz skup, odnosno kolekciju)
 * - u slucaju iteriranja kroz skup parova kljuc/vrednost, dopusteno je zvati metod setValue() za tekuci par
 * - pozivi metoda: remove(), removeAll(), retainAll() i clear() za skup, odnosno kolekciju (kada nema iteratora)
 * 
 * Nisu podrzane operacije: add() i addAll().
 */
public class TestHashMap3 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> mapa = new HashMap<>(10);
		mapa.put("Ivica", 1);
		mapa.put("Marica", 2);
		mapa.put("Stevica", null);
		
		System.out.println("Promena vrednosti u mapi pomocu metoda setValue()");
		Set<Entry<String, Integer>> parovi = mapa.entrySet();
		for(Map.Entry<String, Integer> par: parovi){
			if(par.getValue() != null)
				par.setValue(par.getValue()*2);
//			parovi.remove(par);  // <- izbacuje ConcurrentModificationException
		}
		
		System.out.println(mapa);
		System.out.println();
		
		String kljuc = "Jovica";
		mapa.put(kljuc, null);
		System.out.println(mapa);
		
		Integer vr = mapa.get(kljuc);
		// kada metod get() vrati null
		if(vr == null){
			System.out.print("povratna vrednost metoda get() je null ");
			// metodom containsKey() moguce je utvrditi razlog
			if(mapa.containsKey(kljuc))
				System.out.println("jer je kljucu: " + kljuc + " pridruzena vrednost null");
			else
				System.out.println("jer kljuc: " + kljuc + " nema pridruzenu vrednost u mapi");
		}
		
		kljuc = "Perica";		
		vr = mapa.get(kljuc);
		if(vr == null){
			System.out.print("povratna vrednost metoda get() je null ");
			if(mapa.containsKey(kljuc))
				System.out.println("jer je kljucu " + kljuc + " pridruzena vrednost null");
			else
				System.out.println("jer kljuc " + kljuc + " nema pridruzenu vrednost u mapi");
		}
		System.out.println();

		Map<String, Integer> mapa1 = new HashMap<>();
		mapa1.put("Stevica", 256);
		mapa1.put("Gorica", 512);
		mapa1.put("Jovica", 0);
		System.out.println("mapa1: " + mapa1);
		mapa.putAll(mapa1);
		// vrednosti za kljuceve koji postoje u mapa bice zamenjene vrednostima koje odgovaraju istim kljucevima u mapa1
		System.out.println("mapa: " + mapa);
		
		Set<String> kljuceviMapa1 = mapa1.keySet();
		Set<String> kljuceviMapa = mapa.keySet();
		kljuceviMapa.removeAll(kljuceviMapa1);
//		kljuceviMapa.addAll(new ArrayList<String>(Arrays.asList("zdravo", "svima"))); // <- izbacuje UnsupportedOperationException
		System.out.println("mapa: " + mapa);
	}
}
