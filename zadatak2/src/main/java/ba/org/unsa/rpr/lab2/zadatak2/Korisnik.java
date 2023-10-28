package ba.org.unsa.rpr.lab2.zadatak2;

public class Korisnik extends Osoba{
    private Racun racun;
    Korisnik(String s1, String s2) {
        super(s1, s2);
    }
    public void dodajRacun(Racun r) {
        Banka neka_banka = new Banka();
        neka_banka.kreirajRacunZaKorisnika(this);
    }
}
