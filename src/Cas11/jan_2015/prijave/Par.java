package prijave;

public class Par implements Comparable<Par> {
	private String sif_pred;
	private int br_prij;

	public Par(String sif_pred, int br_prij) {
		this.sif_pred = sif_pred;
		this.br_prij = br_prij;
	}
	
	/* poredjenje se vrsi prema vrednosti 
	 * atributa br_prij; posto se trazi opadajuci
	 * poredak, metod compareTo() vraca vrednost:
	 *  >0 - ako je this.br_prij < p.br_prij
	 *  <0 - ako je this.br_prij > p.br_prij
	 */
	public int compareTo(Par p) {
		return p.br_prij - this.br_prij;
	}
	
	public String getSif_pred() {
		return sif_pred;
	}

	public int getBr_prij() {
		return br_prij;
	}

	public String toString() {
		return sif_pred + ": " + br_prij;
	}
}
