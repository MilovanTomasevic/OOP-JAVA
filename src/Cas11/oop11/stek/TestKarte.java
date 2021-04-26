package stek;

public class TestKarte {

	public static void main(String[] args) {

		// kreira se spil
		Spil spil = new Spil();
		// spil se zatim mesa
		spil.promesaj();
		System.out.println(spil);
		// podele se dve ruke (po 6 karata svakoj)
		// i sortiraju karte u njima
		Ruka mojaRuka = spil.podeliRuku(6).sortiraj();
		Ruka tvojaRuka = spil.podeliRuku(6).sortiraj();
		// ispis karata u rukama
		System.out.println("Moja ruka:  " + mojaRuka);
		System.out.println("Tvoja ruka: " + tvojaRuka);
		
		// ispis karata koje su ostale u spilu (na steku)
		System.out.println(spil);
	}

}
