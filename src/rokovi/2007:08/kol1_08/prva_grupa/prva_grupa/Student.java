package prva_grupa;

public class Student extends Osoba  
{
	private static double suma_godina_studija_svih_studenata = 0.0;
	private static int count = 0;
	
	private String naziv_fakulteta;
	private String naziv_smera;
	private int god_upisa;
	private int god_studija;
	
	// Konstruktor na osnovu zadatih kompletnih podataka kojim se opisuje student
	public Student(String ime, String adresa, String datum, String fakultet, String smer, int god_upisa, int god_studija)
	{
		// Poziv konstruktora bazne klase Osoba
		super(ime,adresa,datum);
		naziv_fakulteta = fakultet;
		naziv_smera = smer;
		this.god_upisa = god_upisa;
		this.god_studija = god_studija;
		count++;
		suma_godina_studija_svih_studenata += god_studiranja();
	}
	
	// Konstruktor kopije
	public Student(final Student student)
	{
		// Neophodno je najpre kreirati objekat pozivom konstruktora - u ovom
		// slucaju konstruktora natklase, kako bi se kasnije postavile odgovarajuce
		// vrednosti za promenljive clanice
		super();
		// Clanice ime, adresa i datum se ne vide u klasi Student, pa je potrebno
		// koristiti set-metode za postavljanje njihovih vrednosti
		setIme(student.getIme());
		setDatum(student.getDatum());
		setAdresa(student.getAdresa());
		naziv_fakulteta = student.naziv_fakulteta;
		naziv_smera = student.naziv_smera;
		god_upisa = student.god_upisa;
		god_studija = student.god_studija;
		
		// Drugi nacin:
		// super(student.getIme(), student.getDatum(), student.getAdresa());
		// naziv_fakulteta = student.naziv_fakulteta;
		// naziv_smera = student.naziv_smera;
		// god_upisa = student.god_upisa;
		// god_studija = student.god_studija;
		
		// Generalno, treba azurirati staticke clanice count i 
		// suma_godina_studija_svih_studenata, ali nije neophodno. Semanticki
		// gledano, ako smo kreirali kopiju nekog studenta, radi se o objektu
		// sa istim podacima, sto ne menja sumu godina studija svih studenata.
		// count++;
		// suma_godina_studija_svih_studenata += god_studiranja();
		
	}
	
	public static double prosek(){
		return suma_godina_studija_svih_studenata / count;
	}
	
	public void bojaMarkice(){
		System.out.println("  Boja markice je zelena");
	}
	
	private int god_studiranja(){
		return 2008 - god_upisa;
	}
	
	public String toString(){
		return "\n" + super.toString() + "\nFakultet: " + naziv_fakulteta +
		               "\nSmer: " + naziv_smera + "\nGodina upisa: " + god_upisa 
		                + "\nGodina studija: " + god_studija;
	}
	
	

}
