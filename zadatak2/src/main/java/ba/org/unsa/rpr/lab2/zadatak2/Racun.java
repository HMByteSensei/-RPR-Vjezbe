package ba.org.unsa.rpr.lab2.zadatak2;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;

    Racun(Long l, Osoba o) {
        brojRacuna = l;
        korisnikRacuna = o;
        odobrenjePrekoracenja = true;
        stanjeRacuna = 0.;
    }
    private boolean provjeriOdobrenjePrekoracenja(Double d) {
        if(odobrenjePrekoracenja) {
            stanjeRacuna = d;
            return true;
        }
        odobrenjePrekoracenja = false;
        return false;
    }
    public boolean izvrsiUplatu(Double d) {
        stanjeRacuna = stanjeRacuna + d;
        if(stanjeRacuna < -100) {
            odobrenjePrekoracenja = true;
            return true;
        }
        return false;
    }
    public boolean izvrsiIsplatu(Double d) {
        if(provjeriOdobrenjePrekoracenja(stanjeRacuna - d)) {
            stanjeRacuna = stanjeRacuna - d;
            return true;
        }
        return false;
    }

    public void odobriPrekoracenje(Double d) {
        if(stanjeRacuna > -100) {
            odobrenjePrekoracenja = true;
        } else {
            odobrenjePrekoracenja = false;
        }
    }

}
