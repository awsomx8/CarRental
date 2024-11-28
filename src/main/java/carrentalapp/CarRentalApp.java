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
        FXMLLoader fxmlLoader = new FXMLLoader(CarRentalApp.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Car car = new Car(0,"Skoda", "Superb", CarCategory.FAMILY, 2014, 108000, Transmission.MANUAL, 222, 36);
        CarDAO carDAO = new CarDAO();
        carDAO.addCar(car);
        DatabaseInitializer.initialize();
        DatabaseInitializer.testDatabase();
        launch();
    }

}