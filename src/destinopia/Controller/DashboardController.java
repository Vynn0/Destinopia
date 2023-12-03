package destinopia.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML
    private Label sessionLabel;
        public void updateSessionName(String sessionName) {
        sessionLabel.setText("Welcome, " + sessionName + "!");
    }
}
