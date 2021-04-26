package z_dodatno02SingleLinkedList;

/* Klasa opisuje element (cvor) povezane liste */
public class Node {
	// sadrzaj elementa (npr. celobrojna vrednost)
	private int data;
	// referenca na sledeci element
	private Node next;

	// konstruktor
	public Node(int n) {
		data = n;
		next = null;
	}

	// get*()
	public int getData() {
		return data;
	}

	// hasNext() - da li postoji sledeci element?
	public boolean hasNext() {
		if (next == null)
			return false;
		else
			return true;
	}

	// getNext() - daj mi sledeci element (tj. referencu na njega)
	public Node getNext() {
		return next;
	}

	// set*()
	public void setNext(Node n) {
		next = n;
	}

	// stringovna reprezentacija elementa
	public String toString() {
		return "" + data;
	}
}
