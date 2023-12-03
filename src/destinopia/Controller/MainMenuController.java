package destinopia.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private Label sessionLabel;
        public void updateSessionName(String sessionName) {
        sessionLabel.setText("Selamat datang, " + sessionName + "!");
    }
}
