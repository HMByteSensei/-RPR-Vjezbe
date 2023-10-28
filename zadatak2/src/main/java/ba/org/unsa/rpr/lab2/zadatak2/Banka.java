package ba.org.unsa.rpr.lab2.zadatak2;

import java.util.List;

public class Banka {
    protected Long brojRacuna;
    private List<Korisnik> lista_korisnika;
    private List<Uposlenik> lista_uposlenika;

    Banka() { brojRacuna = Long.valueOf(0); }
    public Korisnik kreirajNovogKorisnika(String ime, String prezime) {
        Korisnik novi = new Korisnik(ime, prezime);
        lista_korisnika.add(novi);
        return novi;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime) {
        Uposlenik novi = new Uposlenik((ime, prezime));
        lista_uposlenika.add(novi);
        return novi;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k) {
        Racun r;
        r = new Racun(++brojRacuna, k);
        for(int i=0; i<lista_korisnika.size(); i++) {
            if(k.ime.equals(lista_korisnika.get(i).ime) && k.prezime.equals(lista_korisnika.get(i).prezime)) {
                k.dodajRacun(r);
            }
        }
        return r;
    }
}
