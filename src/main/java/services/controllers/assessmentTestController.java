package services.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class assessmentTestController implements Initializable {

    @FXML
    private VBox assessmentsVbox;

    @FXML
    private Button cancelButton;

    @FXML
    private Button addButton;

    @FXML
    private Pane mainPane;

    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        scrollPane.setFitToWidth(true);
        for(int i=0;i<3;i++){
            try {

                assessmentsVbox.getChildren().add(FXMLLoader.load(getClass().getResource("/singleAssessmentTest.fxml")));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }}
}
