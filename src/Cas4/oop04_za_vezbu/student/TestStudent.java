package student;

import java.util.Scanner;

public class TestStudent 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		// Ucitavaju se ime i prezime studenta, fakultet i godina studija
		System.out.print("Ime: ");
		String ime = sc.next();
		System.out.print("Prezime: ");
		String prezime = sc.next();
		System.out.print("Fakultet: ");
		String fakultet = sc.next();
		System.out.print("Godina: ");
		int godina = sc.nextInt();
		sc.close();
		// Generise se string sa imenom i prezimenom studenta razdvojenih belinom
		String imePrezime = ime + " " + prezime;
		
		// Kreira se objekat klase Student, a instancne promenljive se 
		// inicijalizuju ucitanim vrednostima.
		Student student1 = new Student(imePrezime, fakultet, godina);
		// Ispis podataka o studentu. Implicitno se poziva metod toString() za 
		// generisanje String-reprezentacije.
		System.out.println(student1);
		
		// Kreira se objekat klase Student pozivom podrazumevanog konstruktora,
		// tako da ce instancne promenljive biti postavljene na podrazumevane vrednosti.
		Student student2 = new Student();
		System.out.println(student2);
	}
}
