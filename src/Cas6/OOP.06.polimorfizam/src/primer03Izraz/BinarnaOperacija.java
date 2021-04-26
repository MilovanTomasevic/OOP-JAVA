package primer03Izraz;

// Apstraktna klasa koja opisuje izraz sa binarnom operacijom
// E '+' E | E '*' E
public abstract class BinarnaOperacija extends Izraz {
    // levi i desni operand koji su izrazi
	private Izraz levi, desni;
	
	public BinarnaOperacija(Izraz levi, Izraz desni) {
	    // Zelimo da levi i desni operand binarene operacije
        // budu upravo prosledjeni izrazi
        // a ne njihove kopije
        this.levi = levi;
		this.desni = desni;

		// ako bismo zeleli da koristimo kopije kao ranije
        // ne bi bilo moguce, jer je klasa Izraz apstraktna!
        // this.levi = new Izraz(levi);
	}
	
	public Izraz getLevi() {
		return levi;
	}
	
	public Izraz getDesni() {
		return desni;
	}

    // Ne znamo kako da izracunamo vrednost izraza jer
    // operacija moze da varira pa ne implementiramo metod
    // izracunaj() (ostaje apstraktan).
    // Iz tog razloga je i klasa apstraktna.

}
