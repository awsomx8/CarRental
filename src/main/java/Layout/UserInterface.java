package Layout;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserInterface {
    @FXML
    private Label welcomeLabel; // Add this field to reference the label you want to modify

    @FXML
    public void onButtonClick() {
        welcomeLabel.setText("Hello, Login Successful!");
    }
}