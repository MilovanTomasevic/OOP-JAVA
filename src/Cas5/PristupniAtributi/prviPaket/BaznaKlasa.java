package prviPaket;

/* sama klasa je public, pa ce biti dostupna i u drugim paketima */
public class BaznaKlasa {
	
	/* VAZNA NAPOMENA: ovde su atributi klase definisani sa raznim pristupnim atributima: public, protected, ...
	 * radi ilustracije po cemu se pristupni atributi medjusobno razlikuju u pogledu pristupanja i nasledjivanja
	 * 
	 * Zbog enkapsulacije mi uvek stavljamo da su atributi private
	 * (osim ako su u pitanju konstante, koje su public, static i final),
	 * ukoliko je njihovim vrednostima potrebno pristupati iz drugih klasa, pisemo public get*() metode,
	 * a ukoliko ima potrebe za menjanjem njihovih vrednosti iz drugih klasa,
	 * pisemo odgovarajuce public set*() metode.
	 * 
	 * NESTAVLJANJE private ZA PROMENLJIVE U KLASI DOVODI DO GUBLJENJA POENA
	 * NA KOLOKVIJUMU I/ILI ISPITU! Ne gubi se mnogo, ali se gubi.
	 * 
	 * Metode po pravilu definisemo kao public, osim mozda pomocnih metoda, koje pozivaju samo
	 * drugi metodi iste klase. Takvi pomocni metodi se mogu definisati i kao private
	 *
	 * Detaljno izucavanje ovog primera nije potrebno, vec on sluzi kao ilustracija
	 * npr. po cemu se to tacno razlikuje protected, od paketnog prava pristupa.
	 * Potrebno je da znate koji pristupni atributi postoje osim private i public
	 * i da imate neku predstavu o tome sta se njima postize.
	 *
	 * Kao sto je vec receno, za atribute cemo koristiti private, osim ako se ne kaze drugacije u zadatku. 
	 * Sve sto je private dostupno je samo
	 * kodu klase u kojoj je definisano i nikada se ne nasledjuje.
	 * Za metode cemo koristiti public. 
	 * Sve sto je public (ukljucujuci i public konstruktore) svuda je dostupno (u svim klasama svih paketa)
	 * i (osim konstruktora) nasledjuje se u svim izvedenim klasama, bilo da se one nalaze u istom paketu kao i
	 * bazna klasa ili u bilo kom drugom paketu. Konstruktori (bez obzira na pristupni atribut), nikada se ne nasledjuju,
	 * ali je neophodno pozivati ih, eksplicitno ili implicitno, u prvoj liniji konstruktora izvedene klase, koriscenjem
	 * kljucne reci super kao imena metoda.  
	 */

	public int javni; /* svuda dostupan, pa i u proizvoljnoj klasi drugog paketa */
					  /* nasledjuje se u izvedenim klasama i u ovom i u drugim paketima */
	private String privatni; /* dostupan samo kodu ove klase */
						  /* ne nasledjuje se nigde! */
	protected String zasticeni; /* dostupan klasama ovog paketa */
							 /* nasledjuje se u izvedenim klasama i u ovom i u drugim paketima */
	int paketni; /* dostupan klasama ovog paketa */
				 /* nasledjuje se u izvedenim klasama koje se nalaze samo u ovom paketu */
	
	/* konstruktori se ne nasledjuju */
	
	public BaznaKlasa() {
		javni = 100;
		privatni = "Privatni clan";
		zasticeni = "Zasticeni clan";
		paketni = 10;  
	}
	
	/* javni metodi su svuda nasledjeni i svuda dostupni */
	
	/* metod za promenu vrednosti privatnog atributa
	 * iz proizvoljne klase (bilo da se radi o atributu koji je deo 
	 * objekta bazne klase, bilo o atributu koji je deo objekta izvedene klase)
	 */
	public void setPrivatni(String privatni){
		this.privatni = privatni;
	}
	
	/* metod za pristup vrednosti privatnog atributa
	 * iz proizvoljne klase (bilo da se radi o atributu koji je deo 
	 * objekta bazne klase, bilo o atributu koji je deo objekta izvedene klase)
	 */
	public String getPrivatni() {
		return privatni;
	}
	
}
