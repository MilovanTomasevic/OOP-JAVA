package interfejs1;

public class Krug extends Povrs {

	private double radius;
	
	public Krug(Tacka centar, double radius) {
		super(centar);
		this.radius = radius;	
	}
	
	public Krug(final Krug k) {
		super(k);
		radius = k.radius;
	}
	
	/** 
	 * Implementacija apstraktnog polimorfnog metoda. 
	 */
	public double povrsina() {
		return radius * radius * Math.PI;
	}
	
	public String toString() {
		return "krug " + super.toString() + " poluprecnik je " + radius;
	}
}
