package velikiCeliBrojevi_mnozenje;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestVCB {

	private static List<VelikiCeoBroj> brojevi = new ArrayList<VelikiCeoBroj>();

	public static void prikaziBrojeve() {
		if(brojevi.size() == 0)
			System.out.println("Nema brojeva!");
		else 
			for(VelikiCeoBroj vcb : brojevi)
				System.out.println(vcb);
	}
	
	public static void main(String[] args) {
		// ucitavanje brojeva 
		try(Scanner sc = new Scanner(Paths.get("brojevi.txt"), StandardCharsets.UTF_8.name())) {
			while(sc.hasNextLine()) {
				brojevi.add(new VelikiCeoBroj(sc.nextLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// prikaz ucitanih brojeva
		System.out.println("Veliki celi brojevi:");
		System.out.println("--------------------");
		prikaziBrojeve();
		
		// sortiranje
		Collections.sort(brojevi);
		
		// prikaz brojeva nakon sortiranja
		System.out.println("\nSortirani:");
		System.out.println("----------");
		prikaziBrojeve();
		System.out.println();
		
		// mnozenje jednocifrenim brojem
		int broj = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while(true) {
				System.out.print("Unesite jednocifren broj: ");
				broj = sc.nextInt();
				if (broj >= 10 || broj <= -10) {
					System.out.println("Broj nije jednocifren!");
					continue;
				}
				else break;
			}
		}
		List<VelikiCeoBroj> brojeviPomnozeni = new ArrayList<VelikiCeoBroj>();
		for (int i = 0; i < brojevi.size(); i++) {
			brojeviPomnozeni.add(brojevi.get(i).mnozenjeJednocifrenimBrojem(broj));
		}
		brojevi = brojeviPomnozeni;
		
		// prikaz brojeva nakon mnozenja
		System.out.println("\nPomnozeni jednocifrenim brojem:");
		System.out.println("-------------------------------");
		prikaziBrojeve();
	}
}
