package pravougaonik;

/*
 * Klasa Tacka kojom je predstavljena tacka u 2D-ravni
 */
public class Tacka 
{
	// Instancne promenljive - x i y koordinata tacke
	private double x;
	private double y;
	
	// Podrazumevani konstruktor postavlja tacku u koordinatni pocetak
	public Tacka()
	{}
	
	// Konstruktor sa datim vrednostima za koordinate tacke
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// "Copy-konstruktor": kreira kopiju postojeceg objekta klase Tacka.
	// Kljucna rec final ne sprecava promenu objekta tacka unutar konstruktora.
	// Generalno, final se navodi da se naglasi da objekat koji je prosledjen kao argument
	// nece biti modifikovan, vec da se samo pristupa vrednostima njegovih 
	// instancnih promenljivih.
	public Tacka(final Tacka tacka) {
		this(tacka.x, tacka.y); // x = tacka.x; y = tacka.y;
	}
	
	// Metod za pomeranje tacke duz x i y ose
	public void pomeri(double x_pomeraj, double y_pomeraj) {
		x += x_pomeraj;
		y += y_pomeraj;
	}
		
	// Metod za racunanje rastojanja do zadate tacke
	public double rastojanje(final Tacka tacka) {
		return Math.sqrt( (x - tacka.x) * (x - tacka.x)
						+ (y - tacka.y) * (y - tacka.y));
	}
	
	// Metod koji vraca vrednost x koordinate tacke
	public double getX() {
		return x;
	}
	
	// Metod koji vraca vrednost y koordinate tacke
	public double getY() {
		return y;
	}
	
	// Metod koji postavlja vrednost x koordinate tacke na datu vrednost
	public void setX(double x) {
		this.x = x;
	}
	
	// Metod koji postavlja vrednost y koordinate tacke na datu vrednost
	public void setY(double y) {
		this.y = y;
	}
	
	// Metod za dobijanje String reprezentacije tacke
	public String toString() {
		return String.format("(%.2f, %.2f)", x, y);
		// return "(" + x + ", " + y + ")";
		// return "(" + Double.toString(x) + ", " + Double.toString(y) + ")";
		// return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
	}
}