package destinopia;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

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
    protected void loginCheck(ActionEvent event) {
        String username = user_field.getText();
        String password = pass_field.getText();

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (dataService.loginCheck(username, password)) {
            System.out.println("Login successful!");
            openMainMenu(primaryStage);
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    protected void openMainMenu(Stage primaryStage) {
    try {
        Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenuScene = new Scene(mainMenuRoot);

        primaryStage.setScene(mainMenuScene);
        primaryStage.setTitle("Main Menu Destinopia");
        primaryStage.setResizable(false);
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}