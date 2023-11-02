package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadatak3t2 {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        Scanner ulaz = new Scanner(System.in);
        String s = null;
        System.out.println("Unesite brojeve, \"stop\" za kraj unosa: ");
        do {
            try {
                s = ulaz.next();
                Integer broj = Integer.parseInt(s);
                lista.add(broj);
            } catch(NumberFormatException e) {
            }
        } while(!s.equals("stop"));
        System.out.println("Unijeti elementi liste su: " + lista);
        //min, max, mean i standardnu devijaciju
        System.out.print("Min date liste je: " + min(lista) + ", max liste je: " + max(lista) + ", mean je: " + mean(lista) +
                ", a standardna devijacija date liste je: " + standardnaDevijacija(lista));
    }

    public static int min(List<Integer> l) {
        int rez = 0;
        if(!l.isEmpty()) rez = l.get(0);
        for(int i=1; i<l.size(); i++) {
            if(rez < l.get(i)) {
                rez = l.get(i);
            }
        }
        return rez;
    }

    public static int max(List<Integer> l) {
        int rez = 0;
        if(!l.isEmpty()) rez = l.get(0);
        for(int i=1; i<l.size(); i++) {
            if(rez > l.get(i)) {
                rez = l.get(i);
            }
        }
        return rez;
    }

    public static int mean(List<Integer> l) {
        int suma = 0;
        for(Integer x : l) {
            suma = suma + x;
        }
        return suma / l.size();
    }

    public static double standardnaDevijacija(List<Integer> l) {
        double suma = 0;
        int m = mean(l);
        for(Integer x : l) {
            suma = suma + Math.pow( (x - m) , 2); //suma = suma + varijacija
        }
        return Math.sqrt(suma / (l.size() - 1));
    }
}

