package services.controllers;


import com.mongodb.WriteResult;
import gui.MainStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Employee;
import services.dbconnector.DBConnector;
import services.generators.ErrorGenerator;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeTableViewController implements Initializable {

    public static Employee selectedEmployee;
    private Stage viewEmployeeInfoStage;

    @FXML
    private Label label;

    @FXML
    private TableView<Employee> findEmployeeTableView;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> surnameColumn;

    @FXML
    private TableColumn<Employee, String> birthDateColumn;

    @FXML
    private TextField filterField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

        final ObservableList<Employee> dataList = FXCollections.observableArrayList();

        dataList.addAll(DBConnector.getCollectionAsList(Employee.class));

        FilteredList<Employee> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(employee.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else return employee.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1;
            });

        });

        SortedList<Employee> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(findEmployeeTableView.comparatorProperty());

        findEmployeeTableView.setItems(sortedData);
    }

    public Label getLabel()
    {
        return label;
    }

    public void setLabel(Label label)
    {
        this.label = label;
    }

    public TextField getFilterField()
    {
        return filterField;
    }

    public void setFilterField(TextField filterField)
    {
        this.filterField = filterField;
    }

    public TableView<Employee> getFindEmployeeTableView()
    {
        return findEmployeeTableView;
    }

    public void setFindEmployeeTableView(TableView<Employee> findEmployeeTableView)
    {
        this.findEmployeeTableView = findEmployeeTableView;
    }

    public TableColumn<Employee, String> getNameColumn()
    {
        return nameColumn;
    }

    public void setNameColumn(TableColumn<Employee, String> nameColumn)
    {
        this.nameColumn = nameColumn;
    }

    public TableColumn<Employee, String> getSurnameColumn()
    {
        return surnameColumn;
    }

    public void setSurnameColumn(TableColumn<Employee, String> surnameColumn)
    {
        this.surnameColumn = surnameColumn;
    }

    public TableColumn<Employee, String> getBirthDateColumn()
    {
        return birthDateColumn;
    }

    public void setBirthDateColumn(TableColumn<Employee, String> birthDateColumn)
    {
        this.birthDateColumn = birthDateColumn;
    }



    public void refreshTableView()
    {
        final ObservableList<Employee> dataList = FXCollections.observableArrayList();

        dataList.addAll(DBConnector.getCollectionAsList(Employee.class));

        FilteredList<Employee> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(employee.getName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else return employee.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1;
            });

        });

        SortedList<Employee> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(findEmployeeTableView.comparatorProperty());

        findEmployeeTableView.setItems(sortedData);
    }

    public void deleteEmployeeAction(ActionEvent actionEvent)
    {
        Employee selectedEmployee = findEmployeeTableView.getSelectionModel().getSelectedItem();
        if(selectedEmployee == null)
        {
            ErrorGenerator.errorMessage("No employee selected! Please select employee.");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Removing employee");
        alert.setContentText("Are you sure you want to remove employee: " + selectedEmployee.getName() + "?");
        Optional<ButtonType> answer = alert.showAndWait();
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        if(answer.get() == ButtonType.OK)
        {
            WriteResult wr = DBConnector.getDatastore().delete(selectedEmployee);
            info.setContentText("Employee removed succesfully!");
            info.show();
            refreshTableView();
        }

    }

    public void viewEmployeeInfo(ActionEvent actionEvent){
        selectedEmployee = findEmployeeTableView.getSelectionModel().getSelectedItem();
        if(selectedEmployee == null)
        {
            ErrorGenerator.errorMessage("No employee selected! Please select employee.");
            return;
        }

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/viewEmployeeInfoScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewEmployeeInfoStage = new Stage();
        viewEmployeeInfoStage.initModality(Modality.WINDOW_MODAL);
        viewEmployeeInfoStage.initOwner(MainStage.mainStage.getScene().getWindow());
        viewEmployeeInfoStage.setScene(new Scene(root));
        viewEmployeeInfoStage.show();
        //MainStage.mainStage.setScene(new Scene(root));


    }


    public void viewQualificationMenu(ActionEvent actionEvent)
    {
        selectedEmployee = findEmployeeTableView.getSelectionModel().getSelectedItem();
        if(selectedEmployee == null)
        {
            ErrorGenerator.errorMessage("No employee selected! Please select employee.");
            return;
        }
        /*Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("/employeeQualificationMenu.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/employeeQualificationMenu.fxml"));
        try
        {
            loader.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        employeeQualificationMenuController e = loader.getController();
        e.sendEmployee(selectedEmployee);

        Parent root = loader.getRoot();

        viewEmployeeInfoStage = new Stage();
        viewEmployeeInfoStage.initModality(Modality.WINDOW_MODAL);
        viewEmployeeInfoStage.initOwner(MainStage.mainStage.getScene().getWindow());
        viewEmployeeInfoStage.setScene(new Scene(root));
        viewEmployeeInfoStage.show();

    }
}
