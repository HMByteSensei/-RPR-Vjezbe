package ba.unsa.etf.rpr.lab3;

public class Izuzetak extends Exception {
    Izuzetak() {
        super();
    }
    Izuzetak(String e) {
        super("Izuzetak: " + e);
    }
}
