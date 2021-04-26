package enumTest2;

public class EnumTest {

	public static void main(String[] args) {
		
		// prolazimo kroz niz svih konstanti enumeracije, dobijen pozivom
		// statickog metoda values()
		// ispisujemo String-reprezentaciju tekuce konstante
		// (predefinisali smo metod toString(), pa se, umesto imena konstante,
		//  vraca neki drugi string koji smo zadali u toString())
		// i odgovarajucu skracenicu
		for(Velicina velicina: Velicina.values())
			System.out.println(velicina + ", skracenica: " + velicina.getSkracenica());
		
	}
}
