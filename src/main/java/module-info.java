module com.example.carrentalapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.carrentalapp to javafx.fxml;
    exports com.example.carrentalapp;
}