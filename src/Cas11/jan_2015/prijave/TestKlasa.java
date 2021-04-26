package prijave;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestKlasa {

	private static List<Prijava> prijave = new ArrayList<>();
	
	public static void main(String[] args) {
		ucitajPrijave();
		izracunajStatistike();
	}
	
	public static void ucitajPrijave() {
		
		// otvara se izabrani fajl za citanje
		try(Scanner sc = new Scanner(Paths.get("prijave.txt"), StandardCharsets.UTF_8.name())){
			while(sc.hasNextLine()) {
				String linija = sc.nextLine();
				// 2013: P1, 150, jan1
				String godina = linija.substring(0, linija.indexOf(":"));
				String[] delovi = linija.substring(linija.indexOf(":") + 2,
						linija.length()).split(", ");

				Prijava p = new Prijava(godina, delovi[0],
						Integer.parseInt(delovi[1]), Rok.valueOf(delovi[2]));

				prijave.add(p);
			}
		} 
		catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		// Ispis svih ucitanih prijava
		// Ako nisu dobro ucitane - tj. nema navedenih prijava u
		// datoteci, ispisuje se poruka 'Nema prijava'
		if (prijave.size() == 0)
			System.out.println("Nema prijava!");
		else 
			for (Prijava p : prijave) 
				System.out.println(p);
	}
	
	public static void izracunajStatistike() {
		// ako nema prijava prekida se izracunavanje
		if (prijave.size() == 0) 
			return;
		
		List<Par> parovi = new ArrayList<>();
		HashMap<String, Integer> prijaveMap = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		System.out.print("\nUnesite skolsku godinu ('0' ako ne zelite): ");
		String godina = sc.next();
		sc.close();
		for (Prijava p : prijave) {
			// Ako nije uneta godina onda radimo za sve
			if (godina.charAt(0) == '0') {
				// Ako ne postoji naziv predmeta u HashMapi dodajemo ga
				if (!prijaveMap.containsKey(p.getSif_pred())) 
					prijaveMap.put(p.getSif_pred(), p.getBr_prij());
				else 
					// samo sabiramo broj prijavljenih za taj predmet
					prijaveMap.put(p.getSif_pred(), prijaveMap.get(p.getSif_pred()) + p.getBr_prij());
			} else { 
				// inace vrsimo proveru da li je trenutna prijava 
				// iz godine koja se trazi
				if (p.getGodina().equals(godina)) {
					// Ako ne postoji naziv predmeta u HashMapi dodajemo ga
					if (!prijaveMap.containsKey(p.getSif_pred())) 
						prijaveMap.put(p.getSif_pred(), p.getBr_prij());
					else 
						// samo sabiramo broj prijavljenih za taj predmet
						prijaveMap.put(p.getSif_pred(), prijaveMap.get(p.getSif_pred()) + p.getBr_prij());
				}
			}
		}
		
		if (prijaveMap.size() == 0) {
			System.out.println("------------------------\n");
			System.out.println("Nema prijava iz tražene godine!\n");
			System.out.println("Pokušajte sa drugom godinom!\n");
		}
					
		System.out.println("------------------------\n");

		// Sortiranje se vrsi opadajuce po broju prijavljenih studenata 
		// za dati predmet.
		// Broj prijavljenih studenata je vrednost pridruzena kljucu 
		// unutar jednog para mape, pa se za realizaciju sortiranja
		// mora dobiti skup svih parova mape (nije dovoljan samo 
		// skup kljuceva, jer se sortiranje ne radi po kljucevima).
		// Na osnovu skupa parova iz mape treba napraviti novu kolekciju (listu)
		// ciji ce objekti biti klase Par (atribut sif_pred ima vrednost 
		// kljuca odgovarajuceg para iz skupa, a atributu br_prij 
		// se pridruzuje vrednost koja odgovara kljucu iz para.
		for (Map.Entry<String, Integer> entry : prijaveMap.entrySet()) {
			parovi.add(new Par(entry.getKey(), entry.getValue()));
		}

		Collections.sort(parovi);
		
		for (Par par : parovi) {
			System.out.println(par.toString());
		}
	}
}
