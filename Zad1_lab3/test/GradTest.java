import ba.unsa.etf.rpr.lab3.Grad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradTest {

    @Test
    void testToString() {
        Grad prvi = Grad.SARAJEVO;
        Grad treci = Grad.GORAZDE;
        Grad cetvrti = Grad.SIORKI_BRIJEG;


        String ocekivani_prvi = "033";
        String stvarni_prvi = prvi.toString();

        String ocekivani_cetvrti = "039";
        String stvarni_cetvrti = cetvrti.toString();

        assertEquals(ocekivani_prvi, stvarni_prvi);
        assertEquals(ocekivani_cetvrti, stvarni_cetvrti);

        assertEquals("GORAZDE", treci.name());
        assertEquals("SIORKI BRIJEG", cetvrti.name().replace("_", " "));
    }
}