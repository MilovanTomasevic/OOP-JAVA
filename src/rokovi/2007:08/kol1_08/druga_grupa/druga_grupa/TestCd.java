package druga_grupa;

import java.util.Scanner;

public class TestCd
{
	public static void main(String[] args) 
	{
	    Cd[] cdovi = new Cd[10];
	    int i=0;
	    
	    // Indikator koji nam govori da li je korisnik zavrsio sa radom
		boolean indikator = true;

		// Skener za parsiranje ulaznih podataka
		Scanner scanner = new Scanner(System.in);
		
		// Formiranje danasnjeg datuma
		Datum danasnji = new Datum(14,4,2008);
		
		do 
		{
			// Unos podataka o cdovima
			System.out.println("Unesite podatke o cdovima ");

			System.out.print("  Naslov:  ");
			String naslov = scanner.next();

			System.out.print("  Trajanje:  ");
			int trajanje = scanner.nextInt();
			
			System.out.println("  Unesite datum iznajmljivanja:  ");
			System.out.print("	Dan:  ");
			int dan=scanner.nextInt();
			System.out.print("	Mesec:  ");
			int mesec=scanner.nextInt();
			System.out.print("	Godina:  ");
			int godina=scanner.nextInt();
			
			Datum dat=new Datum(dan,mesec,godina);
						
			while(true)
			{
				System.out.print("  Kategorija	m / f:  ");
				String kategorija = scanner.next();
			
				if(kategorija.equalsIgnoreCase("m"))
				{
					System.out.println("  MUZICKI CD");
						
					System.out.print("  Autor:  ");
					String autor = scanner.next();
								
					// konstruisemo muzicki cd
					cdovi[i] = new MuzickiCd(naslov, trajanje, autor, dat);
				
					i++;
					break;
				}
				else if (kategorija.equalsIgnoreCase("f"))
				{
					System.out.println("  FILMSKI CD");
				
					System.out.print("  Reziser:  ");
					String reziser = scanner.next();
				
					System.out.print("  Glavni glumac:  ");
					String glumac = scanner.next();
							
					//	konstruisemo filmski cd
					cdovi[i] = new FilmCd(naslov, trajanje, reziser, glumac, dat);
				
					i++;
					break;
				}
				else
					System.out.println("Pokusajte ponovo sa unosom kategorije ! \n");
					
			}
					
			System.out.print("Da li zelite da nastavite sa unosom (d/n)? ");
			if ((scanner.next().equalsIgnoreCase("n"))) indikator = false;

			System.out.println("");

		} while (indikator && i<=10);

		//Ispisujemo podatke o cdovima koje treba vratiti na danasnji dan
		int s=0; // Brojac cd-ova koje treba ispisati
		System.out.println("Na danasnji dan treba vratiti sledece cd-ove:\n");
		for(int j=0; j<i; j++)
		if (cdovi[j].datumVracanja().isti(danasnji))
		{
			System.out.println(cdovi[j].toString());
			// Povecava se s ako smo izvrsili upis
			s++;
		}
			
		if(s==0)
			System.out.println("Nema cd-ova koje treba vratiti na danasnji dan.");
			
	}

}
