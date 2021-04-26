package interfejs2;

public class Krug extends Povrs
{
	private double radius;
	
	public Krug(double radius) {
		this.radius = radius;
	}
	
	public Krug(Tacka centar, double radius) {
		super(centar);
		this.radius = radius;	
	}
	
	public Krug(final Krug k) {
		super(k);
		radius = k.radius;
	}
	
	/** implementacija metoda iz interfejsa Povrsina
     *  racunanje povrsine tekuceg kruga */
	public double povrsina() {
		return radius * radius * Math.PI;
	}
		
	/** implementacija metoda iz interfejsa Obim
	 *  racunanje obima tekuceg kruga */
	public double obim() {
		return 2 * radius * Math.PI;
	}
	
	public String toString() {
		return "krug " + super.toString() + " poluprecnik je " + radius;
	}
}
