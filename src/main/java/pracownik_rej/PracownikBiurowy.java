package pracownik_rej;

public class PracownikBiurowy extends Pracownik {
    private final int iq;

    public PracownikBiurowy(String id, String imie, String nazwisko, int wiek, int doswiadczenie, Adres adres, int iq) {
        super(id, imie, nazwisko, wiek, doswiadczenie, adres);
        this.iq = iq;
    }

    @Override
    public double obliczWartosc() {
        return getDoswiadczenie() * iq;
    }

    @Override
    public String toString() {
        return super.toString() + ", IQ: " + iq;
    }
}
