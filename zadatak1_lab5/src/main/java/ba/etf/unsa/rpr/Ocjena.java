package ba.etf.unsa.rpr;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;
    private Ocjena(){};
    public Ocjena(LicneInformacije osoba, int ocjena) {
        setOcjena(ocjena);
        this.osoba = osoba;
    }

    public void setOcjena(int ocjena) {
        if(ocjena > 0 && ocjena <= 10) {
            this.ocjena = ocjena;
            return;
        }
        throw new IllegalArgumentException("Ocjena ne smije biti manja od 1 niti veca od 10");
    }
}
