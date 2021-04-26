package d_dodatno;

import java.util.Arrays;

/**
 * Primer ilustruje sortiranje dela niza
 */
public class Primer01_DelimicniSort {

    public static void main(String[] args) {
        double b[] = {1.34, -3.5, 2.3, 7.92, 5.7, -4.12, 2.3, -5, 11, 3.7};
        show("b",  b);

        // moguce je sortirati i deo niza izmedju dve zadate pozicije
        // sortira se niz b pocev od pozicije 2 (drugi argument),
        // a zavrsno sa pozicijom 5 (treci argument-1)
        Arrays.sort(b, 2, 7);
        System.out.println("Nakon sortiranja elemenata na pozicijama 2-6: ");
        show("b", b);
        System.out.println();
    }

    static void show(String name, double[] a) {
        System.out.println(name + ": " + Arrays.toString(a));
    }

}
