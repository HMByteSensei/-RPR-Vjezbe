package ba.etf.unsa.rpr;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static boolean daLiJeString(String s) {
        return s.matches("^[a-zA-Z,. ]+$");
    }
    public static void main(String[] args) {
        InformacijeOStudentu i1 = new InformacijeOStudentu();
        InformacijeONastavniku n1 = new InformacijeONastavniku();
        Predmet p1 = new Predmet();
        ArrayList<Predstavljanje> lista = new ArrayList<>();

        Scanner ulaz = new Scanner(System.in);
        while(true) {
            System.out.println("Unesite 1 za unos Studenta, 2 za nastavnika, bilo koji broj za predmet, 0 za izlaz: ");
            try {
                int x = ulaz.nextInt();
                if(x == 0) {
                    break;
                }
                System.out.print("Unesite ime/naziv: ");
                ulaz.nextLine(); // da proguta newline character
                String y = ulaz.nextLine();
                System.out.print("Unesite prezime/opis: ");
                String y2 = ulaz.nextLine();
                if(daLiJeString(y) && daLiJeString(y2)) {
                    if(x == 1) {
                        InformacijeOStudentu p = new InformacijeOStudentu();
                        p.setIme(y);
                        p.setPrezime(y2);
                        lista.add(p);
                    } else if(x == 2) {
                        InformacijeONastavniku p = new InformacijeONastavniku();
                        p.setIme(y);
                        p.setPrezime(y2);
                        lista.add(p);
                    } else {
                        Predmet p = new Predmet();
                        p.setNaziv(y);
                        p.setOpis(y2);
                        lista.add(p);
                    }
                }
            } catch (InputMismatchException e) {
                ulaz.next();
            }
        }
        System.out.println(lista);
    }
}