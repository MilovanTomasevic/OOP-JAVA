package z_dodatno02SingleLinkedList;

/* klasa opisuje povezanu listu */
public class LinkedList {
	// glava liste
	private Node root;
	// broj elemenata liste
	private int size;

	// podrazumevani konstruktor - pravi praznu listu
	public LinkedList() {
		root = null;
		size = 0;
	}

	// umetanje elementa liste na pocetak
	public void insert(int n) {
		Node tmp = new Node(n);
		tmp.setNext(root);
		root = tmp;
		size++;
	}

	// vraca i-ti element liste
	public int get(int i) {
		if (i < 0 || i >= size) {
			System.out.println("Lose indeksiranje!");
			return 0;
		} 

		Node iter = root;
		while (i > 0) {
			i--;
			iter = iter.getNext();
		}
		return iter.getData();
	}

	// vraca glavu liste
	public Node getHead() {
		return root;
	}

	// velicina liste
	public int getSize() {
		return size;
	}
}
