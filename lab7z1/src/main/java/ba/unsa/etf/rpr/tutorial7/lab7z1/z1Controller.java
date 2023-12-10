package ba.unsa.etf.rpr.tutorial7.lab7z1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class z1Controller {
    public Button krajButton;
    public Button dodajButton;

    public void exitOnClick(ActionEvent actionEvent) {
        Stage stage = (Stage)krajButton.getScene().getWindow();
        stage.close();
    }

    public void dodajOnClick(ActionEvent actionEvent) {
    }
}