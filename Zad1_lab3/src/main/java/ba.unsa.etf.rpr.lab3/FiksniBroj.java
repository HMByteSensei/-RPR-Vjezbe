package ba.unsa.etf.rpr.lab3;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    public String getBroj() {
        return broj;
    }

    @Override
    public String ispisi() {
        return grad + "/" + broj;
    }
    public String ispisi2() throws Izuzetak {
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
                    default -> throw new Izuzetak("Netacan grad!");
                } + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(grad.toString());
    }
}
