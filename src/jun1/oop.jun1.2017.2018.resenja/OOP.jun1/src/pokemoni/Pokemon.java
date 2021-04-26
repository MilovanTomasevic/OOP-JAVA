package pokemoni;

public abstract class Pokemon implements Comparable<Pokemon> {
    private String ime;
    private int nivo;
    private Magija magija1;
    private Magija magija2;
    private int zivot = 100;

    // dodatno polje potrebno za dugme Simuliraj
    private Magija poslednjaBacena = null;

    public Pokemon(String ime, int nivo, Magija magija1, Magija magija2) {
        this.ime = ime;
        this.nivo = nivo;
        this.magija1 = magija1;
        this.magija2 = magija2;
    }

    public String getIme() {
        return ime;
    }

    public int getNivo() {
        return nivo;
    }

    public Magija getMagija1() {
        return magija1;
    }

    public Magija getMagija2() {
        return magija2;
    }

    public int getZivot() {
        return zivot;
    }

    public void nanesiStetu(int koliko) {
        zivot -= koliko;
    }

    public Magija getPoslednjaBacena() { return poslednjaBacena; }

    public void setPoslednjaBacena(Magija poslednjaBacena) {
        this.poslednjaBacena = poslednjaBacena;
    }

    @Override
    public String toString() {
        return "[lvl" + nivo + "] " + ime;
    }

    public abstract void baciMagiju(Pokemon neprijatelj);

    @Override
    public int compareTo(Pokemon o) {
        if (this instanceof IgracPokemon && o instanceof CpuPokemon) {
            return -1;
        } else if (this instanceof CpuPokemon && o instanceof IgracPokemon) {
            return 1;
        } else return Integer.compare(o.getNivo(), this.getNivo());
    }
}
