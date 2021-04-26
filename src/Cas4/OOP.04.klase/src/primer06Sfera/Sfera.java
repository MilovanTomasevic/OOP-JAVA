package primer06Sfera;

public class Sfera {
    /* polja kojim se opisuje stanje objekta
       (svaki objekat ima po svoj primerak svakog od njih)
     */
    private double x; // x-koordinata centra
    private double y; // y-koordinata centra
    private double z; // z-koordinata centra
    private double radius; // poluprecnik

    /* podrazumevani konstruktor - konstruktor bez argumenata
     * pravi reprezentativni primerak klase:
     * jedinicnu sferu sa centrom u koordinatnom pocetku
     */
    public Sfera(){
        radius = 1;
        /* x, y i z su implicitno inicijalizovani na 0
         * zbog svoje numericke prirode
         */
    }

    /* konstruktor koji pravi jedinicnu sferu sa centrom u tacki (x, y, z) */
    public Sfera(double x, double y, double z){
        // koordinate centra se postavljaju na konkretne vrednosti
        this.x = x;
        this.y = y;
        this.z = z;
        radius = 1;
    }

    /* standardni konstruktor koji ocekuje sve neophodne podatke
     * (po vrednost za svako polje)
     */
    public Sfera(double x, double y, double z, double radius){
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    /* get*() metodi za dohvatanje vrednosti koordinata centra sfere
     * i poluprecnika
     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getRadius() {
        return radius;
    }

    /* metod set*() za promenu vrednosti poluprecnika sfere iz koda druge klase
     */
    public void setRadius(double radius) {
        // moze da se doda provera da li je radijus pozitivan
        this.radius = ispravanRadius(radius) ? radius : this.radius;
    }

    /* private metod za proveru ispravnosti zadate vrednosti
     * radijusa.
     * Primetiti da se vrednost radijusa koja se proverava
     * prenosi metodu kao argument!
     */
    private boolean ispravanRadius(double radius) {
        return radius > 0;
    }

    /* metod racuna i vraca zapreminu tekuce sfere (na koju referise 'this') */
    public double zapremina(){
        return 4./3 * radius * this.radius * radius * Math.PI;
        // implicitno se poluprecniku pristupa sa
        // this.radius !

        // radius^3 se moze izracunati i pomocu statickog metoda
        // pow() klase Math:
        // Math.pow(radius, 3);
    }

    /* String-reprezentacija objekta (sfere)
     * obicno se u tekstu zadatka kaze kako treba da izgleda
     */
    public String toString(){
        return "centar = (" + x + ", " + y + ", " + z + ") R = " + radius;
    }
}
