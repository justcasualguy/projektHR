package services.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddEmployeeController {

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField imieTextField;

    @FXML
    private TextField nazwiskoTextField;

    @FXML
    private TextField dayBirthdayTextField;

    @FXML
    private TextField adresTextField;

    @FXML
    private TextField monthBirthdayTextField;

    @FXML
    private TextField yearBirthdayTextField;

    @FXML
    private TextField dayWorkTextField;

    @FXML
    private TextField monthWorkTextField;

    @FXML
    private TextField yearWorkTextField;

    public Button getAddEmployeeButton()
    {
        return addEmployeeButton;
    }

    public void setAddEmployeeButton(Button addEmployeeButton)
    {
        this.addEmployeeButton = addEmployeeButton;
    }

    public Button getCancelButton()
    {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton)
    {
        this.cancelButton = cancelButton;
    }

    public TextField getImieTextField()
    {
        return imieTextField;
    }

    public void setImieTextField(TextField imieTextField)
    {
        this.imieTextField = imieTextField;
    }

    public TextField getNazwiskoTextField()
    {
        return nazwiskoTextField;
    }

    public void setNazwiskoTextField(TextField nazwiskoTextField)
    {
        this.nazwiskoTextField = nazwiskoTextField;
    }

    public TextField getDayBirthdayTextField()
    {
        return dayBirthdayTextField;
    }

    public void setDayBirthdayTextField(TextField dayBirthdayTextField)
    {
        this.dayBirthdayTextField = dayBirthdayTextField;
    }

    public TextField getAdresTextField()
    {
        return adresTextField;
    }

    public void setAdresTextField(TextField adresTextField)
    {
        this.adresTextField = adresTextField;
    }

    public TextField getMonthBirthdayTextField()
    {
        return monthBirthdayTextField;
    }

    public void setMonthBirthdayTextField(TextField monthBirthdayTextField)
    {
        this.monthBirthdayTextField = monthBirthdayTextField;
    }

    public TextField getYearBirthdayTextField()
    {
        return yearBirthdayTextField;
    }

    public void setYearBirthdayTextField(TextField yearBirthdayTextField)
    {
        this.yearBirthdayTextField = yearBirthdayTextField;
    }

    public TextField getDayWorkTextField()
    {
        return dayWorkTextField;
    }

    public void setDayWorkTextField(TextField dayWorkTextField)
    {
        this.dayWorkTextField = dayWorkTextField;
    }

    public TextField getMonthWorkTextField()
    {
        return monthWorkTextField;
    }

    public void setMonthWorkTextField(TextField monthWorkTextField)
    {
        this.monthWorkTextField = monthWorkTextField;
    }

    public TextField getYearWorkTextField()
    {
        return yearWorkTextField;
    }

    public void setYearWorkTextField(TextField yearWorkTextField)
    {
        this.yearWorkTextField = yearWorkTextField;
    }
}
