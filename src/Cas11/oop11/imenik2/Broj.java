package imenik2;

import java.util.Scanner;

public class Broj {
	private String pozivni, lokal;
	
	public Broj(String pozivni, String lokal){
		this.pozivni = pozivni;
		this.lokal = lokal;
	}
	
	public String toString(){
		return "(" + pozivni + ")" + lokal;
	}
	
	public static Broj ucitajBroj(Scanner sc){
		System.out.println("Unesite pozivni i broj u lokalu");
		return new Broj(sc.next(), sc.next());
	}
}
