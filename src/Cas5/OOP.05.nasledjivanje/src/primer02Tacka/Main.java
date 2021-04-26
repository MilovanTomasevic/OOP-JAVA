package primer02Tacka;

public class Main {

	public static void main(String[] args) {
		// Na samom pocetku programa nema nijedne tacke
		// u memoriji postoji samo promenljiva brojacTacaka cija je vrednost 0
		System.out.println("Ukupno instancirano tacaka: " + Tacka.getBrojacTacaka());

		// Pravimo tacku u (0, 0)
		Tacka t = new Tacka();
		
		// Pozivamo konstruktor kopija kako bi napravili novu tacku
		// takodje u (0, 0)
		Tacka p = new Tacka(t);

		// Pravimo tacku u (6, 9)
		Tacka s = new Tacka(6, 9);
		
		// Pravimo referencu na tacku koju povezujemo da pokazuje
		// na VEC POSTOJECU tacku (ne pravimo novi objekat)
		Tacka q = s;
		
		System.out.println("Ukupno instancirano tacaka: " + Tacka.getBrojacTacaka());
		System.out.println("distance(t, s) = " + Tacka.distance(t, s));
		System.out.println("t.distance(s) = " + t.distance(s));

		System.out.println("t = " + t.toString());
		System.out.println("p = " + p.toString());
		System.out.println("s = " + s.toString());
		System.out.println("g = " + s.toString());

		// 't' i 'p' su dve razlicite tacke sa istim kooridanata
		if(t == p)
			System.out.println("t == p");
		else
			System.out.println("t != p");

		// 's' i 'q' su ista tacka
		if(s == q)
			System.out.println("s == q");
		else
			System.out.println("s != q");
	}

}
