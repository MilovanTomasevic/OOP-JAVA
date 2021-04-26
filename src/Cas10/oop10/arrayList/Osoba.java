package arrayList;

public class Osoba implements Comparable<Osoba> {
	
	private String ime;
	private String prezime;
	
	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	
	// implementacija metoda compareTo() iz
	// interfejsa Comparable<> 
	// (ne zaboraviti "implements Comparable<Osoba>" u
	//  prvoj liniji definicije klase!)
	//
	// omogucuje da se metodom Collections.sort()
	// sortira kolekcija objekata tipa Osoba
	//
	// metod treba da vrati int:
	//     0 ako se radi o jednakim objektima
	//    <0 ako je tekuci objekat "manji" od objekta o
	//       (treba da se nadje ispred o u sortiranoj kolekciji)
	//    >0 ako je tekuci objekat "veci" od objekta o
	//       (treba da se nadje iza o u sortiranoj kolekciji)
	@Override
	public int compareTo(Osoba o){
		// najpre se porede prezime tekuce i osobe o
		// koristi se metod compareTo() klase String
		int rez = prezime.compareTo(o.prezime);
		// pa ako su prezimena ista
		if(rez == 0)
			// vraca se odnos imena
			return ime.compareTo(o.ime);
        // ako prezimena nisu ista, osobe su u istom
		// odnosu kao i njihova prezimena
		return rez;
		
		
		/* II nacin 
		 * (funkcionise jer kod za karakter "blanko" je manji od
		 *  kodova za sva slova i "ne kvari" poredjenje: u slucaju
		 *  da je jedno prezime prefiks drugog, krace je "manje" od duzeg)
		 */
		//return this.toString().compareTo(o.toString());
	}
	
	// predefinisanje metoda equals() nasledjenog od
	// univerzalne superklase Object
	// ovo je neophodno jer metodi contains(), indexOf() i lastIndexOf()
	// porede trazeni i tekuci element liste
	// koristeci metod equals()
	//
	// metod treba da vrati:
	// 		true - ako je tekuci objekat atribut po atribut identican objektu o
	//      false - inace
	//
	@Override
	public boolean equals(Object obj){
		// ako o nije tipa Osoba
		if(! (obj instanceof Osoba))
			// vraca se false
			return false;
		// inace, metod treba da vrati true
		// akko metod compareTo() vrati 0
		// argument metoda compareTo() je tipa Osoba
		// pa je kastovanje obavezno
		return this.compareTo((Osoba)obj) == 0;
	}
	
	// prvo prezime pa ime, da bi se videlo
	// da je izvrseno sortiranje u leksikografskom 
	// poretku
	public String toString(){
		return prezime + " " + ime;
	}
}