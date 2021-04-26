package enumTest3;

import java.util.Scanner;

public class EnumTest {

	// Uvodjenje novog tipa Boja unutar druge klase EnumTest
	// ovo mora biti van bilo kog metoda i nema potrebe da na kraju enum deklaracije stoji ;
	// Tip enumeracije se u ovom slucaju ponasa kao ugnjezdena klasa u klasi EnumTest. 
	
	enum Boja {TREF, KARO, HERC, PIK}

	public static void main(String[] args) {

		for(Boja b: Boja.values())
			System.out.println(b.toString() + ", rbr: " + b.ordinal());

		System.out.println();

		Boja boja1 = Boja.KARO;

		System.out.println("Unesite ime boje (velikim slovima)");
		try(Scanner sc = new Scanner(System.in)){
			// staticki metod valueOf klase Enum koristi se za 
			// dobijanje reference na konstantu enumeracije odredjene prvim argumentom
			// (prosledjuje se odgovarajuci Class objekat za tip enumeracije)
			// dok se ime konstante zadaje kao drugi argument, tipa String.
			Boja boja = Enum.valueOf(Boja.class, sc.next());

			System.out.println(boja);
			// koriscenje promenljive tipa enumeracije za kontrolu switch
			switch(boja){
			// navode se samo imena konstanti, bez kvalifikovanja imenom enumeracije
			case TREF:
			case PIK:
				System.out.println("crna");
				break;
			case KARO:
			case HERC:
				System.out.println("crvena");
				break;
			}
			// nije neophodan slucaj default jer su pobrojane sve konstante enumeracije
			// a promenljva tipa enumeracije moze uzeti samo neku od njihovih vrednosti
			
			// ispitivanje u kakvom su odnosu uneta i eksplicitno zadata boja
			// tj. boja i boja1
			// metod compareTo() vraca razliku ordinala tekuceg i objekta argumenta
			int rez = boja.compareTo(boja1);
			if(rez<0)
				System.out.println(boja + " je \"slabija\" boja nego " + boja1);
			else if(rez>0)
				System.out.println(boja + " je \"jaca\" boja nego " + boja1);
			else
				System.out.println("Uneta boja, " + boja + ", je ista kao zadata.");
		}
	}
}
