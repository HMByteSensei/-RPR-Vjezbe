package ba.etf.unsa.rpr;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface LaptopDao {
    public void dodajLaptopUListu(Laptop laptop);
    public void dodajLaptopUFile(Laptop laptop);
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException;
    public void napuniListu(ArrayList<Laptop> laptopi);
    public ArrayList<Laptop> vratiPodatkeIzDatoteke();
}
