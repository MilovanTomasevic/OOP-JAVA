package bez_radio_dugmadi;

public class Telefon extends Artikal {

	private boolean naPretplatu;

	public Telefon(String naziv, float cena, boolean naPretplatu) {
		super(naziv, cena);
		this.naPretplatu = naPretplatu;
	}

	@Override
	public float prodajnaCena() {
		if(naPretplatu) 
			return 1;
		return super.getCena();
	}

	@Override
	public String toString() {
		return super.toString() + "prodajna cena: " + prodajnaCena() + " rsd";
	}
}
