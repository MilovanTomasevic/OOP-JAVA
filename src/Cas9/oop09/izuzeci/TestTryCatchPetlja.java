package izuzeci;

import java.util.Scanner;

public class TestTryCatchPetlja {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite ceo broj: ");
		int i = sc.nextInt();
		sc.close();

		// telo for-petlje je try-catch blok 
		// (izbacivanje izuzetka ne uzrokuje prekid petlje)
		for(int j=3; j>=-1; j--)
			try {
				System.out.println("Uslo se u try: i=" + i + ", j=" + j);
				System.out.println("i/j = " + i/j);
				System.out.println("kraj try\n");
			} catch(ArithmeticException e){
				System.out.println("Uhvacen izuzetak: deljenje nulom!\n");
			}
		System.out.println("Dovidjenja!");
	}
}
