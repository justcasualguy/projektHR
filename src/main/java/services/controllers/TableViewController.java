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

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {



    @FXML
    private Label label;

    @FXML
    private TableView<User> findEmployeeTableView;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TextField filterField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        final ObservableList<User> dataList = FXCollections.observableArrayList();
        User u1 = new User("u1", "test", "email1@email.com", "user");
        User u2 = new User("u2", "test", "email2@email.com", "user");
        User u3 = new User("u3", "test", "email3@email.com", "admin");
        User u4 = new User("u4", "test", "email4@email.com", "user");

        dataList.addAll(u1,u2,u3,u4);

        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(user.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(user.getRole().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else
                    return false;
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

    public TableColumn<User, String> getUsernameColumn()
    {
        return usernameColumn;
    }

    public void setUsernameColumn(TableColumn<User, String> usernameColumn)
    {
        this.usernameColumn = usernameColumn;
    }

    public TableColumn<User, String> getEmailColumn()
    {
        return emailColumn;
    }

    public void setEmailColumn(TableColumn<User, String> emailColumn)
    {
        this.emailColumn = emailColumn;
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
