package velikiCeliBrojevi_sabiranje;

import java.util.ArrayList;

public class VelikiCeoBroj {
	// znak broja
	private char znak; 
	// lista cifara (cifre su objekti klase Integer)
	private ArrayList<Integer> cifre; 
	                                  
	// podrazumevani konstruktor pravi praznu listu cifara
	public VelikiCeoBroj() {
		cifre = new ArrayList<>();
	}
	
	// konstruktor koji pravi veliki ceo broj na osnovu 
	// pojedinacnih karaktera (koji su cifre) stringa linija
	public VelikiCeoBroj(String linija) {
		znak = '+';
		if(linija.startsWith("-")) {
			znak='-';
			// uklanja se znak
			linija = linija.replace("-", "");
		}
		// Okrecemo cifre kako bi na i-toj poziciji  
		// bila cifra i-te tezine
		String broj = new StringBuilder(linija).reverse().toString();
		
		cifre = new ArrayList<>();
		for(int i = 0; i < broj.length(); i++)
			cifre.add(broj.charAt(i)-'0');	
	}

	public char getZnak() {
		return znak;
	}
	
	public ArrayList<Integer> getCifre() {
		return cifre;
	}
	
	public static VelikiCeoBroj saberi (VelikiCeoBroj vcb1, VelikiCeoBroj vcb2) {
		VelikiCeoBroj rez = new VelikiCeoBroj();
		
		// Ako su brojevi istog znaka
		if(vcb1.znak == vcb2.znak){ 
			if(absVeci(vcb1, vcb2) > 0) rez = absSabiranje(vcb1, vcb2);
			else rez = absSabiranje(vcb2, vcb1);
			//Rezultat je istog znaka kao i jedan od ova dva broja
			rez.znak = vcb1.znak;
		}
		// Ako su brojevi razlicitog znaka
		else { 
			if(absVeci(vcb1, vcb2) > 0) {
				rez = absOduzimanje(vcb1, vcb2);
				rez.znak = vcb1.znak;
			}		
			else {
				rez = absOduzimanje(vcb2, vcb1);
				rez.znak = vcb2.znak;
			}
		}
		return rez;
	}

	private static int absVeci(VelikiCeoBroj vcb1, VelikiCeoBroj vcb2){
		if(vcb1.cifre.size() > vcb2.cifre.size()) return 1;
		if(vcb1.cifre.size() < vcb2.cifre.size()) return -1;
		for(int i = 0; i < vcb1.cifre.size(); i++){
			if (vcb1.cifre.get(i) > vcb2.cifre.get(i)) return 1;
			if (vcb1.cifre.get(i) < vcb2.cifre.get(i)) return -1;
		}
		return 0;
	}
	
	private static VelikiCeoBroj absSabiranje(VelikiCeoBroj veci, VelikiCeoBroj manji){
		VelikiCeoBroj zbir = new VelikiCeoBroj();
		
		int brCifaraManjeg = manji.cifre.size();
		int brCifaraVeceg = veci.cifre.size();
		int prenos = 0;
		for(int i = 0; i < brCifaraVeceg; i++ ){
			int c =	veci.cifre.get(i)
			+ ( brCifaraManjeg > i ? manji.cifre.get(i) : 0 )
			+ prenos;
			if(c >= 10){
				prenos = 1;
				c -= 10;
			}
			else
				prenos = 0;
			zbir.cifre.add(c);
		}
		if(prenos > 0)
			zbir.cifre.add(prenos);
		return zbir;
	}

	private static VelikiCeoBroj absOduzimanje(VelikiCeoBroj veci, VelikiCeoBroj manji) {
		VelikiCeoBroj razlika = new VelikiCeoBroj();
		
		int brCifaraManjeg = manji.cifre.size();
		int brCifaraVeceg = veci.cifre.size();
		int pozajmica = 0;
		for( int i = 0; i < brCifaraVeceg; i++ ){
			int c = veci.cifre.get(i) - (brCifaraManjeg > i ? manji.cifre.get(i) : 0) - pozajmica;
			if(c < 0){
				pozajmica = 1;
				c += 10;
			}
			else pozajmica = 0;
			razlika.cifre.add(c);
		}
		// brisemo vodece nule
		while(razlika.cifre.size() > 1 && razlika.cifre.get(razlika.cifre.size()-1) == 0)			
			razlika.cifre.remove(razlika.cifre.size()-1);
		
		return razlika;
	}
	
	public String toString(){
		String broj = (znak == '-') ? "-" : "";
		for(int i = cifre.size()-1; i >= 0; i--)
			broj += cifre.get(i);
		return broj;
	}
}
