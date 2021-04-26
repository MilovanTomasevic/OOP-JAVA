package primer03StudentMinimalno;

public class Main {
    public static void main(String[] args) {

        // pravljenje objekta:
        // poziv podrazumevanog konstruktora koji je kompajler generisao
        Student student = new Student();
        // posto konstruktor ne radi nista, polja naseg objekta zadrzavaju podrazumevane vrednosti (null, 0.0)

        // ispisujemo studenta
        System.out.println("Stanje studenta:");
        System.out.println(student);
        System.out.println("...ili ipak nesto drugo ???");

        /* kao da smo napisali:
         * System.out.println(student.toString());
         * implicitno se poziva metod toString() nasledjen iz
         * univerzalne superklase Object
         * gde je definisan tako da vraca String-reprezentaciju objekta u obliku:
         *       <puno_kvalifikovano_ime_klase>@<hash_code_objekta(heksadekadno)>
         * [o hesiranju ce biti reci u drugom delu kursa:
         *     hes kod objekta je vrednost koja se generise na osnovu vrednosti reference]

         * zeleli bismo da o studentu znamo ime, prezime, indeks i prosek
         * pa je zato neophodno da napisemo ovaj metod u nasoj klasi
         * kao sto je pokazano u prethodnim primerima
         * ---  metod napravi i vrati String koji sadrzi stanje studenta
         */

        // mozemo sami da ispisemo stanje naseg studenta
        // -- samo ilustrujemo, jer ovo nije dobra praksa --
        // (poljima ime, prezime, indeks i prosek naseg studenta mozemo da pristupimo
        // zato sto imaju paketni nivo vidljivosti)
        System.out.println("\nStanje studenta, pojedinacno:");
        System.out.println(student.ime + " " + student.prezime + ", " + student.indeks + ", " + student.prosek);

        // zbog vidljivosti polja mozemo i da promenimo stanje
        // -- opet nije dobra praksa --
        student.ime = "Petar";
        student.prezime = "Petrovic";
        student.indeks = "mv15123";
        student.prosek = 9.5;
        System.out.println("\nPromenjeno stanje studenta, pojedinacno:");
        System.out.println(student.ime + " " + student.prezime + ", " + student.indeks + ", " + student.prosek);
    }
}
