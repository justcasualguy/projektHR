package services.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Employee;
import services.dbconnector.DBConnector;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeTableViewController implements Initializable {


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
}
