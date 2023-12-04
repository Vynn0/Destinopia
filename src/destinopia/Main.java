package destinopia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import destinopia.Controller.LoginController;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load utama constructor dengan login.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        // Parent root untuk melakukan loader load
        Parent root = loader.load();

        // Dari logincontroller, getController di load
        LoginController loginController = loader.getController();

        // Membuat scene baru
        Scene scene = new Scene(root);
        // Stage scene tersebut
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Destinopia"); // Title
        primaryStage.getIcons().add(new Image("destinopia/View/Resource/destinopia-high-resolution-logo 1.png")); // Icon
        primaryStage.setResizable(false);
        primaryStage.show();

        // Inisialiasi loginButton menggunakan scene lookup
        Button loginButton = (Button) scene.lookup("#login_button");

        // Melakukan setOnAction dalam event loginController
        loginButton.setOnAction(event -> loginController.loginCheck(event));
    }

    public static void main(String[] args) {
        launch(args);
    }
}