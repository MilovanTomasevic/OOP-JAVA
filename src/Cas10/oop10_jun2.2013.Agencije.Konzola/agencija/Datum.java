package agencija;

import java.util.Scanner;

public class Datum {

	private int dan;
	private int mesec;
	private int godina;
	
	public Datum(int dan, int mesec, int godina) {
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}
	
	public static Datum ucitajDatum(Scanner scDatum) {
		System.out.println("Unesite datum:");
		return new Datum(scDatum.nextInt(), scDatum.nextInt(), scDatum.nextInt());
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Datum))
			return false;
		Datum d = (Datum) obj;
		return dan == d.dan && mesec == d.mesec && godina == d.godina;
	}
	*/
	
	@Override
	public String toString() {
		return dan + "." + mesec + "." + godina + ".";
	}
}
