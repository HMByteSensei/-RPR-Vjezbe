module ba.unsa.etf.rpr.lab10 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens ba.unsa.etf.rpr.lab10 to javafx.fxml;
    exports ba.unsa.etf.rpr.lab10;
}