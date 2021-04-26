package primer01Student;

public class Student {
	// polja (atributi ili instancne promenljive) koja opisuju stanje objekta klase
	// (ono sto svaki objekat, tj. student ima svoje)
	//
	// vrsi se enkapsulacija: polja su private
	// to znaci da stanje objekta postaje nedostupno
 	// iz metoda drugih klasa
	private String ime; // ime studenta
	private String prezime; // prezime studenta
	private String indeks; // indeks studenta
	// implicitno se inicijalizuju na null

	private double prosek; // prosek studenta; implicitno se inicijalizuje na 0.0
	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Konstruktor - metod koji se poziva pri
	// pravljenju objekta
	// Klasa MORA da ima BAREM JEDAN konstruktor
	//
	// this - referenca na objekat u kojem se trenutno nalazimo
	// U konstruktoru cesto koristimo kako bi razresili koliziju imena
	// 	kada konstruktor prima argument koji se zove isto kao neko od polja.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public Student(String ime, String prezime, String indeks, double prosek) {
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.prosek = prosek;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "GETERI" - metodi koji vracaju korisniku nase klase deo trenutnog
	// 				stanja objekta (obicno ih pisemo kada je izvrsena enkapsulacija polja)
	// Ne mora da znaci da svako polje TREBA da ima svoj geter. Konkretan geter
	// pravimo onda kada procenimo da ce nam neka vrednost biti potrebna.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getIndeks() {
		return indeks;
	}

	public double getProsek() {
		return prosek;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "SETERI" - metodi koji na zahtev korisnika nase klase menjaju deo trenutnog
	// 				stanja objekta (obicno ih pisemo kada je izvrsena enkapsulacija polja)
	// Ne mora da znaci da svako polje TREBA da ima svoj seter. Konkretan seter
	// pravimo onda kada procenimo da ce biti potrebe za izmenom neke vrednosti.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	// Dodatno zahtevamo godinu upisa...
	public int getGodinaUpisa() {
		String tmp = "20" + indeks.charAt(2) + indeks.charAt(3);
		// Klasa 'Integer' sadrzi staticki metod 'parseInt' koji moze da
		// konvertuje objekat klase String u primitivni tip 'int'
		return Integer.parseInt(tmp);
	}

	// ...broj indeksa studenta...
	public int getBrojIndeksa() {
		String tmp = "" + indeks.charAt(4) + indeks.charAt(5) + indeks.charAt(6);
		return Integer.parseInt(tmp);
	}

	// ...i pun naziv smera
	public String getSmer() {
		char studije = indeks.charAt(0);
		char smer = indeks.charAt(1);
		if (studije == 'm')
			switch (smer) {
				case 'm': return "Teorijska matematika";
				case 'n': return "Primenjena matematika";
				case 'v': return "Statistika i aktuarska i finansijska matematika";
				case 'l': return "Profesor matematike i racunarstva";
				case 'r': return "Racunarstvo i informatika";
				case 'i': return "Informatika";
				default:  return "Nepoznat smer...";
			}
		else if (studije == 'a' && smer == 'f')
			return "Astrofizika";
		else if (studije == 'a' && smer == 'i')
			return "Astroinformatika";
		else
			return "Nepoznat smer...";
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// metod toString()
	// za generisanje stringovne reprezentacije objekta klase;
	// kompajler implicitno poziva ovaj metod u situacijama kada metodu
	// System.out.println() prosledimo referencu na objekat klase
	// ili je "saberemo" sa String-om.
	//
	// definisemo metod toString() tako da vrati string sa stanjem objekta
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public String toString() {
		return ime + " " + prezime + ", " + indeks + ", " + prosek;
	}
}
