package primer01Sfera;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// Poziv statickog metoda getBrojac() klase Sfera kada smo u drugoj klasi
		// -- direktan pristup brojacu nije moguc jer je privatan
		System.out.println("Broj sfera = " + Sfera.getBrojac());

		// poziv podrazumevanog konstruktora
		Sfera jedinicna = new Sfera();
		System.out.println("Jedinicna: " + jedinicna.toString());
		System.out.format("Zapremina jedinicne sfere: %.2f\n", jedinicna.zapremina());
		System.out.println("Broj sfera = " + Sfera.getBrojac() + "\n");
				
		// Ucitavanje podataka o sferi sa standardnog ulaza
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite koordinate centra sfere (realni brojevi):");
		System.out.print("x = ");
		double x = sc.nextDouble();
		System.out.print("y = ");
		double y = sc.nextDouble();
		System.out.print("z = ");
		double z = sc.nextDouble();
		double r;
		// unosi se radius sfere dok se ne unese pozitivan broj
		while(true) {
			System.out.println("Unesite radijus sfere (pozitivan realan broj):");
			System.out.print("r = ");
			r = sc.nextDouble();
			if(Sfera.ispravanRadius(r))
				break;
		}

		// poziv konstruktora sa cetiri argumenta tipa double
		Sfera globus = new Sfera(x, y, z, r); 
		System.out.println("Globus: " + globus);
		System.out.printf("Zapremina globusa: %.2f\n", globus.zapremina());
		System.out.println("Broj sfera = " + Sfera.getBrojac() + "\n");
		
		// poziv konstruktora kopije
		Sfera kopijaGlobusa = new Sfera(globus);
		System.out.println("Kopija globusa: " + kopijaGlobusa);
		System.out.println("Broj sfera = " + Sfera.getBrojac() + "\n");
		
		// kopija je identicna originalu u trenutku pravljenja
        // nakon toga oni zive odvojene zivote
        // - promena jednog ne utice na drugi
		System.out.print("Promena radijusa kopije globusa na: ");
		r = sc.nextDouble();
		kopijaGlobusa.setRadius(r);
		System.out.println("Kopija globusa: " + kopijaGlobusa);
		System.out.println("Globus: " + globus );
		System.out.println();

        System.out.println("istoGlobus = globus");
		Sfera istoGlobus = globus;
        System.out.println("Za 'istoGlobus' nema poziva konstruktora!\n" +
                "\t=> Kada nema poziva konstruktora, ne pravi se novi objekat!");
		// Dobili smo jos jednu referencu (istoGlobus) na postojeci objekat
		// na koji smo imali referencu u promenljivoj globus
		System.out.println("IstoGlobus: " + istoGlobus);
		System.out.println("Broj sfera = " + Sfera.getBrojac() + "\n");
		System.out.print("Promena radijusa za 'istoGlobus' na: ");
		r = sc.nextDouble();
		istoGlobus.setRadius(r);
		System.out.println("globus: " + globus);
		System.out.println("istoGlobus: " + istoGlobus);
		System.out.println("kopijaGlobusa: " + kopijaGlobusa);
		
		// nova vrednost radijusa je negativna, pa se promena nece izvrsiti
        System.out.println("\nPromena radijusa za 'istoGlobus' na -5");
		istoGlobus.setRadius(-5);
		System.out.println("istoGlobus: " + istoGlobus);
	}
}
