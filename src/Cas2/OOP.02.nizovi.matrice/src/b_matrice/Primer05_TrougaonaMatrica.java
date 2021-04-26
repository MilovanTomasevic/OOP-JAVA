package b_matrice;

import java.util.Scanner;
/**
 * Primer ilustruje pravljenje 'trougaone' matrice:
 * i-ta vrsta matrice ima i+1 element koji se unose sa standardnog ulaza.
 */
public class Primer05_TrougaonaMatrica {

    public static void main(String[] args) {
        System.out.println("Unesite broj vrsta 'trougaone' matrice:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] trougaona = new int[n][];
        System.out.println("Unesite elemente:");
        for (int i = 0; i < n; i++) {
            // pravljenje i-te vrste
            trougaona[i] = new int[i+1];
            for (int j = 0; j < trougaona[i].length; j++)
                trougaona[i][j] = sc.nextInt();
        }
        showMe(trougaona);
    }

    static void showMe(int[][] m) {
        for (int[] row: m) {
            for (int e: row)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}