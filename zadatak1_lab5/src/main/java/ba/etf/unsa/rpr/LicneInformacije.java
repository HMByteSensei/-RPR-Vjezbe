package ba.etf.unsa.rpr;

public abstract class LicneInformacije implements Predstavljanje {
    private String ime;
    private String prezime;

    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String predstavi() {
        return "Ime:" + ime + " Prezime:" + prezime;
    }
    @Override
    public String toString() {
        return predstavi();
    }
}
