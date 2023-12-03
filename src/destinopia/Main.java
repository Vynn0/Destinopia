package destinopia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import destinopia.Controller.LoginController;
import destinopia.Model.DataService;

public class Main extends Application {
    private DataService dataService;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Destinopia");
        primaryStage.setResizable(false);
        primaryStage.show();

        Button loginButton = (Button) scene.lookup("#login_button");

        loginButton.setOnAction(event -> loginController.loginCheck(event));
    }

    public static void main(String[] args) {
        launch(args);
    }
}