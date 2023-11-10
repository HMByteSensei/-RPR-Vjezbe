package ba.etf.unsa.rpr;

public class Laptop {
    private String brend;
    private String model;
    private double cijena;
    private int ram;
    private int hdd;
    private int ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;

    public Laptop() {}
    public Laptop(String brend, String model, double cijena, int ram, int hdd, int ssd, String procesor, String graficka, double velicinaEkrana) {
        this.brend = brend;
        this. model = model;
        this.cijena = cijena;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.procesor = procesor;
        this.grafickaKartica = graficka;
        this.velicinaEkrana = velicinaEkrana;
    }

    public void setBrend(String br) {
        brend = br;
    }

    public String getBrend() {
        return brend;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRam() {
        return ram;
    }
    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
    public int getHdd() {
        return hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getProcesor() {
        return procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }
}
