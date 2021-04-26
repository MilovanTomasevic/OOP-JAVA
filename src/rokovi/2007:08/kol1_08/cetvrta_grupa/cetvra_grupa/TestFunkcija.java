package cetvra_grupa;

import java.util.Scanner;

public class TestFunkcija 
{
	public static void main(String[] args)
	{
		Scanner skener = new Scanner(System.in);
						
		Funkcija[] funkcije = new Funkcija[30];
		
		String tip;
		System.out.println("Unesite tip funkcije (t/e), odnosno x za kraj: ");
		tip = skener.next();
		int i=0;
		while(tip.compareTo("x") != 0 && i<30)
		{
			
			switch(tip.charAt(0))
			{
				case 't':
					System.out.println("Unesi koeficijent a:");
					System.out.print("a = ");
					double a = skener.nextDouble();
					System.out.println("Unesi koeficijent b:");
					System.out.print("b = ");
					double b = skener.nextDouble();
					funkcije[i++] = new Trig(a, b);
					break;
				case 'e':
					System.out.println("Unesi koeficijent a:");
					System.out.print("a = ");
					a = skener.nextDouble();
					System.out.println("Unesi koeficijent b:");
					System.out.print("b = ");
					b = skener.nextDouble();
					funkcije[i++] = new Exp(a, b);
					break;
				default:
					System.out.println("Nepoznata funkcija");
					break;
			}
			System.out.println("Unesite tip funkcije (t/e), odnosno x za kraj:");
			tip = skener.next();
		}
		
		System.out.println("Broj kreiranih funkcija: " + i);
		
		double x;
		System.out.println("Unesi tacku u kojoj se racunaju vrednosti funkcija: ");
		x = skener.nextDouble();
		
		System.out.println("Kreirane funkcije:");
		for(int j=0; j<i; j++)
		{
			System.out.println("\n" + funkcije[j]);
			System.out.print("Vrednost funkcije u datoj tacki: ");
			System.out.println(funkcije[j].vrednost(x));
			
			Funkcija izvod = funkcije[j].izvod();
			System.out.println("Izvod:\n" + izvod);
			System.out.println("Vrednost izvoda:" + izvod.vrednost(x));
			
		}

	}
	
}
		
