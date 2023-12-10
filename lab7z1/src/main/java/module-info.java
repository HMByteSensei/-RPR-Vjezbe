module ba.unsa.etf.rpr.tutorial7.lab7z1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ba.unsa.etf.rpr.tutorial7.lab7z1 to javafx.fxml;
    exports ba.unsa.etf.rpr.tutorial7.lab7z1;
}