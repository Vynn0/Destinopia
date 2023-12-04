package destinopia.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import destinopia.Model.Database;

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

        if (location.isEmpty() || transport.isEmpty() || bandara.isEmpty() || terminal.isEmpty()) {
            // Membuat label info error
            pemesananInfoLabel.setVisible(true);
            pemesananInfoLabel.setText("Please fill in all the fields.");
            pemesananInfoLabel.setFill(Color.RED);
        } else {
            // Jika tidak, membuat label register sukses dan menambah data
            DBConnection.addPesanan(location, transport, bandara, terminal);
            pemesananInfoLabel.setVisible(true);
            pemesananInfoLabel.setText("Booking success!");
            pemesananInfoLabel.setFill(Color.WHITE);
        }
    }

    @FXML
    private Label sessionLabel;

    public void updateSessionName(String sessionName) {
        sessionLabel.setText("Welcome, " + sessionName + "!");
    }

}
