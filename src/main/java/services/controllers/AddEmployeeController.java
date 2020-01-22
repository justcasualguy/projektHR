package services.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Address;
import models.Employee;
import models.JobPosition;
import models.Salary;
import services.LoginService;
import services.Validators;
import services.dbconnector.DBConnector;
import services.generators.ErrorGenerator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {


    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField dayBirthdayTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField monthBirthdayTextField;

    @FXML
    private TextField yearBirthdayTextField;

    @FXML
    private TextField dayEmployedTextField;

    @FXML
    private TextField monthEmployedTextField;

    @FXML
    private TextField yearEmployedTextField;

    @FXML
    private TextField jobPositionTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private ComboBox<String> contractTypeComboBox;

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private TextField departmentTextField;

    @FXML
    private TextField personalIdentityNumberTextField;

    @FXML
    private TextField idCardNumberTextField;

    @FXML
    private TextField phoneNumberTextField;


    @FXML
    private TextField houseNumberTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField zipCodeTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> contractOptions =
                FXCollections.observableArrayList(
                        "Umowa o pracę",
                        "Umowa zlecenie",
                        "Umowa o dzieło"
                );
        ObservableList<String> currencyOptions =
                FXCollections.observableArrayList(
                        "zł",
                        "\u20AC",
                        "\u00A3"
                );



        contractTypeComboBox.setItems(contractOptions);
        currencyComboBox.setItems(currencyOptions);
        currencyComboBox.getSelectionModel().selectFirst();

    }

    public void addEmployee(){
        String name = nameTextField.getText();
        String surname= surnameTextField.getText();
        String personalIdentityNumber = personalIdentityNumberTextField.getText();
        String idCardNumber = idCardNumberTextField.getText();
        String street = streetTextField.getText();
        String houseNumber = houseNumberTextField.getText();
        String city = cityTextField.getText();
        String country = countryTextField.getText();
        String zipCode = zipCodeTextField.getText();
        String department = departmentTextField.getText();
        String jobPosition = jobPositionTextField.getText();
        String salary = salaryTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String contractType = contractTypeComboBox.getValue();
        String birthDate = yearBirthdayTextField.getText()+"-"+monthBirthdayTextField.getText()+"-"+dayBirthdayTextField.getText();
        String employedSince = yearEmployedTextField.getText()+"-"+monthEmployedTextField.getText()+"-"+dayEmployedTextField.getText();
        List<String> qual = new ArrayList<String>();

        if(!Validators.validateDate(birthDate)) {
            messageLabel.setText("Err: data urodzenia");
            ErrorGenerator.errorMessageWithTitle("Niepoprawna data urodzenia","Błąd");
            return;
        }

        if(!Validators.validateDate(employedSince)) {

            ErrorGenerator.errorMessageWithTitle("Niepoprawna data zatrudnienia","Błąd");
            return;
        }

        if(!Validators.validateName(name)){

            ErrorGenerator.errorMessageWithTitle("Niepoprawne imię","Błąd");
            return;
        }
        if(!Validators.validateSurname(surname)){

            ErrorGenerator.errorMessageWithTitle("Niepoprawne nazwisko","Błąd");
            return;
        }

        if(!Validators.validatePhone(phoneNumber)){
            ErrorGenerator.errorMessageWithTitle("Niepoprawny numer telefonu","Błąd");

            return;
        }

        if(!Validators.validateSalary(salary)){
            ErrorGenerator.errorMessageWithTitle("Niepoprawna wynagrodzenie","Błąd");

            return;
        }
        if(!Validators.validateContractType(contractType)){
            ErrorGenerator.errorMessageWithTitle("Nie wybramo typu kontraktu","Błąd");

            return;
        }



        Employee employee =  new Employee(name,surname,birthDate,personalIdentityNumber,idCardNumber,employedSince,
                new JobPosition(employedSince,"",jobPosition,department),salary+" "+currencyComboBox.getValue(),contractType,
                new Address(country,city,street,houseNumber,zipCode), qual ,new ArrayList<Salary>(), LoginService.loggedUser.getUsername()
                ,phoneNumber);



        DBConnector.getDatastore().save(employee);

        ErrorGenerator.errorMessageWithTitle("Dodano pracowika","Sukces");

    }

    public void cancel(){
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }




}
