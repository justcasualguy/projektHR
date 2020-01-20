package services.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Salary;
import services.dbconnector.DBConnector;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSalarySceneController implements Initializable {

    @FXML
    private TextField dayBeginPeriodTextLabel;

    @FXML
    private TextField monthBeginPeriodTextLabel;

    @FXML
    private TextField yearBeginPeriodTextLabel;

    @FXML
    private TextField dayEndPeriodTextLabel;

    @FXML
    private TextField monthEndPeriodTextLabel;

    @FXML
    private TextField yearEndPeriodTextLabel;

    @FXML
    private TextField salaryTextField;

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> currencyOptions =
                FXCollections.observableArrayList(
                        "zł",
                        "\u20AC",
                        "\u00A3"
                );


        currencyComboBox.setItems(currencyOptions);
        salaryTextField.setText(EmployeeTableViewController.selectedEmployee.getSalary().split(" ")[0]);
        currencyComboBox.getSelectionModel().select( currencyOptions.indexOf(EmployeeTableViewController.selectedEmployee.getSalary().split(" ")[1]));


    }

    @FXML
    void cancel() {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confirmChanges(ActionEvent event) {
        String beginDate = dayBeginPeriodTextLabel.getText()+
                "-"+monthBeginPeriodTextLabel.getText()+
                "-"+yearBeginPeriodTextLabel.getText();

        String endDate = dayEndPeriodTextLabel.getText()+
                "-"+monthEndPeriodTextLabel.getText()+
                "-"+yearEndPeriodTextLabel.getText();

        EmployeeTableViewController.selectedEmployee.getSalaries().add(new Salary(salaryTextField.getText()+" "+currencyComboBox.getValue(),beginDate,endDate));

        DBConnector.getDatastore().save(EmployeeTableViewController.selectedEmployee);
       cancel();

    }

}
