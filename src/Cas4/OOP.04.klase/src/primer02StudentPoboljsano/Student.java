package primer02StudentPoboljsano;

public class Student {
	// polja (atributi ili instancne promenljive) koja opisuju stanje objekta klase
	// (ono sto svaki objekat, tj. student ima svoje)
	private String ime, prezime, indeks;
	private double prosek;
	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Konstruktor - metod koji se poziva pri
	// pravljenju objekta
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public Student(String ime, String prezime, String indeks, double prosek) {
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks.toLowerCase();
		this.prosek = prosek;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "GETERI" - metodi koji vracaju korisniku nase klase deo trenutnog
	// 				stanja objekta.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public String getIme() { return ime; }
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getIndeks() {
		return indeks;
	}

	public double getProsek() {
		return prosek;
	}

	public int getGodinaUpisa() {
		String tmp = "20" + indeks.charAt(2) + indeks.charAt(3);
		// Klasa 'Integer' sadrzi staticki metod 'parseInt' koji moze da
		// konvertuje objekat klase String u primitivni tip 'int'
		return Integer.parseInt(tmp);
	}

	public int getBrojIndeksa() {
		String tmp = "" + indeks.charAt(4) + indeks.charAt(5) + indeks.charAt(6);
		return Integer.parseInt(tmp);
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "SETERI" - metodi koji na zahtev korisnika nase klase menjaju deo trenutnog
	// 				stanja objekta.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public void setIndeks(String indeks) {
		// Umesto da odmah postavimo vrednost indeksa,
		// mozemo proveriti da li je argument metoda u dobrom obliku,
		// odnosno da li je oblika ABCCDDD
		if (validirajIndeks(indeks))
			this.indeks = indeks;
		else
			// Ne moramo raditi nista, no mozemo ispisati nesto na stdout
			// radi ilustracije
			System.out.println("Neuspela promena indeksa, dati indeks '" + indeks + "' nije u korektnom obliku.");
	}

	// Uvodimo pojam privatnog metoda. To je funkcija koja opisuje neko ponasanje
	// objekta, ali je relevantna samo nama koji pisemo klasu.
	// Omogucava nam da neki kod koji se ponavlja apstrahujemo funkcijom i iskoristimo
	// je na vise mesta u nasoj klasi.
	// Spoljni svet ne zna za ovaj metod.
	private boolean validirajIndeks(String indeks) {
		indeks = indeks.toLowerCase();
		
		// Proveravamo studije
		if (indeks.charAt(0) != 'm' && indeks.charAt(0) != 'a')
			return false;

		// Proveravamo smer
		String dopustiviSmerovi = "mnvlrif";
		if (!dopustiviSmerovi.contains("" + indeks.charAt(1)))
			return false;
		
		// proveravamo ostatak indeksa (zahtevamo da su cifre)
		for (int i = 2; i < indeks.length(); i++)
			if (!Character.isDigit(indeks.charAt(i)))
				return false;

		// Inace, prosledjeni indeks je korektan
		return true;
	}
	
	private String validirajSmer(char studije, char smer) {
		if (studije == 'm')
			switch (smer) {
				case 'm': return "Teorijska matematika";
				case 'n': return "Primenjena matematika";
				case 'v': return "Statistika i aktuarska i finansijska matematika";
				case 'l': return "Profesor matematike i racunarstva";
				case 'r': return "Racunarstvo i informatika";
				case 'i': return "Informatika";
				default:  return null;
			}
		else if (studije == 'a' && smer == 'f')
			return "Astrofizika";
		else if (studije == 'a' && smer == 'i')
			return "Astroinformatika";
		else
			return null;

	}
	
	public String getSmer() {
		char studije = indeks.charAt(0);
		char smer = indeks.charAt(1);
		String rezultatValidacije = validirajSmer(studije, smer);
		if (rezultatValidacije == null)
			return "Smer nije validan";
		else
			return rezultatValidacije;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// metod toString()
	// za generisanje stringovne reprezentacije objekta klase
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public String toString() {
		return ime + " " + prezime + ", " + indeks + ", " + prosek;
	}
}
