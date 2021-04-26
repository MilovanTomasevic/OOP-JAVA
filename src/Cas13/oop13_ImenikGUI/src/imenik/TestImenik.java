package imenik;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestImenik {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Imenik imenik = new Imenik();
		
		while(true) {
			
			System.out.println("Unesite:");
			System.out.println("\t1 za novi unos");
			System.out.println("\t2 za pretragu");
			System.out.println("\t3 za listanje leksikografski");
			System.out.println("\t9 za kraj");

			int izbor;
			try {
				izbor = sc.nextInt();
			}
			catch(InputMismatchException e) {
				String greska = sc.next();
				System.out.println("\"" + greska + "\" je pogresan izbor, pokusajte ponovo.");
				continue;
			}
			
			switch (izbor) {
			case 1:
				imenik.dodajKontakt(Osoba.ucitajOsobu(sc), Broj.ucitajBroj(sc));
				break;
			case 2:
				System.out.println("Podaci o osobi ciji se broj trazi");
				Osoba o = Osoba.ucitajOsobu(sc);
				Broj broj = imenik.nadjiBroj(o);
				if(broj == null)
					System.out.println("Osoba \"" + o + "\" se ne nalazi u imeniku");
				else
					System.out.println("Broj telefona osobe " + o + " je " + broj);	
				break;
			case 3:
				System.out.println(imenik);
				break;
			case 9:
				System.out.println("Kraj!");
				System.exit(0);
			default:
				System.out.println("Pogresna opcija, pokusajte ponovo");
				break;
			}
			
		}
	}
}
