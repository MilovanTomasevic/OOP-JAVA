package drugiPaket;

/* BAZNA KLASA SE NE NALAZI U OVOM PAKETU PA MORAMO DA JE UKLJUCIMO */
import prviPaket.BaznaKlasa;

public class IzvedenaKlasaDrugiPaket extends BaznaKlasa{

	// Klasa nema dodatne atribute
	
	// Kompajler ce obezbediti podrazumevani konstruktor 
		
	public void probaNasledjivanja(){
		System.out.println("U izvedenoj klasi koja se nalazi u drugom paketu:\n");
		
		System.out.print("javni clan je nasledjen: ");
		System.out.println("javni = " + javni); 
		
		System.out.print("protected clan je nasledjen: ");
		System.out.println("zasticeni = " + zasticeni);
		
		System.out.println("clan sa paketnim pravom pristupa NIJE nasledjen. ");
		// System.out.println("paketni = " + paketni); // stavljeno pod komentar jer nije dopusteno
		// OVO JE RAZLICITO U ODNOSU NA IZVEDENU KLASU KOJA JE U ISTOM PAKETU KAO I BAZNA
		System.out.println("\tali je prisutan kao deo objekta izvedene klase");	
		
		
		System.out.println("privatni clan NIJE nasledjen,");
		// System.out.println("privatni = " + privatni); // stavljeno pod komentar jer nije dopusteno
		System.out.println("\tali je prisutan kao deo objekta izvedene klase");
		setPrivatni("Privatni clan promenjen***"); // javni metod jeste nasledjen, pa moze da se zove da pristupi i/ili 
						 // promeni vrednost private atributa bazne klase, koji jeste (bitan) 
						 // sastavni deo objekta izvedene (iako nije nasledjen)
		System.out.println("Nakon primene set*() metoda: " + getPrivatni());
		
	}
	
	public void probaNasledjivanja2() {
		/* poziv podrazumevanog konstruktora (koga je generisao kompajler) */
		IzvedenaKlasaDrugiPaket objekatIzvedene = new IzvedenaKlasaDrugiPaket();
		
		/* poziv podrazumevanog konstruktora (koji smo sami definisali) */
		BaznaKlasa objekatBazne = new BaznaKlasa();

		System.out.println("\nU izvedenoj klasi koja se nalazi u drugom paketu:\n");
		
		System.out.print("javni clan je dostupan: ");
		System.out.println("javni = " + objekatBazne.javni);
		
		System.out.print("protected clan NIJE dostupan,\n");
//		System.out.println("zasticeni = " + objekatBazne.zasticeni);
		System.out.println("\tali je nasledjen, pa moze: protected objekta izvedene = " + objekatIzvedene.zasticeni);
		System.out.println("\tIZVEDENA KLASA MOZE PRISTUPATI protected CLANU BAZNE KLASE SAMO PUTEM NASLEDJIVANJA, NE I" +
				" PREKO PROMENLJIVE BAZNOG TIPA.");
		
		
		System.out.println("clan sa paketnim pravom pristupa NIJE dostupan.");
		// System.out.println("paketni = " + objekatBazne.paketni);
		// Razlika u odnosu na slucaj kada se izvedena klasa nalazi u istom paketu kao i bazna
		
		System.out.println("privatni clan NIJE dostupan,");
		// System.out.println("privatni = " + objekatBazne.privatni); // stavljeno pod komentar jer nije dopusteno
		System.out.println("\tali njegovoj vrednosti se moze pristupiti pozivom javnog get*() metoda, ako postoji,");
		System.out.println("\tdok mu se vrednost moze promeniti pozivom javnog set*() metoda, ako postoji.");
		objekatBazne.setPrivatni("Privatni clan promenjen****");
		System.out.println("Nakon primene set*() metoda: " + objekatBazne.getPrivatni());
		
	}
}
