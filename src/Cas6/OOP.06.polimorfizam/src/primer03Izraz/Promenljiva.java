package primer03Izraz;

// Izraz koji je promenljiva
public class Promenljiva extends Izraz {
	private String ime;
	private double vrednost;
	
	public Promenljiva(String ime, double vrednost) {
		this.ime = ime;
		this.vrednost = vrednost;
	}
	
	public String getIme() {
		return ime;
	}
	
	public double getVrednost() {
		return vrednost;
	}

	// Promenljiva moze da uzme proizvoljnu vrednost
	public void setVrednost(double vrednost) {
		this.vrednost = vrednost;
	}
	
	@Override
	public double izracunaj() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return ime;
	}
}









