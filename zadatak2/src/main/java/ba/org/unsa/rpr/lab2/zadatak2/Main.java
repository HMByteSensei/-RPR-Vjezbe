package ba.org.unsa.rpr.lab2.zadatak2;

public class Main {
    public static void main(String[] args) {
        Banka a = new Banka();
        Korisnik k = new Korisnik("Nebitno", "Test");
        Uposlenik u = new Uposlenik("Test2", "Test2");
        a.kreirajNovogKorisnika(k.ime, k.prezime);
    }
}