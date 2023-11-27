package destinopia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField pass_field;

    private DataService dataService;

    public void initialize() {
        // You can initialize anything needed when the controller is created
        dataService = new DataService();
    }

    @FXML
    private void loginCheck(ActionEvent event) {
        String username = user_field.getText();
        String password = pass_field.getText();

        if (dataService.loginCheck(username, password)) {
            System.out.println("Login successful!");
            // Redirect to the main application or perform other actions
        } else {
            System.out.println("Invalid login credentials.");
            // Show an error message or perform other actions
        }
    }

}