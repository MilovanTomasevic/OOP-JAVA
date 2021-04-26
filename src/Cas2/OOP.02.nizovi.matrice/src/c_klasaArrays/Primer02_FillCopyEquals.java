package c_klasaArrays;

// moze i da se importuje staticki metod neke klase dodavanjem kljucne reci
// static iza import a ispred punog imena metoda (ime paketa.ime klase.ime metoda)
// onda metod moze da se pozove samo navodjenjem svog imena
import java.util.Arrays;

import static java.util.Arrays.fill;

/**
 * Program prikazuje koriscenje metoda Arrays.fill, Arrays.copyOf i Arrays.copyOfRange
 */
public class Primer02_FillCopyEquals {

	public static void main(String[] args) {
		// Kako da napravimo niz duzine 30 koji ima sve elemente jednake 17?
		int[] a = new int[30];  // svi elementi su inicijalno 0
        show("a", a);
        Arrays.fill(a, 17);
		show("a", a);

		// Kako da u gornjem nizu postavimo da elementi za date indekse imaju vrednost -11?
		fill(a, 10, 20, -11);
        show("a", a);

        // Kako iskopirati vrednosti nekog niza za date indekse?
		int[] b = Arrays.copyOfRange(a, 5, 15);
		show("b", b);
		
		// Kako iskopirati ceo niz?
		int[] c = Arrays.copyOf(a, a.length);
		show("c", c);

		// Kako proveriti da li su dva niza jednaka?

        // metod Arrays.equals() vraca true akko:
        // - nizovi argumenti imaju jednak broj elemenata istih tipova
        // - odgovarajuci parovi elemenata imaju jednake vrednosti
        if(Arrays.equals(a, b))
            System.out.println("a i b su jednaki");
        else
            System.out.println("a i b nisu jednaki");


        if(Arrays.equals(a, c))
            System.out.println("a i c su jednaki");
        else
            System.out.println("a i c nisu jedanaki");
	}

	static void show(String name, int[] a) {
		System.out.println(name + ": " + Arrays.toString(a));
	}
}
