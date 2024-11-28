module com.example.carrentalapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens carrentalapp to javafx.fxml;
    exports carrentalapp;
    exports Logic;
    opens Logic to javafx.fxml;
}