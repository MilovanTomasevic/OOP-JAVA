package pravougaonik;

// Definicija klase Pravougaonik. Pravougaonik je predstavljen
// koordinatama gornjeg levog i donjeg desnog temena.
public class Pravougaonik
{
	private Tacka gornjeLevo;
	private Tacka donjeDesno;

	// Konstruktor na osnovu datih koordinata temena
	public Pravougaonik(double x1, double y1, double x2, double y2) {
		// Omogucava se da gornje levo teme ima manju x, a vecu y koordinatu
		gornjeLevo = new Tacka(Math.min(x1,x2), Math.max(y1,y2));
		
		// Omogucava se da donje desno teme ima vecu x, a manju y koordinatu
		donjeDesno = new Tacka(Math.max(x1,x2), Math.min(y1,y2));
	}

	// Konstruktor na osnovu dve date tacke
	public Pravougaonik(Tacka gl, Tacka dd) {
		this(gl.getX(), gl.getY(), dd.getX(), dd.getY());
	}

	// Konstruktor na osnovu datog objekta klase Pravougaonik
	public Pravougaonik(Pravougaonik p) {
		this(p.gornjeLevo, p.donjeDesno);
	}

	// Kreira pravougaonik koji obuhvata tekuci pravougaonik i pravougaonik
	// koji se zadaje kao argument
	public Pravougaonik obuhvata(Pravougaonik rect) {
		return new Pravougaonik(Math.min(gornjeLevo.getX(), rect.gornjeLevo.getX()),
                      Math.max(gornjeLevo.getY(), rect.gornjeLevo.getY()),
                      Math.max(donjeDesno.getX(), rect.donjeDesno.getX()),
                      Math.min(donjeDesno.getY(), rect.donjeDesno.getY()));
 
	}

	public String toString() {
		return "Pravougaonik: " + gornjeLevo + " : "+ donjeDesno;  
	}
}