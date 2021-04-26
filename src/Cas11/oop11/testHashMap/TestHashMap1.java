package testHashMap;

import java.util.HashMap;
import java.util.Map.Entry;

public class TestHashMap1 {
	public static void main(String[] args) {
		HashMap<String, Integer> mapa = new HashMap<>();
		String kljuc = "Perica";
		int vrednost = 0;
		/* Smestanje para objekata (tj. odgovarajuce reference) u mapu metodom put(). 
		 * Interno se reference cuvaju u dinamickom nizu, a pozicija u nizu na koju se smesta jedna referenca racuna se
		 * postupkom hesiranja objekta kljuca (ovde objekta klase String).
		 * To znaci da parovi u mapi (tj. internom dinamickom nizu) nece biti smesteni onim redosledom kako 
		 * su unoseni, vec redosled zavisi od hesiranja. 
		 */
		mapa.put(kljuc, vrednost);
		
		/* Metod toString() vraca string reprezentaciju mape 
		 * koja se sastoji od liste string reprezentacija parova navedenih izmedju 
		 * viticastih zagrada u redosledu u kojem bi ih 
		 * vratio iterator nad pogledom dobijenim pozivom metoda entrySet() za mapu. 
		 * String reprezentacija jednog para je oblika 
		 * <string reprezentacija kljuca>=<string reprezentacija vrednosti>. 
		 */
		System.out.println(mapa);
		
		Integer staraVrednost = null;
		for(int i = 0; i < 3; i++)
			// metod put() vraca vrednost prethodno pridruzenu kljucu ili null ukoliko takva vrednost ne postoji
			// povratna vrednost null znaci: vrednost nije pridruzena kljucu ili mu je pridruzena vrednost null
			if((staraVrednost = mapa.put(kljuc, ++vrednost)) != null)
				System.out.println("odbacili smo: " + staraVrednost); 

		System.out.println(mapa);

		// metod remove() vraca vrednost prethodno pridruzenu kljucu ili null ukoliko takva vrednost ne postoji
		// povratna vrednost null znaci: vrednost nije pridruzena kljucu ili mu je pridruzena vrednost null
		vrednost = mapa.remove(kljuc);
		System.out.println("Uklonjena vrednost: " + vrednost + " koja odgovara kljucu: " + kljuc);
		
		System.out.println("Velicina mape: " + mapa.size());
		System.out.println("mapa.isEmpty(): " + mapa.isEmpty());
		
		
		mapa.put("Stevica", null);
		mapa.put("Marica", 0);
		System.out.println(mapa);
		mapa.put("Perica", 1);

		System.out.println(mapa);
		
		for(Entry<String, Integer> par : mapa.entrySet())
			System.out.println(par);
		
		mapa.put("Milica", 2);
		mapa.put("Ivica", 3);

		System.out.println(mapa);

	}
}
