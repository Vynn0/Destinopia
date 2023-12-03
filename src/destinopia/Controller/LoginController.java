package destinopia.Controller;

import java.io.IOException;

import destinopia.Model.Database;
import destinopia.Model.Session;
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
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Text loginStatusLabel;

    protected Database DBConnection;

    public void initialize() {
        DBConnection = new Database();
    }

    @FXML
    public void loginCheck(ActionEvent event) {
        String username = user_field.getText();
        String password = pass_field.getText();
        
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        if (DBConnection.loginCheck(username, password)) {
            System.out.println("Login successful!");
            openMainMenu(primaryStage);
        } else {
            System.out.println("Invalid login credentials.");
            loginStatusLabel.setVisible(true);
        }
    }

    public void gotoSignUp(MouseEvent event) {
        try {
            Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/destinopia/view/SignUp.fxml"));
            Scene mainMenuScene = new Scene(mainMenuRoot);

            // Mengambil stage dari source event, yaitu scene dan window tersebut yang terasosiasi dari MouseEvent 'event'
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(mainMenuScene);
            primaryStage.setTitle("Sign Up Destinopia");
            primaryStage.setResizable(false);
        } catch (IOException e) {   
            e.printStackTrace();
        }
    }   

    public void openMainMenu(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/destinopia/view/Dashboard.fxml"));
            Parent mainMenuRoot = loader.load();
            Scene mainMenuScene = new Scene(mainMenuRoot);

            primaryStage.setScene(mainMenuScene);
            primaryStage.setTitle("Dashboard Destinopia");
            primaryStage.setResizable(false);

            DashboardController mainMenuController = loader.getController();
            mainMenuController.updateSessionName(Session.getLoggedName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}