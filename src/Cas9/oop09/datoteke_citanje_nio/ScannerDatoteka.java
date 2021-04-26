package datoteke_citanje_nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * ScannerDatoteka.java:
 * 
 * Programa ilustruje citanje podataka iz tekstualne datoteke.
 * Koriste se klase iz paketa java.nio i try-with-resources (Java 7).
 * 
 * Ulazna datoteka "brojevi.txt" (koja mora da postoji u direktorijumu projekta)
 * sadrzi cele brojeve razdvojene belinama. Pored njih, mogu se javiti i 
 * proizvoljne niske karaktera. 
 * 
 * Program treba da procita sve cele brojeve i da ih ispise na standardni izlaz.
 */
public class ScannerDatoteka {

	public static void main(String[] args) {
		/* Klasa java.nio.charset.Charset sluzi za mapiranje sekvence bajtova
		 * u UNICODE sekvencu karaktera. Sadrzi metode za pravljenje enkodera i dekodera i
		 * za dobijanje imena karakterskih skupova. Instance ove klase su nepromenljive. */
		/* Klasa java.nio.charset.StandardCharsets sadrzi konstantne definicije standardnih
		 * karakterskih skupova (koji su garantovano podrzani na svakoj implementaciji Java platforme).
		 * Definicije su tipa: public static final Charset
		 * (US_ASCII, ISO_8859_1, UTF_8, UTF_16BE, UTF_16LE, UTF_16) */
		final Charset ENKODIRANJE = StandardCharsets.UTF_8;
		
		/* String sa putanjom do datoteke (ovde samo ime datoteke) prevodi
		 * se u Path objekat (koji se koristi za lociranje datoteke u fajl sistemu).
		 * Konstruktor klase Scanner koristi ovaj objekat
		 * pri otvaranju datoteke.
		 * Metod get() konvertuje string (ili niz stringova, spajajuci ih) u putanju */
		Path putanja = Paths.get("brojevi.txt");
		
		/* Naredba try-with-resources (Java 7):
		 * Resurs je objekat koji mora biti zatvoren kada program zavrsi 
		 * sa njegovom upotrebom (takvi su objekti klasa koje
		 * implementiraju interfejs java.lang.AutoCloseable (uveden u verziji 7)).
		 * Interfejs java.io.Closeable (koga implementira klasa Scanner) je 
		 * podinterfejs interfejsa AutoCloseable, 
		 * pa su i objekti klasa koje implementiraju Closeable, takodje resursi).
		 *	
		 * Naredba try-with-resources obezbedjuje da je na njenom
		 * kraju resurs zatvoren, bez obzira da li se try-blok
		 * izvrsio u celosti (normalno) ili je doslo do izbacivanja
		 * izuzetka.
		 *
		 * Resurs koji se pravi jeste objekat klase Scanner za citanje datoteke. 
		 * Putanja do datoteke zadata je objektom klase Path (prvi argument).
		 * Drugi argument definise nacin konvertovanja (enkodiranja) sekvence bajtova 
		 * iz datoteke u sekvencu UNICODE karaktera.	
		 */
		try (Scanner sc = new Scanner(putanja, ENKODIRANJE.name())){
			while(sc.hasNext()) {
				if(sc.hasNextInt())
					System.out.println(sc.nextInt());
				else
					sc.next();
			}
			
		} catch (IOException e) { 	// Konstruktor Scanner(Path source, String charsetName)
            						// izbacuje izuzetak tipa IOException
			System.out.println("Neuspesno otvaranje datoteke za citanje!");
		}
	}
}
