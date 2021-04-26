package interfejs3A;

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
	 *  klase koja implementira interfejs Opisivanje (Krug, Pravougaonik, Kvadrat)
	 */
	double rastojanjeDoCentra(Opisivanje p);
	
	/** metod getCentar() ce biti potreban za implementaciju metoda 
	 *  rastojanjeDoCentra() u klasama koje implementiraju interfejs Opisivanje
	 */
	Tacka getCentar();
}
