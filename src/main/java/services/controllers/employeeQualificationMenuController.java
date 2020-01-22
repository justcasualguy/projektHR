package services.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Employee;
import services.dbconnector.DBConnector;
import services.generators.ErrorGenerator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class employeeQualificationMenuController implements Initializable
{
    public static TreeItem<String> selectedQual;

    @FXML
    private TreeView<String> qualificationTreeView;

    @FXML
    private Button addQualificationButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void sendEmployee(Employee e)
    {
         List<String> s = new ArrayList<>();
         List<String> qual = e.getQualifications();

         s.add("Test");
         TreeItem<String> root = new TreeItem<>(e.getName() + " " + e.getSurname());
         if(qual.size() == 0)
         {
             root.getChildren().add(new TreeItem<>("Brak Kwalifikacji"));
         }
         else
         {
             for(String item : qual)
             {
                 root.getChildren().add(new TreeItem<>(item));
             }
         }
         qualificationTreeView.setRoot(root);
    }


    public void addQual(ActionEvent actionEvent)
    {
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("/addQualificationScene.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(addQualificationButton.getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.setOnHiding(event -> refreshView());
        stage.show();
    }

    public void removeQual(ActionEvent actionEvent)
    {
        Employee e = EmployeeTableViewController.selectedEmployee;
        selectedQual = qualificationTreeView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Usuwanie kwalifikacji");
        if(selectedQual == null)
        {
            ErrorGenerator.errorMessage("Wystąpił błąd, nic nie zaznaczono!");
            return;
        }
        if(selectedQual.getValue().equalsIgnoreCase("Brak kwalifikacji") || selectedQual.getValue().equalsIgnoreCase(e.getName() + " " + e.getSurname()))
        {
            ErrorGenerator.errorMessage("Wystąpił błąd, nie można usunąć " + selectedQual.getValue());
            return;
        }
        alert.setContentText("Czy chcesz usunąć kwalifikację: " + selectedQual.getValue() + "?");
        Optional<ButtonType> answer = alert.showAndWait();
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        if(answer.get() == ButtonType.OK)
        {
            EmployeeTableViewController.selectedEmployee.getQualifications().remove(selectedQual.getValue());
            DBConnector.getDatastore().save(EmployeeTableViewController.selectedEmployee);
            info.setContentText("Pomyślnie usunięto!");
            info.show();
        }
        refreshView();
    }

    void refreshView()
    {
        Employee e = EmployeeTableViewController.selectedEmployee;
        sendEmployee(e);
    }
}

