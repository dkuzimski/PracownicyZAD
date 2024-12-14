package pracownik_rej;

public abstract class Pracownik {
    private final String id;
    private String imie;
    private String nazwisko;
    private int wiek;
    private int doswiadczenie;
    private Adres adres;

    public Pracownik(String id, String imie, String nazwisko, int wiek, int doswiadczenie, Adres adres) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID nie może być puste");
        }
        if (imie == null || imie.isEmpty()) {
            throw new IllegalArgumentException("Imię nie może być puste");
        }
        if (nazwisko == null || nazwisko.isEmpty()) {
            throw new IllegalArgumentException("Nazwisko nie może być puste");
        }
        if (wiek < 18) {
            throw new IllegalArgumentException("Wiek musi wynosić co najmniej 18 lat");
        }
        if (doswiadczenie < 0) {
            throw new IllegalArgumentException("Doświadczenie nie może być ujemne");
        }
        if (adres == null) {
            throw new IllegalArgumentException("Adres nie może być null");
        }

        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.doswiadczenie = doswiadczenie;
        this.adres = adres;
    }

    public String getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }

    public Adres getAdres() {
        return adres;
    }

    public abstract double obliczWartosc();

    @Override
    public String toString() {
        return String.format("ID: %s, %s %s, Wiek: %d, Doświadczenie: %d, Adres: %s", 
            id, imie, nazwisko, wiek, doswiadczenie, adres);
    }
}
