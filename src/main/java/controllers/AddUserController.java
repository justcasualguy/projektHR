package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUserController {



    @FXML
    private TextField loginText;

    @FXML
    private Button checkAvailability;

    @FXML
    private PasswordField passwdText1;

    @FXML
    private PasswordField passwdText2;

    @FXML
    private Button register;

    @FXML
    private TextField emailText;

    @FXML
    private Button cancel;

    @FXML
    private Label loginError;

    @FXML
    private Label passwdError;

    @FXML
    private Label emailError;
}
