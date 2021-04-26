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
 * i rezultati se upisuju u datoteku 'izlaz.txt'.
 * 
 * Varijanta 5:
 * Koristi se try-with-resources (jedan try blok za oba resursa)
 * Organizacija koda je tipicna za Javu. 
 */
public class TestCitanjePisanje5 {

	public static void main(String[] args) {
		final Charset ENKODIRANJE = StandardCharsets.UTF_8;
		
		System.out.println("Otvaraju se datoteke za citanje i pisanje.");
		
		try (Scanner sc = new Scanner(Paths.get("podaci.txt"), StandardCharsets.UTF_8.name()); 
			 PrintWriter out = new PrintWriter(Files.newBufferedWriter(Paths.get("izlaz.txt"), ENKODIRANJE, StandardOpenOption.APPEND, StandardOpenOption.CREATE))){
			
			System.out.println("citanje i upis podataka...");
			
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
				
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke!");
		}
	}
}
