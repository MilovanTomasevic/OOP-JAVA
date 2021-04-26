package izuzeci;

import java.util.Scanner;

public class TestTryCatchPetlja2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite ceo broj: ");
		int i = sc.nextInt();
		sc.close();

		/* citava for-petlja je u try-bloku:
		 * po izbacivanju izuzetka
		 * ne nastavlja se sa izvrsavanjem petlje
		 * pa stoga nema ni ispisa za j=-1
		 */
		try {
			System.out.println("Uslo se u try\n");
			for(int j=3; j>=-1; j--){
				System.out.println("telo for-petlje: i="+ i + ", j=" + j);
				System.out.println("i/j=" + i/j + "\n");
			}
			System.out.println("Kraj try\n");	
		} catch(ArithmeticException e){
			System.out.println("Uhvacen izuzetak: deljenje nulom!\n");
		}
		System.out.println("Dovidjenja!");
	}
}
