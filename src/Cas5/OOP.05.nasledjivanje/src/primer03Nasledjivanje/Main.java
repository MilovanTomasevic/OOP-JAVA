package primer03Nasledjivanje;

public class Main {

	public static void main(String[] args) {
		// Instanciramo nekoliko objekata nase hijerarhije
		Pravougaonik pravougaonik = new Pravougaonik(10, 20, 100, 200);
		Kvadrat kvadrat = new Kvadrat(new Tacka(2, 3), 40);
		Krug krug = new Krug(40);
		Elipsa elipsa = new Elipsa(new Tacka(), 11, 42);
		Trougao trougao = new Trougao(10, 10, 20, 20, 40, 40);
		
		System.out.println(pravougaonik);
		System.out.println(kvadrat);
		System.out.println(krug);
		System.out.println(elipsa);
		
		// Kako mozemo dobiti centar nekog Oblika?
		Tacka centar = krug.getCentar();
		// centar = krug.centar; // ovo je u redu, jer je polje protected
		System.out.println("\nKrug se nalazi u tacki " + centar);

		// Duzina dijagonale pravougaonika?
		System.out.println("\nduzina dijagonale pravougaonika = " + pravougaonik.dijagonala());

		// Duzine stranica trougla?
		System.out.println("\nDuzine stranica trougla: AB = " + trougao.getAB() + " BC = " + trougao.getBC()
				+ " CA = " + trougao.getCA());
		
		// Kako mozemo TRANSLIRATI Oblik?
		// Nase klase iz hijerarhije Oblik ne nude tu funkcionalnost,
		// ali mozemo izvrsiti translaciju koristeci klasu Tacka.

		// Ako zelimo da sacuvamo staru tacku PRE TRANSLACIJE ne mozemo sa:
		// Tacka c1 = krug.getCentar();
		// vec moramo da dobijemo KOPIJU tacke s obzirom na to
		// da joj sledi promena nakon translacije
		Tacka c1 = new Tacka(krug.getCentar());

		krug.getCentar().translate(10, 20);
		System.out.println("\nKrug je tranisliran iz " + c1 + " u " + krug.getCentar() + " koristeci vektor (10, 20)");

		// Pravimo Kvadrat na osnovu postojece tacke c1
		Kvadrat k = new Kvadrat(c1, 8);
		System.out.println("\n" + k);

		// Traslacija tacke c1 nece uticati na centar kvadrata jer
		// kvadrat ima sopstvenu kopiju tacke c1 kao centar
		// Ukoliko se u konstruktoru Oblik(Tacka centar) umesto
		// 		this.centar = new Tacka(centar);
		// stavi: this.centar = centar;
		// centar kvadrata ce biti promenjen
		System.out.print("Tacka " + c1);
		c1.translate(-2, 2);
		System.out.println(" nakon translacije: " + c1);
		System.out.println(k);

		// kopija kvadrata k
		Kvadrat kk = new Kvadrat(k);
		System.out.println("\nKopija kvadrata:");
		System.out.println(kk);
		kk.getCentar().translate(-1, 2);
		System.out.println("\nNakon translacije centra kopije kvadrata:");
		System.out.println("Kopija: " + kk);
		System.out.println("Kvadrat: " + k);

		// Kako dobiti rastojanje izmedju centara dva Oblika?
		double dist = krug.getCentar().distance(kvadrat.getCentar());
		System.out.println("\nRastojanje izmedju " + krug + " i " + kvadrat + " je " + dist);
	}

}
