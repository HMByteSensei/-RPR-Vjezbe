package ba.etf.unsa.rpr;

import java.util.ArrayList;
import java.util.Iterator;

public class KolekcijaImena {
    private ArrayList<String> ime_prezime;
    private KolekcijaImena() {};
    public KolekcijaImena(ArrayList<String> i) {
        ime_prezime = i;
    }
    public String getNajduzeIme() {
        if(ime_prezime.isEmpty()) {
            return "Lista je prazna";
        }
        String rez = ime_prezime.get(0);
        for(int i=1; i<ime_prezime.size(); i++) {
            if(rez.length() < ime_prezime.get(i).length()) {
                rez = ime_prezime.get(i);
            }
        }
        return rez;
    }
}