package b_matrice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Primer ilustruje pravljenje i ispis matrice uz pomoc metoda.
 * Dimenzije matrice i elementi se unose sa standradnog ulaza.
 */
public class Primer02_PrenosMatriceMetodu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
		int[][] a = unesi();
				
		System.out.println("ispisi1(a):");
		ispisi1(a);
		
		System.out.println("\nispis2(a):");
		ispisi2(a);
		
		System.out.println("\nispis3(a):");
		ispisi3(a);
    }

	private static int[][] unesi() {

		System.out.println("Unesite dimenzije matrice (broj vrsta pa broj kolona)");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] tmp = new int[n][m];
		System.out.printf("Unesite matricu dimenzije %dx%d\n", n, m);
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				tmp[i][j] = sc.nextInt();

		return tmp;
	}

	static void ispisi1(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.printf("%3d", a[i][j]);
			System.out.println();
		}
	}

	static void ispisi2(int[][] a) {
		for (int[] tmp: a) {
			for (int e: tmp)
				System.out.print(e + " ");
			System.out.println();
		}
	}

	static void ispisi3(int[][] a) {
		System.out.println(Arrays.deepToString(a));
	}
}
