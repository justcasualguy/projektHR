package services.controllers;

import gui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.LoginService;

public class LoginController {
   private String errorInvalidCredentials = "Niepoprawne dane logowania";

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginLabel;

    @FXML
    private PasswordField passwdLabel;

    @FXML
    private Label loginErrorLabel;

    @FXML
    public boolean  validateLogin() throws Exception{

        if(!LoginService.validateLogin(loginLabel.getText(),passwdLabel.getText())) {
            loginErrorLabel.setText(errorInvalidCredentials);
            loginErrorLabel.setVisible(true);
        }

 ///////// FOR TESTS
//        if(!(loginLabel.getText().equals("a")&&passwdLabel.getText().equals("a"))) {
//            loginErrorLabel.setText("Invalid credentials");
//            loginErrorLabel.setVisible(true);
//
//        }
       ////////////////////////////// END FOR TESTS
        else {
            Parent root = FXMLLoader.load(getClass().getResource("/mainScene.fxml"));
            MainStage.mainStage.setScene(new Scene(root));

        }
            return true;
    }


}
