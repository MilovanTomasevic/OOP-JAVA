package stringovi;

public class Primer01Poredjenje {
    public static void main(String[] args) {
        // Pravimo promenljivu tipa String
        // Mozemo koristiti i sintaksu za pravljenje objekata.
        // String t = new String("hello world how are you today");
        String t = "hello world how are you today";

        // Ispisujemo nas string
        show("t", t);

        // Stringove poredimo koristeci metod 'equals'
        // ili metod 'equalsIgnoreCase'
        // -----------------------------------------------
        // NAPOMENA 1:
        // -----------------------------------------------
        // Stringove NE SMEMO porediti koristeci operator
        // ==
        // jer on "ne cita" sta pise u stringovima nego
        // poredi da li su jednake reference promenljivih
        // (String je klasni tip)
        // -----------------------------------------------

        String s = t + "?";
        show("s", s);
        if (s.equals(t))
            System.out.println("s == t");
        else
            System.out.println("s != t");

        String s1 = "Hello world how are you TODAY";
        show("s1", s1);
        if(s1.equals(t))
            System.out.println("s1 == t");
        else
            System.out.println("s1 != t");

        if(s1.equalsIgnoreCase(t))
            System.out.println("s1 == t (ignore case)");
        else
            System.out.println("s1 != t (ignore case)");

        // Leksikografsko (alfabetsko) poredjenje stringova
        int i = s1.compareTo(t);
        if(i == 0)
            System.out.println("s1 == t");
        else if(i < 0)
            System.out.println("s1 < t");
        else
            System.out.println("s1 > t");
    }

    static void show(String name, String value) {
        System.out.println(name + " = \"" + value + "\"");
    }
}
