package interfejs2;

public abstract class Povrs implements Povrsina, Obim {
	
	private Tacka centar;
	
	public Povrs() {
		centar = new Tacka();
	}
	
	public Povrs(Tacka centar) {
		this.centar = new Tacka(centar);
	}
	
	public Povrs(final Povrs p)	{
		this(p.centar);
	}

	public Tacka getCentar() {
		return centar;
	}
	
	/** metodi iz interfejsa Povrsina i Obim se ne implementiraju,
	 *  ostaju apstraktni, pa ce i sama klasa biti apstraktna
	 */
	
	public double rastojanjeDoCentra(Povrs p) {
		return centar.rastojanje(p.centar);
	}
	
	public String toString() {
		return "centar u tacki " + centar;
	}
}
