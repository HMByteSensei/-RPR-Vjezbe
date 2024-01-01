package ba.unsa.etf.rpr.lab10;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;

// Function to get unique primary key
public class IDGetter {
    // so that I do not need to cast later on I will convert to Properties
    private static SimpleIntegerProperty gradID = new SimpleIntegerProperty(5);
    private static SimpleIntegerProperty drzavaID = new SimpleIntegerProperty(3);

    public static SimpleIntegerProperty gradIDProperty() {
        int newID = gradID.get() + 1;
        gradID = new SimpleIntegerProperty(newID);
        return gradID;
    }
    public static SimpleIntegerProperty drzavaIDProperty() {
        int newID = drzavaID.get() + 1;
        drzavaID = new SimpleIntegerProperty(newID);
        return drzavaID;
    }
}
