package a_nizovi;

/**
 * Primer ilustruje pravljenje niza zadavanjem
 * inicijalnih vrednosti za elemente niza i
 * ispis elemenata niza.
 */
public class Primer02_InicijalizacijaMalogNiza {

	public static void main(String[] args) {
	    // Pravimo niz zadavanjem inicijalnih vrednosti za elemente
		int[] a = {1, 3, 5, 7, 9};	

		// niz u Javi je objekat i zna koliko ima elemenata
		System.out.println("Niz a ima " + a.length + " elemenata.");
		
		System.out.println("\nElementi niza a:");
		for (int e : a)
			System.out.print(e + " ");
		System.out.println();

        int b[] = a;
		System.out.println("\nb = a");
		// sada imamo dve nizovske promenljive koje sadrze
		// reference na isti niz u memoriji;
		// sto se promeni pomocu jedne, to "vidi" i druga,
        // jer gledaju u istu lokaciju u memoriji
		b[2] = 101;
		System.out.println("b[2] = " + b[2] + "\n");

		System.out.println("Elementi niza b:");
		for (int e : b)
			System.out.print(e + " ");
		System.out.println();

		System.out.println("\nElementi niza a:");
		for (int e : a) 
			System.out.print(e + " ");
		System.out.println();

        // a je sada referenca na novi niz zadatih elemenata
        // Obratiti paznju kako se sada pravi niz!
        // Naradba:
        // a = {5, 15, 25};
        // je sintaksno nekorektna, jer je promenljiva
        // a vec ranije deklarisana.
        // Ispravno je:
        a = new int[] {5, 15, 25};
        System.out.println("\nElementi niza a:");
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();

    }
}
