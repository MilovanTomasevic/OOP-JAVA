package interfejs3B;

/** 
 * Interfejs Opisivanje:
 * Sadrzi apstraktne metode:
 * - opisi(), vraca povrs opisanu oko date povrsi
 * - rastojanjeDoCentra(Opisivanje), za racunanje rasojanja do centra druge povrsi
 * - getCentar(), za vracanje centra povrsi 
 */

public interface Opisivanje {

	/** metod ce u svakoj od klasa koje ga implementiraju
	 * vratiti referencu na objekat opisan oko tekuceg objekta
	 * i to: ako se primeni na krug, vratice referencu na kvadrat
	 * opisan oko tog kruga, ako se primeni na pravougaonik
	 * (a specijalno i na kvadrat), vratice referencu na krug opisan oko njega
	 */
	Opisivanje opisi();
	
	/** metod kao stvarni argument prima referencu na objekat bilo koje
	 *  klase koja implementira interfejs Opisivanje (Krug, Pravougaonik, Kvadrat).
	 *  Posto ima istu implementaciju u svim pomenutim klasama, metod moze
	 *  da bude default (ova mogucnost uvedena je sa JDK 8). 
	 *  Default metod je moguce predefinisati u klasama koje implementiraju
	 *  dati interfejs.
	 */
	default double rastojanjeDoCentra(Opisivanje p) {
		return getCentar().rastojanje(p.getCentar());
	}
	
	Tacka getCentar();
}
