package testLinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Klasa ilustruje prostu upotrebu metoda klase LinkedList<> koji ne postoje u klasi ArrayList<>. 
 * 
 * Klasa LinkedList<> ima dva konstruktora:
 *     podrazumevani - kreira praznu listu
 *     sa argumentom tipa Collection<>  - kreira
 *          LinkedList<> objekat koji inicijalno sadrzi
 *          reference na objekte kolekcije prosledjene
 *          kao argument
 *
 *   Svaki element liste opisan je ugnjezdenom generickom statickom klasom Node: 
 *   private static class Node<E> {
 *      E item;
 *      Node<E> next;
 *      Node<E> prev;
 *
 *      Node(Node<E> prev, E element, Node<E> next) {
 *           this.item = element;
 *           this.next = next;
 *           this.prev = prev;
 *       }
 *   }
 *   
 *   Lista je predstavljena referencama na pocetni i krajnji element.
 *   Clanice klase su:
 *   int size;
 *   Node<E> first;
 *   Node<E> last;       
 *      
 * spisak vecine metoda:
 * 		add(), addAll()
 * 		addFirst(), addLast()
 * 		get(), getFirst(), getLast()
 * 		remove(), removeFirst(), removeLast()
 * 		removeFirstOccurence(), removeLastOccurence()
 * 		removeAll(), retainAll()
 * 		clear(), isEmpty()
 * 		set()
 * 		size()
 * 		iterator(), listiterator(), descendingIterator()        
 * 		subList() 
 * 		toArray() 
 * 		indexOf(), lastIndexOf(), contains(), containsAll()
 */
public class TestLinkedList {

	public static void main(String[] args) {

		// podrazumevani konstruktor:
		LinkedList<String> imena = new LinkedList<>(); // zagradice <> su obavezne!
						// prazna povezana lista stringova (elementi su tipa String)
		
		System.out.println("LinkedList<String> imena = new LinkedList<>();");
		System.out.println("imena: " + imena); // implicitno se poziva metod toString()
		System.out.println();
		
		// konstruktor koji prima kolekciju kao argument:
		imena = new LinkedList<>(Arrays.asList("Stanko", "Pavle", "Stevica", "Mladen", "Stevica", "Milica", "Ana"));
		
		System.out.println("imena = new LinkedList<>(Arrays.asList(\"Stanko\", \"Pavle\", \"Stevica\",\"Mladen\", \"Stevica\",\"Milica\", \"Ana\"));");
		System.out.println("imena: " + imena);
		System.out.println();
		
		// Queue<> metodi
		
		System.out.println("Dodaje element na kraj liste (kao rep):");
		imena.offer("Milica"); 
		
		System.out.println("imena.offer(\"Milica\");");
		System.out.println();
		System.out.println("imena: " + imena);	
		System.out.println();
		
		
		
		System.out.println("Uklanja i vraca glavu liste. NoSuchElementException ako je lista prazna:");
		String bivsaGlava = imena.remove();

		System.out.println("String bivsaGlava = imena.remove();");
		System.out.println();
		System.out.println("imena: " + imena);
		System.out.println("bivsaGlava: " + bivsaGlava);
		System.out.println();
		
		
		
		System.out.println("Uklanja i vraca glavu liste. Vraca null ako je lista prazna");
		bivsaGlava = imena.poll();
		
		System.out.println("bivsaGlava = imena.poll();");
		System.out.println();
		System.out.println("imena: " + imena);
		System.out.println("bivsaGlava: " + bivsaGlava);	
		System.out.println();
		
		
		
		System.out.println("Vraca, ali ne uklanja, glavu liste. NoSuchElementException ako je lista prazna");
		String glava = imena.element();
		

		System.out.println("String glava = imena.element();");
		System.out.println();
		System.out.println("imena: " + imena);
		System.out.println("glava: " + glava);	
		System.out.println();
		
		
		
		System.out.println("Vraca, ali ne uklanja, glavu liste. Vraca null ako je lista prazna.");
		glava = imena.peek();
		
		System.out.println("glava = imena.peek();");
		System.out.println();
		System.out.println("imena: " + imena);
		System.out.println("glava: " + glava);
		System.out.println();
		
		
		// Deque<> metodi
		
		
		System.out.println("Dodaje element na pocetak, odnosno na kraj liste");
		imena.addFirst("Milica");
		imena.addLast("Stevica");
		
		System.out.println("imena.addFirst(\"Milica\");");
		System.out.println("imena.addLast(\"Stevica\");");
		System.out.println();
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		
		System.out.println("Vraca prvi, odnosno poslednji, element liste. NoSuchElementException ako je lista prazna");
		String prvi = imena.getFirst();
		String poslednji = imena.getLast();
		
		System.out.println("String prvi = imena.getFirst();");
		System.out.println("String poslednji = imena.getLast();");		
		System.out.println();
		System.out.println("prvi: " + prvi);
		System.out.println("poslednji: " + poslednji);
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		
		System.out.println("Uklanja i vraca prvi, odnosno poslednji, element liste. NoSuchElementException ako je lista prazna");
		String bivsiPrvi = imena.removeFirst();
		String bivsiPoslednji = imena.removeLast();
		
		System.out.println("String bivsiPrvi = imena.removeFirst();");
		System.out.println("String bivsiPoslednji = imena.removeLast();");
		System.out.println();
		System.out.println("bivsiPrvi: " + bivsiPrvi);
		System.out.println("bivsiPoslednji: " + bivsiPoslednji);
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		
		System.out.println("Dodaje element na pocetak, odnosno na kraj liste");
		imena.offerFirst("Milica");
		imena.offerLast("Stevica");
		
		System.out.println("imena.offerFirst(\"Milica\");");
		System.out.println("imena.offerLast(\"Stevica\");");
		System.out.println();
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		System.out.println("vraca, ali ne uklanja, prvi, odnosno poslednji element liste. Vraca null ako je lista prazna");
		prvi = imena.peekFirst();
		poslednji = imena.peekLast();
		
		System.out.println("prvi = imena.peekFirst();");
		System.out.println("poslednji = imena.peekLast();");
		System.out.println();
		System.out.println("prvi: " + prvi);
		System.out.println("poslednji: " + poslednji);
		System.out.println("imena: " + imena);
		System.out.println();
		
		System.out.println("Dohvata i uklanja prvi, odnosno poslednji element liste. Vraca null ako je lista prazna");
		bivsiPrvi = imena.pollFirst();
		bivsiPoslednji = imena.pollLast();
		
		System.out.println("bivsiPrvi = imena.pollFirst();");
		System.out.println("bivsiPoslednji = imena.pollLast();");
		System.out.println();
		System.out.println("bivsiPrvi: " + bivsiPrvi);
		System.out.println("bivsiPoslednji: " + bivsiPoslednji);
		System.out.println("imena: " + imena);
		System.out.println();
		
		
		imena.push("Milica");
		System.out.println("Gurnuto na vrh steka: Milica");
		System.out.println("imena: " + imena);
		System.out.println();
		
		String vrhSteka = imena.pop();
		System.out.println("Skinuto sa vrha steka: " + vrhSteka);
		System.out.println("imena: " + imena);
		System.out.println();
		
		System.out.println("Uklanjanje prve pojave elementa: \"Milica\"");
		imena.removeFirstOccurrence("Milica");
		
		System.out.println("imena.removeFirstOccurrence(\"Milica\");");
		System.out.println("imena: " + imena);
		System.out.println();
		
		System.out.println("uklanjanje poslednje pojave elementa: \"Stevica\"");
		imena.removeLastOccurrence("Stevica");
		
		System.out.println("imena.removeLastOccurrence(\"Stevica\");");
		System.out.println("imena: " + imena);
		
		
		System.out.println();
		System.out.println("Prolazak unazad pomocu descending iteratora: ");
		Iterator<String> descIter = imena.descendingIterator();
		while(descIter.hasNext())
			System.out.print(descIter.next() + " ");
		System.out.println();
		
	}
	
}
