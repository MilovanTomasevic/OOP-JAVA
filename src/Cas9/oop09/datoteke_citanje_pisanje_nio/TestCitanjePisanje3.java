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
 * Varijanta 3:
 * Pomocni metodi za otvaranje datoteka ne vrse proveru izuzetka IOException, pa je
 * neophodno da se u specifikaciji metoda pomocu kljucne reci 'throws' 
 * naglasi da mogu da izbace ovaj izuzetak. 
 * (organizacija koda je slicna kao u programskom jeziku C).
 */
public class TestCitanjePisanje3 {
	
	public static final Charset ENKODIRANJE = StandardCharsets.UTF_8;
	
	public static Scanner otvoriZaCitanje() throws IOException{
		return new Scanner(Paths.get("podaci.txt"), ENKODIRANJE.name());
	}
	
	public static PrintWriter otvoriZaPisanje() throws IOException{
		return new PrintWriter(Files.newBufferedWriter(Paths.get("izlaz.txt"), ENKODIRANJE));
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
		
		// Obrada izuzetaka se sada nalazi u metodu main()!
		
		System.out.println("Otvara se datoteka za citanje.");
		Scanner sc = null;
		try {
			sc = otvoriZaCitanje();
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke za citanje!");
			System.exit(1);
		}
		
		System.out.println("Otvara se datoteka za pisanje.");
		PrintWriter out = null;
		try {
			out = otvoriZaPisanje();
		} catch (IOException e) {
			System.out.println("Neuspesno otvaranje datoteke za pisanje!");
			System.exit(1);
		}
		
		System.out.println("Citanje i upis podataka...");
		citajPisi(sc, out);
		sc.close();
		out.close();
	}
}
