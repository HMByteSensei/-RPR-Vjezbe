import ba.unsa.etf.rpr.lab3.FiksniBroj;
import ba.unsa.etf.rpr.lab3.Grad;
import ba.unsa.etf.rpr.lab3.Imenik;
import ba.unsa.etf.rpr.lab3.TelefonskiBroj;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @Test
    void dodaj() {
        Imenik t = new Imenik();
        TelefonskiBroj br = new FiksniBroj(Grad.SARAJEVO, "477-012");
        t.dodaj("Haso Hasic", br);
        assertEquals("Haso Hasic", t.dajIme(br));
        assertEquals("033/477-012", t.dajBroj("Haso Hasic"));

        TelefonskiBroj br1 = new FiksniBroj(Grad.TUZLA, "782-659");
        t.dodaj("Hneki Nesto", br1);
        assertEquals("1. Hneki Nesto - " + br1 +"\n" +
                "2. Haso Hasic - " + br + "\n",
                t.naSlovo('H'));
    }

}