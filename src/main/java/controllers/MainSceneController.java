package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private Label whoIsLoggedIn;

    @FXML
    private Button logOut;

    @FXML
    private Button addUser;

    @FXML
    private Button removeUser;

    @FXML
    private Button editUser;

    @FXML
    private Button seekEmploye;

    @FXML
    private Button generateSomething;

    @FXML
    private Label appName;

    @FXML
    private CheckBox nightMode;

    @FXML
    private boolean addUser(){
        Stage addUserWindow = new Stage();
return true;
    }

}