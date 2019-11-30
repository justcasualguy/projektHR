package services.controllers;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import models.User;
import org.bson.Document;
import services.dbconnector.DBConnector;

public class AddUserController {
    private String errorEmptyUsername = "Podaj nazwę użytkownika";
    private String errorEmptyPassword = "Podaj hasło";
    private String errorPasswordConfirmation= "Hasła nie są takie same  ";
    private String errorEmailIncorrect= "Nieprawidłowy email";
    private String errorUsernameTaken = "Nazwa użytkownika niedostępna";
    private String usernameAvailable = "Nazwa użytkownika dostępna";

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
    public boolean isUsernameAvailable(){

        if(usernameLabel.getText().equals("")) {
            loginErrorLabel.setText(errorEmptyUsername);
            loginErrorLabel.setVisible(true);
            return false;
        }
        System.out.println("A1");
        Document doc = DBConnector.getDatabase("Projekt")
                .getCollection("Users")
                .find(Filters.eq("username",usernameLabel.getText()))
                .first();
        System.out.println("A2");
        if(doc!=null) {
            loginErrorLabel.setText(errorUsernameTaken);
            loginErrorLabel.setVisible(true);
        }
        else{
            loginErrorLabel.setTextFill(Color.GREEN);
            loginErrorLabel.setText(usernameAvailable);
            loginErrorLabel.setVisible(true);
        }
        return doc==null;
    }

    @FXML
    public boolean registerUser(){

        if(isUsernameAvailable())
                if (checkPasswd())
                    if (isEmailValid()) {

                        MongoCollection<Document> collection = DBConnector.getDatabase().getCollection("Users");
                        collection.insertOne(new User(usernameLabel.getText(), passwdLabel.getText(), "user").toDocument());
                        emailErrorLabel.setText("zarejestrowano pomyslnie");
                        emailErrorLabel.setVisible(true);

        }

        return false;
    }

    public boolean isEmailValid(){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!emailLabel.getText().matches(regex)){
            emailErrorLabel.setText(errorEmailIncorrect);
            emailErrorLabel.setVisible(true);
        }
        else
            emailErrorLabel.setText("Poprawny email");
        emailErrorLabel.setVisible(true);
        return emailLabel.getText().matches(regex);
    }

    public boolean checkPasswd(){
        if(!passwdLabel.getText().equals(passwdConfirmLabel.getText())) {
            passwdErrorLabel.setText(errorPasswordConfirmation);
            passwdErrorLabel.setVisible(true);
            return false;
        }
       else if(passwdLabel.getText().equals("")){
            passwdErrorLabel.setText(errorEmptyPassword);
            passwdErrorLabel.setVisible(true);
            return false;
        }
       else
            return true;
    }

}
