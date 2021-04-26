package sakupljanjeDragulja;

public class Ranac {
    private double maxTezina;
    private double slobodnoTezina;

    public Ranac(double maxTezina) {
        this.maxTezina = maxTezina;
        this.slobodnoTezina= maxTezina;
    }

    public double getSlobodnoTezine() {
        return slobodnoTezina;
    }

    public boolean smestiDragulj(double tezina) {
        if (slobodnoTezina >= tezina) {
            slobodnoTezina -= tezina;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ranac: " + slobodnoTezina + "(" + maxTezina + ")";
    }
}
