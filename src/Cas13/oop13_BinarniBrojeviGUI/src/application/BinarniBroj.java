package application;

import java.util.Map;

public class BinarniBroj implements Comparable<BinarniBroj> {
	private String ceoDeo;
	private String razlomljeniDeo;
	
	public BinarniBroj(String ceoDeo, String razlomljeniDeo) {
		this.ceoDeo = ceoDeo;
		this.razlomljeniDeo = razlomljeniDeo;
	}
	
	public String getCeoDeo() {
		return ceoDeo;
	}
	
	public String getRazlomljeniDeo() {
		return razlomljeniDeo;
	}
	
	public String hexZapis(Map<String, String> kodovi) {
		
		StringBuffer ceoDeoSB = new StringBuffer(ceoDeo);
		StringBuffer razlomljeniDeoSB = new StringBuffer(razlomljeniDeo);
		StringBuffer rezultat = new StringBuffer();
		
		/* dopunjavanje nulama s pocetka tako da su sve grupe duzine 4 */
		while(ceoDeoSB.length() % 4 != 0) 
			ceoDeoSB.insert(0, '0');
		
		/* dopunjavanje nulama s kraja tako da su sve grupe duzine 4 */
		while(razlomljeniDeoSB.length() % 4 != 0)
				razlomljeniDeoSB.append('0');
		
		/* konverzija celog dela */
		for(int i = 0, j = 0; i < ceoDeoSB.length()/4; i++, j += 4) {
			String cetiriBita = ceoDeoSB.substring(j, j+4);
			rezultat.append(kodovi.get(cetiriBita));
		}
		
		/* konverzija razlomljenog dela */
		if(!razlomljeniDeo.equals("")) {
			rezultat.append(".");
			for(int i = 0, j = 0; i < razlomljeniDeoSB.length()/4; i++, j += 4) {
				String cetiriBita = razlomljeniDeoSB.substring(j, j+4);
				rezultat.append(kodovi.get(cetiriBita));
			}
		}
		
		return toString() + "\t\t-\t\t" + rezultat.toString();
	}

	public boolean ceoDeoBroj() {
		return razlomljeniDeo.length() == 0; 
	}
	
	public double dekVr() {
		int ceoDeoDek = 0;
		double razlomljeniDeoDek = 0;

		for(int i = ceoDeo.length() - 1, stepen = 0; i >= 0; i--, stepen++)
			if(ceoDeo.charAt(i) == '1')
				ceoDeoDek += Math.pow(2, stepen);
		
		for(int i = 0, stepen = -1; i < razlomljeniDeo.length(); i++, stepen--)
			if(razlomljeniDeo.charAt(i) == '1')
				razlomljeniDeoDek += Math.pow(2, stepen);
		
		return ceoDeoDek + razlomljeniDeoDek;
	}

	@Override
	/* kraci nacin: */
	public int compareTo(BinarniBroj o) {
		return Double.compare(dekVr(), o.dekVr());
	}
	
	/* ili: 
	@Override
	public int compareTo(BinarniBroj o) {
		if(this.dekVr() < o.dekVr()) 
			return -1;
		if(this.dekVr() > o.dekVr())
			return 1;
		return 0;
	}
	*/
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(ceoDeo);
		if(!razlomljeniDeo.equals(""))
			sb.append("." + razlomljeniDeo);
		return sb.toString();
	}
}
