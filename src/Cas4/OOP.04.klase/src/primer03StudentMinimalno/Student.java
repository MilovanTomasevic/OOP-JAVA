package primer03StudentMinimalno;

public class Student {
    /* sva polja su deklarisana bez atributa pristupa, tako da
     * se podrazumeva paketni nivo vidljivosti polja
     * (iz metoda bilo koje klase istog paketa moguce
     * je direktno pristupiti stanju objekta klase Student)
     */
    String ime, prezime, indeks;
    double prosek;

    /* ako ne napisemo sami konstruktor u klasi,
       kompajler ce automatski da generise konstruktor bez argumenata
       koji nazivamo "podrazumevani konstruktor"
       razlog je jasan:
       - Konstruktor je metod koji se poziva pri pravljenju objekta
         i klasa u Javi MORA DA IMA BAREM JEDAN KONSTRUKTOR
         ovaj automatski generisan ne radi nista, telo mu je prazno
                public Student() {}
    */

    /* ukoliko ne napisemo metod
         public String toString()
       za generisanje stringovne reprezentacije objekta klase
       klasa ce ga naslediti iz univerzalne superklase Object.
     */
}
