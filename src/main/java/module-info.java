module com.example.carrentalapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;


    opens carrentalapp to javafx.fxml;
    exports carrentalapp;
    exports Logic;
    opens Logic to javafx.fxml;
    exports Layout;
    opens Layout to javafx.fxml;
    exports Database;
    opens Database to javafx.fxml;
}