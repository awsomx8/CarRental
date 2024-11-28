package carrentalapp;

import Database.CarDAO;
import Database.DatabaseInitializer;
import Logic.Car;
import Logic.CarStatus;
import Logic.CarCategory;
import Logic.Transmission;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CarRentalApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CarRentalApp.class.getResource("homescreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Car Rental Login!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DatabaseInitializer.initialize();
        DatabaseInitializer.testDatabase();
        launch();
    }

}