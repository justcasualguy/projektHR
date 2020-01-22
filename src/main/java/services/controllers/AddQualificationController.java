package services.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.dbconnector.DBConnector;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddQualificationController implements Initializable
{
    @FXML
    private TextField qualificationTextField;

    @FXML
    private Button addQualificationButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML


    public void updateEmploye(ActionEvent actionEvent)
    {
        String qual = qualificationTextField.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Dodawanie kwalifikacji");
        alert.setContentText("Czy chcesz dodać kwalifikację: " + qual + "?");
        Optional<ButtonType> answer = alert.showAndWait();
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        if(answer.get() == ButtonType.OK)
        {
            EmployeeTableViewController.selectedEmployee.getQualifications().add(qual);
            DBConnector.getDatastore().save(EmployeeTableViewController.selectedEmployee);
            info.setContentText("Dodano!");
            info.show();
        }
    }
}
