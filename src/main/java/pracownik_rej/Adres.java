package pracownik_rej;

public class Adres {
    private final String ulica;
    private final int numerBudynku;
    private final int numerMieszkania;
    private final String miasto;

    public Adres(String ulica, int numerBudynku, int numerMieszkania, String miasto) {
        this.ulica = ulica;
        this.numerBudynku = numerBudynku;
        this.numerMieszkania = numerMieszkania;
        this.miasto = miasto;
    }

    public String getMiasto() {
        return miasto;
    }

    @Override
    public String toString() {
        return ulica + " " + numerBudynku + "/" + numerMieszkania + ", " + miasto;
    }
}
