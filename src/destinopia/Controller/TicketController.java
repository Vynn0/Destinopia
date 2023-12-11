package destinopia.Controller;

import java.util.List;

import destinopia.Model.Pemesanan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TicketController {
    private int currentIndex = 0;
    @FXML
    private Label locationLabel;

    @FXML
    private Label airlineLabel;

    @FXML
    private Label airportLabel;

    @FXML
    private Label terminalLabel;

    private List<Pemesanan> pemesananList;

    public void setPemesananList(List<Pemesanan> pemesananList) {
        this.pemesananList = pemesananList;
        setLabel();
    }

    public void setLabel() {
        if (!pemesananList.isEmpty()) {
            Pemesanan pemesanan = pemesananList.get(currentIndex); // Assuming you want the first Pemesanan
            locationLabel.setText(pemesanan.getLocation());
            airlineLabel.setText(pemesanan.getAirline());
            airportLabel.setText(pemesanan.getAirport());
            terminalLabel.setText(pemesanan.getTerminal());
        }
    }

    @FXML
    private void nextButtonClick(ActionEvent event) {
        if (pemesananList != null && !pemesananList.isEmpty()) {
            currentIndex = (currentIndex + 1) % pemesananList.size();
            setLabel();
        }
    }

    @FXML
    private void previousButtonClick(ActionEvent event) {
        if (pemesananList != null && !pemesananList.isEmpty()) {
            currentIndex = (currentIndex - 1) % pemesananList.size();
            setLabel();
        }
    }
}
