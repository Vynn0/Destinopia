package destinopia.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import destinopia.Model.Database;
import destinopia.Model.Session;

import java.io.IOException;

public class DashboardController {
    @FXML
    private TextField locationField;

    @FXML
    private TextField transportField;

    @FXML
    private TextField bandaraField;

    @FXML
    private TextField terminalField;

    @FXML
    private Text pemesananInfoLabel;

    private Database DBConnection = new Database();

    @FXML
    private void addPesanan() {
        // Inisialiasi variable yang diambil dari FXML
        String location = locationField.getText();
        String transport = transportField.getText();
        String bandara = bandaraField.getText();
        String terminal = terminalField.getText();
        int userID = Session.getUserId();

        if (location.isEmpty() || transport.isEmpty() || bandara.isEmpty() || terminal.isEmpty()) {
            // Membuat label info error
            pemesananInfoLabel.setVisible(true);
            pemesananInfoLabel.setText("Please fill in all the fields.");
            pemesananInfoLabel.setFill(Color.RED);
        } else {
            // Jika tidak, membuat label register sukses dan menambah data
            DBConnection.addPesanan(location, transport, bandara, terminal, userID);
            pemesananInfoLabel.setVisible(true);
            pemesananInfoLabel.setText("Booking success!");
            pemesananInfoLabel.setFill(Color.WHITE);
        }
    }

    public void gotoTicket(MouseEvent event) {
        try {
            Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/destinopia/view/Ticket.fxml"));
            // Inisialiasi menu scene dengan root sebelumnya
            Scene mainMenuScene = new Scene(mainMenuRoot);

            // Mengambil stage dari source event yang terasosiasi mouse event
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(mainMenuScene);
            primaryStage.setTitle("View Ticket"); // Title
            primaryStage.setResizable(false); // Resizeable = False
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label sessionLabel;

    public void sessionUserName(String sessionName) {
        sessionLabel.setText("Welcome, " + sessionName + "!");
    }

    public void displayData(String location, String transport, String bandara, String terminal, int userID) {

    }

}
