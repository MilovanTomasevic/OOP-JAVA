package nemaDusko;

import java.util.Random;

/*
 * primer ilustruje definisanje sopstvenog tipa izuzetaka: NemaDuskoException
 * 
 * svaki sesir ima svoje ime,
 * a u sesiru se moze nalaziti slucajan broj zeceva
 * kojih moze biti najmanje 1, a najvise 5
 * 
 * svaki zec ima svoje (jedinstveno) ime koje se sastoji iz dva dela:
 * osnovnog imena, koje moze biti: "Dusko", "Zeka", "Peka" ili "Djura"
 * i rednog broja. 
 * Prvi kreirani Dusko imace ime "Dusko1", drugi "Dusko2" itd.
 * Prvi kreirani Zeka imace ime "Zeka1", drugi "Zeka2" itd.
 * (redni brojevi za jedno ime nezavisni su od rednih brojeva za ostala imena).
 * 
 * **************************************************************************************
 * Zelimo da u svakom sesiru postoji bar jedan zec Dusko.
 * Ako Duska nema, ne zelimo takav sesir :)
 * U slucaju da u konstruktoru klase MagicniSesir nije kreiran nijedan zec Dusko,
 * konstruktor izbacuje izuzetak tipa NemaDuskoException.
 * 
 * Klasa NemaDuskoException sadrzi samo neophodni minimum da bi bila korisnicki
 * definisana klasa izuzetaka:
 * - podrazumevani i konstruktor koji ocekuje jedan String (sa porukom o gresci)
 * Izvedena je iz klase Exception kao bazne, pa se radi o izuzecima koji se proveravaju.
 * Stoga postoji throws klauza u zaglavlju konstruktora,
 * a u test-klasi pozivi konstruktora ogradjeni su try-catch blokom koji rukuje
 * nasim tipom izuzetaka.
 * 
 */
public class MagicniSesir {
	// generator pseudo-slucajnih brojeva
	private static Random izbor = new Random();
	// konstanta, max broj zeceva u sesiru
	public static final int MAX_ZECEVA = 5;
	
	private String imeSesira;
	private Zec[] zecevi;
	
	// ako u sesiru nema nijednog Dusko zeca, izbacuje se izuzetak tipa NemaDuskoException
	public MagicniSesir(String imeSesira) throws NemaDuskoException{
		this.imeSesira = imeSesira;
		/*  (slucajan broj od 1 do 5) =
		 *  1 + (slucajan broj od 0 do 4)
		 */
		zecevi = new Zec[1+izbor.nextInt(MAX_ZECEVA)];
		
		boolean nemaDuska = true;
		for(int i=0; i<zecevi.length; i++){
			zecevi[i] = new Zec();
			if(zecevi[i].getIme().startsWith("Dusko"))
				nemaDuska = false;
		}
		// izbacivanje izuzetka tipa nase klase, pomocu naredbe throw
		// (na isti nacin na koji se izbacuju i standardni izuzeci)
		if(nemaDuska)
			throw new NemaDuskoException("Nema Duska u sesiru: " + imeSesira);
			//throw new NemaDuskoException();
	}
	
	// String-reprezentacija obuhvata ime sesira i String-reprezentacije zeceva u njemu
	public String toString(){
		StringBuffer rez = new StringBuffer(imeSesira + ":");
		for(Zec zec: zecevi)
			rez.append("\n\t").append(zec);
		return rez.toString();
	}
}
