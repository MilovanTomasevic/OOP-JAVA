package primer05Tacka;

public class Tacka {
	private double x, y;
	
	// Konstruktor bez argumenata nazivamo "PODRAZUMEVANI KONSTRUKTOR".
	// Pozivali bi ga sa: Tacka t = new Tacka();
	// Obicno ga koristimo kada pravimo reprezentativni primerak klase
	// ovde: kooridanti pocetak
	public Tacka() {
		// x i y su vec inicijalizovani na 0 pa nije neophodno pisati:
//		this.x = 0;
//		this.y = 0;
	}
	
	// Standardan konstruktor za tacku, pozivamo sa:
	// Tacka t = new Tacka(2, 5);
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// Pravimo metod koji poredi tacke.
	// Primetimo da ovaj metod poredi objekte 'this' i 't' koji tu tacke.
	// Metod je jako slican onome koji poseduje klasa String.
	public boolean equals(Tacka t) {
		return this.x == t.x && this.y == t.y;
	}
	
	// Tacku mozemo da transliramo za neki pomeraj (dx, dy)
	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	public double distance(Tacka t) {
		// Smemo pristupiti privatnim clanovima tacke 't' jer smo unutar klase
		// Primetimo da racunamo rastojanje izmedju objekata 'this' i 't'
		return Math.sqrt((this.x-t.x)*(this.x-t.x) + (y - t.y)*(y - t.y));
	}

	// stringovna reprezentacija tacke: (x, y)
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

