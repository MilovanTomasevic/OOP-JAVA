package imenik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Imenik {

	private HashMap<Osoba, Broj> imenik = new HashMap<>();

	public void dodajKontakt(Osoba o, Broj b) {
		imenik.put(o, b);
	}
	
	public Broj nadjiBroj(Osoba o) {
		return imenik.get(o);
	}
	
	public String toString() {
		ArrayList<Osoba> kljucevi = new ArrayList<Osoba>(imenik.keySet());
		Collections.sort(kljucevi);
		StringBuilder sb = new StringBuilder();
		for(Osoba o : kljucevi)
			sb.append(o + ", broj telefona: " + imenik.get(o)).append("\n");
		
		return sb.toString();
	}
}
