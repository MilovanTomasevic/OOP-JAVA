package stringBuilder;

public class Primer02RazniMetodi {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // Metod append vraca referencu na StringBuilder nad kojim je pozvan,
        // tako da mozemo ulancavati pozive (ovaj nacin rada koriste i neki drugi jezici)
        sb.append("Hello").append(" ").append("world, how are you today?");
        System.out.println("sb = " + sb);

        // II nacin:
        // StringBuilder mozemo da napravimo na osnovu String literala.
        StringBuilder sb1 = new StringBuilder("Hello ");
        sb1.append("world!");
        // ili, krace:
        // sb = new StringBuilder("Hello ").append("world, how are you today");
        System.out.println("sb1 = " + sb1);

        // III nacin:
        // StringBuilder mozemo da napravimo na osnovu String objekta.
        String tmp = "Java";
        StringBuilder sb2 = new StringBuilder(tmp).append(" i Intellij IDEA");
        System.out.println("sb2 = " + sb2);

        // Sadrzaj StringBuildera obrce u mestu.
        sb.reverse();

        System.out.println("Obrnuti string u sb: " + sb);

        System.out.println("Broj karaktera u sb: " + sb.length());

        // Mozemo da promenimo i-ti karakter.
        sb.setCharAt(0, '!');
        System.out.println("Promenjeni string u sb: " + sb);

        // Kako ocistiti StringBuilder? Postavljamo mu duzinu na 0 :)
        sb.setLength(0);
        sb.append("Hello world!");

        // Mozemo ubacivati i brisati podstringove
        sb.insert(6, "dear ");
        System.out.println("Posle umetanja \"dear\" u sb: " + sb);
        // Mozemo zameniti podstring sa datim indeksima drugim stringom
        sb.replace(6,10, "my sweet");
        System.out.println("Posle promene \"dear\" u \"my sweet\" u sb: " + sb);
        sb.delete(6, 15);
        System.out.println("Posle brisanja \"my sweet \" iz sb: " + sb);
    }
}
