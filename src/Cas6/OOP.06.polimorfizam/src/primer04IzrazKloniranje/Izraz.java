package primer04IzrazKloniranje;

public abstract class Izraz {
	public abstract double izracunaj();
	
	// Namecemo apstraktnu klasu koju ce klase hijerarhije
	// 	implementirati tako da vrate referencu na svoju kopiju.
	// Na ovaj nacin resavamo problem da kada imamo referencu na baznu klasu
	//  (iako je u stvari to objekat neke potklase) ipak mozemo izvrsiti kopiranje.
	public abstract Izraz klon();
}
