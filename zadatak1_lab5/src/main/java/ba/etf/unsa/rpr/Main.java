package ba.etf.unsa.rpr;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InformacijeOStudentu i1 = new InformacijeOStudentu();
        i1.setIme("Prvi");
        i1.setPrezime("Student");
        i1.setBrojIndexa("19584");
        i1.setGodinaStudija("1978");
        InformacijeONastavniku n1 = new InformacijeONastavniku();
        n1.setIme("Prvi");
        n1.setPrezime("Nastavnik");
        n1.setTitula("Magistar");
        Predmet p1 = new Predmet();
        p1.setNaziv("Numericki algoritmi");
        p1.setOpis("""
            Cilj ovog kursa je upoznavanje sa problemima vezanim za implementaciju računanja 
            sa realnim brojevima na računaru, te dizajn brzih, tačnih i pouzdanih algoritama 
            za rješavanje tipičnih problema numeričke prirode (računanja sa matricama, rješavanje 
            jednačina i sistema jednačina, interpolacija, aproksimacija, numeričko diferenciranje 
            i integriranje, numeričko rješavanje diferencijalnih jednačina, brza Fourierova transformacija).
        """);

        ArrayList<Predstavljanje> lista = new ArrayList<>();
        lista.add(i1);
        lista.add(n1);
        lista.add(p1);
        System.out.println(lista);
    }
}