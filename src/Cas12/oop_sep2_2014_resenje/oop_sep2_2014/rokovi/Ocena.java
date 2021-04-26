package rokovi2;

public enum Ocena {
	sest(6), sedam(7), osam(8), devet(9), deset(10);
		
	private int num;
	
	private Ocena (int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
}
