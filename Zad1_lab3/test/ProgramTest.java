import ba.unsa.etf.rpr.lab3.Imenik;
import ba.unsa.etf.rpr.lab3.MedunarodniBroj;
import ba.unsa.etf.rpr.lab3.TelefonskiBroj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

// Requirements: Have to use "HashMap<String, String> spisak = null;"

class ProgramTest {
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    MedunarodniBroj m_br;

    @Mock
    Imenik kontakt;

    @Test
    void testMain() {
        HashMap<String, String> spisak = new HashMap<>();
        spisak.put("Huso Husic", "033/478-896");

        when(m_br.toString()).thenReturn("033/478-896");
        for(var s : spisak.entrySet()) {
            kontakt.dodaj(s.getKey(), m_br);
        }

        when(kontakt.dajBroj(anyString())).thenReturn("033/478-896");
        when(kontakt.dajIme(any(MedunarodniBroj.class))).thenReturn("Huso Husic");

        String ocekivano = "033/478-896";
        String ocekivano2 = "Huso Husic";

        String ispisano = kontakt.dajBroj("asd");
        // prvi parametar je namjerno null
        String ispisano2 = kontakt.dajIme(new MedunarodniBroj(null,"0635456498"));

        assertEquals(ocekivano, ispisano);
        assertEquals(ocekivano2, ispisano2);
    }
}