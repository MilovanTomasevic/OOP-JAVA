package datoteke_citanje_pisanje_nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class TestCitanjePisanjeMaleDatoteke {

	public static void main(String[] args) {
		final Charset KODIRANJE = StandardCharsets.UTF_8;
			
		System.out.println("Citanje ulazne datoteke.");
		
		Path putanja = Paths.get("ulaz.txt");
		List<String> linije = null;
		try {
			// iscitaju se sve linije datoteke i smeste u listu String-ova
			linije = Files.readAllLines(putanja, KODIRANJE);
			System.out.println(linije.toString());
				// obradjuje se (ovde samo ispisuje) dobijena lista linija
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Upis u izlaznu datoteku.");
		
		putanja = Paths.get("izlaz2.txt");
		
		// mogu da se upisu procitane linije ulazne datoteke, ili da se 
		// napravi nova lista linija koje ce biti upisane
		
		linije = Arrays.asList("прва линија", "đurđevak", "čČ ćĆ šŠ Žž");
				// popunjavanje liste linijama, ovde konkretnim String-ovima
		try {
			// Files.write(putanja, linije, KODIRANJE);
			// Files.write(putanja, linije, KODIRANJE, StandardOpenOption.APPEND);
				// iste linije DOPISUJE NA KRAJ postojece datoteke
			Files.write(putanja, linije, KODIRANJE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
				// a da bi se datoteka kreirala ako ne postoji, neophodno je dodati i tu opciju:
				// StandardOpenOption.APPEND, StandardOpenOption.CREATE
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
