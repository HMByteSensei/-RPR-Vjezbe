package ba.unsa.etf.rpr;

public class Main {

    public static void main(String[] args) {
	    java.util.Scanner ulaz = new java.util.Scanner(System.in);
        System.out.print("Unesite broj: ");
        int n = ulaz.nextInt();
        for(int i=1; i<=n; i++) {
            if(i % sumaCifara(i) == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static int sumaCifara(int n) {
        int suma = 0;
        while(n != 0) {
            suma = suma + (n % 10);
            n = n / 10;
        }
        return suma;
    }
}
