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
        // Mengambil username dan password dari field FXML
        String username = user_field.getText();
        String password = pass_field.getText();

        // Mengambil stage dari source event, yang terasosiasi dari MouseEvent 'event'
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Jika konseksi database dengan login berhasil...
        if (DBConnection.loginCheck(username, password)) {
            System.out.println("Login successful!");
            openMainMenu(primaryStage);
            // Jika tidak...
        } else {
            // Display info error
            loginStatusLabel.setVisible(true);
        }
    }

    public void gotoSignUp(MouseEvent event) {
        try {
            Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/destinopia/view/SignUp.fxml"));
            Scene mainMenuScene = new Scene(mainMenuRoot);

            // Mengambil stage dari source event, yang terasosiasi dari MouseEvent 'event'
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
            // FXMLLoader Dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/destinopia/view/Dashboard.fxml"));
            Parent mainMenuRoot = loader.load();
            Scene mainMenuScene = new Scene(mainMenuRoot);

            primaryStage.setScene(mainMenuScene);
            primaryStage.setTitle("Dashboard Destinopia");
            primaryStage.setResizable(false);

            // Loader dashboard controller
            DashboardController dashboardController = loader.getController();

            // Dari dashboard controller, update nama sesi menggunakan nama logged in
            dashboardController.updateSessionName(Session.getLoggedName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}