package velikiCeliBrojevi_sabiranje;

import java.util.Scanner;

public class TestVCB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesi prvi veliki ceo broj:");
		VelikiCeoBroj prvi = new VelikiCeoBroj(sc.nextLine());
		
		System.out.println("Unesi drugi veliki ceo broj:");
		VelikiCeoBroj drugi = new VelikiCeoBroj(sc.nextLine());
		sc.close();
		
		System.out.println("Prvi broj: " + prvi);
		System.out.println("Drugi broj: " + drugi);

		// sabiranje brojeva
		VelikiCeoBroj zbir = VelikiCeoBroj.saberi(prvi, drugi);
		System.out.println("Zbir brojeva: " + zbir);
	}
}
