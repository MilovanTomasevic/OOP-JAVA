package linkedList;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa ilustruje upotrebu generickog tipa LinkedList<>
 * koji implementira uopstenu dvostruko povezanu listu.
 *
 */
public class PolyLine {
	
	private LinkedList<Tacka> polyline = new LinkedList<Tacka>();
	
	// konstruktor: kreira poligonalnu liniju od niza parova koordinata
	public PolyLine(double[][] koordinate){
		for(double[] xy: koordinate)
			polyline.add(new Tacka(xy[0],xy[1]));
	}

	// konstruktor: kreira poligonalnu liniju od niza tacaka
	public PolyLine(Tacka[] tacke){
		for(Tacka tacka: tacke)
			polyline.add(tacka);
		
		// polyline.addAll(Arrays.asList(tacke));
	}
	
	// dodavanje tacke zadate koordinatama
	public void dodajTeme(double x, double y) {
		polyline.add(new Tacka(x,y));
	}
	
	// dodavanje zadate tacke
	public void dodajTeme(Tacka tacka){
		polyline.addLast(tacka);
	}
	
	public Tacka vratiPrvo() {
		//return polyline.getFirst();
		//return polyline.peek();
		return polyline.peekFirst();
	}
	
	public Tacka vratiPoslednje() {
		//return polyline.getLast();
		return polyline.peekLast();
	}
	
	public String toString(){
		StringBuilder rez = new StringBuilder();
		for(Tacka teme: polyline)
			rez.append(teme).append(" ");
		return rez.toString();
	}
	
	public String toStrDescend() {
		StringBuilder rez = new StringBuilder();
		Iterator<Tacka> iter = polyline.descendingIterator();
		while(iter.hasNext())
			rez.append(iter.next()).append(" ");
		return rez.toString();
	}
}
