package services.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Address;
import models.Employee;
import models.JobPosition;
import models.Salary;
import services.LoginService;
import services.Validators;
import services.dbconnector.DBConnector;
import services.generators.ErrorGenerator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    @FXML
    private Button salariesButton;

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

        currencyComboBox.getSelectionModel().select( currencyOptions.indexOf(salary.split(" ")[1]));

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
        salaryTextField.setText(salary.split(" ")[0]);
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
    public void switchEditMode(){

        confirmButton.setVisible(!confirmButton.isVisible());


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
        salaryTextField.setEditable(!salaryTextField.isEditable());
        phoneNumberTextField.setEditable(!phoneNumberTextField.isEditable());
        currencyComboBox.setDisable(!currencyComboBox.isDisabled());
        contractTypeComboBox.setDisable(!contractTypeComboBox.isDisabled());
        yearEmployedTextField.setEditable(!yearEmployedTextField.isEditable());
        monthEmployedTextField.setEditable(!monthEmployedTextField.isEditable());
        dayEmployedTextField.setEditable(!dayEmployedTextField.isEditable());

        yearBirthdayTextField.setEditable(!yearBirthdayTextField.isEditable());
        monthBirthdayTextField.setEditable(!monthBirthdayTextField.isEditable());
        dayBirthdayTextField.setEditable(!dayBirthdayTextField.isEditable());
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
        if(!(salaryTextField.getText()+" "+currencyComboBox.getValue()).equals(EmployeeTableViewController.selectedEmployee.getSalary()))
            edited.add("Wynagrodzenie");
        if(!phoneNumberTextField.getText().equals(EmployeeTableViewController.selectedEmployee.getPhoneNumber()))
            edited.add("Numer telefonu");
        if(!birthDate.equals(EmployeeTableViewController.selectedEmployee.getBirthDate()))
            edited.add("Data urodzenia");
        if(!employedSince.equals(EmployeeTableViewController.selectedEmployee.getEmployedSince()))
            edited.add("Data urodzenia");
        if(!contractTypeComboBox.getValue().equals(EmployeeTableViewController.selectedEmployee.getContractType()))
            edited.add("Typ kontraktu");


        return edited;


    }
    @FXML
    public void confirmChanges(){

        if(!validate())
            return;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Potwierdź zmiany");
        window.setMinWidth(300);

        Label message = new Label();

        VBox v = new VBox(20);

        StringBuilder messageString = new StringBuilder();
        ArrayList<String> edited = checkEdited();


        if(checkEdited().size()!=0) {
            messageString.append("Edytowno pola:");
            for (String s : edited)
                messageString.append(String.format("\n %s", s));
            messageString.append("\n Zapisać zmienione pola?");

            Button close = new Button("Cofnij");
            Button confirm = new Button("Potwierdź");

            message.setText(messageString.toString());
            close.setOnAction(e -> window.close());
            confirm.setOnAction(e -> {
                upadateEmployee();
                window.close();});
            v.getChildren().addAll(message,confirm, close);

        }
        else {
            messageString.append("Nie wprowadzono zmian");
            message.setText(messageString.toString());
            Button close = new Button("Cofnij");
            close.setOnAction(e -> window.close());
            v.getChildren().addAll( message,close);
        }




        v.setAlignment(Pos.CENTER);

        Scene scene = new Scene(v);
        window.setScene(scene);
        window.showAndWait();
    }

    public boolean validate(){


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



        if(!Validators.validateDate(birthDate)) {
            ErrorGenerator.errorMessage("Niepoprawna data urodzenia.");
            //messageLabel.setText("Err: data urodzenia");
            messageLabel.setVisible(true);
            return false;
        }

        if(!Validators.validateDate(employedSince)) {
            ErrorGenerator.errorMessage("Niepoprawna data zatrudnienia.");
            //messageLabel.setText("Err: data zatrudnienia");
            messageLabel.setVisible(true);
            return false;
        }

        if(!Validators.validateDate(birthDate)) {
            ErrorGenerator.errorMessage("Niepoprawna data urodzenia.");
            //messageLabel.setText("Err: data zatrudnienia");
            messageLabel.setVisible(true);
            return false;
        }

        if(!Validators.validateName(name)){
            ErrorGenerator.errorMessage("Niepoprawne imie.");
            //messageLabel.setText("Err: imie");
            messageLabel.setVisible(true);
            return false;
        }
        if(!Validators.validateSurname(surname)){
            ErrorGenerator.errorMessage("Niepoprawne naziwsko.");
            //messageLabel.setText("Err: nazwisko");
            messageLabel.setVisible(true);
            return false;
        }

        if(!Validators.validatePhone(phoneNumber)){
            ErrorGenerator.errorMessage("Niepoprawny numer telefonu.");
            //messageLabel.setText("Err: numer telefonu");
            messageLabel.setVisible(true);
            return false;
        }

        if(!Validators.validateSalary(salary)){
            ErrorGenerator.errorMessage("Niepoprawne wynagrodzenie.");
            //messageLabel.setText("Err: wynagrodzenie");
            messageLabel.setVisible(true);
            return false;
        }
        if(!Validators.validateContractType(contractType)){
            ErrorGenerator.errorMessage("Wybierz typ kontraktu.");
            //messageLabel.setText("Err: typ kontraktu");
            messageLabel.setVisible(true);
            return false;
        }


        return true;
    }


    public void upadateEmployee(){



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
        List<Salary> salaries = new ArrayList<Salary>();




        Employee employee =  new Employee(name,surname,birthDate,personalIdentityNumber,idCardNumber,employedSince,
                new JobPosition(employedSince,"",jobPosition,department),salary+" "+currencyComboBox.getValue(),contractType,
                new Address(country,city,street,houseNumber,zipCode), qual ,salaries, LoginService.loggedUser.getUsername()
        ,phoneNumber);

        employee.setId(EmployeeTableViewController.selectedEmployee.getId());
        DBConnector.getDatastore().save(employee);
    }

    @FXML
    public void salaries(){
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("/employeeSalariesMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(cancelButton.getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.setTitle("Wypłaty");
        stage.show();
    }


    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

}

