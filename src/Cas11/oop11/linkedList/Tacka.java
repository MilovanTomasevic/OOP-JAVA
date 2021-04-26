package linkedList;

public class Tacka {

	private double x, y;
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Tacka(final Tacka t) {
		this(t.x, t.y);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
