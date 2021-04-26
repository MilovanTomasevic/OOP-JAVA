package primer03Izraz;

// Izraz koji je broj (konstanta)
public class Broj extends Izraz {
    // vrednost broja (konstante) je private
    // i nije obezbedjen metod setVrednost() tako
    // da vrednost ne moze biti promenjena
	private double vrednost;
	
	public Broj(double vrednost) {
		this.vrednost = vrednost;
	}
	
	public double getVrednost() {
		return vrednost;
	}

	@Override
	public double izracunaj() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return "" + vrednost;
	}
}
