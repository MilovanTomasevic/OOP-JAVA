package treca_grupa;

import java.util.Scanner;

public class TestGeometrija 
{
	public static void main(String[] args)
	{
		Scanner skener = new Scanner(System.in);
		
		System.out.println("Unesi broj objekata");
		int n = skener.nextInt();
		
		GeometrijskiObjekat[] objekti = new GeometrijskiObjekat[n];
		
		String tip;
					
		for(int i=0; i<objekti.length; i++)
		{
			System.out.println("Unesi geometrijski objekat (kvadrat/krug):");
			tip = skener.next();
			if(tip.equalsIgnoreCase("kvadrat"))
			{
					System.out.println("Unesi centar kvadrata:");
					System.out.print("x = ");
					double x = skener.nextDouble();
					System.out.print("y = ");
					double y = skener.nextDouble();
					Tacka centar = new Tacka(x, y);
					
					System.out.println("Unesi teme kvadrata:");
					System.out.print("x = ");
					x = skener.nextDouble();
					System.out.print("y = ");
					y = skener.nextDouble();
					Tacka teme = new Tacka(x, y);
					
					objekti[i] = new Kvadrat(teme, centar);
			}
			else if(tip.equalsIgnoreCase("krug"))
			{		
					System.out.println("Unesi centar kruga:");
					System.out.print("x = ");
					double x = skener.nextDouble();
					System.out.print("y = ");
					double y = skener.nextDouble();
					Tacka centar = new Tacka(x, y);
					
					System.out.println("Unesi poluprecnik kruga:");
					System.out.print("r = ");
					double r = skener.nextDouble();
										
					objekti[i] = new Krug(r, centar);
			}
			else 
			{
				System.out.println("Nepoznati objekat");
				i--;
			}
									
		}
		
		PiramidaKupa piramidaKupa;
		
		System.out.println("\nKreiranje piramida i kupa:\n");
		for(int i=0; i<objekti.length; i++)
		{	
			System.out.println(objekti[i]);
			System.out.print("Unesi visinu: ");
			double visina = skener.nextDouble();
			piramidaKupa = new PiramidaKupa(objekti[i], visina);
			
			System.out.println("\n" + piramidaKupa);
			System.out.println("Zapremina: " + piramidaKupa.zapremina() + "\n");
				
		}
		
				
	}

}