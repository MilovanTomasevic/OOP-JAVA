package imenik;

import java.util.Scanner;

public class Broj {

	private String pozivni;
	private String lokal;
	
	public Broj(String pozivni, String lokal) {
		this.pozivni = pozivni;
		this.lokal = lokal;
	}
	
	public static Broj ucitajBroj(Scanner sc) {
		System.out.println("Unesite pozivni i broj u lokalu: ");
		String pozivni = sc.next();
		String lokal = sc.next();
		
		return new Broj(pozivni, lokal);
	}
	
	@Override
	public String toString() {
		return "(" + pozivni + ")" + lokal;
	}
}
