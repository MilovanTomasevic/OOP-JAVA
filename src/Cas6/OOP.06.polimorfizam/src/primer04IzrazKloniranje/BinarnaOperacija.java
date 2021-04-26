package primer04IzrazKloniranje;

public  abstract class BinarnaOperacija extends Izraz {
	private Izraz levi, desni;
	
	public BinarnaOperacija(Izraz levi, Izraz desni) {
		// Umesto this.levi = levi
		// koristimo polimorfan metod 'klon' koja pravi
		// kopiju prosledjenog objekta.
		this.levi = levi.klon();
		this.desni = desni.klon();
	}
	
	public Izraz getLevi() {
		return levi;
	}
	
	public Izraz getDesni() {
		return desni;
	}
}
