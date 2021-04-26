package velikiCeliBrojevi_mnozenje;

import java.util.ArrayList;

public class VelikiCeoBroj implements Comparable<VelikiCeoBroj> {
	// znak broja
	private char znak; 
	// lista cifara (cifre su objekti klase Integer)
	private ArrayList<Integer> cifre; 
	
	// podrazumevani konstruktor pravi praznu listu cifara
	public VelikiCeoBroj() {
		cifre = new ArrayList<>();
	}
	
	// konstruktor koji pravi veliki ceo broj na osnovu 
	// pojedinacnih karaktera (koji su cifre) datog stringa
	public VelikiCeoBroj(String linija) {
		znak = '+';
		if(linija.startsWith("-"))
			znak='-';
		cifre = new ArrayList<>(); 
		for(int i = 1; i < linija.length(); i++)
			cifre.add(linija.charAt(i)-'0');		
	}
	
	public char getZnak() {
		return znak;
	}
	
	public ArrayList<Integer> getCifre() {
		return cifre;
	}
	
	public VelikiCeoBroj mnozenjeJednocifrenimBrojem(int broj) {
		char znak = (broj >= 0) ? '+' : '-';
		
		// dobijamo apsolutnu vrednost cifre
		if(broj < 0) broj = -broj;
		
		VelikiCeoBroj rezultat = new VelikiCeoBroj();
		int prenos = 0;
		for(int j = cifre.size()-1; j >= 0; j--) {
			int p = cifre.get(j) * broj + prenos;
			rezultat.cifre.add(0, p % 10);
			prenos = p / 10;
		}
		if(prenos > 0)
			rezultat.cifre.add(0, prenos);
		
		if(this.znak == znak) rezultat.znak = '+';
		else rezultat.znak = '-';
		
		return rezultat;
	}
	
	public int compareTo(VelikiCeoBroj vcb){
		if(znak == '-' && vcb.znak == '+') return -1;
		else if(znak == '+' && vcb.znak == '-') return 1;
		else if(znak == '+') return absVeci(vcb);
		else return -absVeci(vcb);
	}

	private int absVeci(VelikiCeoBroj vcb){
		if(cifre.size() > vcb.cifre.size()) return 1;
		if(cifre.size() < vcb.cifre.size()) return -1;
		for(int i = 0; i < vcb.cifre.size(); i++){
			if (cifre.get(i) > vcb.cifre.get(i)) return 1;
			if (cifre.get(i) < vcb.cifre.get(i)) return -1;
		}
		return 0;
	}
	
	public String toString(){
		String broj = (znak == '-') ? "-" : "";
		for(int i = 0; i < cifre.size(); i++)
			broj += cifre.get(i);
		return broj;
	}

}
