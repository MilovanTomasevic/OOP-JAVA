package prviPaket;

public class IzvedenaIstiPaket extends BaznaKlasa{

	// Klasa nema dodatne atribute
	
	// Kompajler ce obezbediti podrazumevani konstruktor 
	
	public void probaNasledjivanja(){
		System.out.println("U izvedenoj klasi koja se nalazi u istom paketu:\n");
		
		System.out.print("javni clan je nasledjen: ");
		System.out.println("javni = " + javni); 
		
		System.out.print("protected clan je nasledjen: ");
		System.out.println("zasticeni = " + zasticeni);
		
		System.out.print("clan sa paketnim pravom pristupa je nasledjen: ");
		System.out.println("paketni = " + paketni);
		
		System.out.println("privatni clan NIJE nasledjen,");
//		System.out.println("privatni = " + privatni); // stavljeno pod komentar jer nije dopusteno
		System.out.println("\tali je prisutan kao deo objekta izvedene klase");
		setPrivatni("Privatni clan promenjen"); // javni metod jeste nasledjen, pa moze da se zove 
						// da pristupi i/ili promeni vrednost private atributa
		                // bazne klase, koji jeste (bitan) sastavni deo 
						// tekuceg objekta izvedene (iako nije nasledjen)
		System.out.println("Nakon primene set*() metoda: " + getPrivatni());
		
	}
	
	public void probaNasledjivanja2() {
		
		/* provera dostupnosti atributa postojeceg objekta bazne klase u metodu izvedene klase */
		BaznaKlasa objekatBazne = new BaznaKlasa();
		
		System.out.println("\nU izvedenoj klasi koja se nalazi u istom paketu:\n");
		
		System.out.print("javni clan je dostupan: ");
		System.out.println("javni = " + objekatBazne.javni);
		
		System.out.print("protected clan je dostupan: ");
		System.out.println("zasticeni = " + objekatBazne.zasticeni);
		
		System.out.print("clan sa paketnim pravom pristupa je dostupan: ");
		System.out.println("paketni = " + objekatBazne.paketni);
		
		System.out.println("privatni clan NIJE dostupan,");
		// System.out.println("privatni = " + objekatBazne.privatni); // stavljeno pod komentar jer nije dopusteno
		System.out.println("\tali njegovoj vrednosti se moze pristupiti pozivom javnog get*() metoda, ako postoji,");
		System.out.println("\tdok mu se vrednost moze promeniti pozivom javnog set*() metoda, ako postoji.");
		objekatBazne.setPrivatni("Privatni clan promenjen*");
		System.out.println("Nakon primene set*() metoda: " + objekatBazne.getPrivatni());
	}
}
