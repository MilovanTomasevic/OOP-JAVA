package datoteke_citanje_nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Program ilustruje:
 *
 * citanje iz datoteke i potom iz String-a,
 *
 * pomesanu upotrebu metoda next(), nextInt(), nextDouble()
 * (koji preskacu beline - blankove, tabulatore, nove redove)
 * i metoda nextLine() koji vraca ostatak tekuce linije (ne ukljucujuci
 * oznaku za kraj reda) i pozicionira se na pocetak sledece linije
 *	
 * upotrebu metoda useDelimiter().
 * 
 * Cita se datoteka 'podaci.txt'.
 */
public class ScannerString_delimiter_nextLine {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(Paths.get("podaci.txt"), StandardCharsets.UTF_8.name())){
			System.out.println("Dan: " + sc.next());
			String datumStr = sc.next();
						
			// izdvajaju se dan, mesec i godina, tipa int, iz datuma koji je tipa String.
			// Cita se iz stringa "datum", a kao delimiter se koristi "."
			// Promenljive su deklarisane pre try-bloka, da bi bile vidljive
			// i posle njega.
			int dan, mesec, godina; 
			try (Scanner scDatum = new Scanner(datumStr)) {
				scDatum.useDelimiter("\\."); // useDelimiter() kao argument ocekuje regularni izraz
					// zelimo da delimiter bude bas tacka
					// medjutim, tacka je metakarakter: ima specijalno znacenje u regularnom izrazu
					// (odgovara proizvoljnom karakteru osim oznake za kraj reda)
					//
					// Stoga, kada zelimo da zapisemo samu tacku, trebalo bi da napisemo \.
					// medjutim i \ ima specijalno znacenje (pocetak escape sekvence, npr \n, \t, ...), 
					// pa njega predstavljamo sa \\
					// Otuda za samu tacku dobijemo \\.
				dan = scDatum.nextInt();
				mesec = scDatum.nextInt();
				godina = scDatum.nextInt();
			}
			// formatiran ispis, metod printf()
			System.out.printf("Datum: %02d.%02d.%02d.%n", dan, mesec, godina);
					// dan i mesec ispisuju se u polju sirine 2, poravnato udesno, a
					// po potrebi bivaju dopunjeni nulama do zeljene sirine
			
			System.out.println("Broj casova vezbi: " + sc.nextInt());
			// nextLine() za razliku od ostalih next*() metoda ne preskace delimitere
			// pa je to neophodno eksplicitno uraditi
			String ostatak = sc.nextLine(); // !!! ostatak linije u kojoj je 2 (ovde jedan razmak)
			System.out.println("Predmet: " + sc.nextLine()); // objektno orijentisano programiranje
			
			int h, min;
			while(sc.hasNextLine()) {
				String linija = sc.nextLine();
				try (Scanner scL = new Scanner(linija)){
					scL.useDelimiter("(::|,) +");
					System.out.print("grupa: " + scL.next());
					String vreme = scL.next();
					try (Scanner scV = new Scanner(vreme)) {
						scV.useDelimiter(":");
						h = scV.nextInt();
						min = scV.nextInt();
					}
					System.out.printf(", vreme: %02d:%02d", h, min);
					System.out.println(", ucionica: " + scL.next());
				}
			}
			System.out.println("\nA evo i ostatka koji je procitao \"onaj\" nextLine(): *" + ostatak + "*");
			// oko ostatka je stavljena po zvezdica kako bi se videlo da blanko (iza 2) nije preskocen,
			// a takodje i da oznaka za kraj reda nije ukljucena u ono sto vrati nextLine()
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
