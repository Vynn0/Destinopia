package destinopia.Model;

import destinopia.Controller.DashboardController;
import destinopia.Controller.ProfileController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class Navigation {
    public void gotoHome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/destinopia/view/Dashboard.fxml"));
            Parent mainMenuRoot = loader.load();
            Scene mainMenuScene = new Scene(mainMenuRoot);
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(mainMenuScene);
            primaryStage.setTitle("Home");
            primaryStage.setResizable(false);

            // Loader dashboard controller
            DashboardController dashboardController = loader.getController();

            // Untuk dashboard controller, update nama sesi menggunakan nama logged in
            dashboardController.sessionUserName(Session.getLoggedName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void gotoProfile(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/destinopia/view/Profile.fxml"));
            Parent mainMenuRoot = loader.load();
            Scene mainMenuScene = new Scene(mainMenuRoot);
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(mainMenuScene);
            primaryStage.setTitle("Profile");
            primaryStage.setResizable(false);

            ProfileController profileController = loader.getController();
            profileController.sessionUserNameProfile(Session.getLoggedName());
            profileController.sessionEmailProfile(Session.getLoggedEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
