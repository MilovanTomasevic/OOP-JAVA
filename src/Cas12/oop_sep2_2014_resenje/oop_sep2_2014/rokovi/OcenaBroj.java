package rokovi2;

public class OcenaBroj {
	private Ocena ocena;
	private int broj;
	
	public OcenaBroj(Ocena ocena, int broj){
		this.ocena = ocena;
		this.broj = broj;
	}
	
	public Ocena getOcena(){
		return ocena;
	}
	
	public int getBroj(){
		return broj;
	}
	
	public String toString() {
		return ocena + " (" + ocena.getNum() + ") - " + broj;
	}
}
