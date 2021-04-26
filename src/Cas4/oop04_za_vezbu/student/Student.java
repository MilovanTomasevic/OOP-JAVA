package student;

public class Student
{
	private String imePrezime;
	private String fakultet;
	private int godina;
	
	// Konstruktor sa argumentima koji predstavljaju inicijalne vrednosti 
	// instancnih promenljivih.
	public Student(String imePrezime, String fakultet, int godina) {
		this.imePrezime = imePrezime;
		this.fakultet = fakultet;
		this.godina = godina;
	}
	
	// Podrazumevani konstruktor. Dodeljuje instancnim promenljivim podrazumevane 
	// vrednosti, koje su u ovom slucaju proizvoljno uzete.
	public Student() {
		imePrezime = "Petar Petrovic";
		fakultet = "Matematicki";
		godina = 1;
	}

	// get() i set() metodi za private instancne clanice
	
	public String getFakultet() {
		return fakultet;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public void setFakultet(String fakultet) {
		this.fakultet = fakultet;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}
	
	// metod toString() za generisanje String-reprezentacije studenta.
	public String toString() {
		return "Student " + imePrezime + " studira " + fakultet + " fakultet " + 
				"i trenutno je na " + godina + ". godini";
	}
}
