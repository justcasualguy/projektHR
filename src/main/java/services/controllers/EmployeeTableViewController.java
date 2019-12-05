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
import models.User;
import services.dbconnector.DBConnector;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeTableViewController implements Initializable {


    @FXML
    private Label label;

    @FXML
    private TableView<User> findEmployeeTableView;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> surnameColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TextField filterField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        final ObservableList<User> dataList = FXCollections.observableArrayList();

        dataList.addAll(DBConnector.getCollectionAsList(User.class));

        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(user.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else return user.getRole().toLowerCase().indexOf(lowerCaseFilter) != -1;
            });

        });

        SortedList<User> sortedData = new SortedList<>(filteredData);

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

    public TableView<User> getFindEmployeeTableView()
    {
        return findEmployeeTableView;
    }

    public void setFindEmployeeTableView(TableView<User> findEmployeeTableView)
    {
        this.findEmployeeTableView = findEmployeeTableView;
    }

    public TableColumn<User, String> getNameColumn()
    {
        return nameColumn;
    }

    public void setNameColumn(TableColumn<User, String> nameColumn)
    {
        this.nameColumn = nameColumn;
    }

    public TableColumn<User, String> getSurnameColumn()
    {
        return surnameColumn;
    }

    public void setSurnameColumn(TableColumn<User, String> surnameColumn)
    {
        this.surnameColumn = surnameColumn;
    }

    public TableColumn<User, String> getRoleColumn()
    {
        return roleColumn;
    }

    public void setRoleColumn(TableColumn<User, String> roleColumn)
    {
        this.roleColumn = roleColumn;
    }
}
