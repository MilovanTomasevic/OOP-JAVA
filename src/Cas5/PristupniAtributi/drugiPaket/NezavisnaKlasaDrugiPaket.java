package drugiPaket;

/* BAZNA KLASA SE NE NALAZI U OVOM PAKETU PA MORAMO DA JE UKLJUCIMO */
import prviPaket.BaznaKlasa;

public class NezavisnaKlasaDrugiPaket {

	/* posto nije u relaciji nasledjivanja, nema smisla ni proveravati,
	 * ne nasledjuje nista od klase BaznaKlasa
	 */
	
	public static void main(String[] args) {

		/* poziv podrazumevanog konstruktora (koga je generisao kompajler) */
		IzvedenaKlasaDrugiPaket objekatIzvedene = new IzvedenaKlasaDrugiPaket();
		objekatIzvedene.probaNasledjivanja();
		objekatIzvedene.probaNasledjivanja2();
		
		System.out.println();
		
		BaznaKlasa objekatBazne = new BaznaKlasa();
		
		System.out.println("U nezavisnoj klasi koja se nalazi u drugom paketu:\n");

		System.out.print("SAMO javni clan je dostupan: ");
		System.out.println("javni = " + objekatBazne.javni);
		
		System.out.print("protected clan NIJE dostupan,\n");
		// System.out.println("zasticeni = " + objekatBazne.zasticeni);
		
		
		System.out.println("clan sa paketnim pravom pristupa NIJE dostupan.");
		// System.out.println("paketni = " + objekatBazne.paketni);
		
		System.out.println("privatni clan NIJE dostupan,");
		// System.out.println("privatni = " + objekatBazne.privatni); // stavljeno pod komentar jer nije dopusteno
		System.out.println("\tali njegovoj vrednosti se moze pristupiti pozivom javnog get*() metoda, ako postoji,");
		System.out.println("\tdok mu se vrednost moze promeniti pozivom javnog set*() metoda, ako postoji.");
		objekatBazne.setPrivatni("Privatni clan promenjen*****");
		System.out.println("Nakon primene set*() metoda: " + objekatBazne.getPrivatni());
		
	}

}
