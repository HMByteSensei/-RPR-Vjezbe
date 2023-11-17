package ba.etf.unsa.rpr;

public class InformacijeONastavniku extends LicneInformacije implements Predstavljanje {
    private String titula;

    public String getTitula() {
        return titula;
    }
    public void setTitula(String titula) {
        this.titula = titula;
    }
    @Override
    public String predstavi() {
        return "Ime:" + this.getIme() + " Prezime:" + this.getPrezime();
    }
}
