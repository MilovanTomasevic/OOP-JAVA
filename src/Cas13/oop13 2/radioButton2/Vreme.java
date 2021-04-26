package radioButton2;

public enum Vreme {
	devet, deset, jedanaest, dvanaest;
	
	public String toString() {
		switch(this){
		case devet:
			return "9-10";
		case deset:
			return "10-11";
		case jedanaest:
			return "11-12";
		case dvanaest:
			return "12-13";
			default:
				return "";
		}
	}
}
