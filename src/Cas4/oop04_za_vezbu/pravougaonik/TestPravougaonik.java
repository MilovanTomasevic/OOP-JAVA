package pravougaonik;

public class TestPravougaonik {

	public static void main(String args[]) 
	{
			Pravougaonik[] pravougaonici = new Pravougaonik[4];
			Pravougaonik rezultujuci;
	    
			// Inicijalizacija pravougaonika na proizvoljne velicine i proizvoljne
			// pozicije 
			// Metod Math.random() vraca pseudoslucajan realan broj iz intervala [0.0, 1.0)
			for(int i=0 ; i<pravougaonici.length ; i++) {
				pravougaonici[i] = new Pravougaonik(Math.random()*100, Math.random()*100,
						                     Math.random()*100, Math.random()*100);
				System.out.println((i+1) + ". " + pravougaonici[i]);
				
			}

			// Rezultujuci pravougaonik se inicijalizuje prvim pravougaonikom iz niza
			rezultujuci = pravougaonici[0];
	    
			// Kombinuju se susedni pravougaonici, pri cemu se rezultat kombinovanja
			// prvog i drugog kombinuje sa trecim, zatim dobijeni rezultat sa cetvrtim itd.
			for(Pravougaonik p : pravougaonici)  {
				rezultujuci = rezultujuci.obuhvata(p);
			}

			System.out.println("\nRezultujuci pravougaonik: ");
			System.out.println(rezultujuci);
		}
	}
