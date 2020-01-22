package services.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import models.Salary;
import services.generators.DocumentGenerator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeSalariesMenuController implements Initializable {



    @FXML
    private ListView salariesListView;

    @FXML
    private Button addButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button genPaySlip;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        refreshListView();


    }
    void refreshListView(){
        ObservableList<Salary> salaries = FXCollections.observableArrayList(EmployeeTableViewController.selectedEmployee.getSalaries());

        salariesListView.setItems(salaries);

        StringConverter<Salary> sc = new StringConverter<Salary>() {

            @Override
            public String toString(Salary salary) {
                // TODO Auto-generated method stub
                return salary.toString();
            }

            @Override
            public Salary fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        };
        salariesListView.setCellFactory(TextFieldListCell.forListView(sc));
    }
@FXML
    void addSalary(){

        Parent root = null;
    try {
        root = FXMLLoader.load(getClass().getResource("/addSalaryScene.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Stage stage = new Stage();
    stage.initModality(Modality.WINDOW_MODAL);
    stage.initOwner(exitButton.getScene().getWindow());
    stage.setScene(new Scene(root));
    stage.setOnHiding( event -> refreshListView());
    stage.setTitle("Dodaj paek wypłaty");
    stage.show();

    }

    @FXML
    void paySlipgen(){
        if(salariesListView.getSelectionModel().getSelectedItem()==null)
            return;
        else
        DocumentGenerator.generateEmployeePayslip(EmployeeTableViewController.selectedEmployee,(Salary)salariesListView.getSelectionModel().getSelectedItem(),new File("src/main/resources/payslip.docx").getAbsolutePath(),"pasekTest.docs",null);
    }
    @FXML
    void exit(){
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
}
