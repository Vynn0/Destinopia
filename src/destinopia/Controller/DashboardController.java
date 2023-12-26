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
import destinopia.Model.Navigation;
import destinopia.Model.Session;
import destinopia.Model.Pemesanan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DashboardController {
    @FXML
    private TextField locationField;

    @FXML
    private TextField airlineField;

    @FXML
    private TextField airportField;

    @FXML
    private TextField terminalField;

    @FXML
    private Text pemesananInfoLabel;

    private Database DBConnection = new Database();

    // Mengambil input dari user dan menjalankan fungsi addPesanan dari database
    @FXML
    private void addPesanan() {
        // Inisialiasi variable yang diambil dari FXML
        String location = locationField.getText();
        String airline = airlineField.getText();
        String airport = airportField.getText();
        String terminal = terminalField.getText();
        int userID = Session.getUserId();

        if (location.isEmpty() || airline.isEmpty() || airport.isEmpty() || terminal.isEmpty()) {
            // Membuat label info error
            pemesananInfoLabel.setVisible(true);
            pemesananInfoLabel.setText("Please fill in all the fields.");
            pemesananInfoLabel.setFill(Color.RED);
        } else {
            // Jika tidak, membuat label register sukses dan menambah data
            DBConnection.addPesanan(location, airline, airport, terminal, userID);
            pemesananInfoLabel.setVisible(true);
            pemesananInfoLabel.setText("Booking success!");
            pemesananInfoLabel.setFill(Color.WHITE);
        }
    }

    // Go to menu ticket
    public void gotoTicket(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/destinopia/view/Ticket.fxml"));
            Parent mainMenuRoot = loader.load();

            // Inisialiasi menu scene dengan root sebelumnya
            Scene mainMenuScene = new Scene(mainMenuRoot);
            int userID = Session.getUserId();

            try {
                List<Pemesanan> pemesananList = DBConnection.getAllPemesanan(userID);

                // Pengecekkan data
                if (!pemesananList.isEmpty()) {

                    // Pass ke controller
                    TicketController ticketController = loader.getController();
                    ticketController.setPemesananList(pemesananList);

                    // Mengambil stage dari source event yang terasosiasi mouse event
                    Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    primaryStage.setScene(mainMenuScene);
                    primaryStage.setTitle("View Ticket"); // Title
                    primaryStage.setResizable(false); // Resizeable = False
                } else {
                    System.out.println("No records found for user with ID " + userID);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle the exception appropriately
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML // Fungsi goto profile dengan mengambil dari navigation
    public void gotoProfile(MouseEvent event) {
        Navigation nav = new Navigation();
        nav.gotoProfile(event);
    }

    @FXML
    private Label sessionLabel;

    // Fungsi displayu dan set text nama session
    public void sessionUserName(String sessionName) {
        sessionLabel.setText("Welcome, " + sessionName + "!");
    }

}
