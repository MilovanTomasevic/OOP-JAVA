package imenik;

import java.util.Scanner;

/**
 * Klasa koja opisuje broj telefona osobe.
 * U praksi bi trebalo proveravati korektnost brojeva,
 * ali za prikaz kako funkcionisu hes-mape, to nije od znacaja.
 */

public class Broj {
	private String pozivni, lokal;
	
	public Broj(String pozivni, String lokal){
		this.pozivni = pozivni;
		this.lokal = lokal;
	}
	
	public String toString(){
		return "(" + pozivni + ")" + lokal;
	}
	
	/* staticki metod kojim se ucitavaju podaci o broju telefona */
	public static Broj ucitajBroj(Scanner sc){
		System.out.println("Unesite pozivni i broj u lokalu");
		return new Broj(sc.next(), sc.next());
	}
}
