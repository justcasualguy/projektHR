package services.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import models.Employee;
import models.Salary;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeSalariesMenuController implements Initializable {



    @FXML
    private ListView salariesListView;

    @FXML
    private Button addButton;

    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Salary> salaries = FXCollections.observableArrayList(EmployeeTableViewController.selectedEmployee.getSalaries());
        salariesListView.setItems(salaries);

        StringConverter<Employee> sc = new StringConverter<Employee>() {

            @Override
            public String toString(Employee employee) {
                // TODO Auto-generated method stub
                return employee.toString();
            }

            @Override
            public Employee fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        };
        salariesListView.setCellFactory(TextFieldListCell.forListView(sc));


    }

    void addSalary(){



    }
}
