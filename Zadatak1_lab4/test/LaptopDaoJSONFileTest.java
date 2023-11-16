import ba.etf.unsa.rpr.Laptop;
import ba.etf.unsa.rpr.LaptopDaoJSONFile;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LaptopDaoJSONFileTest {
    @Test
    void dodajLaptopUListu() throws IOException {
        File mockFile = Mockito.mock(File.class);
        LaptopDaoJSONFile laptopDao = new LaptopDaoJSONFile("test", mockFile);
        Laptop mockLaptop = new Laptop("MockBrand", "MockModel", 1000.0, 8, 512, 0, "MockProcessor", "MockGPU", 15.6);

        FileWriter mockFileWriter = Mockito.mock(FileWriter.class);
        when(mockFileWriter.append(Mockito.any())).thenReturn(mockFileWriter);

        when(new FileWriter(mockFile, true)).thenReturn(mockFileWriter);
        laptopDao.dodajLaptopUFile(mockLaptop);
        Mockito.verify(mockFileWriter).append(Mockito.anyString());

        assertEquals(1, laptopDao.vratiPodatkeIzDatoteke().size());
    }
}