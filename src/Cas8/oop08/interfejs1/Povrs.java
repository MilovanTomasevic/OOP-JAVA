package interfejs1;

public abstract class Povrs implements Povrsina {
	private Tacka centar;
	
	public Povrs() {
		centar = new Tacka();
	}
	
	public Povrs(Tacka centar) {
		this.centar = new Tacka(centar);
	}
	
	public Povrs(final Povrs p) {
		this(p.centar);
	}

	public Tacka getCentar() {
		return centar;
	}
	
	/**
     * metod iz interfejsa Povrsina - ne implementira se u klasi
	 * tako da ostaje apstraktan, pa ce i sama klasa biti apstraktna
	 */
	//public abstract double povrsina();
	
	public double rastojanjeDoCentra(Povrs p) {
		return centar.rastojanje(p.centar);
	}
	
	public String toString() {
		return "centar u tacki " + centar;
	}
}
