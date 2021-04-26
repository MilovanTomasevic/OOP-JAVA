package primer03Izraz;

// Apstraktna klasa kojom opisujemo aritmeticki izraz
// Neka je gramatika E: E '+' E | E '*' E | broj | promenljiva
public abstract class Izraz {
	// klasa ne sadrzi polja

	// svaki izraz ima svoju vrednost
	public abstract double izracunaj();
}
