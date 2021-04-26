package z_dodatno01Stack;

public class Stack {
	// stek je predstavljen nizom elemenata tipa int
	private int[] elements;
	// pozicija elementa na vrhu steka
	private int headPtr;

	// podrazumevani konstruktor
	// pravi prazan stek inicijalnog kapaciteta 3
	public Stack() {
		elements = new int[3];
		headPtr = 0;
	}
	
	private void checkCapacity() {
		// ako je stek popunjen
		if (headPtr == elements.length-1) {
			// ispis poruke korisniku (nije neophodno)
			System.out.println("Realokacija niza sa duzine " + elements.length + " na " + 2*elements.length + "...");

			// kopiraju se elementi datog niza u novi niz, ostatak zadate duzine se popunjava
			// neutralnim vrednostima za tip niza (u nasem slucaju 0 za tip int)
			elements = java.util.Arrays.copyOf(elements, 2 * elements.length);
		}
	}

	// smestanje elementa na vrh steka
	public void push(int val) {
		// provera da li je dodavanje moguce
		checkCapacity();
		elements[headPtr++] = val;
	}

	// citanje elementa sa vrha steka
	public int top() {
		return elements[headPtr];
	}
	
	public int size() {
		return headPtr;
	}
	
	public int capacity() {
		return elements.length;
	}
	
	public void showContent() {
		System.out.println("size: " + headPtr + " capacity: " + elements.length);
		for (int i = 0; i < headPtr; i++)
			System.out.print(elements[i] + " ");
		System.out.println();
	}

	// skidanje elementa sa vrha steka
	public int pop() {
		if (headPtr > 0) {
			headPtr--;
			return elements[headPtr+1];
		} else {
			System.out.println("Stack underflow...");
			return 0;
		}
	}
}
