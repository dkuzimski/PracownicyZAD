package pracownik_rej;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RejestrPracownikowTest {
    private RejestrPracownikow rejestr;

    @BeforeEach
    public void przygotujRejestr() {
        rejestr = new RejestrPracownikow();
    }

    @Test
    public void testDodawaniePracownika() {
        Adres adres = new Adres("Kwiatowa", 10, 5, "Poznań");
        PracownikBiurowy biurowy = new PracownikBiurowy("101", "Anna", "Kowalska", 25, 3, adres, 110);
        rejestr.dodajPracownika(biurowy);

        List<Pracownik> pracownicy = rejestr.posortujPracownikow();
        assertEquals(1, pracownicy.size());
        assertEquals("Anna", pracownicy.get(0).getImie());
    }

    @Test
    public void testUsuwanieIstniejacegoPracownika() {
        Adres adres = new Adres("Długa", 5, 2, "Gdynia");
        PracownikBiurowy biurowy = new PracownikBiurowy("102", "Jan", "Nowak", 30, 5, adres, 120);

        rejestr.dodajPracownika(biurowy);
        boolean usuniety = rejestr.usunPracownika("102");

        assertTrue(usuniety);
        assertTrue(rejestr.posortujPracownikow().isEmpty());
    }

    @Test
    public void testNieUsuwanieNieistniejacegoPracownika() {
        boolean usuniety = rejestr.usunPracownika("999");

        assertFalse(usuniety);
    }

    @Test
    public void testDodawanieListyPracownikow() {
        Pracownik fizyczny = new PracownikFizyczny("103", "Marek", "Wiśniewski", 40, 10, new Adres("Kolejowa", 12, 3, "Łódź"), 90);
        Handlarz handlowiec = new Handlarz("104", "Kasia", "Zielińska", 35, 7, new Adres("Grunwaldzka", 8, 4, "Kraków"), Handlarz.Efektywnosc.SREDNIA, 15.0);
        rejestr.dodajPracownikow(Arrays.asList(fizyczny, handlowiec));

        List<Pracownik> pracownicy = rejestr.posortujPracownikow();
        assertEquals(2, pracownicy.size());
    }

    @Test
    public void testSortowaniaPracownikow() {
        Handlarz handlowiec = new Handlarz("105", "Piotr", "Nowicki", 28, 4, new Adres("Lipowa", 5, 6, "Sopot"), Handlarz.Efektywnosc.WYSOKA, 20.0);
        Pracownik fizyczny = new PracownikFizyczny("106", "Ewa", "Domańska", 35, 8, new Adres("Zamkowa", 3, 2, "Wrocław"), 85);

        rejestr.dodajPracownikow(Arrays.asList(handlowiec, fizyczny));
        List<Pracownik> posortowani = rejestr.posortujPracownikow();

        assertEquals(fizyczny, posortowani.get(0));
        assertEquals(handlowiec, posortowani.get(1));
    }

    @Test
    public void testZnajdywaniaPracownikowZMiasta() {
        Adres adres = new Adres("Warszawska", 15, 5, "Warszawa");
        Pracownik fizyczny = new PracownikFizyczny("107", "Monika", "Maj", 32, 6, adres, 95);

        rejestr.dodajPracownika(fizyczny);
        List<Pracownik> pracownicyWWarszawie = rejestr.znajdzPracownikowWgMiasta("Warszawa");

        assertEquals(1, pracownicyWWarszawie.size());
        assertEquals("Monika", pracownicyWWarszawie.get(0).getImie());
    }

    @Test
    public void testObliczanieWartosciPracownikaBiurowego() {
        PracownikBiurowy biurowy = new PracownikBiurowy("108", "Tomasz", "Grabowski", 29, 4, new Adres("Polna", 9, 1, "Katowice"), 115);

        assertEquals(460, biurowy.obliczWartosc(), 0.001);
    }

    @Test
    public void testObliczaniaWartosciPracownikaFizycznego() {
        PracownikFizyczny fizyczny = new PracownikFizyczny("109", "Kamil", "Zając", 30, 5, new Adres("Sadowa", 6, 8, "Gdynia"), 80);

        assertEquals(13.33, fizyczny.obliczWartosc(), 0.01);
    }

    @Test
    public void testObliczaniaWartosciPracownikaHandlarza() {
        Handlarz handlarz = new Handlarz("110", "Magdalena", "Nowak", 38, 10, new Adres("Różana", 11, 7, "Poznań"), Handlarz.Efektywnosc.WYSOKA, 25.0);

        assertEquals(600, handlarz.obliczWartosc(), 0.001);
    }
}


