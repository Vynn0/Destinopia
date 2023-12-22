package destinopia.Controller;

import destinopia.Model.Navigation;
import destinopia.Model.Session;
import destinopia.Model.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class ProfileController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text infoLabel;

    private Database DBConnection = new Database();

    public void sessionUserNameProfile(String sessionName) {
        usernameTextField.setText(sessionName);
    }

    public void sessionEmailProfile(String sessionEmail) {
        emailTextField.setText(sessionEmail);
    }

    @FXML
    public void gotoHome(MouseEvent event) {
        Navigation nav = new Navigation();
        nav.gotoHome(event);
    }

    @FXML
    private void updateData() {
        String name = usernameTextField.getText();
        String email = emailTextField.getText();
        int userId = Session.getUserId();

        if (name.isEmpty() || email.isEmpty()) {
            // Membuat label info error
            infoLabel.setVisible(true);
            infoLabel.setFill(Color.RED);
        } else {
            infoLabel.setVisible(true);
            infoLabel.setText("Mengubah Data Berhasil!");
            infoLabel.setFill(Color.GREEN);
            DBConnection.updateData(userId, name, email);
            Session.setLoggedName(name);
        }
    }

    @FXML
    private void logOut(MouseEvent event) {
        Session.clearSession();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/destinopia/view/Login.fxml"));
            Parent loginRoot = loader.load();
            Scene loginScene = new Scene(loginRoot);
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(loginScene);
            primaryStage.setTitle("Login Destinopia");
            primaryStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}