package gui.software1project;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class gui extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(gui.class.getResource("main-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Part sample1 =new InHouse(1, "Tires", 23.99, 5, 1, 10, 12);
        Part sample2 =new InHouse(2, "Rear-view Mirror", 49.99,5 , 1, 20, 23);
        Part sample3 =new InHouse(3, "Alternator", 199.99, 5, 1, 20, 15);
        Inventory.addPart(sample1);
        Inventory.addPart(sample2);
        Inventory.addPart(sample3);

        launch();



    }
}