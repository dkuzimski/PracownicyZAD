package pracownik_rej;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RejestrPracownikow {
    private final List<Pracownik> pracownicy = new ArrayList<>();

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public boolean usunPracownika(String id) {
        return pracownicy.removeIf(pracownik -> pracownik.getId().equals(id));
    }

    public List<Pracownik> posortujPracownikow() {

        Comparator<Pracownik> byDoswiadczenie = (Pracownik p1, Pracownik p2) -> Integer.compare(p2.getDoswiadczenie(), p1.getDoswiadczenie());


        Comparator<Pracownik> byWiek = (Pracownik p1, Pracownik p2) -> Integer.compare(p1.getWiek(), p2.getWiek());

        Comparator<Pracownik> byNazwisko = (Pracownik p1, Pracownik p2) -> p1.getNazwisko().compareTo(p2.getNazwisko());

        Comparator<Pracownik> combinedComparator = byDoswiadczenie
            .thenComparing(byWiek)
            .thenComparing(byNazwisko);

        return pracownicy.stream()
                .sorted(combinedComparator)
                .collect(Collectors.toList());
    }

    public List<Pracownik> znajdzPracownikowWgMiasta(String miasto) {
        return pracownicy.stream()
                .filter(pracownik -> pracownik.getAdres().getMiasto().equalsIgnoreCase(miasto))
                .collect(Collectors.toList());
    }

    public void dodajPracownikow(List<Pracownik> listaPracownikow) {
        pracownicy.addAll(listaPracownikow);
    }

    public static void main(String[] args) {
        RejestrPracownikow rejestr = new RejestrPracownikow();

        Adres adres1 = new Adres("Kwiatowa", 10, 5, "Poznań");
        PracownikBiurowy biurowy = new PracownikBiurowy("101", "Anna", "Kowalska", 25, 3, adres1, 110);
        rejestr.dodajPracownika(biurowy);

        Adres adres2 = new Adres("Długa", 5, 2, "Gdynia");
        PracownikFizyczny fizyczny = new PracownikFizyczny("102", "Jan", "Nowak", 30, 5, adres2, 120);
        rejestr.dodajPracownika(fizyczny);

        System.out.println("Wszyscy pracownicy:");
        for (Pracownik pracownik : rejestr.posortujPracownikow()) {
            System.out.println(pracownik);
        }

        rejestr.usunPracownika("101");
        System.out.println("\nPo usunięciu pracownika o ID 101:");
        for (Pracownik pracownik : rejestr.posortujPracownikow()) {
            System.out.println(pracownik);
        }

        List<Pracownik> pracownicyGdynia = rejestr.znajdzPracownikowWgMiasta("Gdynia");
        System.out.println("\nPracownicy z Gdyni:");
        for (Pracownik pracownik : pracownicyGdynia) {
            System.out.println(pracownik);
        }
    }
}
