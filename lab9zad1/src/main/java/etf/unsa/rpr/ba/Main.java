package etf.unsa.rpr.ba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ispisiGradove();
        System.out.print(ispisiGradove());
        System.out.println("\nPoziv metode glavniGrad:\n");
        glavniGrad();
    }

    public static String ispisiGradove() {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        String rezultat = "";
        for(Grad g : dao.gradovi()) {
            rezultat = rezultat + g.getNaziv() + "(" + g.getDrzava() + ") - " + g.getBrojStanovnika() + "\n";
        }
        return rezultat;
    }

    public static void glavniGrad() {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        System.out.println("Unesite naziv drzavu: ");
        Scanner ulaz = new Scanner(System.in);
        String unos = ulaz.next();
        try {
            System.out.println("Glavni grad države " + unos + " je " + dao.glavniGrad(unos).getNaziv());
        } catch(NullPointerException e) {
            System.out.println("Nepostojeca drzava");
        }
    }
}