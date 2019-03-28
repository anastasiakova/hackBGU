package View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class loginController {
    @FXML
    public Button createUserButton;
    public TextField passText;
    public TextField userText;
    public Label passLabel;
    public Label useLabel;
    public Button logInButton;

    public void logINButtonAction(ActionEvent event) throws IOException {
        //validate user name & password
        boolean loginSuccessful = false;
        if (userText != "" && passText != "") {
            //controller search
            //this.logedInController = new LogedInController();
//            loginSuccessful = searchController.isLoginValid(userText.getText(), passText.getText());
            //loginSuccessful = logedInController.tryLogIn(userName,password);
            if (loginSuccessful) {
                System.out.println("bla");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("You Suck!");
                alert.show();
            }

        }
    }
}
