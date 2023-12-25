package etf.unsa.rpr.ba;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private final Connection conn;
    private PreparedStatement ps;
    private final PreparedStatement vratiGlavniGrad, vratiDrzavu, vratiSveGradove, dodajGradUpit, sljedeciIdGrad, dodajDrzavuUpit, sljedeciIdDrzava;
    private final PreparedStatement izmjeniGradUpit, nadjiDrzavuUpit;

    private GeografijaDAO() throws SQLException {
        String url = "jdbc:sqlite:bazaGradDrzava.db";
        conn = DriverManager.getConnection(url);
        try {
            ps = conn.prepareStatement("SELECT * FROM Grad, Drzava;");
        } catch (SQLException e) {
            kreirajBazu();
        } finally {
            ps = conn.prepareStatement("SELECT * FROM Grad, Drzava;");
            if(!daLiImaRedova()) {
                popuniBazu();
            }
            vratiGlavniGrad = conn.prepareStatement("SELECT * FROM Grad g, Drzava d " +
                    "WHERE d.naziv = ? AND d.GlavniGrad = g.id;");
            vratiDrzavu = conn.prepareStatement("SELECT * FROM Drzava WHERE naziv = ?;");
            vratiSveGradove = conn.prepareStatement("SELECT * FROM Grad;");
            dodajGradUpit = conn.prepareStatement("INSERT INTO Grad VALUES (?, ?, ?, ?);");
            sljedeciIdGrad = conn.prepareStatement("SELECT Max(id) + 1 FROM Grad;");
            dodajDrzavuUpit = conn.prepareStatement("INSERT INTO Drzava VALUES (?, ?, ?);");
            sljedeciIdDrzava = conn.prepareStatement("SELECT Max(id) + 1 FROM Drzava;");
            izmjeniGradUpit = conn.prepareStatement("UPDATE Grad SET Naziv=?, BrojStanovnika=?, Drzava=?" +
                    "WHERE id=?;");
            nadjiDrzavuUpit = conn.prepareStatement("SELECT * FROM Drzava WHERE id=?;");
        }
    }
    private void ispisi(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                //System.out.print(columnValue + " " + rsmd.getColumnName(i));
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }
    }
    public void vratiSveUBazi() {
        try {
            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM Drzava");
            System.out.println("Ispis svih Drzava:");
            ispisi(resultSet);
            stm.close();
            stm = conn.createStatement();
            resultSet = stm.executeQuery("SELECT * FROM Grad");
            System.out.println("Ispis svih Gradova:");
            ispisi(resultSet);
        } catch (SQLException e) {
            System.out.println("\nNEMA BAZE!");
        }
    }
    public boolean daLiImaRedova() {
        try {
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("\nNEMA BAZE!");
            return false;
        }
    }
    private void popuniBazu() throws SQLException {
        System.out.println("POPUNI BAZU");
        Statement stm = conn.createStatement();
        // Insert into Grad
        stm.execute("INSERT INTO Grad VALUES (1, 'Pariz', 1658745, 1)");
        stm.execute("INSERT INTO Grad VALUES (2, 'London', 7641498, 2)");
        stm.execute("INSERT INTO Grad VALUES (3, 'Beč', 48744848, 3)");
        stm.execute("INSERT INTO Grad VALUES (4, 'Manchester', 4987497, 2)");
        stm.execute("INSERT INTO Grad VALUES (5, 'Graz', 4198414, 3)");
        // Insert into Drzava
        stm.execute("INSERT INTO Drzava VALUES (1, 'Francuska', 1)");
        stm.execute("INSERT INTO Drzava VALUES (2, 'V. Britanija', 2)");
        stm.execute("INSERT INTO Drzava VALUES (3, 'Austrija', 3)");
    }
    private void kreirajBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("bazaGradDrzava.db.sql"));
            String sqlUpit = "";
            if(ulaz.hasNext()) {
                sqlUpit = sqlUpit + ulaz.nextLine();
                if(sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() -1 ) == ';') {
                    Statement stm = conn.createStatement();
                    stm.execute(sqlUpit);
                    sqlUpit = "";
                }
            }
            ulaz.close();
            System.out.println("\nOVDJE\n");
            popuniBazu();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static GeografijaDAO getInstance() {
        if(instance == null) {
            try {
                instance = new GeografijaDAO();
            } catch (SQLException e) {
                instance = null;
                System.out.println("Greska pri radu s bazom OVDJE!");
                System.out.println(e.getMessage());
            }
        }
        return instance;
    }

    public static void removeInstance() throws SQLException {
        if(instance != null) {
            instance.conn.close();
            instance = null;
        }
    }

    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> listaGradova = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rsDrzava = null;
        try {
            rs = vratiSveGradove.executeQuery();
            while(rs.next()) {
                nadjiDrzavuUpit.setInt(1, rs.getInt(4));
                rsDrzava = nadjiDrzavuUpit.executeQuery();
                Drzava d = new Drzava(rsDrzava.getInt(1), rsDrzava.getString(2), rsDrzava.getInt(3));
                listaGradova.add(new Grad(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), d));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(listaGradova, new Comparator<Grad>() {
            @Override
            public int compare(Grad o1, Grad o2) {
                if(o1.getBrojStanovnika() < o2.getBrojStanovnika()) {
                    return 1;
                } else if(o1.getBrojStanovnika() > o2.getBrojStanovnika()) {
                    return -1;
                }
                return 0;
            }
        });
        return listaGradova;
    }

    public void dodajGrad(Grad grad) {
        try {
            ResultSet rs = sljedeciIdGrad.executeQuery();
            grad.setId(rs.getInt(1));
            dodajGradUpit.setInt(1, grad.getId());
            dodajGradUpit.setString(2, grad.getNaziv());
            dodajGradUpit.setInt(3, grad.getBrojStanovnika());
            dodajGradUpit.setInt(4, grad.getDrzava().getId());
            dodajGradUpit.execute();
        } catch (SQLException e) {
            System.out.println("Doslo je do greske u dodavanju grada.");
            System.out.println(e.getMessage());
        }
    }

    public void dodajDrzavu(Drzava drzava) {
        try {
            ResultSet rs = sljedeciIdDrzava.executeQuery();
            drzava.setId(rs.getInt(1));
            dodajDrzavuUpit.setInt(1, drzava.getId());
            dodajDrzavuUpit.setString(2, drzava.getNaziv());
            dodajDrzavuUpit.setInt(3, drzava.getGlavniGrad());
            dodajDrzavuUpit.execute();
        } catch (SQLException e) {
            System.out.println("Doslo je do greske u dodavanju drzave.");
            System.out.println(e.getMessage());
        }
    }

    public void izmijeniGrad(Grad grad) {
        try {
            dodajGradUpit.setString(1, grad.getNaziv());
            dodajGradUpit.setInt(2, grad.getBrojStanovnika());
            dodajGradUpit.setInt(3, grad.getDrzava().getId());
            dodajGradUpit.setInt(4, grad.getId());
            dodajGradUpit.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Doslo je do greske u azuriranju grada.");
            System.out.println(e.getMessage());
        }
    }

    public Drzava nadjiDrzavu(String drzava) {
        try {
            vratiDrzavu.setString(1, drzava);
            return (Drzava) vratiDrzavu.executeQuery();
        } catch (SQLException e) {
            System.out.println("Doslo je do greske u trazenju drzave.");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Grad glavniGrad(String drzava) {
        Grad g = null;
        try {
            vratiGlavniGrad.setString(1, drzava);
            ResultSet rs = vratiGlavniGrad.executeQuery();
            if(!rs.next()) return null;
            Drzava d = new Drzava(rs.getInt(5), rs.getString(6), rs.getInt(7));
            g = new Grad(rs.getInt(1), rs.getString(2), rs.getInt(3), d);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return g;
    }

    public void obrisiDrzavu(String drzava) {
        try {
            try (PreparedStatement obrisi = conn.prepareStatement("DELETE FROM Grad WHERE id = " +
                    "(SELECT d.id FROM Drzava d WHERE naziv = ?);")) {
                obrisi.setString(1, drzava);
                obrisi.execute();
            }
            try (PreparedStatement obrisi = conn.prepareStatement("DELETE FROM Drzava WHERE naziv = ?;")) {
                obrisi.setString(1, drzava);
                obrisi.execute();
            }
        } catch (SQLException e) {
            System.out.println("Doslo je do greske u brisanju.");
            System.out.println(e.getMessage());
        }
    }
}
