package krug;

import java.util.Scanner;

public class TestKrug {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesi koordinate centra kruga i poluprecnik kruga:");
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double r = sc.nextDouble();
		
		Krug krug = new Krug(x, y, r);
		
		System.out.println("Unesi koordinate tacke:");
		x = sc.nextDouble();
		y = sc.nextDouble();
		sc.close();
		System.out.println("Tacka: (" + x + ", " + y + ")");
		
		System.out.println();
		System.out.println(krug);
		System.out.printf("Obim kruga je: %.2f\n", krug.obim());
		System.out.printf("Povrsina kruga je: %.2f\n", krug.povrsina());
				
		System.out.println("Broj napravljenih krugova je: " + Krug.brojKrugova());
		
		if(krug.tackaUKrugu(x, y))
			System.out.println("Tacka pripada krugu");
		else
			System.out.println("Tacka ne pripada krugu");
		
		System.out.println();
		
		Krug krug1 = new Krug();
		System.out.println(krug1);
		System.out.printf("Obim kruga je: %.2f\n", krug1.obim());
		System.out.printf("Povrsina kruga je: %.2f\n", krug1.povrsina());
				
		System.out.println("Broj napravljenih krugova je: " + Krug.brojKrugova());
		
		if(krug1.tackaUKrugu(x, y))
			System.out.println("Tacka pripada krugu");
		else
			System.out.println("Tacka ne pripada krugu");
	}
}
