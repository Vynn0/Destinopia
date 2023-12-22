package destinopia.Controller;

import java.util.List;

import destinopia.Model.Pemesanan;
import destinopia.Model.Session;
import destinopia.Model.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TicketController {
    private int currentIndex = 0; // Index untuk id pada column

    @FXML
    private Label locationLabel; // Label yang diambil dari ticket.fxml

    @FXML
    private Label airlineLabel;

    @FXML
    private Label airportLabel;

    @FXML
    private Label terminalLabel;

    @FXML
    private Label userLabel;

    private List<Pemesanan> pemesananList;

    public void setPemesananList(List<Pemesanan> pemesananList) {
        this.pemesananList = pemesananList;
        setLabel();
    }

    public void setLabel() {
        if (!pemesananList.isEmpty()) {
            Pemesanan pemesanan = pemesananList.get(currentIndex);
            userLabel.setText(Session.getLoggedName());
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

    @FXML
    public void gotoHome(MouseEvent event) {
        Navigation nav = new Navigation();
        nav.gotoHome(event);
    }

    @FXML
    public void gotoProfile(MouseEvent event) {
        Navigation nav = new Navigation();
        nav.gotoProfile(event);
    }
}
