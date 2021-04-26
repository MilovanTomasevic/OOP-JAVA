package primer04StudentMinimalnoEnkapsulacija;

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
         */

        // ispis stanja naseg studenta sada nije moguc
        // posto nismo obezbedili GETERE, nema nacina da pristupimo poljima
//        System.out.println("\nStanje studenta, pojedinacno:");
//        System.out.println(student.ime + " " + student.prezime + ", " + student.indeks + ", " + student.prosek);

        // promena stanja naseg studenta nije moguca iz istog razloga
        // polja su private i nismo obezbedili SETERE
//        student.ime = "Petar";
//        student.prezime = "Petrovic";
//        student.indeks = "mv15123";
//        student.prosek = 9.5;
//        System.out.println("\nPromenjeno stanje studenta, pojedinacno:");
//        System.out.println(student.ime + " " + student.prezime + ", " + student.indeks + ", " + student.prosek);
    }
}
