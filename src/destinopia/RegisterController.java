package destinopia;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private TextField email_field;

    private DataService dataService = new DataService();

    @FXML
    private void addRecord() {
        String name = user_field.getText();
        String password = pass_field.getText();
        String email = email_field.getText();

        dataService.addRecord(name, password, email);
    }

    @FXML
    private void showData() {
        dataService.showData();
    }
}