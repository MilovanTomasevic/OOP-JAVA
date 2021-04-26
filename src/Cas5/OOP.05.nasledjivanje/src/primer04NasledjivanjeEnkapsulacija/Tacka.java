package primer04NasledjivanjeEnkapsulacija;

public class Tacka {
	private double x, y;

	private static int brojacTacaka;
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
		brojacTacaka++;
	}

	public Tacka() {
		this(0, 0);
	}

	public Tacka(Tacka t) {
		this(t.x, t.y);
	}

	public static double distance(Tacka a, Tacka b) {
		return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
	}
	
	public double distance(Tacka t) {
		return Tacka.distance(this, t);
	}
	
	public static int getBrojacTacaka() {
		return brojacTacaka;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
