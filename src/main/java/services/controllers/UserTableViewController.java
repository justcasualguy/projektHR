package services.controllers;

import com.mongodb.WriteResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import services.dbconnector.DBConnector;
import services.generators.ErrorGenerator;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserTableViewController implements Initializable {



    @FXML
    private Label label;

    @FXML
    private TableView<User> findUserTableView;

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

        sortedData.comparatorProperty().bind(findUserTableView.comparatorProperty());

        findUserTableView.setItems(sortedData);
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

    public TableView<User> getFindUserTableView()
    {
        return findUserTableView;
    }

    public void setFindUserTableView(TableView<User> findUserTableView)
    {
        this.findUserTableView = findUserTableView;
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

    public void refreshTableView()
    {
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

        sortedData.comparatorProperty().bind(findUserTableView.comparatorProperty());

        findUserTableView.setItems(sortedData);
    }

    public void deleteUserAction(ActionEvent actionEvent)
    {
        User selectedUser = findUserTableView.getSelectionModel().getSelectedItem();
        if(selectedUser == null)
        {
            ErrorGenerator.errorMessage("No user selected! Please select user.");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Removing user");
        alert.setContentText("Are you sure you want to remove user: " + selectedUser.getUsername() + "?");
        Optional<ButtonType> answer = alert.showAndWait();
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        if(answer.get() == ButtonType.OK)
        {
            WriteResult wr = DBConnector.getDatastore().delete(selectedUser);
            info.setContentText("User removed succesfully!");
            info.show();
            refreshTableView();
        }

    }


}
