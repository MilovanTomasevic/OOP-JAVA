package primer03Izraz;

public class Main {
	// globalne promenljive kako bi se koristile i u main-u i u pomocnom metodu
	public static Promenljiva x, y;

	// Vraca izraz 2+3
	public static Izraz getExample1() {
		Broj b1 = new Broj(2);
		Broj b2 = new Broj(3);
		Sabiranje s = new Sabiranje(b1, b2);

		// Nacin 1
		// ------------------------------------------------------------------------------
		// Mozemo eksplicitno kastovati u izraz posto funkcija vraca izraz
		// Izraz i = (Izraz)s;
		// return i;
		
		// Nacin 2
		// ------------------------------------------------------------------------------
		// Mozemo i javu naterati da kast uradi za nas implicitno
		// Izraz i = s;
		// return i;
		
		// Nacin 3
		// ------------------------------------------------------------------------------
		// Ali zapravo mozemo i direktno vratiti 'Sabiranje' koje ce
		// se implicitno kastovati u 'Izraz' zbog povratne vrednosti funkcije.
		return s;
	}
	
	// Vraca izraz 1*2 + 3
	public static Izraz getExample2() {
		Broj b1 = new Broj(1);
		Broj b2 = new Broj(2);
		Broj b3 = new Broj(3);
		Mnozenje m = new Mnozenje(b1, b2);
		return new Sabiranje(m, b3);
	}
	
	// Vraza izraz 2*x + 2*y, x=2, y=3
	public static Izraz getExample3() {
		Broj b = new Broj(2);
        System.out.println("x = 2, y = 3");
		x = new Promenljiva("x", 2);
		y = new Promenljiva("y", 3);
		
		// Primetimo da objekat na koji ukazuje referenca 'b'
		// mozemo dva puta iskoristiti jer se broj ne moze promeniti.
		// Na ovaj nacin mozemo ustedeti na memoriji.
		Mnozenje m1 = new Mnozenje(b, x);
		Mnozenje m2 = new Mnozenje(b, y);
		
		return new Sabiranje(m1, m2);
	}
	
	public static void main(String[] args) {
		Izraz i1 = getExample1();
		System.out.println(i1 + " = " + i1.izracunaj());
		
		Izraz i2 = getExample2();
		System.out.println(i2 + " = " + i2.izracunaj());

		Izraz i3 = getExample3();
		System.out.println(i3 + " = " + i3.izracunaj());

		// Ako promenimo vrednosti promenljivih 'x' i 'y'
        // to ce uticati i na vrednost izraza '2*x + 2*y'
        // jer se nisu pravile njihove kopije
		System.out.println("x = 5, y = 7");
		x.setVrednost(5);
		y.setVrednost(7);
		System.out.println(i3 + " = " + i3.izracunaj());
	}
}
