package izuzeci;

import java.util.Arrays;

public class TestRuntimeException {

	public static void main(String[] args) {
		
		// ArrayIndexOutOfBoundsException
		int[] niz = {1, 2, 3, 4};
		System.out.println(Arrays.toString(niz));
		System.out.println(niz[4]); 
		
		// StringIndexOutOfBoundsException
		String s = "Runtime izuzeci";
		System.out.println(s);
		System.out.println(s.charAt(20));
		
		// NegativeArraySizeException
		int n = -5;
		System.out.println(n);
		double niz2[] = new double[n];
		System.out.println(niz2);
		
		// ...
	}

}
