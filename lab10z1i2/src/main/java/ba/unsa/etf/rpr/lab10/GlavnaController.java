package ba.unsa.etf.rpr.lab10;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class GlavnaController {
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn nazivCol;
    @FXML
    private TableColumn stanovnikaCol;
    @FXML
    private TableColumn drzavaCol;
    @FXML
    private TableView gradoviTableView = new TableView();
    public static ObservableList<Grad> lista_gradova = FXCollections.observableArrayList();
    public static ObservableList<Drzava> lista_drzava = FXCollections.observableArrayList();
    public static Grad trenutniGrad;

    public void napuniTabelu() {
        Grad g1 = new Grad(new SimpleIntegerProperty(1), new SimpleStringProperty("Pariz"),
                new SimpleIntegerProperty(1658745), null);
        Grad g2 = (new Grad(new SimpleIntegerProperty(2), new SimpleStringProperty("London"),
                new SimpleIntegerProperty(7641498), null));
        Grad g3 = (new Grad(new SimpleIntegerProperty(3), new SimpleStringProperty("Beč"),
                new SimpleIntegerProperty(48744848), null));
        Grad g4 = (new Grad(new SimpleIntegerProperty(4), new SimpleStringProperty("Manchester"),
                new SimpleIntegerProperty(4987497), null));
        Grad g5 = (new Grad(new SimpleIntegerProperty(5), new SimpleStringProperty("Graz"),
                new SimpleIntegerProperty(4198414), null));

        Drzava d1 = new Drzava(new SimpleIntegerProperty(1), new SimpleStringProperty("Francuska"), null);
        Drzava d2 = new Drzava(new SimpleIntegerProperty(2), new SimpleStringProperty("V. Britanija"), null);
        Drzava d3 = new Drzava(new SimpleIntegerProperty(3), new SimpleStringProperty("Austrija"), null);
        g1.setDrzava(d1);
        g2.setDrzava(d2);
        g3.setDrzava(d3);
        g4.setDrzava(d2);
        g5.setDrzava(d3);
        d1.setGlavniGrad(g1);
        d2.setGlavniGrad(g2);
        d3.setGlavniGrad(g3);
        lista_gradova.addAll(g1, g2, g3, g4, g5);
        lista_drzava.addAll(d1, d2, d3);
    }
    @FXML
    public void initialize() {
        napuniTabelu();
        idCol.setCellValueFactory(new PropertyValueFactory<Grad, Integer>("id"));
        nazivCol.setCellValueFactory(new PropertyValueFactory<Grad, String>("naziv"));
        stanovnikaCol.setCellValueFactory(new PropertyValueFactory<Grad, Integer>("brojStanovnika"));
        drzavaCol.setCellValueFactory(new PropertyValueFactory<Grad, Drzava>("drzava"));
        gradoviTableView.setItems(lista_gradova);
        trenutniGrad = lista_gradova.get(1);
        gradoviTableView.getSelectionModel().select(trenutniGrad);
        gradoviTableView.getSelectionModel().selectedItemProperty().addListener((obs, Ov, novoIzabraniGrad) -> {
            trenutniGrad = (Grad) novoIzabraniGrad;
        });
    }

    public void dodajGradOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("fxml/grad.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Dodaj grad");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void dodajDrzavuOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("fxml/drzava.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Dodaj drzavu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void izmijeniGradOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("fxml/grad.fxml"));
        stage.setTitle("Izmjena grada");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

        stage.setOnHidden(event -> gradoviTableView.refresh());
    }

    public void obrisiGradOnClick(ActionEvent actionEvent) {
        lista_gradova.remove(trenutniGrad);
        gradoviTableView.getSelectionModel().selectNext();
    }
}