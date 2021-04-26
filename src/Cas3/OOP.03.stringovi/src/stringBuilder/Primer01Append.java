package stringBuilder;

import java.util.Scanner;

/**
 * Program demonstrira upotrebu klase StringBuilder.
 */
public class Primer01Append {

    // Nekada zelimo da cesto vrsimo modifikaciju stringa.
    // Usled imutabilnosti, to moze biti neefikasno,
    // tako da mozemo koristiti specijalizovanu klasu za to
    // cije je ime StringBuilder.
    public static void main(String[] args) {
        // Pretpostavimo da zelimo da sa standardnog ulaza unosimo rec po rec,
        // i da od svih unetih reci napravimo veliki string koji ih sve sadrzi.
        // Unos staje kada korisnik unese rec exit.

        // Pravimo objekat klase StringBuilder u koji cemo dodavati reci.
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        String ulaz = sc.next();
        while (! ulaz.equals("kraj")) {
            // Ako smo usli u petlju, znamo da je korisnik
            // uneo nesto sto NIJE 'kraj', tako da tu rec dodajemo
            // u StringBuilder objekat.
            sb.append(ulaz + " ");
            // Alternativno, mozemo ULANCAVATI pozive metoda append,
            // jer metod append vraca referencu na StringBuilder nad kojim je pozvan
            // sb.append(input).append(" ");

            // Citamo sledecu rec
            ulaz = sc.next();
        }

        // Na kraju, na standardni izlaz ispisujemo uneto.
        String output = sb.toString();
        System.out.println(output);
        // Alternativno, sadrzaj StringBuilder objekta mozemo ispisati i sa:
        // System.out.println(sb); // jvm sama zove toString()

        sc.close();
    }
}