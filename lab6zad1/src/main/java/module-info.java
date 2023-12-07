module ba.etf.unsa.rpr.lab6zad1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ba.etf.unsa.rpr.lab6zad1 to javafx.fxml;
    exports ba.etf.unsa.rpr.lab6zad1;
}