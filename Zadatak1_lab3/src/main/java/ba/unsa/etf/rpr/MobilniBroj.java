package ba.unsa.etf.rpr;

public class MobilniBroj  extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;

    MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return "\nIme mobilne mreze: " +
                switch(this.mobilnaMreza) {
                    case 61 -> "BH MOBILE";
                    case 60 -> "BH MOBILE";
                    case 63 -> "ERONET";
                    case 64 -> "HALOO";
                    case 65 -> "M:TEL";
                    case 66 -> "M:TEL";
                    default -> throw new IllegalStateException("ne podrzavana vrijednost " + this.mobilnaMreza);
                };
    }

    @Override
    public int hashCode() {

    }

}
