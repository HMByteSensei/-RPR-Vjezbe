package ba.etf.unsa.rpr;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
//    file (File) i laptopi
//(ArrayList<Laptop>)
    private ArrayList<Laptop> spisakLaptopa;
    private String file_path = (new File("").getAbsolutePath()) + "\\src\\main\\Files";
    private File datoteka;
    private LaptopDaoJSONFile(){}; // zabrana default konstruktora

    public LaptopDaoJSONFile(String naziv) {
        this.file_path = this.file_path + File.separator + naziv + ".json";
        datoteka = new File(file_path);
        try {
            if(datoteka.exists()) {
                datoteka.delete(); // we want to start fresh every time we run the program
            }
            datoteka.createNewFile();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public LaptopDaoJSONFile(String naziv, File f) {this(naziv);}
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        spisakLaptopa.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try(FileWriter dodavanje = new FileWriter(file_path, true)) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            objectWriter.writeValue(dodavanje, laptop);
            //objectWriter.writeValue(dodavanje, '\n');
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't open the file.");
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        napuniListu(spisakLaptopa);
        for(var x : spisakLaptopa) {
            if(x.getProcesor().equals(procesor)) {
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            spisakLaptopa  = objectMapper.readValue(new File(file_path), new TypeReference<ArrayList<Laptop>>() {});
        } catch(IOException e) {
            e.printStackTrace();
        }
        return spisakLaptopa;
    }
}
