package linkedList;

public class TestPolyLine {

	public static void main(String[] args) {

		double[][] koordinate = { {1,2}, {2,3}, {3,4}, {4,5} };
		// poziv konstruktora koji ocekuje niz parova koordinata
		PolyLine poly1 = new PolyLine(koordinate);
		System.out.println("poly1 = " + poly1);
		
		Tacka tacka1 = new Tacka(10,0);
		// dodavanje novog temena
		poly1.dodajTeme(tacka1);
		System.out.println("nakon dodavanja temena " + tacka1 + ":");
		System.out.println("poly1 (asc) = " + poly1);
		System.out.println("poly1 (desc) = " + poly1.toStrDescend());
		System.out.println("Prvo teme: " + poly1.vratiPrvo());
		System.out.println();
		
		Tacka tacke[] = new Tacka[koordinate.length];
		for(int i = 0; i < tacke.length; i++)
			tacke[i] = new Tacka(koordinate[i][0], koordinate[i][1]);
		// poziv konstruktora koji ocekuje niz tacaka
		PolyLine poly2 = new PolyLine(tacke);
		System.out.println("poly2 = " + poly2);
		
		// dodavanje novog temena zadatom parom svojih koordinata
		poly2.dodajTeme(256.0,-256.0);
		System.out.println("nakon dodavanja temena (256.0, -256.0):");
		System.out.println("poly2 (asc) = " + poly2);
		System.out.println("poly2 (desc) = " + poly2.toStrDescend());
		System.out.println("Poslednje teme: " + poly2.vratiPoslednje());
	}
}
