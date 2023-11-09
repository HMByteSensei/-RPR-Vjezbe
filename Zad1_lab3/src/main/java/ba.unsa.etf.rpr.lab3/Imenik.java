package ba.unsa.etf.rpr.lab3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Imenik {
    private HashMap<String, TelefonskiBroj> spisak = new HashMap<String, TelefonskiBroj>();

    public void dodaj(String ime, TelefonskiBroj broj) {
        spisak.put(ime, broj);
    }

    public String dajBroj(String ime) {
        return spisak.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for(var x : spisak.entrySet()) {
            if(x.getValue().equals(broj)) {
                return x.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char c) {
        StringBuilder rez = new StringBuilder();
        int i = 1; // samo da pobroji koliko ima brojeva tj. za ispis
        for(var kljuc : spisak.keySet()) {
            if(kljuc.charAt(0) == c) {
                rez.append(i++).append(". ").append(kljuc).append(" - ").append(spisak.get(kljuc)).append("\n");
                //= rez + i+1 + spisak.keySet() + " - " + spisak.values() + "\n";
            }
        }
        return rez.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> sortiran_skup = new TreeSet<>();
        for(var kljuc : spisak.entrySet()) {
            if(kljuc.getValue().equals(g.toString())) {
                sortiran_skup.add(kljuc.getKey());
            }
        }
        return sortiran_skup;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> rezultat = new TreeSet<>(Comparator.comparing(TelefonskiBroj::ispisi));
        for(var skup : spisak.entrySet()) {
            if(skup.getValue().hashCode() == Integer.parseInt(g.toString().substring(0, 3))) {
                rezultat.add(skup.getValue());
            }
        }
        return rezultat;
    }
}
