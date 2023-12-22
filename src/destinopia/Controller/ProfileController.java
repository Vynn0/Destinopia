package destinopia.Controller;

import destinopia.Model.Navigation;
import destinopia.Model.Session;
import destinopia.Model.Database;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProfileController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField emailTextField;

    private Database DBConnection = new Database();

    public void sessionUserNameProfile(String sessionName) {
        usernameTextField.setText(sessionName);
    }

    public void sessionEmailProfile(String sessionEmail) {
        emailTextField.setText(sessionEmail);
    }

    @FXML
    public void gotoHome(MouseEvent event) {
        Navigation nav = new Navigation();
        nav.gotoHome(event);
    }

    @FXML
    private void updateData() {
        String name = usernameTextField.getText();
        String email = emailTextField.getText();
        int userId = Session.getUserId();

        // // Jika nama atau email empty...
        // if (name.isEmpty() || email.isEmpty()) {
        //     // Membuat label info error
        //     editDataLabel.setVisible(true);
        //     editDataLabel.setText("Please fill in all the required credentials.");
        //     editDataLabel.setFill(Color.RED);
        // } else {
        //     // Jika tidak, membuat label edit sukses dan mengedit data
        DBConnection.updateData(userId, name, email);
        Session.setLoggedName(name);
    }
}