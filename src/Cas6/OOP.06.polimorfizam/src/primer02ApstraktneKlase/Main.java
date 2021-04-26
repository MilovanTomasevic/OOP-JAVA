package primer02ApstraktneKlase;

public class Main {

	public static void main(String[] args) {
		Kvadrat kvadrat = new Kvadrat(new Tacka(), 10);
		Pravougaonik pravougaonik = new Pravougaonik(new Tacka(10, 20), 100, 20);
		Trougao trougao = new Trougao(new Tacka(), new Tacka(20, 20), new Tacka(30, 30), new Tacka(10, 100));

		Elipsa elipsa = new Elipsa(new Tacka(10, 20), 10, 20);
		Krug krug = new Krug(new Tacka(1, 2), 16);

		// Vise nije moguce instancirati klasu Oblik, za donju naredbu se prijavljuje greska...
        // Oblik oblik = new Oblik(new Tacka());

        // ...ali je i dalje moguce deklarisati promenljivu tipa apstraktne klase 'Oblik':
        // Oblik elipsa;

		// ...i dodeliti joj referencu na objekat izvedene klase
		// Oblik elipsa = new Elipsa(new Tacka(10, 20), 10, 20);
		// -> Na ovaj nacin, instancira se objekat tipa 'Elipsa', potom
		// se vraca referenca tipa 'Oblik' na njega.

        // Sva dalja obrada je ista kao u primeru sa polimorfizmom.

        // Deklarisemo niz oblika i inicijalizujemo.
        // Vrsi se implicitno kastovanje u tip 'Oblik'. Ovo je bezbedno kastovanje
        // jer kvadrat, pravougaonik, trougao, elipsa i krug JESU oblici.
        Oblik[] oblici = {kvadrat, pravougaonik, trougao, elipsa, krug};

		// Racunacemo rastojanje od centra svakog oblika iz niza do centra datog kruga
        Krug oblik = new Krug(new Tacka(-5, 5), 12);
        System.out.println("Zadati oblik: " + oblik + "\n");

        // Iteriramo kroz niz
		for (Oblik o: oblici) {
			System.out.println(o); // polimorfno se izvrsava implicitni poziv metoda 'toString()'
			// Polimorfno se izvrsavaju metodi 'getObim()' i 'getPovrsina()'.
			System.out.println("O = " + o.getObim());
			System.out.println("P = " + o.getPovrsina());

			// Metod rastojanje do centra se ne izvrsava polimorfno, on se ponasa isto za svaki tip oblika
            System.out.printf("Rastojanje do centra zadatog oblika = %.2f\n\n", o.rastojanjeDoCentra(oblik));
		}

		// Kako da prebrojimo instance klase pravougaonik? (Pravougaonik i Kvadrat)
		// Koristimo binarni operator 'instanceof' koji vraca 'true' ako je prvi argument
		// instanca klase koja predstavlja drugi argument.
		int brojacPravougaonika = 0;
		for (int i = 0; i < oblici.length; i++) { 	// alternativni nacin da iteriramo
			Oblik o = oblici[i];
			if (o instanceof Pravougaonik) {
                brojacPravougaonika++;
                // Za pravougaonike i kvadrate ispisujemo i opisani krug.
                // Pomocu promenljive tipa Oblik moguce je pozivati
                // samo polimorfne metode.
                // Meotd opisaniKrug() klase Pravougaonik ne ispunjava uslove za polimorfizam
                // pa je pri pozivu ovog metoda neophodno kastovanje nanize u tip Pravougaonik
                // (Idea sama dodaje kastovanje)
                System.out.println("Opisani krug oko oblika " + o);
                System.out.println(((Pravougaonik) o).opisaniKrug());
                System.out.println();
            }
		}

		System.out.println("Pronadjeno pravougaonika i kvadrata: " + brojacPravougaonika);

		// Kako traziti samo instance klase pravougaonik (bez kvadrata)?
		// Za objasnjenje konsultovati materijal okacen na stranici.
		brojacPravougaonika = 0;
		for (Oblik o: oblici)
			if (o.getClass() == Pravougaonik.class)
				brojacPravougaonika++;
		System.out.println("Pronadjeno pravougaonika: " + brojacPravougaonika);
	}
}
