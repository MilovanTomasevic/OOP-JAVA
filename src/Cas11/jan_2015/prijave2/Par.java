package prijave2;

/* Druga varijanta klase Par koja ne implementira 
 * interfejs Comparable<Par> i samim tim nema 
 * metod compareTo(), vec se kriterijum poredjenja
 * zadaje u samom metodu sort, drugim argumentom 
 * koji je objekat neimenovane klase koja implementira
 * interfejs Comparator<Par>. 
 */
public class Par {
	private String sif_pred;
	private int br_prij;

	public Par(String sif_pred, int br_prij) {
		this.sif_pred = sif_pred;
		this.br_prij = br_prij;
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
