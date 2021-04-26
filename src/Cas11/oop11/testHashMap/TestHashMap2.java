package testHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap2 {

	public static void main(String[] args) {
		HashMap<String, Integer> mapa1 = new HashMap<>();
		
		mapa1.put("Ivica", 1);
		mapa1.put("Marica", 2);
		mapa1.put("Stevica", null);
		mapa1.put("Perica", 0);
		
		System.out.println(mapa1.toString());
		
		// poziv konstruktora koji ocekuje postojecu mapu kao argument
		Map<String, Integer> mapa = new HashMap<>(mapa1);
	
		// skup svih parova kljuc/vrednost:
		System.out.println("Parovi u mapi:");
		Set<Entry<String, Integer>> parovi = mapa.entrySet();
		for(Entry<String, Integer> par: parovi) 
			System.out.println(par);
		
		System.out.println("Skup kljuceva u mapi:");
		Iterator<String> kljucevi = mapa.keySet().iterator();
		while(kljucevi.hasNext()){
			String klj = kljucevi.next();
			System.out.println(klj);
			Integer vr = mapa.get(klj);
			if(vr!=null)
				mapa.put(klj, vr+1);
		}
		System.out.println(mapa);
		
		System.out.println("Kolekcija vrednosti u mapi: ");
		Collection<Integer> vrednosti = mapa.values();
		for(Integer vr: vrednosti)
			System.out.println(vr);
	}
}
