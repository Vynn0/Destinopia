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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Destinopia");
        primaryStage.getIcons().add(new Image("destinopia/View/Resource/destinopia-high-resolution-logo 1.png"));
        primaryStage.setResizable(false);
        primaryStage.show();

        Button loginButton = (Button) scene.lookup("#login_button");

        loginButton.setOnAction(event -> loginController.loginCheck(event));
    }

    public static void main(String[] args) {
        launch(args);
    }
}