package ba.unsa.etf.rpr.tutorial7.lab7z1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class z1Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(z1Application.class.getResource("/fxml/hello-view.fxml"));
//        z1Controller controller = new z1Controller();
//        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}