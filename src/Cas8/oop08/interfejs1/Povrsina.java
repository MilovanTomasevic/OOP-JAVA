package interfejs1;

/** 
 * Interfejs Povrsina:
 * Kroz apstraktni metod povrsina() opisuje se jedna operacija
 * (ovde: racunanje povrsine povrsi).
 * One klase koje imaju potrebu za definisanjem ovakve operacije
 * implementirace dati interfejs.
 */
public interface Povrsina {

	/* Interfejs je kolekcija konstanti i/ili apstraktnih metoda
	 * i najcesce i sadrzi samo metode. 
	 * Definise samo prototipove metoda. 
	 * Svi metodi u interfejsu su podrazumevano public abstract,
	 * a konstante (ako postoje) public static final.
	 * 
	 * Interfejs moze da sadrzi veci broj apstraktnih metoda. 
	 */
	double povrsina();
}
