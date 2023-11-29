package ba.etf.unsa.rpr;

import java.util.ArrayList;

public class KolekcijaPoruka {
    private ArrayList<String> poruke;

    public ArrayList<String> getPoruke() {
        return poruke;
    }
    public KolekcijaPoruka(ArrayList<Predstavljanje> poruke) {
        for(var x : poruke) {
            this.poruke.add(x.predstavi());
        }
    }
}
