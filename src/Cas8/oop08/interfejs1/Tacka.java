package interfejs1;

public class Tacka {
	
	private double x; 
	private double y;
						 
	public Tacka()
	{ }
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Tacka(final Tacka t) {
		this(t.x, t.y);
	}
	
	public double rastojanje(final Tacka t) {
		return Math.sqrt((x-t.x)*(x-t.x)+(y-t.y)*(y-t.y));
	}
	
	public void pomeri(double dX, double dY) {
		x += dX;
		y += dY;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}