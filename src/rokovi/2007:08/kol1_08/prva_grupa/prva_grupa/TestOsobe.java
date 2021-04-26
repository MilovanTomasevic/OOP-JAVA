package prva_grupa;

import java.util.Scanner;

public class TestOsobe 
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite broj objekata");
		int n = sc.nextInt();
		
		Osoba[] osobe = new Osoba[n];
		
		for(int i=0; i<n; i++)
		{
			System.out.println("Unesite podatke za osobu:");
			System.out.println("Unesite ime:");
			String ime = sc.next();
			System.out.println("Unesite adresu:");
			String adresa = sc.next();
			System.out.println("Unesite datum rodjenja:");
			String datum = sc.next();
			
			while(true)
			{
				System.out.println("\nUnesite opis osobe: \"djak\", \"student\" ili \"zaposleni\"");
				String opis = sc.next();
		
				if(opis.compareTo("djak") == 0)
				{
					System.out.println("Unesite naziv skole:");
					String skola = sc.next();
					System.out.println("Unesite razred:");
					int razred = sc.nextInt();
					System.out.println("Unesite prosecnu ocenu:");
					double prosecnaOcena = sc.nextDouble();
					osobe[i] = new Djak(ime,adresa,datum,skola,razred,prosecnaOcena);
					break;
				}
				else if(opis.compareTo("student") == 0)
				{
					System.out.println("Unesite naziv fakulteta:");
					String fakultet = sc.next();
					System.out.println("Unesite naziv smera:");
					String smer = sc.next();
					System.out.println("Unesite godinu upisa:");
					int godUpisa = sc.nextInt();
					System.out.println("Unesite godinu studija:");
					int godStudija = sc.nextInt();
					osobe[i] = new Student(ime,adresa,datum,fakultet,smer,godUpisa,godStudija);
					break;
				}
				else if(opis.compareTo("zaposleni")==0)
				{
					System.out.println("Unesite naziv firme:");
					String firma = sc.next();
					System.out.println("Unesite naziv odeljenja:");
					String odeljenje = sc.next();
					System.out.println("Unesite mesecnu platu:");
					double plata = sc.nextDouble();
					osobe[i] = new Zaposleni(ime,adresa,datum,firma,odeljenje,plata);
					break;
				}
				else 
					System.out.println("Opis nije korektno unesen, pokusajte ponovo!");
			}
		}
		
		System.out.println("\nIspis podataka o osobama:\n");
		for(int i=0; i<n; i++)
		{
			System.out.println(osobe[i]);
			osobe[i].bojaMarkice();
			if(osobe[i] instanceof Djak) 
				System.out.println("  Suma prosecnih ocena svih ucenika je: " + Djak.prosek());
			else if(osobe[i] instanceof Student)
				System.out.println("  Suma godina studija svih studenata je: " + Student.prosek());
			else 
				System.out.println("  Suma mesecnih zarada svih zaposlenih je: " + Zaposleni.prosek());
		}
	}
}
