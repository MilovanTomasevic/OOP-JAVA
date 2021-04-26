package agencija;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AgencijaTest {

	private static List<Ponuda> ponude = new ArrayList<>();
	
	public static void main(String[] args) {
		
		try {
			
			List<String> linije = Files.readAllLines(Paths.get("ponude.txt"), StandardCharsets.UTF_8);
			
			for(String linija : linije) {
				
				try(Scanner sc = new Scanner(linija)) {
					
					sc.useDelimiter(", ");
					
					String agencija = sc.next(); 
					String nazivDestinacije = sc.next(); 
					
					String datumPolaskaStr = sc.next(); 
					Datum datumPolaska;
					try(Scanner scDatum = new Scanner(datumPolaskaStr)) {
						scDatum.useDelimiter("\\.");
						datumPolaska = new Datum(scDatum.nextInt(), scDatum.nextInt(), scDatum.nextInt());
					}			
					
					int brojNocenja = sc.nextInt();
					int cena = sc.nextInt();
					
					Ponuda p = new Ponuda(agencija, nazivDestinacije, datumPolaska, brojNocenja, cena);
					ponude.add(p);
				}
			}		
			
		} catch (IOException e) {
			System.out.println("Greska pri radu sa datotekom.");
		}
		
		try(Scanner sc = new Scanner(System.in)) {
			
			while(true) {
				
				System.out.println("\nOpcije:");
				System.out.println("\t 1 Sve ponude");
				System.out.println("\t 2 tri najjeftinije ponude");
				System.out.println("\t 3 tri najskuplje ponude");
				System.out.println("\t 4 sve ponude za datum");
				System.out.println("\t 5 jeftinije od");
				System.out.println("\t 9 kraj");
				
				int izbor = sc.nextInt();
				int cena;
				
				switch(izbor) {
				case 1:
					ispisiSvePonude();
					break;
				case 2:
					ispisiNajjeftinije(3);
					break;
				case 3:
					ispisiNajjskuplje(3);
					break;
				case 4:
					Datum d = Datum.ucitajDatum(sc);
					ispisiPonudeZaDatum(d);
					break;
				case 5: 
					System.out.print("cena = ");
					cena = sc.nextInt();
					ispisiJeftinijeOd(cena);
					break;
				case 9:
					System.out.println("Kraj!");
					System.exit(0);
				default: 
					System.out.println("Nije podrzana opcija.");	
					break;
				}
			}
		}
	}
	
	public static void ispisiSvePonude() {
		System.out.println("Spisak svih ponuda:");
		for(Ponuda p : ponude)
			System.out.println(p);
	}
	
	// dodati opciju
	public static void ispisiJeftinijeOd(int cena) {
		System.out.println("\nPonude jeftinije od " + cena + ":");
		Collections.sort(ponude);
		for(Ponuda p : ponude)
			if(p.getCena() <= cena)
				System.out.println(p);
	}
	
	public static void ispisiNajjeftinije(int n) {
		System.out.println("\n" + n + " najjeftinije ponude:");
		Collections.sort(ponude);
		for(int i = 0; i < n; i++)
			System.out.println(ponude.get(i));		
	}
	
	public static void ispisiNajjskuplje(int n) {
		System.out.println("\n" + n + " najskuplje ponude:");
		Collections.sort(ponude);
		for(int i = ponude.size() - 1; i > ponude.size() - 1 - n; i--)
				System.out.println(ponude.get(i));		
	}
	
	public static void ispisiPonudeZaDatum(Datum d) {
		System.out.println("\nPonude za " + d);
		for(Ponuda p : ponude)
			if(p.getDatumPolaska().equals(d))
				System.out.println(p);		
	}
}
