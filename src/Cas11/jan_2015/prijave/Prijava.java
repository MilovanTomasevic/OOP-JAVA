package prijave;

public class Prijava {
	private String sif_pred;
	private Rok rok;
	private int br_prij;
	private String godina;
	
	public Prijava(String godina, String sif_pred, int br_prij, Rok rok) {
		this.sif_pred = sif_pred;
		this.rok = rok;
		this.br_prij = br_prij;
		this.godina = godina;
	}
	
	public String toString() {
		return "sifra predmeta = " + sif_pred + ", rok = " + rok
				+ ", broj prijava = " + br_prij + ", godina=" + godina;
	}
	
	public String getSif_pred() {
		return sif_pred;
	}

	public void setSif_pred(String sif_pred) {
		this.sif_pred = sif_pred;
	}

	public int getBr_prij() {
		return br_prij;
	}

	public void setBr_prij(int br_prij) {
		this.br_prij = br_prij;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}
}
