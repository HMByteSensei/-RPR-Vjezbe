package ba.org.unsa.rpr.lab2.zadatak2;

public abstract class Osoba {
    protected String ime;
    protected String prezime;

    Osoba(String s1, String s2) {
        ime = s1;
        prezime = s2;
    }

    @Override
    public String toString() {
        return ime + prezime;
    }
}
