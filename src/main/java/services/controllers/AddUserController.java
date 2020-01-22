package services.controllers;

import com.mongodb.client.model.Filters;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.User;
import org.bson.Document;
import services.LoginService;
import services.dbconnector.DBConnector;
import services.generators.ErrorGenerator;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {
    private String errorEmptyUsername = "Podaj nazwę użytkownika";
    private String errorEmptyPassword = "Podaj hasło";
    private String errorPasswordConfirmation= "Hasła nie są takie same  ";
    private String errorEmailIncorrect= "Nieprawidłowy email";
    private String errorUsernameTaken = "Nazwa użytkownika niedostępna";
    private String usernameAvailable = "Nazwa użytkownika dostępna";
    private Stage stage;
    @FXML
    private TextField usernameLabel;

    @FXML
    private Button checkAvailability;

    @FXML
    private PasswordField passwdLabel;

    @FXML
    private PasswordField passwdConfirmLabel;

    @FXML
    private Button registerButton;

    @FXML
    private TextField emailLabel;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginErrorLabel;

    @FXML
    private Label passwdErrorLabel;

    @FXML
    private Label emailErrorLabel;

    @FXML
    private RadioButton adminRadioButton;

    @FXML
    private RadioButton userRadioButton;

//    @FXML
//    private TextField nameTextField;
//
//    @FXML
//    private TextField surnameTextField;
//
//    @FXML
//    private TextField peselTextField;

    @FXML
    public boolean isUsernameAvailable(){

        if(usernameLabel.getText().equals("")) {
            ErrorGenerator.errorMessageWithTitle("Login nie może być pusty","Błąd");
            return false;
        }
        Document doc = DBConnector.getDatabase("Projekt")
                .getCollection("Users")
                .find(Filters.eq("username",usernameLabel.getText()))
                .first();
        if(doc!=null) {
            ErrorGenerator.errorMessageWithTitle("Nazwa użytkownika zajęta","Błąd");
            return false;
        }
     return true;

    }

    @FXML
    public boolean isUsernameAvailable2(){

        if(usernameLabel.getText().equals("")) {
            ErrorGenerator.errorMessageWithTitle("Login nie może być pusty","Błąd");
            return false;
        }
        Document doc = DBConnector.getDatabase("Projekt")
                .getCollection("Users")
                .find(Filters.eq("username",usernameLabel.getText()))
                .first();
        if(doc!=null) {
            ErrorGenerator.errorMessageWithTitle("Nazwa użytkownika zajęta","Błąd");
            return false;
        }
        ErrorGenerator.errorMessageWithTitle("Nazwa użytkownika dostępna","");
        return true;

    }

    @FXML
    public boolean registerUser(){
        if(isUsernameAvailable())
                if (checkPasswd())
                    if (isEmailValid()) {
                        DBConnector.getDatastore().save(new User(usernameLabel.getText(), passwdLabel.getText(), emailLabel.getText(), selectedRole(), LoginService.loggedUser.getUsername()));
                        ErrorGenerator.errorMessageWithTitle("Dodano użytkownika","Sukces");

        }

        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();

        userRadioButton.setToggleGroup(group);
        adminRadioButton.setToggleGroup(group);
        userRadioButton.setSelected(true);
    }

    public String selectedRole(){
        if(userRadioButton.isSelected())
            return "user";
        else
            return "admin";

    }

    public boolean isEmailValid(){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!emailLabel.getText().matches(regex)){
            ErrorGenerator.errorMessageWithTitle("Niepoprawny email","Błąd");
        }

        return emailLabel.getText().matches(regex);
    }

    public boolean checkPasswd(){
        if(!passwdLabel.getText().equals(passwdConfirmLabel.getText())) {
            ErrorGenerator.errorMessageWithTitle("Wprowadzone hasłą się róznią","Błąd");
            return false;
        }
       else if(passwdLabel.getText().equals("")){
            ErrorGenerator.errorMessageWithTitle("Hasło nie może być puste","Błąd");
            return false;
        }
       else
            return true;

    }

    public void cancel(){
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
    //<editor-fold desc="GS">
    public String getErrorEmptyUsername() {
        return errorEmptyUsername;
    }

    public void setErrorEmptyUsername(String errorEmptyUsername) {
        this.errorEmptyUsername = errorEmptyUsername;
    }

    public String getErrorEmptyPassword() {
        return errorEmptyPassword;
    }

    public void setErrorEmptyPassword(String errorEmptyPassword) {
        this.errorEmptyPassword = errorEmptyPassword;
    }

    public String getErrorPasswordConfirmation() {
        return errorPasswordConfirmation;
    }

    public void setErrorPasswordConfirmation(String errorPasswordConfirmation) {
        this.errorPasswordConfirmation = errorPasswordConfirmation;
    }

    public String getErrorEmailIncorrect() {
        return errorEmailIncorrect;
    }

    public void setErrorEmailIncorrect(String errorEmailIncorrect) {
        this.errorEmailIncorrect = errorEmailIncorrect;
    }

    public String getErrorUsernameTaken() {
        return errorUsernameTaken;
    }

    public void setErrorUsernameTaken(String errorUsernameTaken) {
        this.errorUsernameTaken = errorUsernameTaken;
    }

    public String getUsernameAvailable() {
        return usernameAvailable;
    }

    public void setUsernameAvailable(String usernameAvailable) {
        this.usernameAvailable = usernameAvailable;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextField getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(TextField usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public Button getCheckAvailability() {
        return checkAvailability;
    }

    public void setCheckAvailability(Button checkAvailability) {
        this.checkAvailability = checkAvailability;
    }

    public PasswordField getPasswdLabel() {
        return passwdLabel;
    }

    public void setPasswdLabel(PasswordField passwdLabel) {
        this.passwdLabel = passwdLabel;
    }

    public PasswordField getPasswdConfirmLabel() {
        return passwdConfirmLabel;
    }

    public void setPasswdConfirmLabel(PasswordField passwdConfirmLabel) {
        this.passwdConfirmLabel = passwdConfirmLabel;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    public TextField getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(TextField emailLabel) {
        this.emailLabel = emailLabel;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public Label getLoginErrorLabel() {
        return loginErrorLabel;
    }

    public void setLoginErrorLabel(Label loginErrorLabel) {
        this.loginErrorLabel = loginErrorLabel;
    }

    public Label getPasswdErrorLabel() {
        return passwdErrorLabel;
    }

    public void setPasswdErrorLabel(Label passwdErrorLabel) {
        this.passwdErrorLabel = passwdErrorLabel;
    }

    public Label getEmailErrorLabel() {
        return emailErrorLabel;
    }

    public void setEmailErrorLabel(Label emailErrorLabel) {
        this.emailErrorLabel = emailErrorLabel;
    }
    //</editor-fold>
}
