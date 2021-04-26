package stek;

public class Karta implements Comparable<Karta>{
	
	// atributi klase su tipa odgovarajucih enumeracija
	private Boja boja;
	private Vrednost vrednost;
	
	public Karta(Boja boja, Vrednost vrednost){
		this.boja=boja;
		this.vrednost=vrednost;
	}
	
	// klasa implementira interfejs Comparable<>
	// pa ce biti moguce sortiranje liste karata
	// koriscenjem metoda Collections.sort()
	public int compareTo(Karta k){
		// prvo se porede boje karata
		// konstante enumeracije porede se
		// metodom compareTo() nasledjenim od bazne klase Enum<>
		int rez=boja.compareTo(k.boja);
		// ako su boje iste
		if(rez==0)
			// jaca je ona karta koja ima jacu vrednost
			return vrednost.compareTo(k.vrednost);
		// a inace ona koja ima jacu boju
		// nezavisno od vrednosti
		return rez;
	}
	
	public String toString(){
		// String-reprezantacija konstante enumeracije je
		// samo ime koje smo joj dali
		return "("+boja+","+vrednost+")";
	}

}
