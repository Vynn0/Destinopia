package destinopia.Controller;

import java.io.IOException;

import destinopia.Model.DataService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField pass_field;

    protected DataService dataService;

    public void initialize() {
        dataService = new DataService();
    }

    
    @FXML
    public void loginCheck(ActionEvent event) {
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

    public void gotoSignUp(MouseEvent event) {
    try {
        Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/destinopia/view/SignUp.fxml"));
        Scene mainMenuScene = new Scene(mainMenuRoot);

        // Mengambil stage dari source event, yaitu scene dan window tersebut yang terasosiasi dari text
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
        Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/destinopia/view/MainMenu.fxml"));
        Scene mainMenuScene = new Scene(mainMenuRoot);

        primaryStage.setScene(mainMenuScene);
        primaryStage.setTitle("Main Menu Destinopia");
        primaryStage.setResizable(false);
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}