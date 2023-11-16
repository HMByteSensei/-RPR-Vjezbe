package ba.etf.unsa.rpr;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File datoteka;
    private ArrayList<Laptop> spisak_laptopa;
    private String file_path = (new File("").getAbsolutePath()) + "\\src\\main\\Files";
    private LaptopDaoXMLFile() {}; // zabrana konstruktora bez parametara
    public LaptopDaoXMLFile(String ime) {
        this.file_path = this.file_path + File.separator + ime + ".xml";
        datoteka = new File(file_path);
        try {
            if (datoteka.exists()) {
                datoteka.delete();
            }
            datoteka.createNewFile();
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("laptopi");
            doc.appendChild(rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(datoteka);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        spisak_laptopa.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop l) {
        int atribut = 1; // za "id" polje u XML datoteci
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document postojeca_datoteka = docBuilder.parse(datoteka); // da bih dodavao na postojevu datoteku
            Element rootElement = postojeca_datoteka.getDocumentElement();

            {
                Element laptopElement = postojeca_datoteka.createElement("laptop");
                rootElement.appendChild(laptopElement);

                // postavljanje `id` atributa u laptopElement element
                Attr attr = postojeca_datoteka.createAttribute("id");
                attr.setValue(String.valueOf(atribut++));
                laptopElement.setAttributeNode(attr);

                // sada pravim dijete elemente
                Element brend = postojeca_datoteka.createElement("brend");
                brend.setTextContent(l.getBrend());
                Element model = postojeca_datoteka.createElement("model");
                model.setTextContent(l.getModel());
                Element cijena = postojeca_datoteka.createElement("cijena");
                cijena.setTextContent(String.valueOf(l.getCijena()));
                Element ram = postojeca_datoteka.createElement("ram");
                ram.setTextContent(String.valueOf(l.getRam()));
                Element hdd = postojeca_datoteka.createElement("hdd");
                hdd.setTextContent(String.valueOf(l.getHdd()));
                Element ssd = postojeca_datoteka.createElement("ssd");
                ssd.setTextContent(String.valueOf(l.getSsd()));
                Element procesor = postojeca_datoteka.createElement("procesor");
                procesor.setTextContent(String.valueOf(l.getProcesor()));
                Element grafickaKartica = postojeca_datoteka.createElement("grafickaKartica");
                grafickaKartica.setTextContent(String.valueOf(l.getGrafickaKartica()));
                Element velicinaEkrana = postojeca_datoteka.createElement("velicinaEkrana");
                velicinaEkrana.setTextContent(String.valueOf(l.getVelicinaEkrana()));

                // dodavanje dijete cvor u laptopElement
                laptopElement.appendChild(brend);
                laptopElement.appendChild(model);
                laptopElement.appendChild(cijena);
                laptopElement.appendChild(ram);
                laptopElement.appendChild(ssd);
                laptopElement.appendChild(hdd);
                laptopElement.appendChild(procesor);
                laptopElement.appendChild(grafickaKartica);
                laptopElement.appendChild(velicinaEkrana);

                //rootElement.appendChild(laptopElement);
            }

            // Pisi u XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(postojeca_datoteka);

            // Koristim StreamResult da specificiram da treba pisati u "datoteka"
            StreamResult result = new StreamResult(datoteka);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        napuniListu(spisak_laptopa);
        for(var x : spisak_laptopa) {
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
        ArrayList<Laptop> spisak_laptopa = new ArrayList<>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dom = builder.parse(datoteka);

            // normaliziranje XML strukture
            dom.normalizeDocument();

            // dohvacanje root elementa
            Element root = dom.getDocumentElement();

            NodeList laptopNodes = root.getElementsByTagName("laptop");
            for (int i = 0; i < laptopNodes.getLength(); i++) {
                Element laptopElement = (Element) laptopNodes.item(i);
                Laptop temp = new Laptop(laptopElement.getElementsByTagName("brend").item(0).getTextContent(),
                                    laptopElement.getElementsByTagName("model").item(0).getTextContent(),
                                    Double.parseDouble(laptopElement.getElementsByTagName("cijena").item(0).getTextContent()),
                                    Integer.parseInt(laptopElement.getElementsByTagName("ram").item(0).getTextContent()),
                        Integer.parseInt(laptopElement.getElementsByTagName("hdd").item(0).getTextContent()),
                                Integer.parseInt(laptopElement.getElementsByTagName("ssd").item(0).getTextContent()),
                        laptopElement.getElementsByTagName("procesor").item(0).getTextContent(),
                        laptopElement.getElementsByTagName("grafickaKartica").item(0).getTextContent(),
                        Double.parseDouble(laptopElement.getElementsByTagName("velicinaEkrana").item(0).getTextContent()));
                spisak_laptopa.add(temp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return spisak_laptopa;
    }
}
