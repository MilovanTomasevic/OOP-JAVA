package primer01Sfera;

/**
 * Primer ilustruje:
 * - staticke promenljive i staticke metode
 * - medjusobno pozivanje konstruktora
 * - konstruktor kopije
 */

/* import statickog clana (ovde konstante) PI klase java.lang.Math
 * moguce je koristiti konstantu PI bez navodjenja imena klase */
import static java.lang.Math.PI;

public class Sfera {
	// instancne promenljive (svaka sfera ima svoj primerak u memoriji)
	private double x;
	private double y;
	private double z;
	private double radius;

	// staticka promenljiva koju cemo koristiti
	// da brojimo koliko je instancirano objekata klase 'Sfera';
	// postoji tacno JEDAN primerak ove promenljive u memoriji
	// i postoji sve vreme izvrsavanja programa
	private static int brojac;

    /* konstruktor koji ocekuje sve neophodne podatke
     * (po vrednost za svaku instancnu promenljivu)
     */
    public Sfera(double x, double y, double z, double radius){
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        // Kada se poziva konstruktor, sigurni smo da se instancira
        // objekat klase kojoj konstruktor pripada.
        // To je pravi trenutak da inkrementiramo brojac objekata.
        brojac++;
    }

    /* konstruktor bez argumenata (podrazumevani konstruktor)
     * pravi reprezentativni primerak klase:
     * jedinicnu sferu sa centrom u koordinatnom pocetku
     */
    public Sfera(){
        /* poziv drugog konstruktora iste klase pomocu kljucne reci this
         * - mora biti prva naredba! */
        // ovde se poziva konstruktor sa 4 argumenta
        // koji nadalje preuzima odgovornost za inicijalizaciju objekta.
        // Na ovaj nacin mozemo smanjiti kolicinu koda i logike koja se ponavlja.
        // Primetimo da sada ne moramo da uvecavamo brojac jer to radi
        // konstruktor kojem delegiramo posao.
        this(0, 0, 0, 1);
    }

    /* konstruktor koji pravi jedinicnu sferu sa centrom u tacki (x, y, z) */
	public Sfera(double x, double y, double z){
	    this(x, y, z, 1);
	}



	/* konstruktor kopije - pravi sferu identicnu
	 * postojecoj sferi s
	 *
	 * final ispred 'Sfera s' ukazuje da metod
	 * nece menjati argument s, tj. nece se 
	 * nigde u telu metoda pojaviti s=...
	 * sto nece spreciti da se menjaju polja objekta
	 * na koji s referise (npr. moglo bi s.x=...)
	 */
	public Sfera(final Sfera s){
		this(s.x, s.y, s.z, s.radius); 
				// Poziv konstruktora koji ocekuje sve neophodne podatke
				// a prosledimo mu kao argumente odgovarajuca polja postojece sfere s.
				// Iako su privatna, mozemo da im pristupimo direktno (s.x, s.y, ...)
				// jer smo u klasi Sfera.
				// Van klase Sfera morali bismo da koristimo getere.
	}
	
	/* metod racuna i vraca zapreminu tekuce sfere (this)
	 * (primetiti koriscenje statickog clana PI klase Math) 
	 */
	public double zapremina(){
		return 4./3 * radius * radius * radius * PI;
				// radius^3 se moze izracunati i koriscenjem statickog metoda Math.pow():
				// Math.pow(radius, 3);
				// implicitno se poluprecniku pristupa sa this.radius!
	}

    /* Nas interni brojac krijemo od spoljasnjeg sveta, spoljasnjem svetu
     * dozvoljavamo samo da procita vrednost brojaca.
	 * (kada je promenljiva staticka i odgovarajuci get*() i set*()
	 *  metodi treba da budu staticki)
	 */
	public static int getBrojac(){ 
		return brojac;
	}

	// metod setBrojac() je naveden radi ilustracije da this
    // ne moze da se koristi u statickom metodu
    // nema realne potrebe za ovima metodom
	private static void setBrojac(int brojac) {
		// NE MOZE: this.brojac
		Sfera.brojac = brojac; 
	}

	/* get*() metodi za dohvatanje vrednosti koordinata centra sfere
	 * i poluprecnika (kada promenljiva nije staticka, ni odgovarajuci
	 * get*() i set*() metodi ne treba da budu staticki) */
	
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
	
	/* metod set*() za promenu vrednosti poluprecnika sfere iz koda druge klase */
	public void setRadius(double radius) {
		this.radius = Sfera.ispravanRadius(radius) ? radius : this.radius;
	}
	
	/* Proveru da li je vrednost radijusa pozitivna vrsimo u statickom metodu.
	 * Primetiti da je vrednost radijusa ulazni parametar za metod!
	 * Metod cemo pozivati pre promene radijusa postojece sfere ali
	 * i PRE pravljenja sfere sa datim radijusom
	 *      iz ovog drugog razloga => metod mora da bude staticki
	 * Uobicajena praksa (nije pravilo) je da u konstruktoru
	 * NE VRSIMO provere ispravnosti inicijalnih vrednosti za polja.
	 * Konstruktor ocekuje korektne ulazne podatke a sve potrebne provere
	 * vrsimo pre pravljenja objekta statickim metodima.
     */
	public static boolean ispravanRadius(double radius) {
		return radius > 0;
	}
	
	/* obicno se u tekstu zadatka kaze kako izgleda String-reprezentacija objekta
	 * koju metod treba da izgradi i vrati.
	 */
	@Override
	public String toString(){
		return "centar = (" + x + ", " + y + ", " + z + ") R = " + radius;
	}
}
