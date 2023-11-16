package ba.etf.unsa.rpr;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File datoteka;
    private ArrayList<Laptop> spisak_laptopa;
    private String file_path = (new File("").getAbsolutePath()) + "\\src\\main\\Files";
    private LaptopDaoSerializableFile() {}; // zabrana konstruktora bez parametara
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        spisak_laptopa.add(laptop);
    }
    public LaptopDaoSerializableFile(String ime) {
        datoteka = new File(file_path + File.separator + ime + ".ser");
        try {
            if(datoteka.exists()) {
                datoteka.delete();
            }
            datoteka.createNewFile();
        } catch(IOException e) {
            e.getMessage();
        }
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            ObjectOutputStream izlaz = new ObjectOutputStream(new FileOutputStream(datoteka));
            izlaz.writeObject(laptop);
            izlaz.close();
        } catch (Exception e) {
            System.out.println("Greska: " + e);
        }
    }

    @Override
    public Laptop getLaptop(String p) throws NeodgovarajuciProcesorException {
        napuniListu(spisak_laptopa);
        for(var x : spisak_laptopa) {
            if(x.getProcesor().equals(p)) {
                return x;
            }
        }
        throw new NeodgovarajuciProcesorException("There is no laptop with such procesor.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        laptopi = vratiPodatkeIzDatoteke();
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        datoteka = new File(file_path);
        try {
            ObjectInputStream ulaz = new ObjectInputStream(new FileInputStream(datoteka));
            while(true) {
                try {
                    Laptop l = (Laptop) ulaz.readObject();
                    spisak_laptopa.add(l);
                }
                catch(EOFException e) {
                    break;
                }
            }
            ulaz.close();
        } catch (Exception e) {
            System.out.println("Greška: " + e);

        }
        return  spisak_laptopa;
    }
}
