package ba.etf.unsa.rpr;

public class Main {
    public static void main(String[] args) {
        LaptopDaoJSONFile test = new LaptopDaoJSONFile("asd");
        test.dodajLaptopUFile(new Laptop());
        test.dodajLaptopUFile(new Laptop("HMCity", "250xE", 10500, 1000000, 10050, 1000625, "i10", "NV", 18));
        System.out.println("Hello world!");
    }
}