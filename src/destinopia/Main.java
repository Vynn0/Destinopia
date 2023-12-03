package destinopia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

import destinopia.Controller.LoginController;
import destinopia.Model.DataService;
import javafx.scene.text.Text;

public class Main extends Application {
    private DataService dataService;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();

        // RegisterController controller = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Destinopia");
        primaryStage.setResizable(false);
        primaryStage.show();

        Text signupText = (Text) scene.lookup("#signup_text");
        Button loginButton = (Button) scene.lookup("#login_button");

        loginButton.setOnAction(event -> loginController.loginCheck(event));

        // signupText.setOnMouseClicked(event -> {
        //     try {
        //         Parent newRoot = FXMLLoader.load(getClass().getResource("view/SignUp.fxml"));
        //         Scene newScene = new Scene(newRoot);

        //         primaryStage.setScene(newScene);

        //         primaryStage.setTitle("Register Destinopia");
        //         primaryStage.setResizable(false);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // });


    }

    public static void main(String[] args) {
        launch(args);
    }
}