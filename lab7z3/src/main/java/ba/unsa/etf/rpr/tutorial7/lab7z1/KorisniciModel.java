package ba.unsa.etf.rpr.tutorial7.lab7z1;

import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> listaKorisnika;
    private SimpleObjectProperty<Korisnik> trenutniKorisnik;

    public void napuni() {
        listaKorisnika.add(new Korisnik("Korisnik", "1", "korisnik1@test.com", "k1", "lozinka1"));
        listaKorisnika.add(new Korisnik("Korisnik", "2", "korisnik2@test.com", "k2", "lozinka2"));
        listaKorisnika.add(new Korisnik("Korisnik", "3", "korisnik3@test.com", "k3", "lozinka3"));
        listaKorisnika.add(new Korisnik("Korisnik", "4", "korisnik4@test.com", "k4", "lozinka4"));
        listaKorisnika.add(new Korisnik("Korisnik", "5", "korisnik5@test.com", "k5", "lozinka5"));
    }

    public KorisniciModel() {
        listaKorisnika = FXCollections.observableArrayList();
        napuni();
        trenutniKorisnik = new SimpleObjectProperty<>(listaKorisnika.get(0));
    }

    public ObservableList<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(ObservableList<Korisnik> l) {
        listaKorisnika = l;
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public void setTrenutniKorisnik(Korisnik k) {
        this.trenutniKorisnik.set(k);
    }
}
