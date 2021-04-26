package prviPaket;

public class NezavisnaKlasaIstiPaket {
	
	/* posto nije u relaciji nasledjivanja, nema smisla ni proveravati,
	 * ne nasledjuje nista od klase BaznaKlasa
	 */

	public static void main(String[] args){
		
		/* poziv podrazumevanog konstruktora (koga je generisao kompajler) */
		IzvedenaIstiPaket objekatIzvedene = new IzvedenaIstiPaket();
		objekatIzvedene.probaNasledjivanja();
		objekatIzvedene.probaNasledjivanja2();
		
		System.out.println();
		
		/* poziv podrazumevanog konstruktora (koji smo sami definisali) */
		BaznaKlasa objekatBazne = new BaznaKlasa();
		
		System.out.println("U nezavisnoj klasi koja se nalazi u istom paketu:\n");

		System.out.print("javni clan je dostupan: ");
		System.out.println("javni = " + objekatBazne.javni);
		
		System.out.print("protected clan je dostupan: ");
		System.out.println("zasticeni = " + objekatBazne.zasticeni);
		
		
		System.out.print("clan sa paketnim pravom pristupa je dostupan: ");
		System.out.println("paketni = " + objekatBazne.paketni);
		
		System.out.println("SAMO privatni clan NIJE dostupan,");
		// System.out.println("privatni = " + objekatBazne.privatni); // stavljeno pod komentar jer nije dopusteno
		System.out.println("\tali njegovoj vrednosti se moze pristupiti pozivom javnog get*() metoda, ako postoji,");
		System.out.println("\tdok mu se vrednost moze promeniti pozivom javnog set*() metoda, ako postoji.");
		objekatBazne.setPrivatni("Privatni clan promenjen**");
		System.out.println("Nakon poziva set*() metoda: " + objekatBazne.getPrivatni());
	}
}
