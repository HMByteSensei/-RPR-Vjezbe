package ba.etf.unsa.rpr;

import java.util.ArrayList;

public class KolekcijaImenaIPrezimena {
    private ArrayList<String> imena;
    private ArrayList<String> prezimena;
    public String getIndexNajduzegPara() {
        if(imena.isEmpty() || prezimena.isEmpty()) {
            return "Prazne liste";
        }
        String rez = imena.get(0) + prezimena.get(0);
        for(int i=0; i<imena.size() && i<prezimena.size(); i++) {
            if(rez.length() < imena.get(i).length()+prezimena.get(i).length()) {
                rez = imena.get(i) + prezimena.get(i);
            }
        }
        return rez;
    }
    public String getImeiPrezime(int i) {
        return imena.get(i) + prezimena.get(i);
    }
}
