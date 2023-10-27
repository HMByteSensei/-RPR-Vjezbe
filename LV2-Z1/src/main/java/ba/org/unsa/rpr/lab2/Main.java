package ba.org.unsa.rpr.lab2;
import java.lang.RuntimeException;
import org.w3c.dom.ranges.RangeException;

public class Main {
    public static int Faktorijel(int n) {
        short code = 1;
        if(n <= 0) throw new RangeException(code, "Gresaka");
        if(n == 1) {
            return n;
        }
        else {
            return Faktorijel(n-1) * n;
        }
    }

    public static void main(String[] args) {
        System.out.println("Sinus datog argumenta je: " + Math.sin(Double.parseDouble(args[0])));
        System.out.println("Faktorijel je: " + Faktorijel((Integer.parseInt(args[0]))));
        //System.out.println("Hello world!");
    }
}