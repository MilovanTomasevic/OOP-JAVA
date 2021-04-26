package sa_radio_dugmadima;

public class Tablet extends Artikal {

	private int odobrenPopust;	
	
	public Tablet(String naziv, float cena, int odobrenPopust) {
		super(naziv, cena);
		this.odobrenPopust = odobrenPopust;
	}

	@Override
	public float prodajnaCena() {
		return (100-odobrenPopust)/100.0f*super.getCena();
	}

	@Override
	public String toString() {
		return super.toString() + "prodajna cena: " + prodajnaCena() + " rsd";
	}
	
}
