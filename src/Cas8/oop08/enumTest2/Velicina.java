package enumTest2;

/** 
 * Velicina.java:
 * Ilustruje upotrebu tipa enumeracije.
 */

/* Tipu enumeracije mogu se dodati konstruktori, metodi i polja.
 * Tip Velicina je prosiren dodavanjem mogucnosti za skraceno
 * predstavljanje konstanti enumeracije.  
*/

public enum Velicina {
	
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL"); /* lista konstanti enumeracije se zavrsava tacka-zapetom */

	/* SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE(); */
	
	private String skracenica;
	
	/* Konstruktor se poziva samo prilikom automatskog pravljenja
	 * konstanti enumeracije. Njime se definise u kom formatu
	 * se zadaju konstane enumeracije u enum deklaraciji.
	 * 
	 * NAPOMENA! konstruktor je private, ne moze biti public,
	 * posto nije namenjen za pozivanje izvan tipa enumeracije. 
	 */
	private Velicina(String skracenica){
		this.skracenica = skracenica;
	}
	
	private Velicina() {
		this.skracenica = "SVE";
	}
	
	public String getSkracenica(){
		return skracenica;
	}
	
	// predefinisani metod toString()
	// koristi switch i this za njegovu kontrolu
	// metod iz SVAKE MOGUCE grane mora vratiti vrednost odgovarajuceg tipa
	public String toString(){
		switch(this){
		case SMALL:
			return "malo";
		case MEDIUM:
			return "srednje";
		case LARGE:
			return "veliko";
		case EXTRA_LARGE:
			return "bas veliko";
			default:
				return null;
		}
	}
}
