package ba.unsa.etf.rpr;

public class FiksniBroj extends TelefonskiBroj {
    enum Grad { SARAJEVO, TUZLA, ZENICA, JAJCE, ODZAK, LIVNO, NEUM, BIHAC, BRCKO, GORAZDE, SIORKI_BRIJEG};

    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return  "\nIme grada: " + grad.name() + " " +
                switch(this.grad) {
                    case SARAJEVO -> "033";
                    case TUZLA -> "035";
                    case ZENICA -> "032";
                    case JAJCE -> "030";
                    case ODZAK -> "031";
                    case LIVNO -> "034";
                    case NEUM -> "036";
                    case BIHAC -> "037";
                    case BRCKO -> {
                        String i = "049";
                        yield i;
                    }
                    case GORAZDE -> "038";
                    case SIORKI_BRIJEG -> "039";
                    default -> throw new IllegalArgumentException("Netacan grad!");
                };
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(broj);
    }
}
