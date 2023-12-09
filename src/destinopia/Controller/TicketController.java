package destinopia.Controller;

import destinopia.Model.Database;
import destinopia.Model.Pemesanan;
import destinopia.Model.Session;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

    public class TicketController {
        @FXML
        private ChoiceBox<Pemesanan> pemesananCBX;  

        private Database database;
    }
