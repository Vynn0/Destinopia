package destinopia.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import destinopia.Model.DataService;

public class RegisterController {
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private TextField email_field;

    @FXML
    private Text addDataLabel;

    private DataService dataService = new DataService();

    @FXML
    private void addRecord() {
        String name = user_field.getText();
        String password = pass_field.getText();
        String email = email_field.getText();

        dataService.addData(name, password, email);
        addDataLabel.setVisible(true);
    }

    public void gotoLogin(MouseEvent event) {
    try {
        Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/destinopia/view/Login.fxml"));
        Scene mainMenuScene = new Scene(mainMenuRoot);

        // Mengambil stage dari source event, yaitu scene dan window tersebut yang terasosiasi dari MouseEvent 'event'
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(mainMenuScene);
        primaryStage.setTitle("Login Destinopia");
        primaryStage.setResizable(false);
    } catch (IOException e) {   
        e.printStackTrace();
    }
    }   

    @FXML
    private void showData() {
        dataService.showData();
    }
}