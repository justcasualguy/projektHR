package services.controllers;

import gui.MainStage;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import services.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
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
            Parent root;
            if(LoginService.loggedUser.getRole().equals("admin"))
                 root = FXMLLoader.load(getClass().getResource("/mainSceneAdmin.fxml"));
            else
                root = FXMLLoader.load(getClass().getResource("/mainSceneUser.fxml"));

           MainStage.mainStage.setScene(new Scene(root));

        }
            return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.getParent().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if( event.getCode()== KeyCode.ENTER) {
                    try {
                        validateLogin();
                    }
                    catch (Exception e){

                    }
                    }

            }
        });
    }

    //<editor-fold desc="G&S">
    public String getErrorInvalidCredentials() {
        return errorInvalidCredentials;
    }

    public void setErrorInvalidCredentials(String errorInvalidCredentials) {
        this.errorInvalidCredentials = errorInvalidCredentials;
    }

    public Button getLoginButton() {
        return loginButton;

    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public TextField getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(TextField loginLabel) {
        this.loginLabel = loginLabel;
    }

    public PasswordField getPasswdLabel() {
        return passwdLabel;
    }

    public void setPasswdLabel(PasswordField passwdLabel) {
        this.passwdLabel = passwdLabel;
    }

    public Label getLoginErrorLabel() {
        return loginErrorLabel;
    }

    public void setLoginErrorLabel(Label loginErrorLabel) {
        this.loginErrorLabel = loginErrorLabel;
    }
    //</editor-fold>
}
