package services.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.generators.ErrorGenerator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewEmployeeInfoController implements Initializable {



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
    private TextField departmentTextField;

    @FXML
    private TextField personalIdentityNumberTextField;

    @FXML
    private TextField idCardNumberTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField houseNumberTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField zipCodeTextField;

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private Button editModeButton;

    @FXML
    private Button confirmButton;
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


        String name = EmployeeTableViewController.selectedEmployee.getName();
        String surname= EmployeeTableViewController.selectedEmployee.getSurname();
        String personalIdentityNumber = EmployeeTableViewController.selectedEmployee.getPersonalIdentityNumber();
        String idCardNumber = EmployeeTableViewController.selectedEmployee.getIdCardNumber();
        String street = EmployeeTableViewController.selectedEmployee.getAddress().getStreet();
        String houseNumber = EmployeeTableViewController.selectedEmployee.getAddress().getHouseNumber();
        String city = EmployeeTableViewController.selectedEmployee.getAddress().getCity();
        String country = EmployeeTableViewController.selectedEmployee.getAddress().getCountry();
        String zipCode = EmployeeTableViewController.selectedEmployee.getAddress().getZipcode();
        String department = EmployeeTableViewController.selectedEmployee.getJobPosition().getDepartment();
        String jobPosition = EmployeeTableViewController.selectedEmployee.getJobPosition().getPositionName();
        String salary = EmployeeTableViewController.selectedEmployee.getSalary();
        String phoneNumber = EmployeeTableViewController.selectedEmployee.getPhoneNumber();
        String contractType = EmployeeTableViewController.selectedEmployee.getContractType();
        String birthDate = EmployeeTableViewController.selectedEmployee.getBirthDate();
        String employedSince = EmployeeTableViewController.selectedEmployee.getEmployedSince();


        nameTextField.setText(name);
        surnameTextField.setText(surname);
        personalIdentityNumberTextField.setText(personalIdentityNumber);
        idCardNumberTextField.setText(idCardNumber);
        streetTextField.setText(street);
        houseNumberTextField.setText(houseNumber);
        cityTextField.setText(city);
        countryTextField.setText(country);
        zipCodeTextField.setText(zipCode);
        departmentTextField.setText(department);
        jobPositionTextField.setText(jobPosition);
        salaryTextField.setText(salary);
        phoneNumberTextField.setText(phoneNumber);

        contractTypeComboBox.setValue(contractType);
        yearBirthdayTextField.setText(birthDate.split("-")[0]);
        monthBirthdayTextField.setText(birthDate.split("-")[1]);
        dayBirthdayTextField.setText(birthDate.split("-")[2]);

        yearEmployedTextField.setText(employedSince.split("-")[0]);
        monthEmployedTextField.setText(employedSince.split("-")[1]);
        dayEmployedTextField.setText(employedSince.split("-")[2]);








    }


    @FXML
    public void switchEditMode(ActionEvent event){
        nameTextField.setEditable(!nameTextField.isEditable());
        surnameTextField.setEditable(!surnameTextField.isEditable());
        personalIdentityNumberTextField.setEditable(!personalIdentityNumberTextField.isEditable());
        idCardNumberTextField.setEditable(!idCardNumberTextField.isEditable());
        streetTextField.setEditable(!streetTextField.isEditable());
        houseNumberTextField.setEditable(!houseNumberTextField.isEditable());
        cityTextField.setEditable(!cityTextField.isEditable());
        countryTextField.setEditable(!countryTextField.isEditable());
        zipCodeTextField.setEditable(!zipCodeTextField.isEditable());
        departmentTextField.setEditable(!departmentTextField.isEditable());
        jobPositionTextField.setEditable(!jobPositionTextField.isEditable());
        salaryTextField.setEditable(!jobPositionTextField.isEditable());
        phoneNumberTextField.setEditable(!phoneNumberTextField.isEditable());

        yearEmployedTextField.setEditable(!yearEmployedTextField.isEditable());
        monthEmployedTextField.setEditable(!monthEmployedTextField.isEditable());
        dayEmployedTextField.setEditable(!dayEmployedTextField.isEditable());

        yearBirthdayTextField.setEditable(!yearBirthdayTextField.isEditable());
        monthBirthdayTextField.setEditable(!monthBirthdayTextField.isEditable());
        dayEmployedTextField.setEditable(!monthEmployedTextField.isEditable());
    }

    public ArrayList<String> checkEdited(){
        ArrayList<String> edited = new ArrayList<String>();
        String birthDate = yearBirthdayTextField.getText()+"-"+monthBirthdayTextField.getText()+"-"+dayBirthdayTextField.getText();
        String employedSince = yearEmployedTextField.getText()+"-"+monthEmployedTextField.getText()+"-"+dayEmployedTextField.getText();

        if(!nameTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getName()))
            edited.add("Imię");
        if(!surnameTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getSurname()))
            edited.add("Nazwisko");
        if(!personalIdentityNumberTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getPersonalIdentityNumber()))
            edited.add("PESEL");
        if(!idCardNumberTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getIdCardNumber()))
            edited.add("Numer dowodu osobistego");
        if(!streetTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getAddress().getStreet()))
            edited.add("Ulica");
        if(!houseNumberTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getAddress().getHouseNumber()))
            edited.add("Numer domu");
        if(!cityTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getAddress().getCity()))
            edited.add("Miasto");
        if(!countryTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getAddress().getCountry()))
            edited.add("Kraj");
        if(!zipCodeTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getAddress().getZipcode()))
            edited.add("Kod pocztowy");
        if(!departmentTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getJobPosition().getDepartment()))
            edited.add("Dział");
        if(!jobPositionTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getJobPosition().getPositionName()))
            edited.add("Stanowisko");
        if(!salaryTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getSalary()))
            edited.add("Wynagrodzenie");
        if(!phoneNumberTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getPhoneNumber()))
            edited.add("Numer telefonu");
        if(!birthDate.equals(EmployeeTableViewController.selectedEmployee.getBirthDate()))
            edited.add("Data urodzenia");
        if(!employedSince.equals(EmployeeTableViewController.selectedEmployee.getEmployedSince()))
            edited.add("Data urodzenia");

        return edited;


    }
    @FXML
    public void confirmEdition(){
        StringBuilder message= new StringBuilder();
        ArrayList<String> edited = checkEdited();
        message.append("Edytowno pola:");



        if(checkEdited().size()!=0){
            for (String s: edited)
                message.append(String.format("\n %s",s));
            ErrorGenerator.errorMessage(message.toString());
        }
    }


    @FXML
    void addEmployee(ActionEvent event) {

    }


    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

}

