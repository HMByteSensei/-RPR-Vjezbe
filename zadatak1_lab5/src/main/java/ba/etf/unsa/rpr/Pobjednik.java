package ba.etf.unsa.rpr;

import java.util.*;

public class Pobjednik extends LicneInformacije {
    private int brojZnakova = this.getIme().length();
    public Pobjednik(KolekcijaImena imena) {
        String[] niz = imena.getNajduzeIme().split("\\s+");
        System.out.println(niz);
        this.setIme(niz[0]);
        this.setPrezime(niz[1]);
        brojZnakova = niz[0].length();
    }
    public static void main(String[] args) {
        ArrayList<String> ime_prezime = new ArrayList<>(
                List.of("asd fgh", "qwe tr", "dugodugo imeiprezime")
        );
        Pobjednik p = new Pobjednik(new KolekcijaImena(ime_prezime));
    }
}
