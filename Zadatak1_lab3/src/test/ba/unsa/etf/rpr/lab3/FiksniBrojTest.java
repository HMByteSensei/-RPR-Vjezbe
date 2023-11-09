package ba.unsa.etf.rpr.lab3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FiksniBrojTest {
    public FiksniBroj[] generirajBr() {
        FiksniBroj[] novi = new FiksniBroj[5];
        novi[0] = new FiksniBroj(Grad.SARAJEVO, "123-456");
        novi[1] = new FiksniBroj(Grad.TUZLA, "789-101");
        novi[2] = new FiksniBroj(Grad.ZENICA, "112-121");
        novi[3] = new FiksniBroj(Grad.JAJCE, "415-161");
        novi[4] = new FiksniBroj(Grad.SIORKI_BRIJEG, "718-192");
        return novi;
    }
    @Test
    void ispisi() {
        FiksniBroj[] lista = generirajBr();

        for(var br : lista) {
            String ocekivano = br.hashCode() + "/" + br.getBroj();
            String stvarniIspis = br.ispisi();
            assertEquals(ocekivano, stvarniIspis);
        }
    }

    @Test
    void ispisi2() throws Izuzetak {
        FiksniBroj[] lista = generirajBr();

        String ocekivano = "\nIme grada: SARAJEVO 033/123-456";
        String stvarniIspis = lista[0].ispisi2();
        assertEquals(ocekivano, stvarniIspis);

        ocekivano = "\nIme grada: TUZLA 035/123-456";
        stvarniIspis = lista[1].ispisi2();
        assertEquals(ocekivano, stvarniIspis);

        ocekivano = "\nIme grada: SIORKI_BRIJEG 039/123-456";
        stvarniIspis = lista[4].ispisi2();
        assertEquals(ocekivano, stvarniIspis);


//        FiksniBroj e = new FiksniBroj("Nepostoji", "123-4");
//        assertThrows(Izuzetak.class, () -> e.ispisi2());
    }

    @Test
    void testHashCode() {
        FiksniBroj[] l = generirajBr();
        assertEquals(l[0], 33);
    }
}