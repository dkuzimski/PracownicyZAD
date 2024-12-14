package pracownik_rej;

public class PracownikFizyczny extends Pracownik {
    private final int sila;

    public PracownikFizyczny(String id, String imie, String nazwisko, int wiek, int doswiadczenie, Adres adres, int sila) {
        super(id, imie, nazwisko, wiek, doswiadczenie, adres);
        this.sila = sila;
    }

    @Override
    public double obliczWartosc() {
        return getDoswiadczenie() * sila / (double) getWiek();
    }

    @Override
    public String toString() {
        return super.toString() + ", Siła: " + sila;
    }
}
