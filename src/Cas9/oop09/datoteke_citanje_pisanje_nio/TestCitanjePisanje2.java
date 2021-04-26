package datoteke_citanje_pisanje_nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Cita se datoteka 'podaci.txt' 
 * i rezultati se upisuju u datoteku 'izlaz.txt'.
 * 
 * Varijanta 2:
 * Koristi se obican try/catch i pomocni metodi za otvaranje datoteka
 * (organizacija koda je slicna kao u programskom jeziku C).
 */
public class TestCitanjePisanje2 {

	public static final Charset ENKODIRANJE = StandardCharsets.UTF_8;
	
	public static Scanner otvoriZaCitanje() {
		Scanner sc = null;
		try {
			sc = new Scanner(Paths.get("podaci.txt"), StandardCharsets.UTF_8.name());
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke za citanje!");
		}
		return sc;
	}
	
	public static PrintWriter otvoriZaPisanje() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(Files.newBufferedWriter(Paths.get("izlaz.txt"), StandardCharsets.UTF_8));
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke za pisanje!");
		} 
		return out;
	}
	
	public static void citajPisi(Scanner sc, PrintWriter out) {
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
	}
	
	public static void main(String[] args) {
		System.out.println("Otvara se datoteka za citanje...");
		Scanner sc = otvoriZaCitanje();
		if(sc == null)
			System.exit(1);
		System.out.println("Otvara se datoteka za pisanje...");
		PrintWriter out = otvoriZaPisanje();
		if(out == null)
			System.exit(1);
		System.out.println("Citanje i upis podataka...");
		citajPisi(sc, out);
		sc.close();
		out.close();
	}
}
