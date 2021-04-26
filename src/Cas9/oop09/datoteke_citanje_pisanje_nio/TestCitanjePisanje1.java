package datoteke_citanje_pisanje_nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Cita se datoteka 'podaci.txt' 
 * (na isti nacin kao u programu ScannerString_Delimiter_nextLine)
 * pri cemu se rezultat upisuje u datoteku 'izlaz.txt'.
 * 
 * Varijanta 1:
 * Koristi se obican try/catch
 * (organizacija koda je slicna kao u programskom jeziku C).
 */
public class TestCitanjePisanje1 {

	public static void main(String[] args) {
		
		Scanner sc = null;
		PrintWriter out = null;
		final Charset KODIRANJE = StandardCharsets.UTF_8;
		
		System.out.println("Otvara se datoteka za citanje.");
		
		try {
			// ukoliko zelite da se koristi podrazumevano kodiranje platforme,
			// STO NIJE DOBRA IDEJA, I NE PREPORUCUJE SE,
			// izostavite drugi argument konstruktora - KODIRANJE.name()
			// ili neka on bude: Charset.defaultCharset().name()
			sc = new Scanner(Paths.get("podaci.txt"), KODIRANJE.name());
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke za citanje!");
			System.exit(1); // prekid daljeg izvrsavanja programa
		}
		
		System.out.println("Otvara se datoteka za pisanje.");
		
		/* za PrintWriter objekat se mogu pozivati metodi println() i printf() za formatirani ispis. */
		
		/* metod Files.newBufferedWriter() otvara ili kreira datoteku za pisanje, i vraca 
		 * BufferedWriter objekat koji ce se koristiti za pisanje teksta. 
		 * Ovaj objekat nema podrzane metode za formatirani ispis, pa zato od njega pravimo 
		 * PrintWriter objekat. 			
		 * Metodi za pisanje izbacuju izuzetak tipa IOException, ako tekst ne moze biti 
		 * enkodirana datim karakterskim skupom. */
		try {
			out = new PrintWriter(Files.newBufferedWriter(Paths.get("izlaz.txt"), KODIRANJE 
					, StandardOpenOption.APPEND, StandardOpenOption.CREATE
				));
					// Files.newBufferedWriter(putanja, KODIRANJE);
							// otvaranje datoteke za pisanje (podrazumeva se ocija StandardOpenOption.WRITE)
							// ako datoteka ne postoji, kreira se nova i upisuje se sadrzaj
							// ako datoteka postoji, novi sadrzaj se prepisuje preko postojeceg
					// Files.newBufferedWriter(putanja, KODIRANJE, StandardOpenOption.APPEND);
							// otvaranje datoteke za nadovezivanje na kraj. Datoteka mora da postoji. 
					// Files.newBufferedWriter(putanja, KODIRANJE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
							// ako datoteka postoji, vrsi se dopisivanje na kraj, inace se kreira nova datoteka. 
	
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke za pisanje!");
			System.exit(1);
		}
		
		// Ukoliko su obe datoteke uspesno otvorene, nastavlja se dalje sa obradom
		
		System.out.println("Citanje i upis podataka...");
		
		out.println("Dan: " + sc.next());
		String datumStr = sc.next();
		int d, m, g;
		try (Scanner scD = new Scanner(datumStr)){
			scD.useDelimiter("\\.");
			d = scD.nextInt();
			m = scD.nextInt();
			g = scD.nextInt();
		}
		out.printf("Datum: %02d.%02d.%02d.%n", d, m, g);
		out.println("Broj casova vezbi: " + sc.nextInt());
		
		String ostatak = sc.nextLine();
		out.println("Predmet: " + sc.nextLine());
		
		int h, min;
		while(sc.hasNextLine()) {
			String linija = sc.nextLine();
			try (Scanner scL = new Scanner(linija)){
				scL.useDelimiter("(::|,) +");
				out.print("grupa: " + scL.next());
				String vreme = scL.next();
				try (Scanner scV = new Scanner(vreme)) {
					scV.useDelimiter(":");
					h = scV.nextInt();
					min = scV.nextInt();
				}
				out.printf(", vreme: %02d:%02d", h, min);
				out.println(", ucionica: " + scL.next());
			}
		}
		out.println("*" + ostatak + "*");
		sc.close();
		out.close(); // neophodno je zatvaranje izlazne datoteke da bi upisani sadrzaj bio vidljiv
	}
}
