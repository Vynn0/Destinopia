package destinopia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file and get the root node
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        // Create a Scene with the root node
        Scene scene = new Scene(root);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Set the stage properties
        primaryStage.setTitle("Login Destinopia.");
        // primaryStage.setResizable(false);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}