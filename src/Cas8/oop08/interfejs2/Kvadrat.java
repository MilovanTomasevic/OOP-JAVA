package interfejs2;

public class Kvadrat extends Pravougaonik 
{
	public Kvadrat(double a) {
		super(a, a);
	}
	
	public Kvadrat(Tacka centar, double a) {
		super(centar, a, a);
	}
	
	public Kvadrat(final Kvadrat k) {
		super(k);
	}

	public String toString() {
		return "kvadrat centar u tacki " + getCentar() + " a = " + getA();
	}
}
