package ba.etf.unsa.rpr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
//    file (File) i laptopi
//(ArrayList<Laptop>)
    private ArrayList<Laptop> spisakLaptopa;
    private String file_path = "C:\\Users\\Student\\Desktop\\Vjezba\\Desktop\\Vjezba\\Zadatak1_lab4\\src\\main\\Files" + ;
    private File file;

    public LaptopDaoJSONFile(String naziv) {
        try(file = new File(file_path + naziv)) {
            System.out.print(")");
        }(file_path);
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        spisakLaptopa.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try(FileWriter upis = new FileWriter(file)) {
            upis.write(laptop);
//            writeObject()
//            FileOutputStream
//                    ObjectOutputStream
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getLaptop(String procesor) {

    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {

    }

    @Override
    public void vratiPodatkeIzDatoteke() {

    }
}
