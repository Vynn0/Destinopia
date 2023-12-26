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

    // Fungsi display nama user session
    public void sessionUserNameProfile(String sessionName) {
        usernameTextField.setText(sessionName);
    }

    // Fungsi display email user session
    public void sessionEmailProfile(String sessionEmail) {
        emailTextField.setText(sessionEmail);
    }

    // Fungsi kembali ke dashboard
    @FXML
    public void gotoHome(MouseEvent event) {
        Navigation nav = new Navigation();
        nav.gotoHome(event);
    }

    // Fungsi update data
    @FXML
    private void updateData() {
        String name = usernameTextField.getText();
        String email = emailTextField.getText();
        int userId = Session.getUserId();

        // Jika nama atau email kosong
        if (name.isEmpty() || email.isEmpty()) {
            // Membuat label info error
            infoLabel.setVisible(true);
            infoLabel.setFill(Color.RED);
        } else {
            // Display label
            infoLabel.setVisible(true);
            infoLabel.setText("Mengubah Data Berhasil!");
            infoLabel.setFill(Color.GREEN);
            // Lakukan update data
            DBConnection.updateData(userId, name, email);
            Session.setLoggedName(name);
        }
    }

    // Fungsi logout
    @FXML
    private void logOut(MouseEvent event) {
        // Fungsi clear session dari class session
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