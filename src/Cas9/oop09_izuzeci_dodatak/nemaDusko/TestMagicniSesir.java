package nemaDusko;

public class TestMagicniSesir {

	public static void main(String[] args) {

		// ako se desi da prilikom pravljenja bilo kog sesira u njemu ne bude Duska,
		// ispisujemo poruku o tome i program se zavrsava
		try {
			// pravimo tri sesira
			MagicniSesir plaviSesir = new MagicniSesir("plavi sesir");
			MagicniSesir crveniSesir = new MagicniSesir("crveni sesir");
			MagicniSesir zeleniSesir = new MagicniSesir("zeleni sesir");

			// ispisujemo njihove String-reprezentacije
			System.out.println(plaviSesir+"\n");
			System.out.println(crveniSesir+"\n");
			System.out.println(zeleniSesir+"\n");

		} catch(NemaDuskoException e) {
			//e.printStackTrace();
			//System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
}
