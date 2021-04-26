package enumTest1;

/** 
 * Velicina.java:
 * Ilustruje upotrebu tipa enumeracije.
 * 
 * Promenljiva moze da sluzi za cuvanje vrednosti iz 
 * ogranicenog skupa. Te vrednosti mogu da se kodiraju
 * na proizvoljan nacin: celim brojevima, stringovima,
 * karakterima i slicno. Ovaj pristup je sklon greskama, 
 * jer se lako moze desiti da promenljiva dobije pogresnu 
 * vrednost. 
 * Od Java 5.0 moguce je definisati tip enumeracije.
 * Takav tip ima konacan broj imenovanih vrednosti. 
 *
 * Svi tipovi enumeracije su potklase klase Enum.
 * Iz nje se nasledjuju neki metodi. 
 * 
 * Dakle, tip enumeracije ponasa se kao klasa, u ovom slucaju samostalna
 * jer se definise u zasebnoj .java datoteci.
 * Klasa ce imati tacno 
 * 4 instance - nije moguce praviti nove objekte.
 * 
 * Imena koja dajemo konstantama enumeracije su od znacaja, 
 * jer metod toString() nasledjen od bazne klase Enum vraca ime konstante.
 * Dozvoljena su i velika i mala slova u imenima konstanti enumeracije, 
 * pri cemu se pravi razlika u velicini slova. 
 * Redosled kojim navodimo konstante je takodje bitan ukoliko ih poredimo metodom
 * compareTo(), takodje nasledjenim od bazne klase Enum.
 */
public enum Velicina {
	SMALL, MEDIUM, LARGE, EXTRA_LARGE /* nije neophodna tacka-zapeta na kraju liste konstanti enumeracije */
}
	
	
	
	
