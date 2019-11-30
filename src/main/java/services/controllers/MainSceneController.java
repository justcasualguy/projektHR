package services.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private void addUser() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/registerScene.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
    stage.show();
        //MainStage.mainStage.setScene(new Scene(root));

    }

}