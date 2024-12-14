package pracownik_rej;

public class Handlarz extends Pracownik {
    public enum Efektywnosc {
        NISKA(60), SREDNIA(90), WYSOKA(120);

        private final int wartosc;

        Efektywnosc(int wartosc) {
            this.wartosc = wartosc;
        }

        public int getWartosc() {
            return wartosc;
        }
    }

    private final Efektywnosc efektywnosc;
    private final double prowizja;

    public Handlarz(String id, String imie, String nazwisko, int wiek, int doswiadczenie, Adres adres, Efektywnosc efektywnosc, double prowizja) {
        super(id, imie, nazwisko, wiek, doswiadczenie, adres);
        this.efektywnosc = efektywnosc;
        this.prowizja = prowizja;
    }

    @Override
    public double obliczWartosc() {
        return getDoswiadczenie() * efektywnosc.getWartosc();
    }

    @Override
    public String toString() {
        return super.toString() + ", Efektywność: " + efektywnosc + ", Prowizja: " + prowizja + "%";
    }
}
