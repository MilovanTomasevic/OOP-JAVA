package nemaDusko;

/*
 * Klasa NemaDuskoException sadrzi samo neophodni minimum da bi bila korisnicki
 * definisana klasa izuzetaka:
 * - podrazumevani i konstruktor koji ocekuje jedan String (sa porukom o gresci)
 * Izvedena je iz klase Exception kao bazne, pa se radi o izuzecima koji se proveravaju.
 * Stoga postoji throws klauza u zaglavlju konstruktora klase MagicniSesir koji
 * moze da dovede do izbacivanja izuzetka ovog tipa,
 * a u test-klasi pozivi konstruktora ogradjeni su try-catch blokom koji rukuje
 * nasim tipom izuzetaka.
 */

public class NemaDuskoException extends Exception{
	/*
	 * vise o ovoj konstanti, na sledecem casu, kada budemo radili serijalizaciju
	 */
	private static final long serialVersionUID = 1L;

	public NemaDuskoException() {
		
	}
	
	public NemaDuskoException(String poruka){
		super(poruka); // poziv konstruktora bazne klase Exception
	}
}
