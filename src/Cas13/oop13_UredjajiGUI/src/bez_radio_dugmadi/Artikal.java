package bez_radio_dugmadi;

public abstract class Artikal {

	private String naziv;
	private float cena;
	
	public Artikal(String naziv, float cena) {
		this.naziv = naziv;
		this.cena = cena;
	}	
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public abstract float prodajnaCena();
	
	@Override
	public String toString() {
		return naziv + "\t\t***\tregularna cena: " + cena + " rsd\t***\t"; 
	}	
}
