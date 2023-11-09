package ba.unsa.etf.rpr.lab3;

public enum Grad {
    SARAJEVO("033"),
    TUZLA("035"),
    ZENICA("032"),
    JAJCE("030"),
    ODZAK("031"),
    LIVNO("034"),
    NEUM("036"),
    BIHAC("037"),
    BRCKO("049"),
    GORAZDE("038"),
    SIORKI_BRIJEG("039"),
    NEPOSTOJI("000");
    private final String broj;

    Grad(String broj) {
        this.broj = broj;
    }

    @Override
    public String toString() {
        return broj;
    }
};
