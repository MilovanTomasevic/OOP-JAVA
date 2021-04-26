package izuzeci;

/*
 * Primer ilustruje tok izvrsavanja programa kada dodje do izbacivanja izuzetka
 * kao i kada do njega ne dodje.
 * 
 * Kada dodje do izbacivanja izuzetka: 
 * izvrsava se deo try-bloka do naredbe u kojoj se izbacuje izuzetak, 
 * ostatak try-bloka se preskace, 
 * izvrsava se catch-blok, 
 * a potom i naredbe ispod catch-bloka
 * 
 * Kada nema izbacivanja izuzetka: 
 * izvrsava se citav try-blok,
 * catch-blok se preskace,
 * a izvrsavanje se nastavlja pocev od prve naredbe ispod catch-bloka
 *
 * Tradicionalno se u Java literaturi upotreba izuzetaka ilustruje slucajem deljenja nulom.
 * Primer sluzi samo da bi se ilustrovala tehnika (jer se ovaj izuzetak jednostavno generise). 
 * Bilo bi jednostavnije i korektnije pre deljenja testirati da li delilac ima vrednost 0, 
 * pa ako je to slucaj, uopste ne vrsiti deljenje.
 */
import java.util.Scanner;

public class TestTryCatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite dva cela broja: ");
		int i = sc.nextInt();
		int j = sc.nextInt();
		sc.close();
		
		try {
			System.out.println("Uslo se u try: i=" + i + ", j=" + j);
			// Deljenje nulom - izbacuje se izuzetak
			System.out.println("i/j = " + i/j);
			// ovaj red se izvrsava samo ako izuzetak nije 'bacen'
			System.out.println("Kraj try");
		} 
		// ArithmeticException spada u RuntimeException-e, tako da 
		// kompajler ne zahteva od korisnika obradu pomocu try/catch,
		// tj. korisnik nece biti upozoren ukoliko nisu navedeni.	
		catch(ArithmeticException e){
			System.out.println("Uhvacen izuzetak: deljenje nulom!");
			//System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		System.out.println("Dovidjenja!");
	}

}
