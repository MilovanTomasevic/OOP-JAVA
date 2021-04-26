package izuzeci;

public class StringUBroj {

	public static void main(String[] args) {

		String strI = "";

		int br;
		try {
			strI = " -012"; 
			br = Integer.parseInt(strI.trim());
			System.out.println("Ceo broj: " + br);
		} catch (NumberFormatException e) {
			System.out.println("'" + strI + "'" + " nije validna reprezentacija celog broja.");
		}
		
		try {
			strI = "-128"; // oktalni sistem -ne!
			br = Integer.parseInt(strI, 8);
			System.out.println("Ceo broj (oktalno): " + br);
		} catch (NumberFormatException e) {
			System.out.println("'" + strI + "'" + " nije validna reprezentacija celog oktalnog broja.");
		}
		
		try {
			//strI = "-128";
			strI = "-FF"; // -255
			br = Integer.parseInt(strI, 16);
			System.out.println("Ceo broj (heksadekadno): " + br);
		} catch (NumberFormatException e) {
			System.out.println("'" + strI + "'" + " nije validna reprezentacija celog heksadekadnog broja.");
		}
		
		System.out.println();
		
		String str = "";
		
//		str = "0012.5"; // vodece nule, ok!
//		str = "12.500"; // zavrsne nule, ok!
//		str = "  12.5 "; // vodece i zavrsne beline, ok!
//		str = "  012.50d";  // ok
		
		str = "0.1f"; // parseFloat(), a zatim parseDouble()
						// parseDouble()
		
		try {
			float brF = Float.parseFloat(str);
			double brD = brF;
			System.out.println("Realan broj (string -> float) " + brF);
			System.out.println("Realan broj (float -> double) " + brD);
			
			brD = Double.parseDouble(str);
			System.out.println("Realan broj (string -> double) " + brD);
		} catch (NumberFormatException e) {
			System.out.println("'" + strI + "'" + " nije validna reprezentacija realnog broja u pokretnom zarezu.");
		}
	}
}
